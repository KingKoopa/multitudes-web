package cl.cleardigital.web.multitudes.service.impl;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cl.cleardigital.web.multitudes.dto.fichas.LicitacionesAdjudicadasDetalleDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoLicitacionesDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraLicitacionesDTO;
import cl.cleardigital.web.multitudes.dto.licitaciones.LicitacionDetailDTO;
import cl.cleardigital.web.multitudes.dto.licitaciones.LicitacionDetailListadoDTO;
import cl.cleardigital.web.multitudes.dto.licitaciones.LicitacionHeaderDTO;
import cl.cleardigital.web.multitudes.dto.licitaciones.LicitacionHeaderListadoDTO;
import cl.cleardigital.web.multitudes.dto.licitaciones.ListadoDTO;
import cl.cleardigital.web.multitudes.feign.client.MercadoPublicoFeignClient;
import cl.cleardigital.web.multitudes.model.mercadopublico.LicitacionDetalle;
import cl.cleardigital.web.multitudes.model.mercadopublico.LicitacionItem;
import cl.cleardigital.web.multitudes.repository.mercadopublico.LicitacionDetalleRepository;
import cl.cleardigital.web.multitudes.repository.mercadopublico.LicitacionItemRepository;
import cl.cleardigital.web.multitudes.service.MercadoPublicoService;

@Service("mercadoPublicoService")
public class MercadoPublicoServiceImpl implements MercadoPublicoService {

	private static final Logger log = LoggerFactory.getLogger(MercadoPublicoServiceImpl.class);

	@Autowired
	private Gson gson;

	@Autowired
	private MercadoPublicoFeignClient mercadoPublicoFeignClient;

	@Autowired
	private LicitacionItemRepository licitacionItemRepository;

	@Autowired
	private LicitacionDetalleRepository licitacionDetalleRepository;

	@Autowired
	private LeyLobbyServiceImpl leyLobbyServiceImpl;

	@Override
	public Boolean getLicitacionPorFecha(Date fechaDesde, Date fechaHasta) throws Exception {

		// LocalDate from = LocalDate.of(2015, 7, 1);
		// LocalDate to = LocalDate.of(2015, 9, 1);

		LocalDate from = fechaDesde.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate to = fechaHasta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		for (LocalDate actual = from; actual.isBefore(to); actual = actual.plusDays(1)) {
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("ddMMyyyy");
			String day = actual.format(formatters);
			log.info("DIA A CONSULTAR: {}", day);

			String licitaciones = mercadoPublicoFeignClient
					.getLicitacionPorDia("adjudicada", day, "209E4884-27D6-4A45-9F68-CE247DECCF2F").getBody();

			Thread.sleep(2000);// esperamos 2 segs.

			// Obtengo la info
			LicitacionHeaderListadoDTO licitacionListado = gson.fromJson(licitaciones,
					LicitacionHeaderListadoDTO.class);
			if (licitacionListado != null) {
				log.info("***INFORMACIÓN LICITACIONES ADJUDICADAS***");
				log.info("Cantidad de licitaciones:{}", licitacionListado.getCantidad());
				log.info("Versión: {}", licitacionListado.getVersion());
				if (licitacionListado.getListado() != null && !licitacionListado.getListado().isEmpty()) {
					log.info("-->***Inicio Listado: [ \n");
					for (LicitacionHeaderDTO licitacionHeaderDTO : licitacionListado.getListado()) {
						log.info("*DIA A CONSULTAR*: {}", day);
						log.info("Nombre: {}", licitacionHeaderDTO.getNombre());
						log.info("Código estado: {}", licitacionHeaderDTO.getCodigoEstado());
						log.info("Fecha cierre: {}", licitacionHeaderDTO.getFechaCierre());
						log.info("Código externo: {} \n", licitacionHeaderDTO.getCodigoExterno());
						log.info("---->Detalle Licitación: ");
						String detalleLicitacion = null;
						try {
							detalleLicitacion = mercadoPublicoFeignClient
									.getDetalleLicitacion("4825-155-L114",
											"209E4884-27D6-4A45-9F68-CE247DECCF2F")
									.getBody();
						} catch (Exception e) {
							log.error("***Error, día: {}, Detalle codigo externo: {} ***", day,
									licitacionHeaderDTO.getCodigoExterno());
							continue;
						}

						Thread.sleep(2000);// esperamos 2 segs.

						LicitacionDetailListadoDTO licitacionDetailListadoDTO = gson.fromJson(detalleLicitacion,
								LicitacionDetailListadoDTO.class);
						if (licitacionDetailListadoDTO != null && !licitacionDetailListadoDTO.getListado().isEmpty()) {
							for (LicitacionDetailDTO licitacionDetailDTO : licitacionDetailListadoDTO.getListado()) {
								log.info("*DIA A CONSULTAR*: {}", day);
								log.info("*ADJUDICACION FECHA*: {}",
										licitacionDetailDTO.getAdjudicacion() != null
												? licitacionDetailDTO.getAdjudicacion().getFecha()
												: null);
								log.info("*FECHA ADJUDICACION*: {}",
										licitacionDetailDTO.getFechas() != null
												? licitacionDetailDTO.getFechas().getFechaAdjudicacion()
												: null);

								// almacenar items del detalle:
								List<LicitacionItem> licitacionItemLst = new ArrayList<>();
								for (ListadoDTO listadoDTO : licitacionDetailDTO.getItems().getListado()) {
									LicitacionItem licitacionItem = new LicitacionItem();
									licitacionItem.setAdjudicacionAntidad(listadoDTO.getAdjudicacion() != null
											? listadoDTO.getAdjudicacion().getCantidad().intValue()
											: null);
									licitacionItem.setAdjudicacionMontoUnitario(listadoDTO.getAdjudicacion() != null
											? listadoDTO.getAdjudicacion().getMontoUnitario().intValue()
											: null);
									licitacionItem.setAdjudicacionNombreProveedor(listadoDTO.getAdjudicacion() != null
											? listadoDTO.getAdjudicacion().getNombreProveedor()
											: null);
									licitacionItem.setAdjudicacionRutProveedor(listadoDTO.getAdjudicacion() != null
											? listadoDTO.getAdjudicacion().getRutProveedor()
											: null);
									licitacionItem.setCantidad(listadoDTO.getCantidad().intValue());
									licitacionItem.setCategoria(listadoDTO.getCategoria());
									licitacionItem.setCodigoCategoria(listadoDTO.getCodigoCategoria());
									licitacionItem.setCodigoProducto(listadoDTO.getCodigoProducto());
									licitacionItem.setCorrelativo(listadoDTO.getCorrelativo());
									licitacionItem.setDescripcion(listadoDTO.getDescripcion());
									licitacionItem.setNombreProducto(listadoDTO.getNombreProducto());
									licitacionItem.setUnidadMedida(listadoDTO.getUnidadMedida());
									licitacionItemLst.add(licitacionItem);
								}
								licitacionItemRepository.save(licitacionItemLst);
								LicitacionDetalle licitacionDetalle = new LicitacionDetalle();
								licitacionDetalle.setItems(licitacionItemLst);// almacenamos los items de la licitacion
								licitacionDetalle.setAdjudicacionFecha(licitacionDetailDTO.getAdjudicacion() != null
										? licitacionDetailDTO.getAdjudicacion().getFecha()
										: null);
								licitacionDetalle.setAdjudicacionNumero(licitacionDetailDTO.getAdjudicacion() != null
										? licitacionDetailDTO.getAdjudicacion().getNumero()
										: null);
								licitacionDetalle
										.setAdjudicacionNumeroOferentes(licitacionDetailDTO.getAdjudicacion() != null
												? licitacionDetailDTO.getAdjudicacion().getNumeroOferentes()
												: null);
								licitacionDetalle.setAdjudicacionUrlActa(licitacionDetailDTO.getAdjudicacion() != null
										? licitacionDetailDTO.getAdjudicacion().getUrlActa()
										: null);
								licitacionDetalle.setAdjudicacionTipo(licitacionDetailDTO.getAdjudicacion() != null
										? licitacionDetailDTO.getAdjudicacion().getTipo()
										: null);

								licitacionDetalle.setCodigoEstado(licitacionDetailDTO.getCodigoEstado());
								licitacionDetalle.setCodigoExterno(licitacionDetailDTO.getCodigoExterno().trim());
								licitacionDetalle.setCompradorCargoUsuario(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getCargoUsuario()
										: null);
								licitacionDetalle.setCompradorCodigoOrganismo(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getCodigoOrganismo()
										: null);
								licitacionDetalle.setCompradorComunaUnidad(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getComunaUnidad()
										: null);
								licitacionDetalle.setCompradorDireccionUnidad(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getDireccionUnidad()
										: null);
								licitacionDetalle.setCompradorNombreOrganismo(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getNombreOrganismo()
										: null);
								licitacionDetalle.setCompradorNombreUnidad(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getNombreUnidad()
										: null);
								licitacionDetalle.setCompradorNombreUsuario(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getNombreUsuario()
										: null);
								licitacionDetalle.setCompradorRegionUnidad(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getRegionUnidad()
										: null);
								licitacionDetalle.setCompradorRutUnidad(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getRutUnidad()
										: null);
								licitacionDetalle.setCompradorRutUsuario(licitacionDetailDTO.getComprador() != null
										? licitacionDetailDTO.getComprador().getRutUsuario()
										: null);
								licitacionDetalle.setDescripcion(licitacionDetailDTO.getDescripcion());
								licitacionDetalle.setTipo(licitacionDetailDTO.getTipo());
								licitacionDetalle.setEstado(licitacionDetailDTO.getEstado());
								licitacionDetalle.setFechaAdjudicacion(licitacionDetailDTO.getFechas() != null
										? licitacionDetailDTO.getFechas().getFechaAdjudicacion()
										: null);
								licitacionDetalle.setFechaCierre(licitacionDetailDTO.getFechas() != null
										? licitacionDetailDTO.getFechas().getFechaCierre()
										: null);
								licitacionDetalle.setFechaCreacion(licitacionDetailDTO.getFechas() != null
										? licitacionDetailDTO.getFechas().getFechaCreacion()
										: null);
								licitacionDetalle.setFechaEstimadaAdjudicacion(licitacionDetailDTO.getFechas() != null
										? licitacionDetailDTO.getFechas().getFechaEstimadaAdjudicacion()
										: null);
								licitacionDetalle.setFechaFinal(licitacionDetailDTO.getFechas() != null
										? licitacionDetailDTO.getFechas().getFechaFinal()
										: null);
								licitacionDetalle.setFechaInicio(licitacionDetailDTO.getFechas() != null
										? licitacionDetailDTO.getFechas().getFechaInicio()
										: null);
								licitacionDetalle.setFechaPublicacion(licitacionDetailDTO.getFechas() != null
										? licitacionDetailDTO.getFechas().getFechaPublicacion()
										: null);
								licitacionDetalle.setNombre(licitacionDetailDTO.getNombre());
								licitacionDetalleRepository.save(licitacionDetalle);
							}
						}
					}
					log.info("Cantidad de licitaciones:{}", licitacionListado.getCantidad());
					log.info("Versión: {}", licitacionListado.getVersion());
					log.info("-->Fin Listado: ]***");
				}
			}
		}

		return Boolean.TRUE;
	}

	@Override
	public List<LicitacionDetailDTO> getLicitacionDetallePorRutProveedor(String rutProveedor) throws Exception {

		List<LicitacionDetalle> licitacionDetalleLst = licitacionDetalleRepository
				.findDistinctByItemsAdjudicacionRutProveedor(rutProveedor);

		List<LicitacionDetailDTO> licitacionDetailDTOLst = new ArrayList<>();

		if (licitacionDetalleLst != null && !licitacionDetalleLst.isEmpty()) {
			licitacionDetalleLst.stream().forEach(licitacionDetalle -> {
				LicitacionDetailDTO licitacionDetailDTO = new LicitacionDetailDTO();
				licitacionDetailDTOLst.add(licitacionDetailDTO.populateFromModel(licitacionDetalle)); // poblar en base
																										// al modelo.
			});
		}
		return licitacionDetailDTOLst;
	}

	@Override
	public SujetoPasivoCabeceraDTO getFichaSujetoPasivo(String rutOrganismo, java.sql.Date fechaDesde,
			java.sql.Date fechaHasta) throws Exception {
		log.info("MercadoPublicoService::getFichaSujetoPasivo()");
		List<LicitacionDetalle> licitacionDetalleLst = licitacionDetalleRepository
				.findByCompradorRutUnidad(rutOrganismo);
		SujetoPasivoCabeceraDTO sujetoPasivoCabeceraDTO = new SujetoPasivoCabeceraDTO();
		if (licitacionDetalleLst != null && !licitacionDetalleLst.isEmpty()) {
			Long montoLicitado = 0L;
			sujetoPasivoCabeceraDTO
					.setNombreComprador(licitacionDetalleLst.stream().findFirst().get().getCompradorNombreOrganismo());
			sujetoPasivoCabeceraDTO
					.setRutComprador(licitacionDetalleLst.stream().findFirst().get().getCompradorRutUnidad());
			List<SujetoPasivoCabeceraLicitacionesDTO> sujetoPasivoCabeceraLicitacionesDTOLst = new ArrayList<>();

			for (LicitacionDetalle licitacionDetalle : licitacionDetalleLst) {
				for (LicitacionItem items : licitacionDetalle.getItems()) {
					if (items.getAdjudicacionAntidad() != null && items.getAdjudicacionMontoUnitario() != null) {
						montoLicitado += items.getAdjudicacionAntidad() * items.getAdjudicacionMontoUnitario();
					}
				}
				// tipos de licitacion:
				SujetoPasivoCabeceraLicitacionesDTO sujetoPasivoCabeceraLicitacionesDTO = new SujetoPasivoCabeceraLicitacionesDTO();
				sujetoPasivoCabeceraLicitacionesDTO.setTipoLicitacion(licitacionDetalle.getTipo());
				sujetoPasivoCabeceraLicitacionesDTOLst.add(sujetoPasivoCabeceraLicitacionesDTO);

			}
			sujetoPasivoCabeceraDTO.setMontoLicitado(montoLicitado);
			// agrupar licitaciones y cantidad:
			Map<String, Long> result = sujetoPasivoCabeceraLicitacionesDTOLst.stream().collect(Collectors
					.groupingBy(SujetoPasivoCabeceraLicitacionesDTO::getTipoLicitacion, Collectors.counting()));

			List<SujetoPasivoCabeceraLicitacionesDTO> newSujetoPasivoCabeceraLicitaciones = _populateSujetoPasivoCabeceraLicitaciones(
					result);
			if (newSujetoPasivoCabeceraLicitaciones != null && !newSujetoPasivoCabeceraLicitaciones.isEmpty()) {
				sujetoPasivoCabeceraDTO.setCabecerasLicitacion(newSujetoPasivoCabeceraLicitaciones);
				sujetoPasivoCabeceraDTO.setLicitacionesPublicas(newSujetoPasivoCabeceraLicitaciones.stream()
						.filter(cabeceraLicitacion -> cabeceraLicitacion.getCantidad() > 0)
						.mapToInt(cabeceraLicitacion -> cabeceraLicitacion.getCantidad()).sum());
			}

		}

		// poblar audiencias
		List<SujetoPasivoAudienciaDTO> pasivoDetalleLst = leyLobbyServiceImpl
				.findByPasivoAudiencias(sujetoPasivoCabeceraDTO.getNombreComprador(), fechaDesde, fechaHasta);
		if (pasivoDetalleLst != null && !pasivoDetalleLst.isEmpty()) {
			sujetoPasivoCabeceraDTO.setSujetoPasivoAudiencias(pasivoDetalleLst);
			sujetoPasivoCabeceraDTO.setSujetosPasivosCantidad(pasivoDetalleLst.size());
		}

		return sujetoPasivoCabeceraDTO;
	}

	@Override // FichaSujetoActivo
	public SujetoActivoCabeceraDTO getFichaSujetoActivo(String rutProveedor, java.sql.Date fechaDesde,
			java.sql.Date fechaHasta) throws Exception {
		log.info("MercadoPublicoService::getFichaSujetoPasivo()");

		List<LicitacionItem> licitacionItemLst = licitacionItemRepository.findByAdjudicacionRutProveedor(rutProveedor);
		SujetoActivoCabeceraDTO sujetoActivoCabeceraDTO = new SujetoActivoCabeceraDTO();
		if (licitacionItemLst != null && !licitacionItemLst.isEmpty()) {
			Integer montoLicitado = 0;
			sujetoActivoCabeceraDTO
					.setNombreProveedor(licitacionItemLst.stream().findFirst().get().getAdjudicacionNombreProveedor());
			sujetoActivoCabeceraDTO
					.setRutProveedor(licitacionItemLst.stream().findFirst().get().getAdjudicacionRutProveedor());
			sujetoActivoCabeceraDTO.setGiro(licitacionItemLst.stream().findFirst().get().getCategoria());

			List<SujetoActivoLicitacionesDTO> SujetoActivoLicitacionesDTOLst = new ArrayList<>();

			for (LicitacionItem licitacionItem : licitacionItemLst) {

				if (licitacionItem.getAdjudicacionAntidad() != null
						&& licitacionItem.getAdjudicacionMontoUnitario() != null
						&& licitacionItem.getAdjudicacionRutProveedor().equals(rutProveedor)) {
					montoLicitado += licitacionItem.getAdjudicacionAntidad()
							* licitacionItem.getAdjudicacionMontoUnitario();
				}

				// tipos de licitacion:
				SujetoActivoLicitacionesDTO sujetoActivoLicitacionesDTO = new SujetoActivoLicitacionesDTO();
				sujetoActivoLicitacionesDTO.setTipo(licitacionItem.getLicitacionDetalle() != null
						? licitacionItem.getLicitacionDetalle().stream().findFirst().get().getTipo()
						: null);
				SujetoActivoLicitacionesDTOLst.add(sujetoActivoLicitacionesDTO);

			}

			sujetoActivoCabeceraDTO.setMonto(montoLicitado);
			// agrupar licitaciones y cantidad:
			Map<String, Long> result = SujetoActivoLicitacionesDTOLst.stream()
					.collect(Collectors.groupingBy(SujetoActivoLicitacionesDTO::getTipo, Collectors.counting()));

			List<SujetoActivoLicitacionesDTO> newSujetoActivoLicitacionesDTO = _populateSujetoActivoLicitaciones(
					result);
			if (newSujetoActivoLicitacionesDTO != null && !newSujetoActivoLicitacionesDTO.isEmpty()) {
				sujetoActivoCabeceraDTO.setSujetoLicitaciones(newSujetoActivoLicitacionesDTO);
				sujetoActivoCabeceraDTO.setNumeroLicitaciones(newSujetoActivoLicitacionesDTO.stream()
						.filter(cabeceraLicitacion -> cabeceraLicitacion.getCantidad() > 0)
						.mapToInt(cabeceraLicitacion -> cabeceraLicitacion.getCantidad()).sum());
			}

		}

		// poblar audiencias

		List<SujetoActivoAudienciaDTO> activoDetalleLst = leyLobbyServiceImpl
				.findByActivoAudiencias(sujetoActivoCabeceraDTO.getRutProveedor(), fechaDesde, fechaHasta);
		if (activoDetalleLst != null && !activoDetalleLst.isEmpty()) {
			sujetoActivoCabeceraDTO.setSujetosActivos(activoDetalleLst);
			sujetoActivoCabeceraDTO.setNumeroAudiencias(activoDetalleLst.size());
		}

		return sujetoActivoCabeceraDTO;
	}

	private List<SujetoActivoLicitacionesDTO> _populateSujetoActivoLicitaciones(Map<String, Long> result) {
		List<SujetoActivoLicitacionesDTO> newSujetoActivoLicitacionesDTO = new ArrayList<>();
		result.forEach((key, value) -> {
			SujetoActivoLicitacionesDTO sujetoActivoLicitacionesDTO = new SujetoActivoLicitacionesDTO();
			sujetoActivoLicitacionesDTO.setTipo(key);
			sujetoActivoLicitacionesDTO.setCantidad(value.intValue());
			newSujetoActivoLicitacionesDTO.add(sujetoActivoLicitacionesDTO);
		});

		return newSujetoActivoLicitacionesDTO;
	}

	private List<SujetoPasivoCabeceraLicitacionesDTO> _populateSujetoPasivoCabeceraLicitaciones(
			Map<String, Long> result) {
		List<SujetoPasivoCabeceraLicitacionesDTO> newSujetoPasivoCabeceraLicitaciones = new ArrayList<>();
		result.forEach((key, value) -> {
			SujetoPasivoCabeceraLicitacionesDTO sujetoPasivoCabeceraLicitacionesDTO = new SujetoPasivoCabeceraLicitacionesDTO();
			sujetoPasivoCabeceraLicitacionesDTO.setTipoLicitacion(key);
			sujetoPasivoCabeceraLicitacionesDTO.setCantidad(value.intValue());
			newSujetoPasivoCabeceraLicitaciones.add(sujetoPasivoCabeceraLicitacionesDTO);
		});

		return newSujetoPasivoCabeceraLicitaciones;
	}

	@Override
	public List<SujetoPasivoCabeceraDTO> getCompradoresPorRut(String rutUnidad) throws Exception {

		List<SujetoPasivoCabeceraDTO> licitacionDetalleLst = licitacionDetalleRepository
				.getDistinctByCompradorRutUnidad(rutUnidad);

		log.info(licitacionDetalleLst.toString());
		return licitacionDetalleLst;

	}

	@Override
	public List<SujetoActivoCabeceraDTO> getVendedoresPorRut(String rutProveedor) throws Exception {

		List<SujetoActivoCabeceraDTO> licitacionDetalleLst = licitacionDetalleRepository
				.getDistinctByVendedorRutProveedor(rutProveedor);

		log.info(licitacionDetalleLst.toString());
		return licitacionDetalleLst;

	}

	@Override
	public List<LicitacionesAdjudicadasDetalleDTO> getDetalleLicitacionAdjudicada(String rutAdjudicado, String tipo)
			throws Exception {

		List<LicitacionesAdjudicadasDetalleDTO> AdjudicacionDetalleLst = licitacionDetalleRepository
				.getDistinctByLicitacionAdjudicadaRutUnidad(rutAdjudicado, tipo);

		log.info(AdjudicacionDetalleLst.toString());

		return AdjudicacionDetalleLst;
	}

	@Override
	public List<LicitacionesAdjudicadasDetalleDTO> getDistinctByLicitacionAdjudicadaRutProveedor(String rutAdjudicado,
			String tipo) throws Exception {

		List<LicitacionesAdjudicadasDetalleDTO> AdjudicacionDetalleLst = licitacionDetalleRepository
				.getDistinctByLicitacionAdjudicadaRutProveedor(rutAdjudicado, tipo);

		log.info(AdjudicacionDetalleLst.toString());

		return AdjudicacionDetalleLst;
	}

	

}