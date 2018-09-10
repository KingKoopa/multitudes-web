package cl.cleardigital.web.multitudes.dto.licitaciones;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class AdjudicacionDTO implements Serializable
{
    private String Numero;

    private Integer Tipo;

    private String Fecha;

    private Integer NumeroOferentes;

    private String UrlActa;

    public String getNumero ()
    {
        return Numero;
    }

    public void setNumero (String Numero)
    {
        this.Numero = Numero;
    }

    public Integer getTipo ()
    {
        return Tipo;
    }

    public void setTipo (Integer Tipo)
    {
        this.Tipo = Tipo;
    }

    public String getFecha ()
    {
        return Fecha;
    }

    public void setFecha (String Fecha)
    {
        this.Fecha = Fecha;
    }

    public Integer getNumeroOferentes ()
    {
        return NumeroOferentes;
    }

    public void setNumeroOferentes (Integer NumeroOferentes)
    {
        this.NumeroOferentes = NumeroOferentes;
    }

    public String getUrlActa ()
    {
        return UrlActa;
    }

    public void setUrlActa (String UrlActa)
    {
        this.UrlActa = UrlActa;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Numero = "+Numero+", Tipo = "+Tipo+", Fecha = "+Fecha+", NumeroOferentes = "+NumeroOferentes+", UrlActa = "+UrlActa+"]";
    }
}
