package cl.cleardigital.web.multitudes.repository.mercadopublico;

import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.LicitacionesAdjudicadasDetalleDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;

public interface LicitacionDetalleCustomRepository {
	
	public List<SujetoPasivoCabeceraDTO> getDistinctByCompradorRutUnidad(String rutUnidad)throws Exception;
	
	public List<SujetoActivoCabeceraDTO> getDistinctByVendedorRutProveedor(String rutProveedor)throws Exception;
	
	public List<LicitacionesAdjudicadasDetalleDTO> getDistinctByLicitacionAdjudicadaRutUnidad(String rutAdjudicado, String tipo)throws Exception;

	public List<LicitacionesAdjudicadasDetalleDTO> getDistinctByLicitacionAdjudicadaRutProveedor(String rutAdjudicado, String tipo)throws Exception;
}
