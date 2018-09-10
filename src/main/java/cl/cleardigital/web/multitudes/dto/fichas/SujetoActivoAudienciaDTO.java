package cl.cleardigital.web.multitudes.dto.fichas;

public class SujetoActivoAudienciaDTO {
	
	private String sujetoActivo;
	private String fecha;
	private String tema;
	private String materias;
	private String organismo;
	
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