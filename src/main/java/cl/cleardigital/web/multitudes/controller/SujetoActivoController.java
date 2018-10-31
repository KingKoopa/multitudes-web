package cl.cleardigital.web.multitudes.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.cleardigital.web.multitudes.dto.fichas.LicitacionesAdjudicadasDetalleDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;
import cl.cleardigital.web.multitudes.service.LeyLobbyService;
import cl.cleardigital.web.multitudes.service.MercadoPublicoService;



@Controller
@RequestMapping("/")
public class SujetoActivoController {
	
	@Autowired
	private MercadoPublicoService mercadoPublicoService;
	@Autowired
	private LeyLobbyService leyLobbyService;
	
	private static final Logger log = LoggerFactory.getLogger(SujetoPasivoController.class);
		
	@RequestMapping(path= {"ficha-sujeto-activo"}, method = RequestMethod.GET)
	public ModelAndView fichaSujetoActivo() throws Exception{
		ModelAndView modelAndView = new ModelAndView("active-subject-list");
		return modelAndView;
	}
	
	@RequestMapping(path= {"ficha-sujeto-activo-cabecera"}, method = RequestMethod.POST)
	public ModelAndView getSujetoActivoData(
			@RequestParam(value="fiscalId", required=false) String fiscalId
			,@RequestParam(value="fechaDesde", required=false) Date fechaDesde
			,@RequestParam(value="fechaHasta", required=false) Date fechaHasta) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView("active-subject-list");
		
		SujetoActivoCabeceraDTO sujetoActivoCabeceraDTO = new SujetoActivoCabeceraDTO();
		if(fiscalId != null) {
			sujetoActivoCabeceraDTO = mercadoPublicoService.getFichaSujetoActivo(fiscalId, fechaDesde, fechaHasta);
		}
		modelAndView.addObject("sujetoActivoCabeceraDTO", sujetoActivoCabeceraDTO);
		return modelAndView;
	}
	
	@RequestMapping(path= {"detalle-audiencia-sujeto-activo"}, method = RequestMethod.GET)
	public ModelAndView getSujetoActivoDetail(
			@RequestParam(value="fiscalId", required=false) String fiscalId
			,@RequestParam(value="fechaDesde", required=false) Date fechaDesde
			,@RequestParam(value="fechaHasta", required=false) Date fechaHasta
			,@RequestParam(value="cargoActivoid", required=false) Integer cargoActivoid) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView("adjudicated-audiencias-detail");
		
		List<SujetoActivoAudienciaDTO> sujetoActivoAudienciaDTOLst = new ArrayList<>();
		
		if(fiscalId != null) {
			sujetoActivoAudienciaDTOLst = leyLobbyService.getFichaSujetoActivoDetalle(fiscalId, fechaDesde, fechaHasta, cargoActivoid);
		}
		modelAndView.addObject("sujetoActivoAudienciaDTOLst", sujetoActivoAudienciaDTOLst);
		return modelAndView;	
	}

}
