package cl.cleardigital.web.multitudes.dto.leylobby;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SujetoDTO implements Serializable
{
    private String nombres;

    private String apellidos;

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

    @Override
    public String toString()
    {
        return "ClassPojo [nombres = "+nombres+", apellidos = "+apellidos+"]";
    }
}
