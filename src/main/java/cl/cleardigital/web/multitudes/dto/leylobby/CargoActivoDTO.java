package cl.cleardigital.web.multitudes.dto.leylobby;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CargoActivoDTO implements Serializable
{
    private SujetoDTO sujeto;

    private String tipo;

    private String remunerado;

    public SujetoDTO getSujeto ()
    {
        return sujeto;
    }

    public void setSujeto (SujetoDTO sujeto)
    {
        this.sujeto = sujeto;
    }

    public String getTipo ()
    {
        return tipo;
    }

    public void setTipo (String tipo)
    {
        this.tipo = tipo;
    }

    public String getRemunerado ()
    {
        return remunerado;
    }

    public void setRemunerado (String remunerado)
    {
        this.remunerado = remunerado;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sujeto = "+sujeto+", tipo = "+tipo+", remunerado = "+remunerado+"]";
    }
}

