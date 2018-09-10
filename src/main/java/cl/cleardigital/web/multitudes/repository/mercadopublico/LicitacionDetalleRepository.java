package cl.cleardigital.web.multitudes.repository.mercadopublico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.cleardigital.web.multitudes.model.mercadopublico.LicitacionDetalle;

public interface LicitacionDetalleRepository extends JpaRepository<LicitacionDetalle, String>{
	
	public List<LicitacionDetalle> findDistinctByItemsAdjudicacionRutProveedor(String rutProveedor);
	
	public List<LicitacionDetalle> findDistinctByCompradorRutUnidad(String rutUnidad);
	
}
