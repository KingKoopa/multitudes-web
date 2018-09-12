package cl.cleardigital.web.multitudes.service;

import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.licitaciones.LicitacionDetailDTO;

public interface MercadoPublicoService {
	
	public Boolean getLicitacionPorFecha() throws Exception;
	
	public List<LicitacionDetailDTO> getLicitacionDetallePorRutProveedor(String rutProveedor) throws Exception;
	
	public List<SujetoActivoCabeceraDTO> getCompradoresPorRut(String rutUnidad) throws Exception;
	
}
