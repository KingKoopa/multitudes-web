package cl.cleardigital.web.multitudes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(path= {"ficha-sujeto-pasivo-cabecera"}, method = RequestMethod.GET)
	public ResponseEntity<?> getSujetoPasivoData(
			@RequestParam(value="rutOrganismo", required=false) String rutOrganismo) throws Exception{
		return new ResponseEntity<SujetoPasivoCabeceraDTO>(mercadoPublicoService.getFichaSujetoPasivo(rutOrganismo), HttpStatus.OK);
	}
	
}
