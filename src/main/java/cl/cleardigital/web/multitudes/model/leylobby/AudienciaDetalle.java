package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the audiencia_detalle database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="audiencia_detalle")
@NamedQuery(name="AudienciaDetalle.findAll", query="SELECT a FROM AudienciaDetalle a")
public class AudienciaDetalle implements Serializable {

	@Id
	private Integer id;

	@Column(name="institucion_url")
	private String institucionUrl;

	@Column(name="sujeto_pasivo_url")
	private String sujetoPasivoUrl;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "audiencia_detalle_asistente", joinColumns = {
			@JoinColumn(name = "audiencia_detalle_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "asistente_id", nullable = false, updatable = false) })
	private List<Asistente> asistentes;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "audiencia_detalle_materia", joinColumns = {
			@JoinColumn(name = "audiencia_detalle_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "audiencia_materia_id", nullable = false, updatable = false) })
	private List<AudienciaMateria> materias;
	
    //bi-directional many-to-one association to sujetoPasivoDetalle
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sujeto_pasivo_id", nullable = false)
	private SujetoPasivoDetalle sujetoPasivo;
	
	public AudienciaDetalle() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstitucionUrl() {
		return this.institucionUrl;
	}

	public void setInstitucionUrl(String institucionUrl) {
		this.institucionUrl = institucionUrl;
	}

	public String getSujetoPasivoUrl() {
		return this.sujetoPasivoUrl;
	}

	public void setSujetoPasivoUrl(String sujetoPasivoUrl) {
		this.sujetoPasivoUrl = sujetoPasivoUrl;
	}

	public List<Asistente> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<Asistente> asistentes) {
		this.asistentes = asistentes;
	}

	public List<AudienciaMateria> getMaterias() {
		return materias;
	}

	public void setMaterias(List<AudienciaMateria> materias) {
		this.materias = materias;
	}

	public SujetoPasivoDetalle getSujetoPasivo() {
		return sujetoPasivo;
	}

	public void setSujetoPasivo(SujetoPasivoDetalle sujetoPasivo) {
		this.sujetoPasivo = sujetoPasivo;
	}

}