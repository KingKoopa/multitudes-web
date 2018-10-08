package cl.cleardigital.web.multitudes.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cl.cleardigital.web.multitudes.dto.dashboard.AudienciasPorMesDTO;
import cl.cleardigital.web.multitudes.dto.fichas.InstitucionDetalleDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.leylobby.CabeceraAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.leylobby.CargoActivoDTO;
import cl.cleardigital.web.multitudes.dto.leylobby.DetalleAudienciaDTO;
import cl.cleardigital.web.multitudes.feign.client.LeyLobbyFeignClient;
import cl.cleardigital.web.multitudes.model.leylobby.Asistente;
import cl.cleardigital.web.multitudes.model.leylobby.AudienciaCabecera;
import cl.cleardigital.web.multitudes.model.leylobby.AudienciaDetalle;
import cl.cleardigital.web.multitudes.model.leylobby.CargoActivo;
import cl.cleardigital.web.multitudes.model.leylobby.InstitucionDetalle;
import cl.cleardigital.web.multitudes.repository.leylobby.AsistenteRepository;
import cl.cleardigital.web.multitudes.repository.leylobby.AudienciaDetalleRepository;
import cl.cleardigital.web.multitudes.repository.leylobby.CabeceraAudienciaRepository;
import cl.cleardigital.web.multitudes.repository.leylobby.CargoActivoRepository;
import cl.cleardigital.web.multitudes.repository.leylobby.InstitucionDetalleRepository;
import cl.cleardigital.web.multitudes.service.LeyLobbyService;

@Service("leyLobbyService")
public class LeyLobbyServiceImpl implements LeyLobbyService{

	private static final Logger log = LoggerFactory.getLogger(LeyLobbyServiceImpl.class);
	
	@Autowired
	private LeyLobbyFeignClient leyLobbyFeignClient;

	@Autowired
	private Gson gson;
	
	@Autowired
	private CabeceraAudienciaRepository cabeceraAudienciaRepository;
	
	@Autowired
	private InstitucionDetalleRepository institucionDetalleRepository;
	
	@Autowired
	private CargoActivoRepository cargoActivoRepository;
	
	@Autowired
	private AsistenteRepository asistenteRepository;
	
	@Autowired
	private AudienciaDetalleRepository audienciaDetalleRepository;
	
	@Override
	public Boolean getAudienciasHeaders() throws Exception {
		
		String header = leyLobbyFeignClient.getAudienciasPorPagina(1, 100, "$2y$10$Svt0LXSqQFTNrBUvvkvsTOZRhZ.ERbz.hmFU3dLy5Cp").getBody();
		
		CabeceraAudienciaDTO headerDTO = gson.fromJson(header, CabeceraAudienciaDTO.class);
		
		Integer currentPage = Integer.parseInt(headerDTO.getCurrent_page());
		
		Integer lastPage = Integer.parseInt(headerDTO.getLast_page());
		log.info("Ultima pagina: {}", lastPage);
		
		for(Integer actualPage = currentPage; actualPage <= lastPage;  actualPage++) {
			//Traer datos de las audiencias
			String cabeceraAudiencias = leyLobbyFeignClient.getAudienciasPorPagina(actualPage, 100, "$2y$10$Svt0LXSqQFTNrBUvvkvsTOZRhZ.ERbz.hmFU3dLy5Cp").getBody();
			log.info("Pagina actual: {}", actualPage);
			CabeceraAudienciaDTO cabeceraAudienciaDTO = gson.fromJson(cabeceraAudiencias, CabeceraAudienciaDTO.class);
			
			if(cabeceraAudienciaDTO.getData() != null && !cabeceraAudienciaDTO.getData().isEmpty()) {
				cabeceraAudienciaDTO.getData().forEach(cabeceraAudiencia -> {
					log.info("Audiencia: {}", cabeceraAudiencia.getId());
					AudienciaCabecera audienciaCabecera = new AudienciaCabecera();
					audienciaCabecera.setApellidos(cabeceraAudiencia.getApellidos());
					audienciaCabecera.setCargo(cabeceraAudiencia.getCargo());
					audienciaCabecera.setComuna(cabeceraAudiencia.getComuna());
					audienciaCabecera.setDetallesUrl(cabeceraAudiencia.getDetalles_url());
					audienciaCabecera.setFechaInicio(cabeceraAudiencia.getFecha_inicio());
					audienciaCabecera.setFechaTermino(cabeceraAudiencia.getFecha_termino());
					audienciaCabecera.setForma(cabeceraAudiencia.getForma());
					audienciaCabecera.setId(Integer.parseInt(cabeceraAudiencia.getId()));
					audienciaCabecera.setInstitucionUrl(cabeceraAudiencia.getInstitucion_url());
					audienciaCabecera.setLugar(cabeceraAudiencia.getLugar());
					audienciaCabecera.setNombres(cabeceraAudiencia.getNombres());
					audienciaCabecera.setReferencia(cabeceraAudiencia.getReferencia());
					audienciaCabecera.setSujetoPasivoUrl(cabeceraAudiencia.getSujeto_pasivo_url());
					audienciaCabecera.setUpdated(cabeceraAudiencia.getUpdated_at().getDate());
					audienciaCabecera.setVistaPublicaDetallesUrl(cabeceraAudiencia.getVista_publica_detalles_url());
					audienciaCabecera.setVistaPublicaInstitucionUrl(cabeceraAudiencia.getVista_publica_institucion_url());
					//guardar cabecera:
					cabeceraAudienciaRepository.save(audienciaCabecera);
				});
			}
			
		}
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean getAudienciasDetalle() throws Exception {
	
		Long pages = cabeceraAudienciaRepository.count()/100;
		
		Integer currentPage = 0;
		
		Integer lastPage = pages.intValue();
		
		log.info("Ultima pagina: {}", lastPage);
		
		for(Integer actualPage = currentPage; actualPage <= lastPage;  actualPage++) {
			log.info("página actual: {}", actualPage);
			Page<AudienciaCabecera> audienciaCabeceraPage = cabeceraAudienciaRepository.findAll(new PageRequest(actualPage, 100));
			List<AudienciaCabecera> audienciaCabeceraLst = audienciaCabeceraPage.getContent();
			if(audienciaCabeceraLst != null && !audienciaCabeceraLst.isEmpty()) {
				audienciaCabeceraLst.stream().forEach(audienciaCabecera ->{
					try {
						String detalleAudiencia = leyLobbyFeignClient.getAudienciaDetalle(audienciaCabecera.getId(), "$2y$10$Svt0LXSqQFTNrBUvvkvsTOZRhZ.ERbz.hmFU3dLy5Cp").getBody();
						if(detalleAudiencia != null) {
							DetalleAudienciaDTO detalleAudienciaDTO = gson.fromJson(detalleAudiencia, DetalleAudienciaDTO.class);
							List<Asistente> asistenteLst = new ArrayList<>();
							if(detalleAudienciaDTO != null) {
								detalleAudienciaDTO.getAsistentes().stream().forEach(asistenteDTO -> {
									//Poblar los cargos activos:
									Integer cargoActivoId = Integer.parseInt(asistenteDTO.getCargo_activo_url().split("/")[6]);
									CargoActivo cargoActivo = cargoActivoRepository.findOne(cargoActivoId);
									try {
										if(cargoActivo == null) {//no existe el cargo
											cargoActivo = new CargoActivo();
											String cargoActivoStr = leyLobbyFeignClient.getCargoActivo(cargoActivoId, "$2y$10$Svt0LXSqQFTNrBUvvkvsTOZRhZ.ERbz.hmFU3dLy5Cp").getBody();
											if(cargoActivoStr != null) {
												CargoActivoDTO cargoActivoDTO = gson.fromJson(cargoActivoStr, CargoActivoDTO.class);
												cargoActivo.setId(cargoActivoId);
												cargoActivo.setRemunerado(cargoActivoDTO.getRemunerado() == "true" ? Boolean.TRUE : Boolean.FALSE);
												cargoActivo.setSujetoApellidos(cargoActivoDTO.getSujeto().getApellidos());
												cargoActivo.setSujetoNombres(cargoActivoDTO.getSujeto().getNombres());
												cargoActivo.setTipo(cargoActivoDTO.getTipo());
												cargoActivoRepository.save(cargoActivo);
											}
										}
										
									} catch (Exception e) {
										e.printStackTrace();
									}
									Asistente asistente = new Asistente();
									asistente.setApellidos(asistenteDTO.getApellidos());
									asistente.setCargoActivo(cargoActivo);
									asistente.setCargoActivoUrl(asistenteDTO.getCargo_activo_url());
									asistente.setNombres(asistenteDTO.getNombres());
									asistente.setRepresentaDirectorio(asistenteDTO.getRepresenta().getDirectorio());
									asistente.setRepresentaDomicilio(asistenteDTO.getRepresenta().getDomicilio());
									asistente.setRepresentaGiro(asistenteDTO.getRepresenta().getGiro());
									asistente.setRepresentaNaturaleza(asistenteDTO.getRepresenta().getNaturaleza());
									asistente.setRepresentaNombre(asistenteDTO.getRepresenta().getNombre());
									asistente.setRepresentanteLegal(asistenteDTO.getRepresenta().getRepresentante_legal());
									asistente.setRepresentaPais(asistenteDTO.getRepresenta().getPais());
									asistente.setRepresentaTipo(asistenteDTO.getRepresenta().getTipo());
									asistenteRepository.save(asistente);
									asistenteLst.add(asistente);
								});
								//Poblar detalle audiencia:
								AudienciaDetalle audienciaDetalle = new AudienciaDetalle();
								audienciaDetalle.setInstitucionUrl(detalleAudienciaDTO.getInstitucion_url());
								audienciaDetalle.setSujetoPasivoUrl(detalleAudienciaDTO.getSujeto_pasivo_url());
								audienciaDetalle.setId(audienciaCabecera.getId());
								audienciaDetalle.setAsistentes(asistenteLst);
								audienciaDetalleRepository.save(audienciaDetalle);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			}
		}
		
		return Boolean.TRUE;
	}

	@Override
	public Boolean getInstitucionesDetalle() throws Exception {
		
		Long pages = cabeceraAudienciaRepository.count()/100;
		
		Integer currentPage = 0;
		
		Integer lastPage = pages.intValue();
		
		log.info("Ultima pagina: {}", lastPage);
		
		for(Integer actualPage = currentPage; actualPage <= lastPage;  actualPage++) {
			log.info("página actual: {}", actualPage);
			Page<AudienciaCabecera> audienciaCabeceraPage = cabeceraAudienciaRepository.findAll(new PageRequest(actualPage, 100));
			List<AudienciaCabecera> audienciaCabeceraLst = audienciaCabeceraPage.getContent();
			if(audienciaCabeceraLst != null && !audienciaCabeceraLst.isEmpty()) {
				for(AudienciaCabecera audienciaCabecera : audienciaCabeceraLst) {	
					Integer institucionId = Integer.parseInt(audienciaCabecera.getInstitucionUrl().split("/")[6]);
					InstitucionDetalle institucionDetalle = institucionDetalleRepository.findOne(institucionId);
					if(institucionDetalle == null) {//no existe el organismo
						try {
							institucionDetalle = new InstitucionDetalle();
							String institucionDetalleStr = leyLobbyFeignClient.getInstitucionDetalle(institucionId, "$2y$10$Svt0LXSqQFTNrBUvvkvsTOZRhZ.ERbz.hmFU3dLy5Cp").getBody();
							if(institucionDetalleStr != null) {
								InstitucionDetalleDTO institucionDetalleDTO = gson.fromJson(institucionDetalleStr, InstitucionDetalleDTO.class);
								institucionDetalle.setId(institucionId);
								institucionDetalle.setCodigo(institucionDetalleDTO.getCodigo());
								institucionDetalle.setNombre(institucionDetalleDTO.getNombre());
								institucionDetalleRepository.save(institucionDetalle);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					audienciaCabecera.setInstitucionDetalle(institucionDetalle);
					cabeceraAudienciaRepository.save(audienciaCabecera);
				}
			}
		}
		
		return Boolean.TRUE;
	}

	@Override
	public List<SujetoPasivoAudienciaDTO> findByPasivoAudiencias(String nombre, Date fechaDesde, Date fechaHasta) throws Exception {
		
		List<SujetoPasivoAudienciaDTO> pasivoDetalleLst = cabeceraAudienciaRepository.findByPasivoAudiencias(nombre, fechaDesde, fechaHasta);    
		
		return pasivoDetalleLst;
	}
	
	@Override
	public List<SujetoActivoAudienciaDTO> findByActivoAudiencias(String nombre) throws Exception {
		
		List<SujetoActivoAudienciaDTO> activoDetalleLst = cabeceraAudienciaRepository.findByActivoAudiencias(nombre);
		
		return activoDetalleLst;
	}
	
	@Override
	public List<AudienciasPorMesDTO> getAudienciasPorMes () throws Exception {
		
		//List<AudienciasPorMesDTO> activoDetalleLst = cabeceraAudienciaRepository.findByActivoAudiencias(nombre);
		
		return null;
	}
	
	

}