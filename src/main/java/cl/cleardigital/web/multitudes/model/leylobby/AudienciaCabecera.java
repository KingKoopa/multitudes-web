package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the audiencia_cabecera database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="audiencia_cabecera")
@NamedQuery(name="AudienciaCabecera.findAll", query="SELECT a FROM AudienciaCabecera a")
public class AudienciaCabecera implements Serializable {

	@Column(name="apellidos")
	private String apellidos;

	@Column(name="audience_detail_id")
	private Integer audienceDetailId;

	@Column(name="cargo")
	private String cargo;

	@Column(name="comuna")
	private String comuna;

	@Column(name="detalles_url")
	private String detallesUrl;

	@Column(name="fecha_inicio")
	private String fechaInicio;

	@Column(name="fecha_termino")
	private String fechaTermino;

	@Column(name="forma")
	private String forma;

	@Id
	private Integer id;

//	@Column(name="institucion_detail_id")
//	private Integer institucionDetailId;
	
	//bi-directional many-to-one association to instucionDetalle
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "institucion_detail_id", nullable = false)
	private InstitucionDetalle institucionDetalle;

	@Column(name="institucion_url")
	private String institucionUrl;

	@Column(name="lugar")
	private String lugar;

	@Column(name="nombres")
	private String nombres;

	@Column(name="referencia")
	private String referencia;

	@Column(name="sujeto_pasivo_detail_id")
	private Integer sujetoPasivoDetailId;

	@Column(name="sujeto_pasivo_url")
	private String sujetoPasivoUrl;

	@Column(name="updated")
	private String updated;

	@Column(name="vista_publica_detalles_url")
	private String vistaPublicaDetallesUrl;

	@Column(name="vista_publica_institucion_url")
	private String vistaPublicaInstitucionUrl;

	public AudienciaCabecera() {
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getAudienceDetailId() {
		return this.audienceDetailId;
	}

	public void setAudienceDetailId(Integer audienceDetailId) {
		this.audienceDetailId = audienceDetailId;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getComuna() {
		return this.comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getDetallesUrl() {
		return this.detallesUrl;
	}

	public void setDetallesUrl(String detallesUrl) {
		this.detallesUrl = detallesUrl;
	}

	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaTermino() {
		return this.fechaTermino;
	}

	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getForma() {
		return this.forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Integer getInstitucionDetailId() {
//		return this.institucionDetailId;
//	}
//
//	public void setInstitucionDetailId(Integer institucionDetailId) {
//		this.institucionDetailId = institucionDetailId;
//	}

	public InstitucionDetalle getInstitucionDetalle() {
		return institucionDetalle;
	}

	public void setInstitucionDetalle(InstitucionDetalle institucionDetalle) {
		this.institucionDetalle = institucionDetalle;
	}

	public void setSujetoPasivoDetailId(Integer sujetoPasivoDetailId) {
		this.sujetoPasivoDetailId = sujetoPasivoDetailId;
	}

	public String getInstitucionUrl() {
		return this.institucionUrl;
	}

	public void setInstitucionUrl(String institucionUrl) {
		this.institucionUrl = institucionUrl;
	}

	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getSujetoPasivoDetailId() {
		return this.sujetoPasivoDetailId;
	}

	public void setSujetoPasivoDetailId(int sujetoPasivoDetailId) {
		this.sujetoPasivoDetailId = sujetoPasivoDetailId;
	}

	public String getSujetoPasivoUrl() {
		return this.sujetoPasivoUrl;
	}

	public void setSujetoPasivoUrl(String sujetoPasivoUrl) {
		this.sujetoPasivoUrl = sujetoPasivoUrl;
	}

	public String getUpdated() {
		return this.updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getVistaPublicaDetallesUrl() {
		return this.vistaPublicaDetallesUrl;
	}

	public void setVistaPublicaDetallesUrl(String vistaPublicaDetallesUrl) {
		this.vistaPublicaDetallesUrl = vistaPublicaDetallesUrl;
	}

	public String getVistaPublicaInstitucionUrl() {
		return this.vistaPublicaInstitucionUrl;
	}

	public void setVistaPublicaInstitucionUrl(String vistaPublicaInstitucionUrl) {
		this.vistaPublicaInstitucionUrl = vistaPublicaInstitucionUrl;
	}

}