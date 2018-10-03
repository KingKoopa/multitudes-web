package cl.cleardigital.web.multitudes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;
import cl.cleardigital.web.multitudes.service.LeyLobbyService;

@Controller
@RequestMapping({"ley-lobby"})
public class LeyLobbyController {
	
	@Autowired
	private LeyLobbyService leyLobbyService;
	
	@RequestMapping(value="/traer-audiencias-por-pagina", method = RequestMethod.GET)
	public ResponseEntity<?> traerAudienciasHeader() throws Exception{
		
		return new ResponseEntity<Boolean>(leyLobbyService.getAudienciasHeaders(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/traer-institucion-detalle", method = RequestMethod.GET)
	public ResponseEntity<?> traerInstitucionDetalle() throws Exception{
		
		return new ResponseEntity<Boolean>(leyLobbyService.getInstitucionesDetalle(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/traer-audiencia-detalle", method = RequestMethod.GET)
	public ResponseEntity<?> traerDetalleAudiencia() throws Exception{
		
		return new ResponseEntity<Boolean>(leyLobbyService.getAudienciasDetalle(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/traer-pasivo-detalle", method = RequestMethod.GET)
	public ResponseEntity<?> getPasivoAudiencias(
			@RequestParam(name="nombre") String nombre
			) throws Exception {
		List<SujetoPasivoAudienciaDTO> pasivoDetailDTOLst = leyLobbyService.findByPasivoAudiencias(nombre);
		return new ResponseEntity<List<SujetoPasivoAudienciaDTO>>(pasivoDetailDTOLst, HttpStatus.OK);
	}
	

}
