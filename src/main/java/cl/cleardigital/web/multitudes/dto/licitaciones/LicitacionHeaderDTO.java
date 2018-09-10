package cl.cleardigital.web.multitudes.dto.licitaciones;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@SuppressWarnings("serial")
public class LicitacionHeaderDTO implements Serializable {
	
    	private String CodigoExterno;
	private String Nombre;
	private String CodigoEstado;
	private String FechaCierre;
	
	
	public String getCodigoExterno() {
		return CodigoExterno;
	}
	public void setCodigoExterno(String codigoExterno) {
		CodigoExterno = codigoExterno;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCodigoEstado() {
		return CodigoEstado;
	}
	public void setCodigoEstado(String codigoEstado) {
		CodigoEstado = codigoEstado;
	}
	public String getFechaCierre() {
		return FechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		FechaCierre = fechaCierre;
	}

	
	
}