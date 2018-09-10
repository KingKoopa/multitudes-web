package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
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

	@Column(name="audiencias_url")
	private String audienciasUrl;

	@Column(name="cargo")
	private String cargo;

	@Column(name="donativos_url")
	private String donativosUrl;

	@Id
	private Integer id;

	@Column(name="institucion_url")
	private String institucionUrl;

	@Column(name="nombres")
	private String nombres;

	@Column(name="resolucion")
	private String resolucion;

	@Column(name="resolucion_url")
	private String resolucionUrl;

	@Column(name="viajes_url")
	private String viajesUrl;

	public SujetoPasivoDetalle() {
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getAudienciasUrl() {
		return this.audienciasUrl;
	}

	public void setAudienciasUrl(String audienciasUrl) {
		this.audienciasUrl = audienciasUrl;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDonativosUrl() {
		return this.donativosUrl;
	}

	public void setDonativosUrl(String donativosUrl) {
		this.donativosUrl = donativosUrl;
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

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getResolucion() {
		return this.resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getResolucionUrl() {
		return this.resolucionUrl;
	}

	public void setResolucionUrl(String resolucionUrl) {
		this.resolucionUrl = resolucionUrl;
	}

	public String getViajesUrl() {
		return this.viajesUrl;
	}

	public void setViajesUrl(String viajesUrl) {
		this.viajesUrl = viajesUrl;
	}

}