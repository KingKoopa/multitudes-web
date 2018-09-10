package cl.cleardigital.web.multitudes.dto.licitaciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import cl.cleardigital.web.multitudes.model.mercadopublico.LicitacionDetalle;
import cl.cleardigital.web.multitudes.model.mercadopublico.LicitacionItem;

@JsonInclude(Include.NON_NULL)
@SuppressWarnings("serial")
public class LicitacionDetailDTO implements Serializable {
	
    private String JustificacionPublicidad;

    private String CodigoTipo;

    private String ProhibicionContratacion;

    private String UnidadTiempoContratoLicitacion;

    private String EsBaseTipo;

    private String VisibilidadMonto;

    private String NombreResponsableContrato;

    private String Nombre;

    private Integer CodigoEstado;

    private String SubContratacion;

    private String UnidadTiempoDuracionContrato;

    private String EsRenovable;

    private String DiasCierreLicitacion;

    private String Moneda;

    private String TipoConvocatoria;

    private String Obras;

    private String Descripcion;

    private String TipoDuracionContrato;

    private String ExtensionPlazo;

    private String UnidadTiempo;

    private String ValorTiempoRenovacion;

    private String TipoPago;

    private String Estimacion;

    private String Contrato;

    private String EmailResponsableContrato;

    private String Etapas;

    private String DireccionVisita;

    private String CodigoExterno;
    
    private CompradorDTO Comprador;

    private AdjudicacionDTO Adjudicacion;
    
    private ItemsDTO Items;

    private String PeriodoTiempoRenovacion;

    private String TomaRazon;

    private String EstadoEtapas;

    private String JustificacionMontoEstimado;

    private String FuenteFinanciamiento;

    private String UnidadTiempoEvaluacion;

    private String Estado;

    private String NombreResponsablePago;

    private String Tipo;

    private FechasDTO Fechas;

    private String Modalidad;

    private String EstadoPublicidadOfertas;

    private String TiempoDuracionContrato;

    private String DireccionEntrega;

    private String CantidadReclamos;

    private String EmailResponsablePago;

    private String FonoResponsableContrato;

    private String Informada;

    public String getJustificacionPublicidad ()
    {
        return JustificacionPublicidad;
    }

    public void setJustificacionPublicidad (String JustificacionPublicidad)
    {
        this.JustificacionPublicidad = JustificacionPublicidad;
    }

    public String getCodigoTipo ()
    {
        return CodigoTipo;
    }

    public void setCodigoTipo (String CodigoTipo)
    {
        this.CodigoTipo = CodigoTipo;
    }

    public String getProhibicionContratacion ()
    {
        return ProhibicionContratacion;
    }

    public void setProhibicionContratacion (String ProhibicionContratacion)
    {
        this.ProhibicionContratacion = ProhibicionContratacion;
    }

    public String getUnidadTiempoContratoLicitacion ()
    {
        return UnidadTiempoContratoLicitacion;
    }

    public void setUnidadTiempoContratoLicitacion (String UnidadTiempoContratoLicitacion)
    {
        this.UnidadTiempoContratoLicitacion = UnidadTiempoContratoLicitacion;
    }

    public String getEsBaseTipo ()
    {
        return EsBaseTipo;
    }

    public void setEsBaseTipo (String EsBaseTipo)
    {
        this.EsBaseTipo = EsBaseTipo;
    }

    public String getVisibilidadMonto ()
    {
        return VisibilidadMonto;
    }

    public void setVisibilidadMonto (String VisibilidadMonto)
    {
        this.VisibilidadMonto = VisibilidadMonto;
    }

    public String getNombreResponsableContrato ()
    {
        return NombreResponsableContrato;
    }

    public void setNombreResponsableContrato (String NombreResponsableContrato)
    {
        this.NombreResponsableContrato = NombreResponsableContrato;
    }

    public String getNombre ()
    {
        return Nombre;
    }

    public void setNombre (String Nombre)
    {
        this.Nombre = Nombre;
    }

    public Integer getCodigoEstado ()
    {
        return CodigoEstado;
    }

    public void setCodigoEstado (Integer CodigoEstado)
    {
        this.CodigoEstado = CodigoEstado;
    }

    public String getSubContratacion ()
    {
        return SubContratacion;
    }

    public void setSubContratacion (String SubContratacion)
    {
        this.SubContratacion = SubContratacion;
    }

    public String getUnidadTiempoDuracionContrato ()
    {
        return UnidadTiempoDuracionContrato;
    }

    public void setUnidadTiempoDuracionContrato (String UnidadTiempoDuracionContrato)
    {
        this.UnidadTiempoDuracionContrato = UnidadTiempoDuracionContrato;
    }

    public String getEsRenovable ()
    {
        return EsRenovable;
    }

    public void setEsRenovable (String EsRenovable)
    {
        this.EsRenovable = EsRenovable;
    }

    public String getDiasCierreLicitacion ()
    {
        return DiasCierreLicitacion;
    }

    public void setDiasCierreLicitacion (String DiasCierreLicitacion)
    {
        this.DiasCierreLicitacion = DiasCierreLicitacion;
    }

    public String getMoneda ()
    {
        return Moneda;
    }

    public void setMoneda (String Moneda)
    {
        this.Moneda = Moneda;
    }

    public String getTipoConvocatoria ()
    {
        return TipoConvocatoria;
    }

    public void setTipoConvocatoria (String TipoConvocatoria)
    {
        this.TipoConvocatoria = TipoConvocatoria;
    }

    public String getObras ()
    {
        return Obras;
    }

    public void setObras (String Obras)
    {
        this.Obras = Obras;
    }

    public String getDescripcion ()
    {
        return Descripcion;
    }

    public void setDescripcion (String Descripcion)
    {
        this.Descripcion = Descripcion;
    }

    public String getTipoDuracionContrato ()
    {
        return TipoDuracionContrato;
    }

    public void setTipoDuracionContrato (String TipoDuracionContrato)
    {
        this.TipoDuracionContrato = TipoDuracionContrato;
    }

    public String getExtensionPlazo ()
    {
        return ExtensionPlazo;
    }

    public void setExtensionPlazo (String ExtensionPlazo)
    {
        this.ExtensionPlazo = ExtensionPlazo;
    }

    public String getUnidadTiempo ()
    {
        return UnidadTiempo;
    }

    public void setUnidadTiempo (String UnidadTiempo)
    {
        this.UnidadTiempo = UnidadTiempo;
    }

    public String getValorTiempoRenovacion ()
    {
        return ValorTiempoRenovacion;
    }

    public void setValorTiempoRenovacion (String ValorTiempoRenovacion)
    {
        this.ValorTiempoRenovacion = ValorTiempoRenovacion;
    }

    public String getTipoPago ()
    {
        return TipoPago;
    }

    public void setTipoPago (String TipoPago)
    {
        this.TipoPago = TipoPago;
    }

    public String getEstimacion ()
    {
        return Estimacion;
    }

    public void setEstimacion (String Estimacion)
    {
        this.Estimacion = Estimacion;
    }

    public String getContrato ()
    {
        return Contrato;
    }

    public void setContrato (String Contrato)
    {
        this.Contrato = Contrato;
    }

    public String getEmailResponsableContrato ()
    {
        return EmailResponsableContrato;
    }

    public void setEmailResponsableContrato (String EmailResponsableContrato)
    {
        this.EmailResponsableContrato = EmailResponsableContrato;
    }
    
    public String getEtapas ()
    {
        return Etapas;
    }

    public void setEtapas (String Etapas)
    {
        this.Etapas = Etapas;
    }

    public String getDireccionVisita ()
    {
        return DireccionVisita;
    }

    public void setDireccionVisita (String DireccionVisita)
    {
        this.DireccionVisita = DireccionVisita;
    }

    public String getCodigoExterno ()
    {
        return CodigoExterno;
    }

    public void setCodigoExterno (String CodigoExterno)
    {
        this.CodigoExterno = CodigoExterno;
    }

    public AdjudicacionDTO getAdjudicacion ()
    {
        return Adjudicacion;
    }

    public void setAdjudicacion (AdjudicacionDTO Adjudicacion)
    {
        this.Adjudicacion = Adjudicacion;
    }

    public String getPeriodoTiempoRenovacion ()
    {
        return PeriodoTiempoRenovacion;
    }

    public void setPeriodoTiempoRenovacion (String PeriodoTiempoRenovacion)
    {
        this.PeriodoTiempoRenovacion = PeriodoTiempoRenovacion;
    }

    public ItemsDTO getItems ()
    {
        return Items;
    }

    public void setItems (ItemsDTO Items)
    {
        this.Items = Items;
    }

    public String getTomaRazon ()
    {
        return TomaRazon;
    }

    public void setTomaRazon (String TomaRazon)
    {
        this.TomaRazon = TomaRazon;
    }

    public String getEstadoEtapas ()
    {
        return EstadoEtapas;
    }

    public void setEstadoEtapas (String EstadoEtapas)
    {
        this.EstadoEtapas = EstadoEtapas;
    }

    public String getJustificacionMontoEstimado ()
    {
        return JustificacionMontoEstimado;
    }

    public void setJustificacionMontoEstimado (String JustificacionMontoEstimado)
    {
        this.JustificacionMontoEstimado = JustificacionMontoEstimado;
    }

    public String getFuenteFinanciamiento ()
    {
        return FuenteFinanciamiento;
    }

    public void setFuenteFinanciamiento (String FuenteFinanciamiento)
    {
        this.FuenteFinanciamiento = FuenteFinanciamiento;
    }

    public String getUnidadTiempoEvaluacion ()
    {
        return UnidadTiempoEvaluacion;
    }

    public void setUnidadTiempoEvaluacion (String UnidadTiempoEvaluacion)
    {
        this.UnidadTiempoEvaluacion = UnidadTiempoEvaluacion;
    }

    public String getEstado ()
    {
        return Estado;
    }

    public void setEstado (String Estado)
    {
        this.Estado = Estado;
    }

    public String getNombreResponsablePago ()
    {
        return NombreResponsablePago;
    }

    public void setNombreResponsablePago (String NombreResponsablePago)
    {
        this.NombreResponsablePago = NombreResponsablePago;
    }

    public String getTipo ()
    {
        return Tipo;
    }

    public void setTipo (String Tipo)
    {
        this.Tipo = Tipo;
    }

    public FechasDTO getFechas ()
    {
        return Fechas;
    }

    public void setFechas (FechasDTO Fechas)
    {
        this.Fechas = Fechas;
    }

    public String getModalidad ()
    {
        return Modalidad;
    }

    public void setModalidad (String Modalidad)
    {
        this.Modalidad = Modalidad;
    }

    public String getEstadoPublicidadOfertas ()
    {
        return EstadoPublicidadOfertas;
    }

    public void setEstadoPublicidadOfertas (String EstadoPublicidadOfertas)
    {
        this.EstadoPublicidadOfertas = EstadoPublicidadOfertas;
    }

    public String getTiempoDuracionContrato ()
    {
        return TiempoDuracionContrato;
    }

    public void setTiempoDuracionContrato (String TiempoDuracionContrato)
    {
        this.TiempoDuracionContrato = TiempoDuracionContrato;
    }

    public String getDireccionEntrega ()
    {
        return DireccionEntrega;
    }

    public void setDireccionEntrega (String DireccionEntrega)
    {
        this.DireccionEntrega = DireccionEntrega;
    }

    public String getCantidadReclamos ()
    {
        return CantidadReclamos;
    }

    public void setCantidadReclamos (String CantidadReclamos)
    {
        this.CantidadReclamos = CantidadReclamos;
    }

    public String getEmailResponsablePago ()
    {
        return EmailResponsablePago;
    }

    public void setEmailResponsablePago (String EmailResponsablePago)
    {
        this.EmailResponsablePago = EmailResponsablePago;
    }

    public String getFonoResponsableContrato ()
    {
        return FonoResponsableContrato;
    }

    public void setFonoResponsableContrato (String FonoResponsableContrato)
    {
        this.FonoResponsableContrato = FonoResponsableContrato;
    }

    public String getInformada ()
    {
        return Informada;
    }

    public void setInformada (String Informada)
    {
        this.Informada = Informada;
    }

	public CompradorDTO getComprador() {
		return Comprador;
	}

	public void setComprador(CompradorDTO comprador) {
		Comprador = comprador;
	}
	
	public LicitacionDetailDTO populateFromModel(LicitacionDetalle licitacionDetalle) {
		
		this.Nombre = licitacionDetalle.getNombre();
		this.CodigoEstado = licitacionDetalle.getCodigoEstado();
		this.Descripcion = licitacionDetalle.getDescripcion();
		//CompradorDTO:
		if(licitacionDetalle.getCompradorRutUnidad() != null) {
			CompradorDTO compradorDTO = new CompradorDTO();
			compradorDTO.setCargoUsuario(licitacionDetalle.getCompradorCargoUsuario());
			compradorDTO.setCodigoOrganismo(licitacionDetalle.getCompradorCodigoOrganismo());
			compradorDTO.setComunaUnidad(licitacionDetalle.getCompradorComunaUnidad());
			compradorDTO.setDireccionUnidad(licitacionDetalle.getCompradorDireccionUnidad());
			compradorDTO.setNombreOrganismo(licitacionDetalle.getCompradorNombreOrganismo());
			compradorDTO.setNombreUnidad(licitacionDetalle.getCompradorNombreUnidad());
			compradorDTO.setNombreUsuario(licitacionDetalle.getCompradorNombreUsuario());
			compradorDTO.setRegionUnidad(licitacionDetalle.getCompradorRegionUnidad());
			compradorDTO.setRutUnidad(licitacionDetalle.getCompradorRutUnidad());
			compradorDTO.setRutUsuario(licitacionDetalle.getCompradorRutUsuario());
			this.Comprador = compradorDTO;
		}
		this.CodigoExterno = licitacionDetalle.getCodigoExterno();
		//AdjudicacionDTO:
		if(licitacionDetalle.getAdjudicacionNumero() != null) {
			AdjudicacionDTO adjudicacionDTO = new AdjudicacionDTO();
			adjudicacionDTO.setFecha(licitacionDetalle.getAdjudicacionFecha());
			adjudicacionDTO.setNumero(licitacionDetalle.getAdjudicacionNumero());
			adjudicacionDTO.setNumeroOferentes(licitacionDetalle.getAdjudicacionNumeroOferentes()); 
			adjudicacionDTO.setTipo(licitacionDetalle.getAdjudicacionTipo()); 
			adjudicacionDTO.setUrlActa(licitacionDetalle.getAdjudicacionUrlActa()); 
			this.Adjudicacion = adjudicacionDTO;
		}
		
		//ItemsDTO:
		if(licitacionDetalle.getItems() != null && !licitacionDetalle.getItems().isEmpty()) {
			ItemsDTO itemsDTO = new ItemsDTO();
			List<ListadoDTO> listadoDTOLst = new ArrayList<>();
			for(LicitacionItem licitacionItem : licitacionDetalle.getItems()) {
				ListadoDTO listadoDTO = new ListadoDTO();
				//ProveedorDTO:
				if(licitacionItem.getAdjudicacionRutProveedor() != null) {
					ProveedorDTO proveedorDTO = new ProveedorDTO();
					proveedorDTO.setCantidad(licitacionItem.getCantidad().floatValue());
					proveedorDTO.setMontoUnitario(licitacionItem.getAdjudicacionMontoUnitario().floatValue());
					proveedorDTO.setNombreProveedor(licitacionItem.getAdjudicacionNombreProveedor());
					proveedorDTO.setRutProveedor(licitacionItem.getAdjudicacionRutProveedor());
					listadoDTO.setAdjudicacion(proveedorDTO);
				}
				listadoDTO.setCantidad(licitacionItem.getCantidad().floatValue());
				listadoDTO.setCategoria(licitacionItem.getCategoria());
				listadoDTO.setCodigoCategoria(licitacionItem.getCodigoCategoria());
				listadoDTO.setCodigoProducto(licitacionItem.getCodigoProducto());
				listadoDTO.setCorrelativo(licitacionItem.getCorrelativo());
				listadoDTO.setDescripcion(licitacionItem.getDescripcion());
				listadoDTO.setNombreProducto(licitacionItem.getNombreProducto());
				listadoDTO.setUnidadMedida(licitacionItem.getUnidadMedida());
				listadoDTOLst.add(listadoDTO);
			}
			itemsDTO.setListado(listadoDTOLst);
			this.Items = itemsDTO;
		}
		
		this.Estado = licitacionDetalle.getEstado();
		//this.NombreResponsablePago = licitacionDetalle.get //TODO: RELLENAR
		
		//FechasDTO:
		if(licitacionDetalle.getFechaInicio() != null){
			FechasDTO fechasDTO = new FechasDTO();
			fechasDTO.setFechaAdjudicacion(licitacionDetalle.getAdjudicacionFecha());
			fechasDTO.setFechaCierre(licitacionDetalle.getFechaCierre());
			fechasDTO.setFechaCreacion(licitacionDetalle.getFechaCreacion());
			fechasDTO.setFechaEstimadaAdjudicacion(licitacionDetalle.getFechaEstimadaAdjudicacion());
			fechasDTO.setFechaFinal(licitacionDetalle.getFechaFinal());
			fechasDTO.setFechaInicio(licitacionDetalle.getFechaInicio());
			fechasDTO.setFechaPublicacion(licitacionDetalle.getFechaPublicacion());
			this.Fechas = fechasDTO;
		}
		
		return this;
	}
    
}