package cl.cleardigital.web.multitudes.repository.leylobby;

import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;

public interface CabeceraAudienciaCustomRepository {
	
	public List<SujetoPasivoAudienciaDTO> findByPasivoAudiencias(String nombre)throws Exception;
	
	public List<SujetoActivoAudienciaDTO> findByActivoAudiencias(String nombre)throws Exception;

}
