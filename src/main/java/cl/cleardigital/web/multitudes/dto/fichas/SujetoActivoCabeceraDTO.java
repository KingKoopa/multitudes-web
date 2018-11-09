package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@SuppressWarnings("serial")
public class SujetoActivoCabeceraDTO implements Serializable{
	
	private String nombreProveedor;
	private String rutProveedor;
	private String giro;
	private String region;
	private Long monto;
	private String tipoProveedor;
	private Integer numeroAudiencias;
	private Integer numeroLicitaciones;
	private String displayableName; //Nombre & Region Proveedor
	private List<SujetoActivoAudienciaDTO> sujetosActivos;
	private List<SujetoActivoLicitacionesDTO> sujetoLicitaciones;
	
	
		


	public String getDisplayableName() {
		
		this.displayableName = this.rutProveedor 
							  + " " + this.nombreProveedor;
		//Remover los acentos
		this.displayableName = StringUtils.stripAccents(this.displayableName);
		return displayableName;
	}
    
	public void setDisplayableName(String displayableName) 
	{
		this.displayableName = displayableName;
	}
    public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public List<SujetoActivoAudienciaDTO> getSujetosActivos() 
	{
		return sujetosActivos;
	}
	
		public List<SujetoActivoLicitacionesDTO> getSujetoLicitaciones() 
	{
		return sujetoLicitaciones;
	}
		
		public Integer getNumeroLicitaciones()
	{
		return numeroLicitaciones;
	}
	public String getNombreProveedor() 
	{
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) 
	{
		this.nombreProveedor = nombreProveedor;
	}
	public String getRutProveedor() 
	{
		return rutProveedor;
	}
	public void setRutProveedor(String rutProveedor) 
	{
		this.rutProveedor = rutProveedor;
	}
	public String getGiro() 
	{
		return giro;
	}
	public void setGiro(String giro) 
	{
		this.giro = giro;
	}
	public Long getMonto() 
	{
		return monto;
	}
	public void setMonto(Long monto)
	{
		this.monto = monto;
	}
	public String getTipoProveedor() 
	{
		return tipoProveedor;
	}
	public void setTipoProveedor(String tipoProveedor)
	{
		this.tipoProveedor = tipoProveedor;
	}
	public Integer getNumeroAudiencias() 
	{
		return numeroAudiencias;
	}
	public void setNumeroAudiencias(Integer numeroAudiencias) 
	{
		this.numeroAudiencias = numeroAudiencias;
	}
	public void setNumeroLicitaciones(Integer numeroLicitaciones)
	{
		this.numeroLicitaciones = numeroLicitaciones;
	}
	public void setSujetosActivos(List<SujetoActivoAudienciaDTO> sujetosActivos) 
	{
		this.sujetosActivos = sujetosActivos;
	}
	public void setSujetoLicitaciones(List<SujetoActivoLicitacionesDTO> sujetoLicitaciones) 
	{
		this.sujetoLicitaciones = sujetoLicitaciones;
	}

	@Override
	public String toString() {
		return "SujetoActivoCabeceraDTO [nombreProveedor=" + nombreProveedor + ", rutProveedor=" + rutProveedor
				+ ", giro=" + giro + ", region=" + region + ", monto=" + monto + ", tipoProveedor=" + tipoProveedor
				+ ", numeroAudiencias=" + numeroAudiencias + ", numeroLicitaciones=" + numeroLicitaciones
				+ ", displayableName=" + displayableName + ", sujetosActivos=" + sujetosActivos
				+ ", sujetoLicitaciones=" + sujetoLicitaciones + "]";
	}
	



	

		
}		
	
	