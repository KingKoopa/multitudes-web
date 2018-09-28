package cl.cleardigital.web.multitudes.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cl.cleardigital.web.multitudes.dto.fichas.InstitucionDetalleDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.leylobby.CabeceraAudienciaDTO;
import cl.cleardigital.web.multitudes.feign.client.LeyLobbyFeignClient;
import cl.cleardigital.web.multitudes.model.leylobby.AudienciaCabecera;
import cl.cleardigital.web.multitudes.model.leylobby.InstitucionDetalle;
import cl.cleardigital.web.multitudes.repository.leylobby.CabeceraAudienciaRepository;
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

	//PorHacer	
	@Override
	public Boolean getAudienciasDetalle() throws Exception {
	
		List<AudienciaCabecera> audienciaCabeceraLst = cabeceraAudienciaRepository.findAll();
		if(audienciaCabeceraLst != null && !audienciaCabeceraLst.isEmpty()) {
			audienciaCabeceraLst.stream().forEach(audienciaCabecera ->{
				try {
					leyLobbyFeignClient.getAudienciaDetalle(audienciaCabecera.getAudienceDetailId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean getInstitucionesDetalle() throws Exception {
		
		Long pages = cabeceraAudienciaRepository.count()/1000;
		
		Integer currentPage = 0;
		
		Integer lastPage = pages.intValue();
		
		log.info("Ultima pagina: {}", lastPage);
		
		for(Integer actualPage = currentPage; actualPage <= lastPage;  actualPage++) {
			Page<AudienciaCabecera> audienciaCabeceraPage = cabeceraAudienciaRepository.findAll(new PageRequest(actualPage, 1000));
			List<AudienciaCabecera> audienciaCabeceraLst = audienciaCabeceraPage.getContent();
			if(audienciaCabeceraLst != null && !audienciaCabeceraLst.isEmpty()) {
				for(AudienciaCabecera audienciaCabecera : audienciaCabeceraLst) {	
					Integer institucionId = Integer.parseInt(audienciaCabecera.getInstitucionUrl().split("/")[6]);
					InstitucionDetalle institucionDetalle = institucionDetalleRepository.findOne(institucionId);
					if(institucionDetalle == null) {//no existe el organismo
						try {
							institucionDetalle = new InstitucionDetalle();
							String institucionDetalleStr = leyLobbyFeignClient.getInstitucionDetalle(institucionId).getBody();
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
	public List<SujetoPasivoAudienciaDTO> findByPasivoAudiencias(String nombre) throws Exception {
		
		List<SujetoPasivoAudienciaDTO> pasivoDetalleLst = cabeceraAudienciaRepository.findByPasivoAudiencias(nombre);    
		
		return pasivoDetalleLst;
	}
	
	

}