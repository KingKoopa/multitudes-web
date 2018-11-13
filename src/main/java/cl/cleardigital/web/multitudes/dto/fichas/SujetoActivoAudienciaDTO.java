package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class SujetoActivoAudienciaDTO implements Serializable{
	
	private String sujetoActivo;
	private String sujetoPasivo;
	private String cargoPasivo;
	private String fecha;
	private String tema;
	private String materias;
	private String organismo;
	private Integer cantidad;
	private Boolean remunerado;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer cargoId;
	
	
	
	public String getSujetoPasivo() {
		return sujetoPasivo;
	}
	public void setSujetoPasivo(String sujetoPasivo) {
		this.sujetoPasivo = sujetoPasivo;
	}
	public String getCargoPasivo() {
		return cargoPasivo;
	}
	public void setCargoPasivo(String cargoPasivo) {
		this.cargoPasivo = cargoPasivo;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public Integer getCargoId() {
		return cargoId;
	}
	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Boolean getRemunerado() {
		return remunerado;
	}
	public void setRemunerado(Boolean remunerado) {
		this.remunerado = remunerado;
	}
	public String getSujetoActivo()
	{
		return sujetoActivo;
	}
	public void setSujetoActivo(String sujetoActivo)
	{
		this.sujetoActivo = sujetoActivo;
	}
	public String getFecha() 
	{
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
		
	}
	public String getTema() 
	{
		return tema;
	}
	public void setTema(String tema) 
	{
		this.tema = tema;
	}
	public String getMaterias()
	{
		return materias;
	}
	public void setMaterias(String materias) 
	{
		this.materias = materias;
	}
	public String getOrganismo() 
	{
		return organismo;
	}
	public void setOrganismo(String organismo) 
	{
		this.organismo = organismo;
	}
	
	@Override
	public String toString() {
		return "SujetoActivoAudienciaDTO [sujetoActivo=" + sujetoActivo + ", fecha=" + fecha + ", tema=" + tema
				+ ", materias=" + materias + ", organismo=" + organismo + "]";
	}
	
	
	
}