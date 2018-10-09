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
import cl.cleardigital.web.multitudes.service.LeyLobbyService;

@Controller
@RequestMapping({"dashboard"})

public class DashboardController {
	
	@Autowired
	private LeyLobbyService lobbyService;
	
	@RequestMapping(path= {""}, method = RequestMethod.GET)
	public ModelAndView charts() throws Exception{
		ModelAndView modelAndView = new ModelAndView("dashboard");
		return modelAndView;
	}
	
	@RequestMapping(value = "/audiencias-por-mes", method = RequestMethod.GET)
	public ResponseEntity<?> getAudienciasPorMes(
			) throws Exception {
		List<AudienciasPorMesDTO> audienciasPorMesDTOLst = lobbyService.getAudienciasPorMes();
		
		return new ResponseEntity<List<AudienciasPorMesDTO>>(audienciasPorMesDTOLst, HttpStatus.OK);	
	}
	
	
}
