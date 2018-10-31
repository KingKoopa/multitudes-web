package cl.cleardigital.web.multitudes.dto.dashboard;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Top10ProveedorLicitacionesDTO {

	private Integer cantidad;
	private String nombreProveedor;
	private String rutProveedor;
	private Integer totalAdjudicado;
	
	
	public Integer getTotalAdjudicado() {
		return totalAdjudicado;
	}
	public void setTotalAdjudicado(Integer totalAdjudicado) {
		this.totalAdjudicado = totalAdjudicado;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getRutProveedor() {
		return rutProveedor;
	}
	public void setRutProveedor(String rutProveedor) {
		this.rutProveedor = rutProveedor;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
	
}
