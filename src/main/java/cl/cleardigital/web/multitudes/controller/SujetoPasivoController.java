package cl.cleardigital.web.multitudes.controller;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;
import cl.cleardigital.web.multitudes.service.MercadoPublicoService;

@Controller
@RequestMapping("/")
public class SujetoPasivoController {

	private static final Logger log = LoggerFactory.getLogger(SujetoPasivoController.class);
	
	
	@Autowired
	private MercadoPublicoService mercadoPublicoService;

	@RequestMapping(path= {"ficha-sujeto-pasivo"}, method = RequestMethod.GET)
	public ModelAndView fichaSujetoPasivo() throws Exception{
		ModelAndView modelAndView = new ModelAndView("passive-subject-list");
		return modelAndView;
	}
	

	
	@RequestMapping(path= {"ficha-sujeto-pasivo-cabecera"}, method = RequestMethod.POST)
	public ModelAndView getSujetoPasivoData(
			@RequestParam(value="fiscalId", required=false) String fiscalId
			,@RequestParam(value="fechaDesde", required=false) Date fechaDesde
			,@RequestParam(value="fechaHasta", required=false) Date fechaHasta) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView("passive-subject-list");
		SujetoPasivoCabeceraDTO sujetoPasivoCabeceraDTO = new SujetoPasivoCabeceraDTO();
		if(fiscalId != null) {
			sujetoPasivoCabeceraDTO = mercadoPublicoService.getFichaSujetoPasivo(fiscalId, fechaDesde, fechaHasta);
			sujetoPasivoCabeceraDTO.setFechaDesde(fechaDesde);
			sujetoPasivoCabeceraDTO.setFechaHasta(fechaHasta);
		}
		modelAndView.addObject("sujetoPasivoCabeceraDTO", sujetoPasivoCabeceraDTO);
		return modelAndView;
	} 
	
	
}
