package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class SujetoPasivoAudienciaDTO implements Serializable {

private Integer sujetoPasivosCantidad;
private String nombreCompleto;
private String cargo;
private Integer cantidadDeAudiencias;
private Integer sujetoActivosCantidad;

public Integer getSujetoPasivosCantidad() {
	return sujetoPasivosCantidad;
}
public void setSujetoPasivosCantidad(Integer sujetoPasivosCantidad) {
	this.sujetoPasivosCantidad = sujetoPasivosCantidad;
}
public String getNombreCompleto() {
	return nombreCompleto;
}
public void setNombreCompleto(String nombreCompleto) {
	this.nombreCompleto = nombreCompleto;
}
public String getCargo() {
	return cargo;
}
public void setCargo(String cargo) {
	this.cargo = cargo;
}
public Integer getCantidadDeAudiencias() {
	return cantidadDeAudiencias;
}
public void setCantidadDeAudiencias(Integer cantidadDeAudiencias) {
	this.cantidadDeAudiencias = cantidadDeAudiencias;
}
public Integer getSujetoActivosCantidad() {
	return sujetoActivosCantidad;
}
public void setSujetoActivosCantidad(Integer sujetoActivosCantidad) {
	this.sujetoActivosCantidad = sujetoActivosCantidad;
}


@Override
public String toString() {
	return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
}


	
	
	
}
