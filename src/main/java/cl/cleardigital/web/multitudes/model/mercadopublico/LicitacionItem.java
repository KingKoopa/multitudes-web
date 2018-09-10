package cl.cleardigital.web.multitudes.model.mercadopublico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the licitacion_item database table.
 * 
 */
@Entity
@Table(name="licitacion_item")
@NamedQuery(name="LicitacionItem.findAll", query="SELECT l FROM LicitacionItem l")
public class LicitacionItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="adjudicacion_antidad")
	private Integer adjudicacionAntidad;

	@Column(name="adjudicacion_monto_unitario")
	private Integer adjudicacionMontoUnitario;

	@Column(name="adjudicacion_nombre_proveedor")
	private String adjudicacionNombreProveedor;

	@Column(name="adjudicacion_rut_proveedor")
	private String adjudicacionRutProveedor;

	@Column(name="cantidad")
	private Integer cantidad;

	@Column(name="categoria")
	private String categoria;

	@Column(name="codigo_categoria")
	private String codigoCategoria;

	@Column(name="codigo_producto")
	private Integer codigoProducto;

	@Column(name="correlativo")
	private Integer correlativo;

	@Column(name="descripcion")
	private String descripcion;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="nombre_producto")
	private String nombreProducto;

	@Column(name="unidad_medida")
	private String unidadMedida;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "licitacion_detalle_licitacion_item", joinColumns = {
			@JoinColumn(name = "licitacion_item_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "codigo_externo", nullable = false, updatable = false) })
	private List<LicitacionDetalle> licitacionDetalle;
	
	public LicitacionItem() {
	}

	public Integer getAdjudicacionAntidad() {
		return this.adjudicacionAntidad;
	}

	public void setAdjudicacionAntidad(Integer adjudicacionAntidad) {
		this.adjudicacionAntidad = adjudicacionAntidad;
	}

	public Integer getAdjudicacionMontoUnitario() {
		return this.adjudicacionMontoUnitario;
	}

	public void setAdjudicacionMontoUnitario(Integer adjudicacionMontoUnitario) {
		this.adjudicacionMontoUnitario = adjudicacionMontoUnitario;
	}

	public String getAdjudicacionNombreProveedor() {
		return this.adjudicacionNombreProveedor;
	}

	public void setAdjudicacionNombreProveedor(String adjudicacionNombreProveedor) {
		this.adjudicacionNombreProveedor = adjudicacionNombreProveedor;
	}

	public String getAdjudicacionRutProveedor() {
		return this.adjudicacionRutProveedor;
	}

	public void setAdjudicacionRutProveedor(String adjudicacionRutProveedor) {
		this.adjudicacionRutProveedor = adjudicacionRutProveedor;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Integer getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Integer getCorrelativo() {
		return this.correlativo;
	}

	public void setCorrelativo(Integer correlativo) {
		this.correlativo = correlativo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public List<LicitacionDetalle> getLicitacionDetalle() {
		return licitacionDetalle;
	}

	public void setLicitacionDetalle(List<LicitacionDetalle> licitacionDetalle) {
		this.licitacionDetalle = licitacionDetalle;
	}

}