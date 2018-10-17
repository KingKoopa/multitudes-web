package cl.cleardigital.web.multitudes.repository.leylobby;

import java.util.List;

import cl.cleardigital.web.multitudes.dto.dashboard.AudienciasPorMesDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPrivadasDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPublicasDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10CompradorLicitacionesDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10ProveedorLicitacionesDTO;

public interface DashboardCustomRepository {
	
	public List<Top10AudienciasPublicasDTO> getTop10AudienciasPublicas() throws Exception;
	
	public List<AudienciasPorMesDTO> getAudienciasPorMes() throws Exception;
	
	public List<Top10AudienciasPrivadasDTO> getTop10AudienciasPrivadas() throws Exception;
	
	
	public List<Top10CompradorLicitacionesDTO> getTop10CompradorLicitaciones() throws Exception;
	
	public List<Top10ProveedorLicitacionesDTO> getTop10ProveedorLicitaciones() throws Exception;

}
