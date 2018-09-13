package cl.cleardigital.web.multitudes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	

}
