package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the asistente database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="asistente")
@NamedQuery(name="Asistente.findAll", query="SELECT a FROM Asistente a")
public class Asistente implements Serializable {

	@Column(name="active_position_id")
	private Integer activePositionId;

	@Column(name="apellidos")
	private String apellidos;

	@Column(name="cargo_activo_url")
	private String cargoActivoUrl;

	@Id
	private Integer id;

	@Column(name="nombres")
	private String nombres;

	@Column(name="representa_directorio")
	private String representaDirectorio;

	@Column(name="representa_domicilio")
	private String representaDomicilio;

	@Column(name="representa_giro")
	private String representaGiro;

	@Column(name="representa_naturaleza")
	private String representaNaturaleza;

	@Column(name="representa_nombre")
	private String representaNombre;

	@Column(name="representa_pais")
	private String representaPais;

	@Column(name="representa_tipo")
	private String representaTipo;

	@Column(name="representante_legal")
	private String representanteLegal;

	public Asistente() {
	}

	public Integer getActivePositionId() {
		return this.activePositionId;
	}

	public void setActivePositionId(Integer activePositionId) {
		this.activePositionId = activePositionId;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargoActivoUrl() {
		return this.cargoActivoUrl;
	}

	public void setCargoActivoUrl(String cargoActivoUrl) {
		this.cargoActivoUrl = cargoActivoUrl;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getRepresentaDirectorio() {
		return this.representaDirectorio;
	}

	public void setRepresentaDirectorio(String representaDirectorio) {
		this.representaDirectorio = representaDirectorio;
	}

	public String getRepresentaDomicilio() {
		return this.representaDomicilio;
	}

	public void setRepresentaDomicilio(String representaDomicilio) {
		this.representaDomicilio = representaDomicilio;
	}

	public String getRepresentaGiro() {
		return this.representaGiro;
	}

	public void setRepresentaGiro(String representaGiro) {
		this.representaGiro = representaGiro;
	}

	public String getRepresentaNaturaleza() {
		return this.representaNaturaleza;
	}

	public void setRepresentaNaturaleza(String representaNaturaleza) {
		this.representaNaturaleza = representaNaturaleza;
	}

	public String getRepresentaNombre() {
		return this.representaNombre;
	}

	public void setRepresentaNombre(String representaNombre) {
		this.representaNombre = representaNombre;
	}

	public String getRepresentaPais() {
		return this.representaPais;
	}

	public void setRepresentaPais(String representaPais) {
		this.representaPais = representaPais;
	}

	public String getRepresentaTipo() {
		return this.representaTipo;
	}

	public void setRepresentaTipo(String representaTipo) {
		this.representaTipo = representaTipo;
	}

	public String getRepresentanteLegal() {
		return this.representanteLegal;
	}

	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

}