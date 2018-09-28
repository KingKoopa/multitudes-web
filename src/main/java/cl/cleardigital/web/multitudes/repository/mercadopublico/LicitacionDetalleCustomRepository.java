package cl.cleardigital.web.multitudes.repository.mercadopublico;

import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoLicitacionesAdjudicadasDetalleDTO;

public interface LicitacionDetalleCustomRepository {
	
	public List<SujetoActivoCabeceraDTO> getDistinctByCompradorRutUnidad(String rutUnidad)throws Exception;
	
	public List<SujetoPasivoLicitacionesAdjudicadasDetalleDTO> getDistinctByLicitacionAdjudicadaRutUnidad(String rutAdjudicado, String tipo)throws Exception;
}
