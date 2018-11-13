package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the sujeto_pasivo_detalle database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="sujeto_pasivo_detalle")
@NamedQuery(name="SujetoPasivoDetalle.findAll", query="SELECT s FROM SujetoPasivoDetalle s")
public class SujetoPasivoDetalle implements Serializable {

	@Column(name="apellidos")
	private String apellidos;

	@Column(name="cargo")
	private String cargo;

	@Column(name="fecha_inicio")
	private String fechaInicio;

	@Column(name="fecha_termino")
	private String fechaTermino;

	@Id
	private int id;

	@Column(name="institucion_codigo")
	private String institucionCodigo;

	@Column(name="institucion_nombre")
	private String institucionNombre;

	@Column(name="nombres")	
	private String nombres;

	//bi-directional many-to-one association to Asistente
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sujetoPasivo")
	private List<AudienciaDetalle> AudienciaDetalle;
	
	public SujetoPasivoDetalle() {
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstitucionCodigo() {
		return this.institucionCodigo;
	}

	public void setInstitucionCodigo(String institucionCodigo) {
		this.institucionCodigo = institucionCodigo;
	}

	public String getInstitucionNombre() {
		return this.institucionNombre;
	}

	public void setInstitucionNombre(String institucionNombre) {
		this.institucionNombre = institucionNombre;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<AudienciaDetalle> getAudienciaDetalle() {
		return AudienciaDetalle;
	}

	public void setAudienciaDetalle(List<AudienciaDetalle> audienciaDetalle) {
		AudienciaDetalle = audienciaDetalle;
	}
}