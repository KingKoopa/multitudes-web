package cl.cleardigital.web.multitudes.dto.licitaciones;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class ItemsDTO implements Serializable
{
    private List<ListadoDTO> Listado;

    private Float Cantidad;

    public List<ListadoDTO> getListado ()
    {
        return Listado;
    }

    public void setListado (List<ListadoDTO> Listado)
    {
        this.Listado = Listado;
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
        return "ClassPojo [Listado = "+Listado+", Cantidad = "+Cantidad+"]";
    }
}
