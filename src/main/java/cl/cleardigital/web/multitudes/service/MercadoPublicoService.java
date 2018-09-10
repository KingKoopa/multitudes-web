package cl.cleardigital.web.multitudes.service;

import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.licitaciones.LicitacionDetailDTO;

public interface MercadoPublicoService {
	
	public Boolean getLicitacionPorFecha() throws Exception;
	
	public List<LicitacionDetailDTO> getLicitacionDetallePorRutProveedor(String rutProveedor) throws Exception;
	
	public SujetoPasivoCabeceraDTO getFichaSujetoPasivo(String rutOrganismo) throws Exception;
}
