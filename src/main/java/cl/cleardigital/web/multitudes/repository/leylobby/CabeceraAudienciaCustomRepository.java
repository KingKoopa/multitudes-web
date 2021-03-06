package cl.cleardigital.web.multitudes.repository.leylobby;

import java.sql.Date;
import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;

public interface CabeceraAudienciaCustomRepository {
	
	public List<SujetoPasivoAudienciaDTO> findByPasivoAudiencias(String nombre, Date fechaDesde, Date fechaHasta)throws Exception;
	
	public List<SujetoActivoAudienciaDTO> findByActivoAudiencias(String rut, Date fechaDesde, Date fechaHasta)throws Exception;
	
	public List<SujetoActivoAudienciaDTO> findByActivoAudienciasDetalle(String rut, Date fechaDesde, Date fechaHasta, Integer cargoId)throws Exception;
	
	public Integer getCantidadSujetosActivos(Integer audienciaId)throws Exception;
	

}
