package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the audiencia_materia database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="audiencia_materia")
@NamedQuery(name="AudienciaMateria.findAll", query="SELECT a FROM AudienciaMateria a")
public class AudienciaMateria implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nombre")
	private String nombre;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "audiencia_detalle_materia", joinColumns = {
			@JoinColumn(name = "audiencia_materia_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "audiencia_detalle_id", nullable = false, updatable = false) })
	private List<AudienciaDetalle> audienciasDetalle;
	
	public AudienciaMateria() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AudienciaDetalle> getAudienciasDetalle() {
		return audienciasDetalle;
	}

	public void setAudienciasDetalle(List<AudienciaDetalle> audienciasDetalle) {
		this.audienciasDetalle = audienciasDetalle;
	}

}