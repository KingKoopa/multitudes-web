package cl.cleardigital.web.multitudes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(path= {"main"}, method = RequestMethod.GET)
	public ModelAndView main() throws Exception{
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@RequestMapping(path= {"ficha-por-categoria"}, method = RequestMethod.GET)
	public ModelAndView fichaPorCategoria() throws Exception{
		ModelAndView modelAndView = new ModelAndView("category-subject-list");
		return modelAndView;
	}
	
	@RequestMapping(path= {""}, method = RequestMethod.GET)
	public ModelAndView home() throws Exception{
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	
}
