package cl.cleardigital.web.multitudes.dto.licitaciones;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class FechasDTO implements Serializable
{
    private String FechaInicio;

    private String FechaCreacion;

    private String FechaActoAperturaTecnica;

    private String FechaPublicacion;

    private String FechaEstimadaAdjudicacion;

    private String FechaCierre;

    private String FechaPubRespuestas;

    private String FechaFinal;

    private String FechaAdjudicacion;

    private String FechaActoAperturaEconomica;

    public String getFechaInicio ()
    {
        return FechaInicio;
    }

    public void setFechaInicio (String FechaInicio)
    {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaCreacion ()
    {
        return FechaCreacion;
    }

    public void setFechaCreacion (String FechaCreacion)
    {
        this.FechaCreacion = FechaCreacion;
    }

    public String getFechaActoAperturaTecnica ()
    {
        return FechaActoAperturaTecnica;
    }

    public void setFechaActoAperturaTecnica (String FechaActoAperturaTecnica)
    {
        this.FechaActoAperturaTecnica = FechaActoAperturaTecnica;
    }

    public String getFechaPublicacion ()
    {
        return FechaPublicacion;
    }

    public void setFechaPublicacion (String FechaPublicacion)
    {
        this.FechaPublicacion = FechaPublicacion;
    }

    public String getFechaEstimadaAdjudicacion ()
    {
        return FechaEstimadaAdjudicacion;
    }

    public void setFechaEstimadaAdjudicacion (String FechaEstimadaAdjudicacion)
    {
        this.FechaEstimadaAdjudicacion = FechaEstimadaAdjudicacion;
    }

    public String getFechaCierre ()
    {
        return FechaCierre;
    }

    public void setFechaCierre (String FechaCierre)
    {
        this.FechaCierre = FechaCierre;
    }

    public String getFechaPubRespuestas ()
    {
        return FechaPubRespuestas;
    }

    public void setFechaPubRespuestas (String FechaPubRespuestas)
    {
        this.FechaPubRespuestas = FechaPubRespuestas;
    }

    public String getFechaFinal ()
    {
        return FechaFinal;
    }

    public void setFechaFinal (String FechaFinal)
    {
        this.FechaFinal = FechaFinal;
    }

    public String getFechaAdjudicacion ()
    {
        return FechaAdjudicacion;
    }

    public void setFechaAdjudicacion (String FechaAdjudicacion)
    {
        this.FechaAdjudicacion = FechaAdjudicacion;
    }

    public String getFechaActoAperturaEconomica ()
    {
        return FechaActoAperturaEconomica;
    }

    public void setFechaActoAperturaEconomica (String FechaActoAperturaEconomica)
    {
        this.FechaActoAperturaEconomica = FechaActoAperturaEconomica;
    }
}
