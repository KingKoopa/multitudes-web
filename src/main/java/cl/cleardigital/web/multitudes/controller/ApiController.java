package cl.cleardigital.web.multitudes.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("api")
public class ApiController {
	
	@Autowired
	private MercadoPublicoService mercadoPublicoService;
	
	private static final Logger log = LoggerFactory.getLogger(SujetoPasivoController.class);
		

	@RequestMapping(value= {"sujeto-activo"}, method = RequestMethod.GET)
	public ResponseEntity<?> getSujetoActivoData(
			@RequestParam(value="fiscalId", required=false) String fiscalId
			,@RequestParam(value="fechaDesde", required=false) Date fechaDesde
			,@RequestParam(value="fechaHasta", required=false) Date fechaHasta) throws Exception{
	
		
		SujetoActivoCabeceraDTO sujetoActivoCabeceraDTO = new SujetoActivoCabeceraDTO();
		if(fiscalId != null) {
			sujetoActivoCabeceraDTO = mercadoPublicoService.getFichaSujetoActivo(fiscalId, fechaDesde, fechaHasta);
		}

		return new ResponseEntity<SujetoActivoCabeceraDTO>(sujetoActivoCabeceraDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value= {"sujeto-pasivo"}, method = RequestMethod.GET)
	public ResponseEntity<?> getSujetoPasivoData(
			@RequestParam(value="fiscalId", required=false) String fiscalId
			,@RequestParam(value="fechaDesde", required=false)Date fechaDesde
			,@RequestParam(value="fechaHasta", required=false) Date fechaHasta) throws Exception{

		SujetoPasivoCabeceraDTO sujetoPasivoCabeceraDTO = new SujetoPasivoCabeceraDTO();
		if(fiscalId != null) {
			sujetoPasivoCabeceraDTO = mercadoPublicoService.getFichaSujetoPasivo(fiscalId, fechaDesde, fechaHasta);
		}

		return new ResponseEntity<SujetoPasivoCabeceraDTO>(sujetoPasivoCabeceraDTO, HttpStatus.OK);
	} 


}
