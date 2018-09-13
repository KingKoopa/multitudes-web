package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@SuppressWarnings("serial")
public class SujetoActivoCabeceraDTO implements Serializable{
	
	private String nombreProveedor;
	private String rutProveedor;
	private String giro;
	private Integer monto;
	private String tipoProveedor;
	private Integer numeroAudiencias;
	private Integer numeroLicitaciones;
	private List<SujetoActivoAudienciaDTO> sujetosActivos;
	private List<SujetoActivoLicitacionesDTO> sujetoLicitaciones;
	
		
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
	public Integer getMonto() 
	{
		return monto;
	}
	public void setMonto(Integer monto)
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
				+ ", giro=" + giro + ", monto=" + monto + ", tipoProveedor=" + tipoProveedor + ", numeroAudiencias="
				+ numeroAudiencias + ", numeroLicitaciones=" + numeroLicitaciones + ", sujetosActivos=" + sujetosActivos
				+ ", sujetoLicitaciones=" + sujetoLicitaciones + "]";
	}

		
}		
	
	