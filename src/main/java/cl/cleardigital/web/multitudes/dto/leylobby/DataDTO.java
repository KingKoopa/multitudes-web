package cl.cleardigital.web.multitudes.dto.leylobby;

public class DataDTO
{
    private String vista_publica_institucion_url;

    private String apellidos;

    private String fecha_termino;

    private String vista_publica_detalles_url;

    private String cargo;

    private String referencia;

    private String forma;

    private String id;

    private String detalles_url;

    private String comuna;

    private UpdatedDTO updated_at;

    private String nombres;

    private String lugar;

    private String sujeto_pasivo_url;

    private String institucion_url;

    private String fecha_inicio;

    public String getVista_publica_institucion_url ()
    {
        return vista_publica_institucion_url;
    }

    public void setVista_publica_institucion_url (String vista_publica_institucion_url)
    {
        this.vista_publica_institucion_url = vista_publica_institucion_url;
    }

    public String getApellidos ()
    {
        return apellidos;
    }

    public void setApellidos (String apellidos)
    {
        this.apellidos = apellidos;
    }

    public String getFecha_termino ()
    {
        return fecha_termino;
    }

    public void setFecha_termino (String fecha_termino)
    {
        this.fecha_termino = fecha_termino;
    }

    public String getVista_publica_detalles_url ()
    {
        return vista_publica_detalles_url;
    }

    public void setVista_publica_detalles_url (String vista_publica_detalles_url)
    {
        this.vista_publica_detalles_url = vista_publica_detalles_url;
    }

    public String getCargo ()
    {
        return cargo;
    }

    public void setCargo (String cargo)
    {
        this.cargo = cargo;
    }

    public String getReferencia ()
    {
        return referencia;
    }

    public void setReferencia (String referencia)
    {
        this.referencia = referencia;
    }

    public String getForma ()
    {
        return forma;
    }

    public void setForma (String forma)
    {
        this.forma = forma;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDetalles_url ()
    {
        return detalles_url;
    }

    public void setDetalles_url (String detalles_url)
    {
        this.detalles_url = detalles_url;
    }

    public String getComuna ()
    {
        return comuna;
    }

    public void setComuna (String comuna)
    {
        this.comuna = comuna;
    }

    public UpdatedDTO getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (UpdatedDTO updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getNombres ()
    {
        return nombres;
    }

    public void setNombres (String nombres)
    {
        this.nombres = nombres;
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

    public String getFecha_inicio ()
    {
        return fecha_inicio;
    }

    public void setFecha_inicio (String fecha_inicio)
    {
        this.fecha_inicio = fecha_inicio;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [vista_publica_institucion_url = "+vista_publica_institucion_url+", apellidos = "+apellidos+", fecha_termino = "+fecha_termino+", vista_publica_detalles_url = "+vista_publica_detalles_url+", cargo = "+cargo+", referencia = "+referencia+", forma = "+forma+", id = "+id+", detalles_url = "+detalles_url+", comuna = "+comuna+", updated_at = "+updated_at+", nombres = "+nombres+", lugar = "+lugar+", sujeto_pasivo_url = "+sujeto_pasivo_url+", institucion_url = "+institucion_url+", fecha_inicio = "+fecha_inicio+"]";
    }
}
