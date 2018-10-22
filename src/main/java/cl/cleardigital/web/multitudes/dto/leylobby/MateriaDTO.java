package cl.cleardigital.web.multitudes.dto.leylobby;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MateriaDTO implements Serializable
{
    private String nombre;

    public String getNombre ()
    {
        return nombre;
    }

    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [nombre = "+nombre+"]";
    }
}
			

