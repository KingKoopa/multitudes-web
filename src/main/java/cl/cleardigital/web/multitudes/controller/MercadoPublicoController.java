package cl.cleardigital.web.multitudes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.cleardigital.web.multitudes.dto.licitaciones.LicitacionDetailDTO;
import cl.cleardigital.web.multitudes.service.MercadoPublicoService;
import cl.cleardigital.web.multitudes.util.RUTValidator;

@Controller
@RequestMapping({"mercado-publico"})
public class MercadoPublicoController {
	
	@Autowired
	private MercadoPublicoService mainService;
	
	@Autowired
	private RUTValidator RUTValidator;
	
	@RequestMapping(value="/traer-licitaciones-por-dia", method = RequestMethod.GET)
	public ResponseEntity<?> traerLicitacionesPorDia() throws Exception{
		
		return new ResponseEntity<Boolean>(mainService.getLicitacionPorFecha(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/traer-licitaciones-por-rut-proveedor/{rutProveedor}", method = RequestMethod.GET)
	public ResponseEntity<?> getLicitacionDetallePorRutProveedor(
			@PathVariable(name="rutProveedor") String rutProveedor) throws Exception{
		
		List<LicitacionDetailDTO> licitacionDetailDTOLst = mainService.getLicitacionDetallePorRutProveedor(RUTValidator.formatRUT(rutProveedor));
		
		return new ResponseEntity<List<LicitacionDetailDTO>>(licitacionDetailDTOLst, HttpStatus.OK);
	}

}
