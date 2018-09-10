package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class SujetoPasivoCabeceraLicitacionesDTO implements Serializable {
	
	private String tipoLicitacion;
	private Integer cantidad;
	private Integer monto;
	
	public String getTipoLicitacion() {
		return tipoLicitacion;
	}
	public void setTipoLicitacion(String tipoLicitacion) {
		this.tipoLicitacion = tipoLicitacion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	
	
}
