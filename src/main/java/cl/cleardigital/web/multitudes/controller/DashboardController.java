package cl.cleardigital.web.multitudes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.cleardigital.web.multitudes.dto.dashboard.AudienciasPorMesDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPrivadasDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPublicasDTO;
import cl.cleardigital.web.multitudes.service.LeyLobbyService;

@Controller
@RequestMapping({"dashboard"})

public class DashboardController {
	
	@Autowired
	private LeyLobbyService lobbyService;
	
	@RequestMapping(path= {""}, method = RequestMethod.GET)
	public ModelAndView dashboard() throws Exception{
		ModelAndView modelAndView = new ModelAndView("dashboard");
		return modelAndView;
	}
	
	@RequestMapping(value = "/audiencias-por-mes", method = RequestMethod.GET)
	public ResponseEntity<?> getAudienciasPorMes(
			) throws Exception {
		List<AudienciasPorMesDTO> audienciasPorMesDTOLst = lobbyService.getAudienciasPorMes();
		
		return new ResponseEntity<List<AudienciasPorMesDTO>>(audienciasPorMesDTOLst, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/top-audiencias-publicas", method = RequestMethod.GET)
	public ResponseEntity<?> getTopAudienciasPublicas(
			) throws Exception {
		
		List<Top10AudienciasPublicasDTO> top10AudienciasPublicasLst  = lobbyService.getTop10AudienciasPublicas();
		
		return new ResponseEntity<List<Top10AudienciasPublicasDTO>>(top10AudienciasPublicasLst, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/top-audiencias-privadas", method = RequestMethod.GET)
	public ResponseEntity<?> getTopAudienciasPrivadas(
			) throws Exception {
		
		List<Top10AudienciasPrivadasDTO> top10AudienciasPrivadasLst  = lobbyService.getTop10AudienciasPrivadas();
		
		return new ResponseEntity<List<Top10AudienciasPrivadasDTO>>(top10AudienciasPrivadasLst, HttpStatus.OK);	

	}
}
