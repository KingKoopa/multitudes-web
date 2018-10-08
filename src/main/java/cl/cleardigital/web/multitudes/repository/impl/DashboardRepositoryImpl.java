package cl.cleardigital.web.multitudes.repository.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.cleardigital.web.multitudes.dto.dashboard.AudienciasPorMesDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPublicasDTO;
import cl.cleardigital.web.multitudes.repository.leylobby.DashboardCustomRepository;

@Repository
public class DashboardRepositoryImpl implements DashboardCustomRepository {

	@Autowired
	private EntityManager entityManager;

	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public List<Top10AudienciasPublicasDTO> getTop10AudienciasPublicas() throws Exception {

		List<Top10AudienciasPublicasDTO> top10AudienciasPublicasLst = new ArrayList<>();
		
		Query query = entityManager.createNativeQuery("select count(ac.id) as cantidad_audiencias " + 
				", id.nombre as nombre_institucion " + 
				"from institucion_detalle id " + 
				"join audiencia_cabecera ac on ac.institucion_detail_id = id.id " + 
				"group by id.nombre " + 
				"order by count(ac.id) desc " + 
				"limit 10");
		
		List<Object[]> objLst = query.getResultList();
		for(Object[] obj: objLst){
			Top10AudienciasPublicasDTO top10AudienciasPublicasDTO = new Top10AudienciasPublicasDTO();
			top10AudienciasPublicasDTO.setCantidad((Integer) obj[0]);
			top10AudienciasPublicasDTO.setInstitucion((String) obj[1]);
			top10AudienciasPublicasLst.add(top10AudienciasPublicasDTO);
		}
		return top10AudienciasPublicasLst;
	}
	
	@Override
	public List<AudienciasPorMesDTO> getAudienciasPorMes() throws Exception {

		Query query = entityManager.createNativeQuery(" select count(*) as 'Cantidad de Audiencias', \r\n" + 
				"DATE_FORMAT(fecha_inicio, '%m-%Y') as 'Fecha' \r\n" + 
				"from audiencia_cabecera\r\n" + 
				"group by DATE_FORMAT(fecha_inicio, '%m') \r\n" + 
				"order by fecha_inicio DESC ");
		
		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<AudienciasPorMesDTO> cantidadMesLst = new ArrayList<>();
	    for(Object[] obj: objLst){
	    	AudienciasPorMesDTO cantidadMes = new AudienciasPorMesDTO();
	    	cantidadMes.setCantidad(((BigInteger) obj[0]).intValue());
	    	cantidadMes.setFecha((String) obj[1]);
	    	
	    	cantidadMesLst.add(cantidadMes);
	    }
		 
		return cantidadMesLst;
	}
	
}
