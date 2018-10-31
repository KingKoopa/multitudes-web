package cl.cleardigital.web.multitudes.service;

import java.util.Date;
import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.LicitacionesAdjudicadasDetalleDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.licitaciones.LicitacionDetailDTO;

public interface MercadoPublicoService {
	
	public Boolean getLicitacionPorFecha(Date fechaDesde, Date fechaHasta) throws Exception;
	
	public List<LicitacionDetailDTO> getLicitacionDetallePorRutProveedor(String rutProveedor) throws Exception;
	
	public List<SujetoPasivoCabeceraDTO> getCompradoresPorRut(String rutUnidad) throws Exception;
	
	public List<SujetoActivoCabeceraDTO> getVendedoresPorRut(String rutVendedor) throws Exception;
	
	public SujetoPasivoCabeceraDTO getFichaSujetoPasivo(String rutOrganismo, java.sql.Date fechaDesde, java.sql.Date fechaHasta) throws Exception;
	
	public SujetoActivoCabeceraDTO getFichaSujetoActivo(String rutOrganismo, java.sql.Date fechaDesde, java.sql.Date fechaHasta) throws Exception;
	
	public List<LicitacionesAdjudicadasDetalleDTO> getDetalleLicitacionAdjudicada(String rutAdjudicado, String tipo) throws Exception;
	
	public List<LicitacionesAdjudicadasDetalleDTO> getDistinctByLicitacionAdjudicadaRutProveedor(String rutAdjudicado, String tipo)throws Exception;
}
