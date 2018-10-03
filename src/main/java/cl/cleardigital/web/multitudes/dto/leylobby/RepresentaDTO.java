package cl.cleardigital.web.multitudes.dto.leylobby;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RepresentaDTO implements Serializable
{
    private String giro;

    private String nombre;

    private String pais;

    private String domicilio;

    private String tipo;

    private String representante_legal;

    private String directorio;

    private String naturaleza;

    public String getGiro ()
    {
        return giro;
    }

    public void setGiro (String giro)
    {
        this.giro = giro;
    }

    public String getNombre ()
    {
        return nombre;
    }

    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    public String getPais ()
    {
        return pais;
    }

    public void setPais (String pais)
    {
        this.pais = pais;
    }

    public String getDomicilio ()
    {
        return domicilio;
    }

    public void setDomicilio (String domicilio)
    {
        this.domicilio = domicilio;
    }

    public String getTipo ()
    {
        return tipo;
    }

    public void setTipo (String tipo)
    {
        this.tipo = tipo;
    }

    public String getRepresentante_legal ()
    {
        return representante_legal;
    }

    public void setRepresentante_legal (String representante_legal)
    {
        this.representante_legal = representante_legal;
    }

    public String getDirectorio ()
    {
        return directorio;
    }

    public void setDirectorio (String directorio)
    {
        this.directorio = directorio;
    }

    public String getNaturaleza ()
    {
        return naturaleza;
    }

    public void setNaturaleza (String naturaleza)
    {
        this.naturaleza = naturaleza;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [giro = "+giro+", nombre = "+nombre+", pais = "+pais+", domicilio = "+domicilio+", tipo = "+tipo+", representante_legal = "+representante_legal+", directorio = "+directorio+", naturaleza = "+naturaleza+"]";
    }
}
