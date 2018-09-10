package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institucion_detalle database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="institucion_detalle")
@NamedQuery(name="InstitucionDetalle.findAll", query="SELECT i FROM InstitucionDetalle i")
public class InstitucionDetalle implements Serializable {

	@Column(name="codigo")
	private String codigo;

	@Id
	private Integer id;

	@Column(name="nombre")
	private String nombre;

	public InstitucionDetalle() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

}