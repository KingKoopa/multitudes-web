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
		Query query = entityManager.createNativeQuery("select concat(ac.nombres, ' ' " + 
				", ac.apellidos) as \"Nombre\" " + 
				", ac.cargo " + 
				", count(ac.id) as cantidad_audiencias " + 
				", ac.id " +
				"from institucion_detalle ins " + 
				"join audiencia_cabecera ac  " + 
				"on ac.institucion_detail_id = ins.id " + 
				"where ins.nombre like '%"+nombre+"%' " + 
				"and str_to_date(ac.fecha_inicio,'%Y-%m-%d') between '2015-06-01' AND '2015-06-31' " + 
				"group by ac.nombres " + 
				", ac.apellidos");
		
		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoPasivoAudienciaDTO> personPasiveLst = new ArrayList<>();
	    for(Object[] obj: objLst){
	    	SujetoPasivoAudienciaDTO personPasive = new SujetoPasivoAudienciaDTO();
	    	personPasive.setNombreCompleto((String) obj[0]);
	    	personPasive.setCargo((String) obj[1]);
	    	personPasive.setCantidadDeAudiencias(((BigInteger) obj[2]).intValue());
	    	personPasive.setSujetoActivosCantidad(getCantidadSujetosActivos((Integer) obj[3]));
	    	personPasiveLst.add(personPasive);
	    }
		 
		return personPasiveLst;
	}

	@Override
	public Integer getCantidadSujetosActivos(Integer audienciaId) throws Exception {
		Query query = entityManager.createNativeQuery("   select " + 
				"    count(ada.asistente_id) as sujetos_activos " + 
				"    from audiencia_detalle ad " + 
				"    join audiencia_detalle_asistente ada on ada.audiencia_detalle_id = ad.id " + 
				"    where ad.id = " + audienciaId + 
				"    group by ad.id, ada.audiencia_detalle_id ");
		Integer cantidadSujetosActivos = 0;
			try {
				if(query.getSingleResult() != null) {
					cantidadSujetosActivos = ((BigInteger) query.getSingleResult()).intValue();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return cantidadSujetosActivos;
	}
}
