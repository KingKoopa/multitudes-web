package cl.cleardigital.web.multitudes.repository.mercadopublico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.cleardigital.web.multitudes.model.mercadopublico.LicitacionDetalle;

public interface LicitacionDetalleRepository extends JpaRepository<LicitacionDetalle, String>{
	
	public List<LicitacionDetalle> findDistinctByItemsAdjudicacionRutProveedor(String rutProveedor);
	
<<<<<<< HEAD
	public List<LicitacionDetalle> findByCompradorRutUnidad(String rutOrganismo);
=======
	public List<LicitacionDetalle> findDistinctByCompradorRutUnidad(String rutUnidad);
	
>>>>>>> 7722fa3d6dc97a2375149e854a8d2f3268092baa
}
