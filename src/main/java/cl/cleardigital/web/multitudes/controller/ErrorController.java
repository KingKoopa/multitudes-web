package cl.cleardigital.web.multitudes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

		
@ExceptionHandler(Throwable.class)
	public ModelAndView handleCourseNotFoundException(Model model, Exception e) {
		ModelAndView modelAndView = new ModelAndView("404");
		return modelAndView;
	}

@RequestMapping(path= {"/error"}, method = RequestMethod.GET)
public ModelAndView main() throws Exception{
	ModelAndView modelAndView = new ModelAndView("404");
	return modelAndView;
}
		

}
	
	

