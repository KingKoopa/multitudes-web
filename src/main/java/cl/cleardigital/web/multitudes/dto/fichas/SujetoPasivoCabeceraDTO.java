package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class SujetoPasivoCabeceraDTO implements Serializable{

	private String nombreComprador;
	private String rutComprador;
	private Integer montoLicitado;
	private Integer sujetosPasivosCantidad;
	private Integer numeroAudiencias;
	private Integer licitacionesPublicas;
	private List<SujetoPasivoCabeceraLicitacionesDTO> cabecerasLicitacion;
	
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
	public Integer getMontoLicitado() {
		return montoLicitado;
	}
	public void setMontoLicitado(Integer montoLicitado) {
		this.montoLicitado = montoLicitado;
	}
	public Integer getSujetosPasivosCantidad() {
		return sujetosPasivosCantidad;
	}
	public void setSujetosPasivosCantidad(Integer sujetosPasivosCantidad) {
		this.sujetosPasivosCantidad = sujetosPasivosCantidad;
	}
	public Integer getNumeroAudiencias() {
		return numeroAudiencias;
	}
	public void setNumeroAudiencias(Integer numeroAudiencias) {
		this.numeroAudiencias = numeroAudiencias;
	}
	public Integer getLicitacionesPublicas() {
		return licitacionesPublicas;
	}
	public void setLicitacionesPublicas(Integer licitacionesPublicas) {
		this.licitacionesPublicas = licitacionesPublicas;
	}
	public List<SujetoPasivoCabeceraLicitacionesDTO> getCabecerasLicitacion() {
		return cabecerasLicitacion;
	}
	public void setCabecerasLicitacion(List<SujetoPasivoCabeceraLicitacionesDTO> cabecerasLicitacion) {
		this.cabecerasLicitacion = cabecerasLicitacion;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
	
	
}
