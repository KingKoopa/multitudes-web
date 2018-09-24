package cl.cleardigital.web.multitudes.repository.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;
import cl.cleardigital.web.multitudes.repository.leylobby.CabeceraAudienciaCustomRepository;

@Repository
public class CabeceraAudienciaRepositoryImpl implements CabeceraAudienciaCustomRepository {

	@Autowired
	private EntityManager entityManager;

	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public List<SujetoPasivoAudienciaDTO> findByPasivoAudiencias(String nombre) throws Exception {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("select concat(ac.nombres, ' '\r\n" + 
				", ac.apellidos) as \"Nombre\"\r\n" + 
				", ac.cargo\r\n" + 
				", count(ac.id) as cantidad_audiencias\r\n" + 
				"from institucion_detalle ins\r\n" + 
				"join audiencia_cabecera ac \r\n" + 
				"on ac.institucion_detail_id = ins.id\r\n" + 
				"where ins.nombre like '%"+nombre+"%'\r\n" + 
				"and str_to_date(ac.fecha_inicio,'%Y-%m-%d') between '2015-06-01' AND '2015-06-31'\r\n" + 
				"group by ac.nombres\r\n" + 
				", ac.apellidos");
		
		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoPasivoAudienciaDTO> personPasiveLst = new ArrayList<>();
	    for(Object[] obj: objLst){
	    	SujetoPasivoAudienciaDTO personPasive = new SujetoPasivoAudienciaDTO();
	    	personPasive.setNombreCompleto((String) obj[0]);
	    	personPasive.setCargo((String) obj[1]);
	    	personPasive.setCantidadDeAudiencias(((BigInteger) obj[2]).intValue());

	    	personPasiveLst.add(personPasive);
	    }
		 
		return personPasiveLst;
	}
	


}
