package cl.cleardigital.web.multitudes.service;

import java.sql.Date;
import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;

public interface LeyLobbyService {
	
	public Boolean getAudienciasHeaders() throws Exception;
	
	public Boolean getAudienciasDetalle() throws Exception;
	
	public Boolean getInstitucionesDetalle() throws Exception;
	
	public List<SujetoPasivoAudienciaDTO> findByPasivoAudiencias(String nombre, Date fechaDesde, Date fechaHasta)throws Exception;
	
	public List<SujetoActivoAudienciaDTO> findByActivoAudiencias(String nombre)throws Exception;
}
