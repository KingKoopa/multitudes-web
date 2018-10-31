package cl.cleardigital.web.multitudes.service;

import java.sql.Date;
import java.util.List;

import cl.cleardigital.web.multitudes.dto.dashboard.AudienciasPorMesDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPrivadasDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPublicasDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10CompradorLicitacionesDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10ProveedorLicitacionesDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;


public interface LeyLobbyService {
	
	public Boolean getAudienciasHeaders() throws Exception;
	
	public Boolean getAudienciasDetalle() throws Exception;
	
	public Boolean getInstitucionesDetalle() throws Exception;
	
	public List<AudienciasPorMesDTO> getAudienciasPorMes()throws Exception;
	
	public List<SujetoPasivoAudienciaDTO> findByPasivoAudiencias(String nombre, Date fechaDesde, Date fechaHasta)throws Exception;
	
	public List<SujetoActivoAudienciaDTO> findByActivoAudiencias(String rut, Date fechaDesde, Date fechaHasta)throws Exception;
	
	public List<Top10AudienciasPublicasDTO> getTop10AudienciasPublicas() throws Exception;
	
	public List<Top10AudienciasPrivadasDTO> getTop10AudienciasPrivadas() throws Exception;
	
	public List<Top10CompradorLicitacionesDTO> getTop10CompradorLicitaciones() throws Exception;
	
	public List<Top10ProveedorLicitacionesDTO> getTop10ProveedorLicitaciones() throws Exception;
	
	public List<SujetoActivoAudienciaDTO> getFichaSujetoActivoDetalle(String rutOrganismo, java.sql.Date fechaDesde, java.sql.Date fechaHasta, Integer cargoId) throws Exception;
}
