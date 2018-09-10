package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
import javax.persistence.*;


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
	private Integer remunerado;

	@Column(name="sujeto_apellidos")
	private String sujetoApellidos;

	@Column(name="sujeto_nombres")
	private String sujetoNombres;

	@Column(name="tipo")
	private String tipo;

	public CargoActivo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRemunerado() {
		return this.remunerado;
	}

	public void setRemunerado(Integer remunerado) {
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

}