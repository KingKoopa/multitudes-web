package cl.cleardigital.web.multitudes.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.repository.mercadopublico.LicitacionDetalleCustomRepository;

@Repository
public class LicitacionDetalleRepositoryImpl implements LicitacionDetalleCustomRepository {

	@Autowired
	private EntityManager entityManager;

	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public List<SujetoActivoCabeceraDTO> getDistinctByCompradorRutUnidad(String rutUnidad)throws Exception {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("SELECT " + 
				"	    li.comprador_nombre_organismo as Nombre, " + 
				"	    li.comprador_rut_unidad as Rut, " +  
				"	    li.comprador_region_unidad as Region " + 
				"	FROM  licitacion_detalle li " + 
				"	WHERE " + 
				"	    CONCAT_WS(\" \", " + 
				"	            LTRIM(RTRIM(li.comprador_nombre_organismo)), " + 
				"	            LTRIM(RTRIM(li.comprador_rut_unidad)) " + 
				"	            ) LIKE '%"+rutUnidad+"%' " + 
				"	GROUP BY li.comprador_rut_unidad " + 
				"	ORDER BY li.comprador_nombre_organismo ASC; ");
		
		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoActivoCabeceraDTO> personActiveLst = new ArrayList<>();
	    for(Object[] obj: objLst){
	      SujetoActivoCabeceraDTO personActive = new SujetoActivoCabeceraDTO();
          personActive.setNombreProveedor((String) obj[0]);
          personActive.setRutProveedor((String) obj[1]);
          personActive.setRegion((String) obj[2]);

          personActiveLst.add(personActive);
	    }
		 
		return personActiveLst;
	}
		

	

}
