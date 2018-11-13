package cl.cleardigital.web.multitudes.dto.leylobby;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cl.cleardigital.web.multitudes.dto.fichas.InstitucionDetalleDTO;

@SuppressWarnings("serial")
public class CargoPasivoDTO implements Serializable
{

    private String nombres;

    private String audiencias_url;

    private String apellidos;

    private String donativos_url;

    private String viajes_url;

    private String resolucion_url;

    private String institucion_url;

    private String cargo;

    private String fecha_termino;

    private String fecha_inicio;

    private InstitucionDetalleDTO institucion;

    public String getNombres ()
    {
        return nombres;
    }

    public void setNombres (String nombres)
    {
        this.nombres = nombres;
    }

    public String getAudiencias_url ()
    {
        return audiencias_url;
    }

    public void setAudiencias_url (String audiencias_url)
    {
        this.audiencias_url = audiencias_url;
    }

    public String getApellidos ()
    {
        return apellidos;
    }

    public void setApellidos (String apellidos)
    {
        this.apellidos = apellidos;
    }

    public String getDonativos_url ()
    {
        return donativos_url;
    }

    public void setDonativos_url (String donativos_url)
    {
        this.donativos_url = donativos_url;
    }

    public String getViajes_url ()
    {
        return viajes_url;
    }

    public void setViajes_url (String viajes_url)
    {
        this.viajes_url = viajes_url;
    }

    public String getResolucion_url ()
    {
        return resolucion_url;
    }

    public void setResolucion_url (String resolucion_url)
    {
        this.resolucion_url = resolucion_url;
    }

    public String getInstitucion_url ()
    {
        return institucion_url;
    }

    public void setInstitucion_url (String institucion_url)
    {
        this.institucion_url = institucion_url;
    }

    public String getCargo ()
    {
        return cargo;
    }

    public void setCargo (String cargo)
    {
        this.cargo = cargo;
    }

    public String getFecha_termino ()
    {
        return fecha_termino;
    }

    public void setFecha_termino (String fecha_termino)
    {
        this.fecha_termino = fecha_termino;
    }

    public String getFecha_inicio ()
    {
        return fecha_inicio;
    }

    public void setFecha_inicio (String fecha_inicio)
    {
        this.fecha_inicio = fecha_inicio;
    }

    public InstitucionDetalleDTO getInstitucion() {
		return institucion;
	}

	public void setInstitucion(InstitucionDetalleDTO institucion) {
		this.institucion = institucion;
	}

	@Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
