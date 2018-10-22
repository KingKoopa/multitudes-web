package cl.cleardigital.web.multitudes.dto.leylobby;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DetalleAudienciaDTO implements Serializable
{
    private String comuna;

    private String nombres;

    private String apellidos;

    private String lugar;

    private String sujeto_pasivo_url;

    private String institucion_url;

    private String fecha_termino;

    private String cargo;

    private List<AsistenteDTO> asistentes;
    
    private List<MateriaDTO> materias;

    private String fecha_inicio;

    private String forma;

    private String referencia;

    public String getComuna ()
    {
        return comuna;
    }

    public void setComuna (String comuna)
    {
        this.comuna = comuna;
    }

    public String getNombres ()
    {
        return nombres;
    }

    public void setNombres (String nombres)
    {
        this.nombres = nombres;
    }

    public String getApellidos ()
    {
        return apellidos;
    }

    public void setApellidos (String apellidos)
    {
        this.apellidos = apellidos;
    }

    public String getLugar ()
    {
        return lugar;
    }

    public void setLugar (String lugar)
    {
        this.lugar = lugar;
    }

    public String getSujeto_pasivo_url ()
    {
        return sujeto_pasivo_url;
    }

    public void setSujeto_pasivo_url (String sujeto_pasivo_url)
    {
        this.sujeto_pasivo_url = sujeto_pasivo_url;
    }

    public String getInstitucion_url ()
    {
        return institucion_url;
    }

    public void setInstitucion_url (String institucion_url)
    {
        this.institucion_url = institucion_url;
    }

    public String getFecha_termino ()
    {
        return fecha_termino;
    }

    public void setFecha_termino (String fecha_termino)
    {
        this.fecha_termino = fecha_termino;
    }

    public String getCargo ()
    {
        return cargo;
    }

    public void setCargo (String cargo)
    {
        this.cargo = cargo;
    }

    public List<AsistenteDTO> getAsistentes ()
    {
        return asistentes;
    }

    public void setAsistentes (List<AsistenteDTO> asistentes)
    {
        this.asistentes = asistentes;
    }

    public List<MateriaDTO> getMaterias() {
		return materias;
	}

	public void setMaterias(List<MateriaDTO> materias) {
		this.materias = materias;
	}

	public String getFecha_inicio ()
    {
        return fecha_inicio;
    }

    public void setFecha_inicio (String fecha_inicio)
    {
        this.fecha_inicio = fecha_inicio;
    }

    public String getForma ()
    {
        return forma;
    }

    public void setForma (String forma)
    {
        this.forma = forma;
    }

    public String getReferencia ()
    {
        return referencia;
    }

    public void setReferencia (String referencia)
    {
        this.referencia = referencia;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [comuna = "+comuna+", nombres = "+nombres+", apellidos = "+apellidos+", lugar = "+lugar+", sujeto_pasivo_url = "+sujeto_pasivo_url+", institucion_url = "+institucion_url+", fecha_termino = "+fecha_termino+", cargo = "+cargo+", asistentes = "+asistentes+", fecha_inicio = "+fecha_inicio+", forma = "+forma+", referencia = "+referencia+"]";
    }
}
