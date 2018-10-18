package cl.cleardigital.web.multitudes.repository.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.cleardigital.web.multitudes.dto.dashboard.AudienciasPorMesDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPrivadasDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPublicasDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10CompradorLicitacionesDTO;
import cl.cleardigital.web.multitudes.dto.dashboard.Top10ProveedorLicitacionesDTO;
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

		Query query = entityManager.createNativeQuery("select count(ac.id) as cantidad_audiencias "
				+ ", id.nombre as nombre_institucion " + "from institucion_detalle id "
				+ "join audiencia_cabecera ac on ac.institucion_detail_id = id.id " + "group by id.nombre "
				+ "order by count(ac.id) desc " + "limit 10");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		for (Object[] obj : objLst) {
			Top10AudienciasPublicasDTO top10AudienciasPublicasDTO = new Top10AudienciasPublicasDTO();
			top10AudienciasPublicasDTO.setCantidad(((BigInteger) obj[0]).intValue());
			top10AudienciasPublicasDTO.setInstitucion((String) obj[1]);
			top10AudienciasPublicasLst.add(top10AudienciasPublicasDTO);
		}
		return top10AudienciasPublicasLst;
	}

	@Override
	public List<AudienciasPorMesDTO> getAudienciasPorMes() throws Exception {

		Query query = entityManager.createNativeQuery(" select count(*) as 'Cantidad de Audiencias', \r\n"
				+ "DATE_FORMAT(trim(fecha_inicio), '%b-%y') as 'Fecha' \r\n" + "from audiencia_cabecera\r\n"
				+ "group by DATE_FORMAT(fecha_inicio, '%m') \r\n" + "order by fecha_inicio DESC ");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<AudienciasPorMesDTO> cantidadMesLst = new ArrayList<>();
		for (Object[] obj : objLst) {
			AudienciasPorMesDTO cantidadMes = new AudienciasPorMesDTO();
			cantidadMes.setCantidad(((BigInteger) obj[0]).intValue());
			cantidadMes.setFecha((String) obj[1]);

			cantidadMesLst.add(cantidadMes);
		}

		return cantidadMesLst;
	}

	@Override
	public List<Top10AudienciasPrivadasDTO> getTop10AudienciasPrivadas() throws Exception {

		List<Top10AudienciasPrivadasDTO> top10AudienciasPrivadasLst = new ArrayList<>();

		Query query = entityManager.createNativeQuery("select count(ad.id) as cantidad_audiencias "
				+ ", asist.representa_nombre as nombre_proveedor " + "from audiencia_detalle ad "
				+ "join audiencia_detalle_asistente ada on ada.audiencia_detalle_id = ad.id "
				+ "join asistente asist on asist.id = ada.asistente_id " + "group by asist.representa_nombre "
				+ "order by count(ad.id) desc " + "limit 10;");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		for (Object[] obj : objLst) {
			Top10AudienciasPrivadasDTO top10AudienciasPrivadasDTO = new Top10AudienciasPrivadasDTO();
			top10AudienciasPrivadasDTO.setCantidad(((BigInteger) obj[0]).intValue());
			top10AudienciasPrivadasDTO.setProveedor((String) obj[1]);
			top10AudienciasPrivadasLst.add(top10AudienciasPrivadasDTO);
		}
		return top10AudienciasPrivadasLst;

	}

	@Override
	public List<Top10CompradorLicitacionesDTO> getTop10CompradorLicitaciones() throws Exception {

		List<Top10CompradorLicitacionesDTO> top10CompradorLicitacionesLst = new ArrayList<>();

		Query query = entityManager.createNativeQuery(
				"select count(comprador_rut_unidad), comprador_rut_unidad, comprador_nombre_unidad\r\n"
						+ "from licitacion_detalle  \r\n" + "group by comprador_rut_unidad \r\n"
						+ "order by count(comprador_rut_unidad) desc limit 10;");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		for (Object[] obj : objLst) {
			Top10CompradorLicitacionesDTO top10CompradorLicitacionesDTO = new Top10CompradorLicitacionesDTO();
			top10CompradorLicitacionesDTO.setCantidad(((BigInteger) obj[0]).intValue());
			top10CompradorLicitacionesDTO.setRutComprador((String) obj[1]);
			top10CompradorLicitacionesDTO.setNombreComprador((String) obj[2]);
			top10CompradorLicitacionesLst.add(top10CompradorLicitacionesDTO);
		}
		return top10CompradorLicitacionesLst;
	}

	@Override
	public List<Top10ProveedorLicitacionesDTO> getTop10ProveedorLicitaciones() throws Exception {
		List<Top10ProveedorLicitacionesDTO> top10ProveedorLicitacionesLst = new ArrayList<>();

		Query query = entityManager.createNativeQuery(
				"select count(adjudicacion_rut_proveedor), adjudicacion_rut_proveedor, adjudicacion_nombre_proveedor\n" + 
				"from licitacion_item\n" + 
				"group by adjudicacion_rut_proveedor\n" + 
				"order by count(adjudicacion_rut_proveedor) desc limit 10");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		for (Object[] obj : objLst) {
			Top10ProveedorLicitacionesDTO top10ProveedorLicitacionesDTO = new Top10ProveedorLicitacionesDTO();
			top10ProveedorLicitacionesDTO.setCantidad(((BigInteger) obj[0]).intValue());
			top10ProveedorLicitacionesDTO.setRutProveedor((String) obj[1]);
			top10ProveedorLicitacionesDTO.setNombreProveedor((String) obj[2]);
			top10ProveedorLicitacionesLst.add(top10ProveedorLicitacionesDTO);
		}
		return top10ProveedorLicitacionesLst;
	}

}
