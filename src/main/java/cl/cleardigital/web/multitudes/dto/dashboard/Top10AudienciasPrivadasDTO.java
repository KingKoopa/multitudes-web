package cl.cleardigital.web.multitudes.dto.dashboard;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class Top10AudienciasPrivadasDTO implements Serializable{
	
	private Integer cantidad;
	private String proveedor;
	private String rutProveedor;
	
	public String getRutProveedor() {
		return rutProveedor;
	}

	public void setRutProveedor(String rutProveedor) {
		this.rutProveedor = rutProveedor;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
