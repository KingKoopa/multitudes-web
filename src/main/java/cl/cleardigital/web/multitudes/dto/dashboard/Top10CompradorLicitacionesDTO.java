package cl.cleardigital.web.multitudes.dto.dashboard;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Top10CompradorLicitacionesDTO {

	private Integer cantidad;
	private String nombreComprador;
	private String rutComprador;
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombreComprador() {
		return nombreComprador;
	}
	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}
	public String getRutComprador() {
		return rutComprador;
	}
	public void setRutComprador(String rutComprador) {
		this.rutComprador = rutComprador;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
}
