package cl.cleardigital.web.multitudes.dto.licitaciones;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@SuppressWarnings("serial")
public class CompradorDTO implements Serializable
{
    private String NombreUnidad;

    private String CodigoUsuario;

    private String RutUsuario;

    private String RegionUnidad;

    private String CodigoOrganismo;

    private String DireccionUnidad;

    private String ComunaUnidad;

    private String CargoUsuario;

    private String NombreUsuario;

    private String CodigoUnidad;

    private String RutUnidad;

    private String NombreOrganismo;

    public String getNombreUnidad ()
    {
        return NombreUnidad;
    }

    public void setNombreUnidad (String NombreUnidad)
    {
        this.NombreUnidad = NombreUnidad;
    }

    public String getCodigoUsuario ()
    {
        return CodigoUsuario;
    }

    public void setCodigoUsuario (String CodigoUsuario)
    {
        this.CodigoUsuario = CodigoUsuario;
    }

    public String getRutUsuario ()
    {
        return RutUsuario;
    }

    public void setRutUsuario (String RutUsuario)
    {
        this.RutUsuario = RutUsuario;
    }

    public String getRegionUnidad ()
    {
        return RegionUnidad;
    }

    public void setRegionUnidad (String RegionUnidad)
    {
        this.RegionUnidad = RegionUnidad;
    }

    public String getCodigoOrganismo ()
    {
        return CodigoOrganismo;
    }

    public void setCodigoOrganismo (String CodigoOrganismo)
    {
        this.CodigoOrganismo = CodigoOrganismo;
    }

    public String getDireccionUnidad ()
    {
        return DireccionUnidad;
    }

    public void setDireccionUnidad (String DireccionUnidad)
    {
        this.DireccionUnidad = DireccionUnidad;
    }

    public String getComunaUnidad ()
    {
        return ComunaUnidad;
    }

    public void setComunaUnidad (String ComunaUnidad)
    {
        this.ComunaUnidad = ComunaUnidad;
    }

    public String getCargoUsuario ()
    {
        return CargoUsuario;
    }

    public void setCargoUsuario (String CargoUsuario)
    {
        this.CargoUsuario = CargoUsuario;
    }

    public String getNombreUsuario ()
    {
        return NombreUsuario;
    }

    public void setNombreUsuario (String NombreUsuario)
    {
        this.NombreUsuario = NombreUsuario;
    }

    public String getCodigoUnidad ()
    {
        return CodigoUnidad;
    }

    public void setCodigoUnidad (String CodigoUnidad)
    {
        this.CodigoUnidad = CodigoUnidad;
    }

    public String getRutUnidad ()
    {
        return RutUnidad;
    }

    public void setRutUnidad (String RutUnidad)
    {
        this.RutUnidad = RutUnidad;
    }

    public String getNombreOrganismo ()
    {
        return NombreOrganismo;
    }

    public void setNombreOrganismo (String NombreOrganismo)
    {
        this.NombreOrganismo = NombreOrganismo;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [NombreUnidad = "+NombreUnidad+", CodigoUsuario = "+CodigoUsuario+", RutUsuario = "+RutUsuario+", RegionUnidad = "+RegionUnidad+", CodigoOrganismo = "+CodigoOrganismo+", DireccionUnidad = "+DireccionUnidad+", ComunaUnidad = "+ComunaUnidad+", CargoUsuario = "+CargoUsuario+", NombreUsuario = "+NombreUsuario+", CodigoUnidad = "+CodigoUnidad+", RutUnidad = "+RutUnidad+", NombreOrganismo = "+NombreOrganismo+"]";
    }
}