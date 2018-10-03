package cl.cleardigital.web.multitudes.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoLicitacionesAdjudicadasDetalleDTO;
import cl.cleardigital.web.multitudes.repository.mercadopublico.LicitacionDetalleCustomRepository;

@Repository
public class LicitacionDetalleRepositoryImpl implements LicitacionDetalleCustomRepository {

	@Autowired
	private EntityManager entityManager;

	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public List<SujetoPasivoCabeceraDTO> getDistinctByCompradorRutUnidad(String rutUnidad)throws Exception {
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
		List<SujetoPasivoCabeceraDTO> personPasiveLst = new ArrayList<>();
	    for(Object[] obj: objLst){
	    	SujetoPasivoCabeceraDTO personPasive = new SujetoPasivoCabeceraDTO();
	    	personPasive.setNombreComprador((String) obj[0]);
	    	personPasive.setRutComprador((String) obj[1]);
	    	personPasive.setRegionComprador((String) obj[2]);

	    	personPasiveLst.add(personPasive);
	    }
		 
		return personPasiveLst;
	}
	
	@Override
	public List<SujetoPasivoLicitacionesAdjudicadasDetalleDTO> getDistinctByLicitacionAdjudicadaRutUnidad(String rutAdjudicado, String tipo)throws Exception {
		Query query = entityManager.createNativeQuery("select  \r\n" + 
				"date_format(ld.fecha_adjudicacion, '%d-%m-%Y')\r\n" + 
				", ld.codigo_externo\r\n" + 
				", ld.comprador_region_unidad\r\n" + 
				", ld.comprador_nombre_usuario\r\n" + 
				"from licitacion_detalle ld\r\n" + 
				"join licitacion_detalle_licitacion_item ldi on ldi.codigo_externo = ld.codigo_externo\r\n" + 
				"join licitacion_item li on li.id = ldi.licitacion_item_id\r\n" + 
				"where ld.comprador_rut_unidad = '"+rutAdjudicado+"'\r\n" + 
				"and ld.tipo = '"+tipo+"'" +
				"group by ld.codigo_externo\r\n" + 
				", ld.comprador_region_unidad\r\n" + 
				", ld.comprador_nombre_usuario "); 
		
		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoPasivoLicitacionesAdjudicadasDetalleDTO> personAdjudicadaLst = new ArrayList<>();
	    for(Object[] obj: objLst){
	    	SujetoPasivoLicitacionesAdjudicadasDetalleDTO personAdjudicada = new SujetoPasivoLicitacionesAdjudicadasDetalleDTO();
	    	personAdjudicada.setFecha(((String) obj[0]).toString());
	    	personAdjudicada.setCodigoExterno((String) obj[1]);
	    	personAdjudicada.setRegion((String) obj[2]);
	    	personAdjudicada.setTomaRazon((String) obj[3]);

	    	personAdjudicadaLst.add(personAdjudicada);
	    }
		 
		return personAdjudicadaLst;
	}

	@Override
	public List<SujetoActivoCabeceraDTO> getDistinctByVendedorRutProveedor(String rutProveedor) throws Exception {

		Query query = entityManager.createNativeQuery("SELECT " + 
				"	    li.adjudicacion_nombre_proveedor as Nombre," + 
				"	    li.adjudicacion_rut_proveedor as Rut" + 
				"	FROM  licitacion_item li " + 
				"	WHERE " + 
				"	    CONCAT_WS(\" \", " + 
				"	            LTRIM(RTRIM(li.adjudicacion_nombre_proveedor)), " + 
				"	            LTRIM(RTRIM(li.adjudicacion_rut_proveedor)) " + 
				"	            ) LIKE '%"+rutProveedor+"%' " + 
				"	GROUP BY li.adjudicacion_rut_proveedor " + 
				"	ORDER BY li.adjudicacion_nombre_proveedor ASC");
		
		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoActivoCabeceraDTO> personActiveLst = new ArrayList<>();
	    for(Object[] obj: objLst){
	      SujetoActivoCabeceraDTO personActive = new SujetoActivoCabeceraDTO();
          personActive.setNombreProveedor((String) obj[0]);
          personActive.setRutProveedor((String) obj[1]);

          personActiveLst.add(personActive);
	    }
		 
		return personActiveLst;
	}

	

}
