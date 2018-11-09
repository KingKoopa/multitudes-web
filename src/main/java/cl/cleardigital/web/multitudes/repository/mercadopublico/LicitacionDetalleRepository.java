package cl.cleardigital.web.multitudes.repository.mercadopublico;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.cleardigital.web.multitudes.model.mercadopublico.LicitacionDetalle;
import cl.cleardigital.web.multitudes.model.mercadopublico.LicitacionItem;

public interface LicitacionDetalleRepository extends JpaRepository<LicitacionDetalle, String>, LicitacionDetalleCustomRepository{
	
	public List<LicitacionDetalle> findDistinctByItemsAdjudicacionRutProveedor(String rutProveedor);
	
	public List<LicitacionDetalle> findByCompradorRutUnidadAndFechaAdjudicacionBetween(String rutOrganismo, String fechaDesde, String fechaHasta);
	
	public List<LicitacionItem> findByItemsAdjudicacionRutProveedor(String rutProveedor);
}
