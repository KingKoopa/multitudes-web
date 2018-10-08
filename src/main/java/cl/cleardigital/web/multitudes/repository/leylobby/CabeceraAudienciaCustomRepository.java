package cl.cleardigital.web.multitudes.repository.leylobby;

import java.sql.Date;
import java.util.List;

import cl.cleardigital.web.multitudes.dto.dashboard.AudienciasPorMesDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;

public interface CabeceraAudienciaCustomRepository {
	
	public List<SujetoPasivoAudienciaDTO> findByPasivoAudiencias(String nombre, Date fechaDesde, Date fechaHasta)throws Exception;
	
	public List<SujetoActivoAudienciaDTO> findByActivoAudiencias(String nombre)throws Exception;
	
	public Integer getCantidadSujetosActivos(Integer audienciaId)throws Exception;
	
	public List<AudienciasPorMesDTO> getCantidadAudienciasPorMes()throws Exception;

}
