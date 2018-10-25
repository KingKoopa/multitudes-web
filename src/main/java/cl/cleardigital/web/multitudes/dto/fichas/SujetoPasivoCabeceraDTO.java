package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class SujetoPasivoCabeceraDTO implements Serializable{

	private String nombreComprador;
	private String rutComprador;
	private Long montoLicitado;
	private Integer sujetosPasivosCantidad = 0;
	private Integer numeroAudiencias;
	private Integer licitacionesPublicas;
	private String regionComprador;
	private String displayableName;
	private List<SujetoPasivoCabeceraLicitacionesDTO> cabecerasLicitacion;
	private List<SujetoPasivoAudienciaDTO> sujetoPasivoAudiencias;
	
	public String getDisplayableName() {
		
		this.displayableName = this.rutComprador 
							  + " " + this.nombreComprador
							  + " " + this.regionComprador;
		//Remover los acentos
		this.displayableName = StringUtils.stripAccents(this.displayableName);
		return displayableName;
	}
	public void setDisplayableName(String displayableName) {
		this.displayableName = displayableName;
	}
	
	public String getRegionComprador() {
		return regionComprador;
	}
	public void setRegionComprador(String regionComprador) {
		this.regionComprador = regionComprador;
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
	public Long getMontoLicitado() {
		return montoLicitado;
	}
	public void setMontoLicitado(Long montoLicitado) {
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
	public List<SujetoPasivoAudienciaDTO> getSujetoPasivoAudiencias() {
		return sujetoPasivoAudiencias;
	}
	public void setSujetoPasivoAudiencias(List<SujetoPasivoAudienciaDTO> sujetoPasivoAudiencias) {
		this.sujetoPasivoAudiencias = sujetoPasivoAudiencias;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}

	
	
}
