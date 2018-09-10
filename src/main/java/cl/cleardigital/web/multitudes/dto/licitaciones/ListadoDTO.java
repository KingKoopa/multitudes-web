package cl.cleardigital.web.multitudes.dto.licitaciones;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@JsonInclude(Include.NON_NULL)
public class ListadoDTO implements Serializable
{
    private Integer CodigoProducto;

    private String UnidadMedida;

    private Integer Correlativo;

    private String NombreProducto;

    private String CodigoCategoria;

    private Float Cantidad;

    private String Categoria;

    private String Descripcion;

    private ProveedorDTO Adjudicacion;

    public Integer getCodigoProducto ()
    {
        return CodigoProducto;
    }

    public void setCodigoProducto (Integer CodigoProducto)
    {
        this.CodigoProducto = CodigoProducto;
    }

    public String getUnidadMedida ()
    {
        return UnidadMedida;
    }

    public void setUnidadMedida (String UnidadMedida)
    {
        this.UnidadMedida = UnidadMedida;
    }

    public Integer getCorrelativo ()
    {
        return Correlativo;
    }

    public void setCorrelativo (Integer Correlativo)
    {
        this.Correlativo = Correlativo;
    }

    public String getNombreProducto ()
    {
        return NombreProducto;
    }

    public void setNombreProducto (String NombreProducto)
    {
        this.NombreProducto = NombreProducto;
    }

    public String getCodigoCategoria ()
    {
        return CodigoCategoria;
    }

    public void setCodigoCategoria (String CodigoCategoria)
    {
        this.CodigoCategoria = CodigoCategoria;
    }

    public Float getCantidad ()
    {
        return Cantidad;
    }

    public void setCantidad (Float Cantidad)
    {
        this.Cantidad = Cantidad;
    }

    public String getCategoria ()
    {
        return Categoria;
    }

    public void setCategoria (String Categoria)
    {
        this.Categoria = Categoria;
    }

    public String getDescripcion ()
    {
        return Descripcion;
    }

    public void setDescripcion (String Descripcion)
    {
        this.Descripcion = Descripcion;
    }

    public ProveedorDTO getAdjudicacion ()
    {
        return Adjudicacion;
    }

    public void setAdjudicacion (ProveedorDTO Proveedor)
    {
        this.Adjudicacion = Proveedor;
    }
}
