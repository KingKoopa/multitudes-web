package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class LicitacionesAdjudicadasDetalleDTO implements Serializable{
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String fecha;
	
	private String codigoExterno;
	private String region;
	private String tomaRazon;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCodigoExterno() {
		return codigoExterno;
	}
	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTomaRazon() {
		return tomaRazon;
	}
	public void setTomaRazon(String tomaRazon) {
		this.tomaRazon = tomaRazon;
	}
	@Override
	public String toString() {
		return "SujetoActivoLicitacionesAdjudicadasDetalleDTO [fecha=" + fecha + ", codigoExterno=" + codigoExterno
				+ ", region=" + region + ", tomaRazon=" + tomaRazon + "]";
	}

	
	

}
