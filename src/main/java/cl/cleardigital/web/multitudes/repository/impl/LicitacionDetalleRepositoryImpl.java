package cl.cleardigital.web.multitudes.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.cleardigital.web.multitudes.dto.fichas.LicitacionesAdjudicadasDetalleDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoCabeceraDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoCabeceraDTO;
import cl.cleardigital.web.multitudes.repository.mercadopublico.LicitacionDetalleCustomRepository;

@Repository
public class LicitacionDetalleRepositoryImpl implements LicitacionDetalleCustomRepository {

	@Autowired
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public List<SujetoPasivoCabeceraDTO> getDistinctByCompradorRutUnidad(String rutUnidad) throws Exception {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("SELECT " + "	    li.comprador_nombre_organismo as Nombre, "
				+ "	    li.comprador_rut_unidad as Rut, " + "	    li.comprador_region_unidad as Region "
				+ "	FROM  licitacion_detalle li " + "	WHERE " + "	    CONCAT_WS(\" \", "
				+ "	            LTRIM(RTRIM(li.comprador_nombre_organismo)), "
				+ "	            LTRIM(RTRIM(li.comprador_rut_unidad)) " + "	            ) LIKE '%" + rutUnidad + "%' "
				+ "	GROUP BY li.comprador_rut_unidad " + "	ORDER BY li.comprador_nombre_organismo ASC; ");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoPasivoCabeceraDTO> personPasiveLst = new ArrayList<>();
		for (Object[] obj : objLst) {
			SujetoPasivoCabeceraDTO personPasive = new SujetoPasivoCabeceraDTO();
			personPasive.setNombreComprador((String) obj[0]);
			personPasive.setRutComprador((String) obj[1]);
			personPasive.setRegionComprador((String) obj[2]);

			personPasiveLst.add(personPasive);
		}

		return personPasiveLst;
	}

	@Override
	public List<LicitacionesAdjudicadasDetalleDTO> getDistinctByLicitacionAdjudicadaRutUnidad(String rutAdjudicado,
			String tipo) throws Exception {
		Query query = entityManager.createNativeQuery("select  \r\n"
				+ "date_format(ld.fecha_adjudicacion, '%d-%m-%Y')\r\n" + ", ld.codigo_externo\r\n"
				+ ", ld.comprador_region_unidad\r\n" + ", ld.comprador_nombre_usuario\r\n"
				+ "from licitacion_detalle ld\r\n"
				+ "join licitacion_detalle_licitacion_item ldi on ldi.codigo_externo = ld.codigo_externo\r\n"
				+ "join licitacion_item li on li.id = ldi.licitacion_item_id\r\n" + "where ld.comprador_rut_unidad = '"
				+ rutAdjudicado + "'\r\n" + "and ld.tipo = '" + tipo + "'" + "group by ld.codigo_externo\r\n"
				+ ", ld.comprador_region_unidad\r\n" + ", ld.comprador_nombre_usuario ");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<LicitacionesAdjudicadasDetalleDTO> personAdjudicadaLst = new ArrayList<>();
		for (Object[] obj : objLst) {
			LicitacionesAdjudicadasDetalleDTO personAdjudicada = new LicitacionesAdjudicadasDetalleDTO();
			String codigoExterno = (String) obj[1];
			personAdjudicada.setFecha(((String) obj[0]).toString());
			personAdjudicada.setCodigoExterno(codigoExterno);
			personAdjudicada.setRegion((String) obj[2]);
			personAdjudicada.setTomaRazon((String) obj[3]);
			personAdjudicada.setAdjudicadoStr(_getProveedoresAdjudicados(codigoExterno));

			personAdjudicadaLst.add(personAdjudicada);
		}

		return personAdjudicadaLst;
	}

	@SuppressWarnings("unchecked")
	private String _getProveedoresAdjudicados(String codigoExterno) {
		Query query = entityManager.createNativeQuery("select  \n"
				+ "COALESCE(concat(li.adjudicacion_nombre_proveedor,' - ',li.adjudicacion_rut_proveedor),'',concat(li.adjudicacion_nombre_proveedor,'',li.adjudicacion_rut_proveedor, ''))\n"
				+ "from licitacion_detalle ld\n"
				+ "join licitacion_detalle_licitacion_item ldi on ldi.codigo_externo = ld.codigo_externo\n"
				+ "join licitacion_item li on li.id = ldi.licitacion_item_id\n" + "where ld.codigo_externo = '"
				+ codigoExterno + "'\n" + "group by ld.codigo_externo\n" + ", ld.comprador_region_unidad\n"
				+ ", ld.comprador_nombre_usuario \n"
				+ ", concat(li.adjudicacion_nombre_proveedor,' - ',li.adjudicacion_rut_proveedor)");

		List<String> objLst = query.getResultList();
		List<String> proveedoresAdjudicados = new ArrayList<>();
		for (String obj : objLst) {
			proveedoresAdjudicados.add((String) obj);
		}
		return proveedoresAdjudicados != null && !proveedoresAdjudicados.isEmpty()
				? StringUtils.join(proveedoresAdjudicados).replace("[", "").replace("]", "")
				: "";
	}

	@Override
	public List<LicitacionesAdjudicadasDetalleDTO> getDistinctByLicitacionAdjudicadaRutProveedor(String rutAdjudicado,
			String tipo) throws Exception {
		Query query = entityManager
				.createNativeQuery("select \r\n" + "date_format(ld.fecha_adjudicacion, '%d-%m-%Y') as 'Fecha'\r\n"
						+ ", ld.codigo_externo\r\n" + ", ld.comprador_region_unidad\r\n"
						+ ", ld.comprador_nombre_usuario\r\n" + "from licitacion_detalle ld\r\n"
						+ "join licitacion_detalle_licitacion_item ldi on ldi.codigo_externo = ld.codigo_externo\r\n"
						+ "join licitacion_item li on li.id = ldi.licitacion_item_id\r\n"
						+ "where li.adjudicacion_rut_proveedor = '" + rutAdjudicado + "'\r\n" + "and ld.tipo = '" + tipo
						+ "'\r\n" + "group by ld.codigo_externo\r\n" + ", ld.comprador_region_unidad\r\n"
						+ ", ld.comprador_nombre_usuario ");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<LicitacionesAdjudicadasDetalleDTO> personAdjudicadaLst = new ArrayList<>();
		for (Object[] obj : objLst) {
			LicitacionesAdjudicadasDetalleDTO personAdjudicada = new LicitacionesAdjudicadasDetalleDTO();
			String codigoExterno = (String) obj[1];
			personAdjudicada.setFecha(((String) obj[0]).toString());
			personAdjudicada.setCodigoExterno(codigoExterno);
			personAdjudicada.setRegion((String) obj[2]);
			personAdjudicada.setTomaRazon((String) obj[3]);
			personAdjudicada.setAdjudicadoStr(_getCompradorOtorgante(codigoExterno));

			personAdjudicadaLst.add(personAdjudicada);
		}

		return personAdjudicadaLst;
	}

	@SuppressWarnings("unchecked")
	private String _getCompradorOtorgante(String codigoExterno) {
		Query query = entityManager.createNativeQuery("select \n"
				+ " COALESCE(concat(ld.comprador_nombre_organismo,' - ',ld.comprador_rut_unidad),'',concat(ld.comprador_nombre_organismo,' / ',ld.comprador_rut_unidad))\n"
				+ "from licitacion_detalle ld\n" + "where ld.codigo_externo = '" + codigoExterno + "'");

		List<String> objLst = query.getResultList();
		String compradorOtorgante = "";
		for (String obj : objLst) {
			compradorOtorgante = obj;
		}
		return compradorOtorgante;
	}

	@Override
	public List<SujetoActivoCabeceraDTO> getDistinctByVendedorRutProveedor(String rutProveedor) throws Exception {

		Query query = entityManager.createNativeQuery("SELECT " + "	    li.adjudicacion_nombre_proveedor as Nombre,"
				+ "	    li.adjudicacion_rut_proveedor as Rut" + "	FROM  licitacion_item li " + "	WHERE "
				+ "	    CONCAT_WS(\" \", " + "	            LTRIM(RTRIM(li.adjudicacion_nombre_proveedor)), "
				+ "	            LTRIM(RTRIM(li.adjudicacion_rut_proveedor)) " + "	            ) LIKE '%"
				+ rutProveedor + "%' " + "	GROUP BY li.adjudicacion_rut_proveedor "
				+ "	ORDER BY li.adjudicacion_nombre_proveedor ASC");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoActivoCabeceraDTO> personActiveLst = new ArrayList<>();
		for (Object[] obj : objLst) {
			SujetoActivoCabeceraDTO personActive = new SujetoActivoCabeceraDTO();
			personActive.setNombreProveedor((String) obj[0]);
			personActive.setRutProveedor((String) obj[1]);

			personActiveLst.add(personActive);
		}

		return personActiveLst;
	}

/*	@Override
	public Long getMontoTransadoPorRutOrganismo(String rutProveedor) throws Exception {

		Query query = entityManager
				.createNativeQuery("Select coalesce(SUM(li.adjudicacion_antidad * li.adjudicacion_monto_unitario), 0) \r\n" + 
						"from licitacion_detalle ld  Join licitacion_detalle_licitacion_item lu \r\n" + 
						"on (lu.codigo_externo = ld.codigo_externo)\r\n" + 
						"Join licitacion_item li on (li.id = lu.licitacion_item_id)\r\n" + 
						"where comprador_rut_unidad = '"+rutProveedor+"' ");

		@SuppressWarnings("unchecked")
		Long montoTransado = (Long) query.getSingleResult();


		return montoTransado;
	}*/

}
