package cl.cleardigital.web.multitudes.repository.mercadopublico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.cleardigital.web.multitudes.model.mercadopublico.LicitacionItem;

public interface LicitacionItemRepository extends JpaRepository<LicitacionItem, Integer>{
	
	public List<LicitacionItem> findByAdjudicacionRutProveedorAndLicitacionDetalleFechaAdjudicacionBetween(String rutProveedor, String fechaDesde, String fechaHasta);

}
