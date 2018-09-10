package cl.cleardigital.web.multitudes.model.leylobby;

import java.io.Serializable;
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

}