package cl.cleardigital.web.multitudes.repository.mercadopublico;

import java.util.List;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoLicitacionesAdjudicadasDetalleDTO;

public interface LicitacionDetalleCustomRepository {
	
	public List<SujetoPasivoCabeceraDTO> getDistinctByCompradorRutUnidad(String rutUnidad)throws Exception;
	
	public List<SujetoActivoCabeceraDTO> getDistinctByVendedorRutProveedor(String rutProveedor)throws Exception;
	
	public List<SujetoPasivoLicitacionesAdjudicadasDetalleDTO> getDistinctByLicitacionAdjudicadaRutUnidad(String rutAdjudicado, String tipo)throws Exception;
}
