package cl.cleardigital.web.multitudes.model.mercadopublico;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the licitacion_detalle database table.
 * 
 */
@Entity
@Table(name="licitacion_detalle")
@NamedQuery(name="LicitacionDetalle.findAll", query="SELECT l FROM LicitacionDetalle l")
public class LicitacionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="adjudicacion_fecha")
	private String adjudicacionFecha;

	@Column(name="adjudicacion_numero")
	private String adjudicacionNumero;
	
	@Column(name="adjudicacion_numero_oferentes")
	private Integer adjudicacionNumeroOferentes;
	
	@Column(name="adjudicacion_tipo")
	private Integer adjudicacionTipo;
	
	@Column(name="adjudicacion_url_acta")
	private String adjudicacionUrlActa;

	@Column(name="codigo_estado")
	private Integer codigoEstado;

	@Id
	@Column(name="codigo_externo")
	private String codigoExterno;

	@Column(name="comprador_cargo_usuario")
	private String compradorCargoUsuario;

	@Column(name="comprador_codigo_organismo")
	private String compradorCodigoOrganismo;

	@Column(name="comprador_comuna_unidad")
	private String compradorComunaUnidad;

	@Column(name="comprador_direccion_unidad")
	private String compradorDireccionUnidad;

	@Column(name="comprador_nombre_organismo")
	private String compradorNombreOrganismo;

	@Column(name="comprador_nombre_unidad")
	private String compradorNombreUnidad;

	@Column(name="comprador_nombre_usuario")
	private String compradorNombreUsuario;

	@Column(name="comprador_region_unidad")
	private String compradorRegionUnidad;

	@Column(name="comprador_rut_unidad")
	private String compradorRutUnidad;

	@Column(name="comprador_rut_usuario")
	private String compradorRutUsuario;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="tipo")
	private String tipo;

	@Column(name="estado")
	private String estado;

	@Column(name="fecha_adjudicacion")
	private String fechaAdjudicacion;

	@Column(name="fecha_cierre")
	private String fechaCierre;

	@Column(name="fecha_creacion")
	private String fechaCreacion;

	@Column(name="fecha_estimada_adjudicacion")
	private String fechaEstimadaAdjudicacion;

	@Column(name="fecha_final")
	private String fechaFinal;

	@Column(name="fecha_inicio")
	private String fechaInicio;

	@Column(name="fecha_publicacion")
	private String fechaPublicacion;

	@Column(name="nombre")
	private String nombre;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "licitacion_detalle_licitacion_item", joinColumns = {
			@JoinColumn(name = "codigo_externo", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "licitacion_item_id", nullable = false, updatable = false) })
	private List<LicitacionItem> items;
	
	public LicitacionDetalle() {
	}

	public String getAdjudicacionFecha() {
		return this.adjudicacionFecha;
	}

	public void setAdjudicacionFecha(String adjudicacionFecha) {
		this.adjudicacionFecha = adjudicacionFecha;
	}

	public String getAdjudicacionNumero() {
		return this.adjudicacionNumero;
	}

	public void setAdjudicacionNumero(String adjudicacionNumero) {
		this.adjudicacionNumero = adjudicacionNumero;
	}

	public Integer getAdjudicacionNumeroOferentes() {
		return adjudicacionNumeroOferentes;
	}

	public void setAdjudicacionNumeroOferentes(Integer adjudicacionNumeroOferentes) {
		this.adjudicacionNumeroOferentes = adjudicacionNumeroOferentes;
	}

	public Integer getAdjudicacionTipo() {
		return adjudicacionTipo;
	}

	public void setAdjudicacionTipo(Integer adjudicacionTipo) {
		this.adjudicacionTipo = adjudicacionTipo;
	}

	public String getAdjudicacionUrlActa() {
		return adjudicacionUrlActa;
	}

	public void setAdjudicacionUrlActa(String adjudicacionUrlActa) {
		this.adjudicacionUrlActa = adjudicacionUrlActa;
	}

	public Integer getCodigoEstado() {
		return this.codigoEstado;
	}

	public void setCodigoEstado(Integer codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public String getCodigoExterno() {
		return this.codigoExterno;
	}

	public void setCodigoExterno(String codigoExterno) {
		this.codigoExterno = codigoExterno;
	}

	public String getCompradorCargoUsuario() {
		return this.compradorCargoUsuario;
	}

	public void setCompradorCargoUsuario(String compradorCargoUsuario) {
		this.compradorCargoUsuario = compradorCargoUsuario;
	}

	public String getCompradorCodigoOrganismo() {
		return this.compradorCodigoOrganismo;
	}

	public void setCompradorCodigoOrganismo(String compradorCodigoOrganismo) {
		this.compradorCodigoOrganismo = compradorCodigoOrganismo;
	}

	public String getCompradorComunaUnidad() {
		return this.compradorComunaUnidad;
	}

	public void setCompradorComunaUnidad(String compradorComunaUnidad) {
		this.compradorComunaUnidad = compradorComunaUnidad;
	}

	public String getCompradorDireccionUnidad() {
		return this.compradorDireccionUnidad;
	}

	public void setCompradorDireccionUnidad(String compradorDireccionUnidad) {
		this.compradorDireccionUnidad = compradorDireccionUnidad;
	}

	public String getCompradorNombreOrganismo() {
		return this.compradorNombreOrganismo;
	}

	public void setCompradorNombreOrganismo(String compradorNombreOrganismo) {
		this.compradorNombreOrganismo = compradorNombreOrganismo;
	}

	public String getCompradorNombreUnidad() {
		return this.compradorNombreUnidad;
	}

	public void setCompradorNombreUnidad(String compradorNombreUnidad) {
		this.compradorNombreUnidad = compradorNombreUnidad;
	}

	public String getCompradorNombreUsuario() {
		return this.compradorNombreUsuario;
	}

	public void setCompradorNombreUsuario(String compradorNombreUsuario) {
		this.compradorNombreUsuario = compradorNombreUsuario;
	}

	public String getCompradorRegionUnidad() {
		return this.compradorRegionUnidad;
	}

	public void setCompradorRegionUnidad(String compradorRegionUnidad) {
		this.compradorRegionUnidad = compradorRegionUnidad;
	}

	public String getCompradorRutUnidad() {
		return this.compradorRutUnidad;
	}

	public void setCompradorRutUnidad(String compradorRutUnidad) {
		this.compradorRutUnidad = compradorRutUnidad;
	}

	public String getCompradorRutUsuario() {
		return this.compradorRutUsuario;
	}

	public void setCompradorRutUsuario(String compradorRutUsuario) {
		this.compradorRutUsuario = compradorRutUsuario;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaAdjudicacion() {
		return this.fechaAdjudicacion;
	}

	public void setFechaAdjudicacion(String fechaAdjudicacion) {
		this.fechaAdjudicacion = fechaAdjudicacion;
	}

	public String getFechaCierre() {
		return this.fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaEstimadaAdjudicacion() {
		return this.fechaEstimadaAdjudicacion;
	}

	public void setFechaEstimadaAdjudicacion(String fechaEstimadaAdjudicacion) {
		this.fechaEstimadaAdjudicacion = fechaEstimadaAdjudicacion;
	}

	public String getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LicitacionItem> getItems() {
		return items;
	}

	public void setItems(List<LicitacionItem> items) {
		this.items = items;
	}

}