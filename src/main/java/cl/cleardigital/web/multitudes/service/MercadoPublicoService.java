package cl.cleardigital.web.multitudes.service;

import java.sql.Date;
import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoLicitacionesAdjudicadasDetalleDTO;
import cl.cleardigital.web.multitudes.dto.licitaciones.LicitacionDetailDTO;

public interface MercadoPublicoService {
	
	public Boolean getLicitacionPorFecha() throws Exception;
	
	public List<LicitacionDetailDTO> getLicitacionDetallePorRutProveedor(String rutProveedor) throws Exception;
	
	public List<SujetoPasivoCabeceraDTO> getCompradoresPorRut(String rutUnidad) throws Exception;
	
	public List<SujetoActivoCabeceraDTO> getVendedoresPorRut(String rutVendedor) throws Exception;
	
	public SujetoPasivoCabeceraDTO getFichaSujetoPasivo(String rutOrganismo, Date fechaDesde, Date fechaHasta) throws Exception;
	
	public SujetoActivoCabeceraDTO getFichaSujetoActivo(String rutProveedor) throws Exception;

	public List<SujetoPasivoLicitacionesAdjudicadasDetalleDTO> getDetalleLicitacionAdjudicada(String rutAdjudicado, String tipo) throws Exception;
	
}
