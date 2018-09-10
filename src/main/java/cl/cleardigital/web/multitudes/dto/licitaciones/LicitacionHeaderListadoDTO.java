package cl.cleardigital.web.multitudes.dto.licitaciones;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@SuppressWarnings("serial")
public class LicitacionHeaderListadoDTO implements Serializable {
	
	private Integer Cantidad;
	private String FechaCreacion;
	private String Version;
	private List<LicitacionHeaderDTO> Listado;
	
	public Integer getCantidad() {
		return Cantidad;
	}
	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}
	public String getFechaCreacion() {
		return FechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public List<LicitacionHeaderDTO> getListado() {
		return Listado;
	}
	public void setListado(List<LicitacionHeaderDTO> listado) {
		Listado = listado;
	}
	
	
	
}