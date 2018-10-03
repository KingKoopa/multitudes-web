package cl.cleardigital.web.multitudes.dto.leylobby;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AsistenteDTO implements Serializable
{
    private String cargo_activo_url;

    private String nombres;

    private String apellidos;

    private RepresentaDTO representa;

    public String getCargo_activo_url ()
    {
        return cargo_activo_url;
    }

    public void setCargo_activo_url (String cargo_activo_url)
    {
        this.cargo_activo_url = cargo_activo_url;
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

    public RepresentaDTO getRepresenta ()
    {
        return representa;
    }

    public void setRepresenta (RepresentaDTO representa)
    {
        this.representa = representa;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cargo_activo_url = "+cargo_activo_url+", nombres = "+nombres+", apellidos = "+apellidos+", representa = "+representa+"]";
    }
}