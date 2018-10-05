package cl.cleardigital.web.multitudes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.service.MercadoPublicoService;



@Controller
@RequestMapping("/")
public class SujetoActivoController {
	
	@Autowired
	private MercadoPublicoService mercadoPublicoService;
	
	private static final Logger log = LoggerFactory.getLogger(SujetoPasivoController.class);
		
	@RequestMapping(path= {"ficha-sujeto-activo"}, method = RequestMethod.GET)
	public ModelAndView fichaSujetoActivo() throws Exception{
		ModelAndView modelAndView = new ModelAndView("active-subject-list");
		return modelAndView;
	}
	
	@RequestMapping(path= {"ficha-sujeto-activo-cabecera"}, method = RequestMethod.POST)
	public ModelAndView getSujetoActivoData(
			@RequestParam(value="fiscalId", required=false) String fiscalId) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView("active-subject-list");
		
		SujetoActivoCabeceraDTO sujetoActivoCabeceraDTO = new SujetoActivoCabeceraDTO();
		if(fiscalId != null) {
			sujetoActivoCabeceraDTO = mercadoPublicoService.getFichaSujetoActivo(fiscalId);
		}
		modelAndView.addObject("sujetoActivoCabeceraDTO", sujetoActivoCabeceraDTO);
		return modelAndView;
	}
	

}
