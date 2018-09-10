package cl.cleardigital.web.multitudes.dto.fichas;

public class SujetoActivoLicitacionesDTO {
	
	private String Tipo;
	private Integer cantidad;
	private Integer Monto;
	
	public String getTipo() 
	{
		return Tipo;
	}
	public void setTipo(String tipo)
	{
		Tipo = tipo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) 
	{
		this.cantidad = cantidad;
	}
	public Integer getMonto() 
	{
		return Monto;
	}
	public void setMonto(Integer monto)
	{
		Monto = monto;
	}
	
	@Override
	public String toString() {
		return "SujetoActivoLicitacionesDTO [Tipo=" + Tipo + ", cantidad=" + cantidad + ", Monto=" + Monto + "]";
	}
	
	

}
