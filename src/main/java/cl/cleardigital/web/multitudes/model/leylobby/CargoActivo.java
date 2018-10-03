package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the cargo_activo database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="cargo_activo")
@NamedQuery(name="CargoActivo.findAll", query="SELECT c FROM CargoActivo c")
public class CargoActivo implements Serializable {

	@Id
	private Integer id;

	@Column(name="remunerado")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean remunerado;

	@Column(name="sujeto_apellidos")
	private String sujetoApellidos;

	@Column(name="sujeto_nombres")
	private String sujetoNombres;

	@Column(name="tipo")
	private String tipo;

	//bi-directional many-to-one association to Asistente
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cargoActivo")
	private List<Asistente> asistentes;
	
	public CargoActivo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getRemunerado() {
		return this.remunerado;
	}

	public void setRemunerado(Boolean remunerado) {
		this.remunerado = remunerado;
	}

	public String getSujetoApellidos() {
		return this.sujetoApellidos;
	}

	public void setSujetoApellidos(String sujetoApellidos) {
		this.sujetoApellidos = sujetoApellidos;
	}

	public String getSujetoNombres() {
		return this.sujetoNombres;
	}

	public void setSujetoNombres(String sujetoNombres) {
		this.sujetoNombres = sujetoNombres;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Asistente> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<Asistente> asistentes) {
		this.asistentes = asistentes;
	}

}