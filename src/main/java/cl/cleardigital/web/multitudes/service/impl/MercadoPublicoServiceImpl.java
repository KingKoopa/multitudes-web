package cl.cleardigital.web.multitudes.service.impl;

import java.time.LocalDate;
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
public class MercadoPublicoServiceImpl implements MercadoPublicoService{

	private static final Logger log = LoggerFactory.getLogger(MercadoPublicoServiceImpl.class);
	
	@Autowired
	private Gson gson;
	
	@Autowired
	private MercadoPublicoFeignClient mercadoPublicoFeignClient;
	
	@Autowired
	private LicitacionItemRepository licitacionItemRepository;
	
	@Autowired
	private LicitacionDetalleRepository licitacionDetalleRepository;
	
	@Override
	public Boolean getLicitacionPorFecha() throws Exception {
		
//		LocalDate now = LocalDate.now();
//		LocalDate to = now.minusMonths(3);
		
		LocalDate now = LocalDate.of(2018, 1, 1);
		LocalDate to = LocalDate.of(2018, 2, 1);
		
		for (LocalDate actual = now; actual.isBefore(to); actual = actual.plusDays(1)) {
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("ddMMyyyy");
			String day = actual.format(formatters);
			log.info("DIA A CONSULTAR: {}", day);
			
			String licitaciones = 
					mercadoPublicoFeignClient
					.getLicitacionPorDia("adjudicada", day, "209E4884-27D6-4A45-9F68-CE247DECCF2F")
					.getBody();
			
			Thread.sleep(2000);//esperamos 2 segs.
			
			//Obtengo la info
			LicitacionHeaderListadoDTO licitacionListado = gson.fromJson(licitaciones, LicitacionHeaderListadoDTO.class);
			if(licitacionListado != null) {
				log.info("***INFORMACIÓN LICITACIONES ADJUDICADAS***");
				log.info("Cantidad de licitaciones:{}", licitacionListado.getCantidad());
				log.info("Versión: {}", licitacionListado.getVersion());
				if(licitacionListado.getListado() != null && !licitacionListado.getListado().isEmpty()) {
					log.info("-->***Inicio Listado: [ \n");
					for(LicitacionHeaderDTO licitacionHeaderDTO : licitacionListado.getListado()) {
						log.info("Nombre: {}",licitacionHeaderDTO.getNombre());
						log.info("Código estado: {}",licitacionHeaderDTO.getCodigoEstado());
						log.info("Fecha cierre: {}",licitacionHeaderDTO.getFechaCierre());
						log.info("Código externo: {} \n",licitacionHeaderDTO.getCodigoExterno());
						log.info("---->Detalle Licitación: ");
						String detalleLicitacion = null;
						try {
							detalleLicitacion = mercadoPublicoFeignClient
									.getDetalleLicitacion(licitacionHeaderDTO.getCodigoExterno(), "209E4884-27D6-4A45-9F68-CE247DECCF2F")
									.getBody();
						}catch (Exception e) {
							log.error("***Error, día: {}, Detalle codigo externo: {} ***", day, licitacionHeaderDTO.getCodigoExterno()); 
							continue;
						}
						
						Thread.sleep(2000);//esperamos 2 segs.
						
						LicitacionDetailListadoDTO licitacionDetailListadoDTO = gson.fromJson(detalleLicitacion, LicitacionDetailListadoDTO.class);
						if(licitacionDetailListadoDTO != null && !licitacionDetailListadoDTO.getListado().isEmpty()) {
							for(LicitacionDetailDTO licitacionDetailDTO : licitacionDetailListadoDTO.getListado()) {
								//almacenar items del detalle:
								List<LicitacionItem> licitacionItemLst = new ArrayList<>();
								for(ListadoDTO listadoDTO : licitacionDetailDTO.getItems().getListado()) {
									LicitacionItem licitacionItem = new LicitacionItem();
									licitacionItem.setAdjudicacionAntidad(listadoDTO.getAdjudicacion() != null ? listadoDTO.getAdjudicacion().getCantidad().intValue() : null);
									licitacionItem.setAdjudicacionMontoUnitario(listadoDTO.getAdjudicacion() != null ? listadoDTO.getAdjudicacion().getMontoUnitario().intValue() : null);
									licitacionItem.setAdjudicacionNombreProveedor(listadoDTO.getAdjudicacion() != null ? listadoDTO.getAdjudicacion().getNombreProveedor() : null);
									licitacionItem.setAdjudicacionRutProveedor(listadoDTO.getAdjudicacion() != null ? listadoDTO.getAdjudicacion().getRutProveedor() : null);
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
								licitacionDetalle.setItems(licitacionItemLst);//almacenamos los items de la licitacion
								licitacionDetalle.setAdjudicacionFecha(licitacionDetailDTO.getAdjudicacion() != null ? licitacionDetailDTO.getAdjudicacion().getFecha() : null);
								licitacionDetalle.setAdjudicacionNumero(licitacionDetailDTO.getAdjudicacion() != null ? licitacionDetailDTO.getAdjudicacion().getNumero() : null);
								licitacionDetalle.setAdjudicacionNumeroOferentes(licitacionDetailDTO.getAdjudicacion() != null ? licitacionDetailDTO.getAdjudicacion().getNumeroOferentes() : null);
								licitacionDetalle.setAdjudicacionUrlActa(licitacionDetailDTO.getAdjudicacion() != null ? licitacionDetailDTO.getAdjudicacion().getUrlActa() : null);
								licitacionDetalle.setAdjudicacionTipo(licitacionDetailDTO.getAdjudicacion() != null ? licitacionDetailDTO.getAdjudicacion().getTipo() : null);
								
								licitacionDetalle.setCodigoEstado(licitacionDetailDTO.getCodigoEstado());
								licitacionDetalle.setCodigoExterno(licitacionDetailDTO.getCodigoExterno());
								licitacionDetalle.setCompradorCargoUsuario(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getCargoUsuario() : null);
								licitacionDetalle.setCompradorCodigoOrganismo(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getCodigoOrganismo() : null);
								licitacionDetalle.setCompradorComunaUnidad(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getComunaUnidad() : null);
								licitacionDetalle.setCompradorDireccionUnidad(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getDireccionUnidad() : null);
								licitacionDetalle.setCompradorNombreOrganismo(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getNombreOrganismo() : null);
								licitacionDetalle.setCompradorNombreUnidad(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getNombreUnidad() : null);
								licitacionDetalle.setCompradorNombreUsuario(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getNombreUsuario() : null);
								licitacionDetalle.setCompradorRegionUnidad(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getRegionUnidad() : null);
								licitacionDetalle.setCompradorRutUnidad(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getRutUnidad() : null);
								licitacionDetalle.setCompradorRutUsuario(licitacionDetailDTO.getComprador() != null ? licitacionDetailDTO.getComprador().getRutUsuario() : null);
								licitacionDetalle.setDescripcion(licitacionDetailDTO.getDescripcion());
								licitacionDetalle.setTipo(licitacionDetailDTO.getTipo());
								licitacionDetalle.setEstado(licitacionDetailDTO.getEstado());
								licitacionDetalle.setFechaAdjudicacion(licitacionDetailDTO.getFechas() != null ? licitacionDetailDTO.getFechas().getFechaAdjudicacion() : null);
								licitacionDetalle.setFechaCierre(licitacionDetailDTO.getFechas() != null ? licitacionDetailDTO.getFechas().getFechaCierre() : null);
								licitacionDetalle.setFechaCreacion(licitacionDetailDTO.getFechas() != null ? licitacionDetailDTO.getFechas().getFechaCreacion() : null);
								licitacionDetalle.setFechaEstimadaAdjudicacion(licitacionDetailDTO.getFechas() != null ? licitacionDetailDTO.getFechas().getFechaEstimadaAdjudicacion() : null);
								licitacionDetalle.setFechaFinal(licitacionDetailDTO.getFechas() != null ? licitacionDetailDTO.getFechas().getFechaFinal() : null);
								licitacionDetalle.setFechaInicio(licitacionDetailDTO.getFechas() != null ? licitacionDetailDTO.getFechas().getFechaInicio() : null);
								licitacionDetalle.setFechaPublicacion(licitacionDetailDTO.getFechas() != null ? licitacionDetailDTO.getFechas().getFechaPublicacion() : null);
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
		
		List<LicitacionDetalle> licitacionDetalleLst = licitacionDetalleRepository.findDistinctByItemsAdjudicacionRutProveedor(rutProveedor);
		
		List<LicitacionDetailDTO> licitacionDetailDTOLst = new ArrayList<>();
		
		if(licitacionDetalleLst != null && !licitacionDetalleLst.isEmpty()) {
			licitacionDetalleLst.stream().forEach(licitacionDetalle -> {
				LicitacionDetailDTO licitacionDetailDTO = new LicitacionDetailDTO();
				licitacionDetailDTOLst.add(licitacionDetailDTO.populateFromModel(licitacionDetalle)); //poblar en base al modelo.
			});
		}
		return licitacionDetailDTOLst;
	}

	@Override
	public SujetoPasivoCabeceraDTO getFichaSujetoPasivo(String rutOrganismo) throws Exception {
		log.info("MercadoPublicoService::getFichaSujetoPasivo()");
		List<LicitacionDetalle> licitacionDetalleLst =  licitacionDetalleRepository.findByCompradorRutUnidad(rutOrganismo);
		SujetoPasivoCabeceraDTO sujetoPasivoCabeceraDTO = new SujetoPasivoCabeceraDTO();
		if(licitacionDetalleLst != null && !licitacionDetalleLst.isEmpty()) {
			Integer montoLicitado = 0;
			sujetoPasivoCabeceraDTO.setNombreComprador(licitacionDetalleLst.stream().findFirst().get().getCompradorNombreOrganismo());
			sujetoPasivoCabeceraDTO.setRutComprador(licitacionDetalleLst.stream().findFirst().get().getCompradorRutUnidad());
			List<SujetoPasivoCabeceraLicitacionesDTO> sujetoPasivoCabeceraLicitacionesDTOLst = new ArrayList<>();
			
			for(LicitacionDetalle licitacionDetalle : licitacionDetalleLst) {
				for(LicitacionItem items : licitacionDetalle.getItems()) {
					if(items.getAdjudicacionAntidad() != null && items.getAdjudicacionMontoUnitario() != null) {
						montoLicitado = items.getAdjudicacionAntidad() * items.getAdjudicacionMontoUnitario();
					}
					//tipos de licitacion:
					SujetoPasivoCabeceraLicitacionesDTO sujetoPasivoCabeceraLicitacionesDTO = new SujetoPasivoCabeceraLicitacionesDTO();
					sujetoPasivoCabeceraLicitacionesDTO.setTipoLicitacion(licitacionDetalle.getTipo());
					sujetoPasivoCabeceraLicitacionesDTOLst.add(sujetoPasivoCabeceraLicitacionesDTO);
				}
				
			}
			sujetoPasivoCabeceraDTO.setMontoLicitado(montoLicitado);
			//agrupar licitaciones y cantidad:
			Map<String, Long> result =
					sujetoPasivoCabeceraLicitacionesDTOLst.stream().collect(
	                        Collectors.groupingBy(
	                        		SujetoPasivoCabeceraLicitacionesDTO::getTipoLicitacion, Collectors.counting()
	                        )
	                );

	        sujetoPasivoCabeceraDTO.setCabecerasLicitacion(_populateSujetoPasivoCabeceraLicitaciones(result));
		
		}
		return sujetoPasivoCabeceraDTO;
	}

	private List<SujetoPasivoCabeceraLicitacionesDTO> _populateSujetoPasivoCabeceraLicitaciones(Map<String, Long> result){
		List<SujetoPasivoCabeceraLicitacionesDTO> newSujetoPasivoCabeceraLicitaciones = new ArrayList<>();
		result.forEach((key,value)->{
			SujetoPasivoCabeceraLicitacionesDTO sujetoPasivoCabeceraLicitacionesDTO = new SujetoPasivoCabeceraLicitacionesDTO();
			sujetoPasivoCabeceraLicitacionesDTO.setTipoLicitacion(key);
			sujetoPasivoCabeceraLicitacionesDTO.setCantidad(value.intValue());
			newSujetoPasivoCabeceraLicitaciones.add(sujetoPasivoCabeceraLicitacionesDTO);
		});
		return newSujetoPasivoCabeceraLicitaciones; 
	}

}