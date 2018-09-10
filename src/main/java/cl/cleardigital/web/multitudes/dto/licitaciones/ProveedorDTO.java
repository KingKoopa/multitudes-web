package cl.cleardigital.web.multitudes.dto.licitaciones;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class ProveedorDTO implements Serializable
{
    private String NombreProveedor;

    private String RutProveedor;

    private Float MontoUnitario;

    private Float Cantidad;

    public String getNombreProveedor ()
    {
        return NombreProveedor;
    }

    public void setNombreProveedor (String NombreProveedor)
    {
        this.NombreProveedor = NombreProveedor;
    }

    public String getRutProveedor ()
    {
        return RutProveedor;
    }

    public void setRutProveedor (String RutProveedor)
    {
        this.RutProveedor = RutProveedor;
    }

    public Float getMontoUnitario ()
    {
        return MontoUnitario;
    }

    public void setMontoUnitario (Float MontoUnitario)
    {
        this.MontoUnitario = MontoUnitario;
    }

    public Float getCantidad ()
    {
        return Cantidad;
    }

    public void setCantidad (Float Cantidad)
    {
        this.Cantidad = Cantidad;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [NombreProveedor = "+NombreProveedor+", RutProveedor = "+RutProveedor+", MontoUnitario = "+MontoUnitario+", Cantidad = "+Cantidad+"]";
    }
}
