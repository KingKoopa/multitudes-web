package cl.cleardigital.web.multitudes.dto.fichas;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InstitucionDetalleDTO implements Serializable{

    private String codigo;

    private String nombre;

    private String audiencias_url;

    private String sujetos_activos_url;

    private String sujetos_pasivos_url;

    private String donativos_url;

    private String viajes_url;

    public String getCodigo ()
    {
        return codigo;
    }

    public void setCodigo (String codigo)
    {
        this.codigo = codigo;
    }

    public String getNombre ()
    {
        return nombre;
    }

    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    public String getAudiencias_url ()
    {
        return audiencias_url;
    }

    public void setAudiencias_url (String audiencias_url)
    {
        this.audiencias_url = audiencias_url;
    }

    public String getSujetos_activos_url ()
    {
        return sujetos_activos_url;
    }

    public void setSujetos_activos_url (String sujetos_activos_url)
    {
        this.sujetos_activos_url = sujetos_activos_url;
    }

    public String getSujetos_pasivos_url ()
    {
        return sujetos_pasivos_url;
    }

    public void setSujetos_pasivos_url (String sujetos_pasivos_url)
    {
        this.sujetos_pasivos_url = sujetos_pasivos_url;
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

    @Override
    public String toString()
    {
        return "ClassPojo [codigo = "+codigo+", nombre = "+nombre+", audiencias_url = "+audiencias_url+", sujetos_activos_url = "+sujetos_activos_url+", sujetos_pasivos_url = "+sujetos_pasivos_url+", donativos_url = "+donativos_url+", viajes_url = "+viajes_url+"]";
    }
	
}
