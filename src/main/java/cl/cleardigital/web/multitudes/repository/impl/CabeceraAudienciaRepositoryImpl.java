package cl.cleardigital.web.multitudes.repository.impl;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.cleardigital.web.multitudes.dto.dashboard.AudienciasPorMesDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoActivoAudienciaDTO;
import cl.cleardigital.web.multitudes.dto.fichas.SujetoPasivoAudienciaDTO;
import cl.cleardigital.web.multitudes.repository.leylobby.CabeceraAudienciaCustomRepository;

@Repository
public class CabeceraAudienciaRepositoryImpl implements CabeceraAudienciaCustomRepository {

	@Autowired
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public List<SujetoPasivoAudienciaDTO> findByPasivoAudiencias(String nombre, Date fechaDesde, Date fechaHAsta)
			throws Exception {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("select concat(ac.nombres, ' ' "
				+ ", ac.apellidos) as \"Nombre\" " + ", ac.cargo " + ", count(ac.id) as cantidad_audiencias "
				+ ", ac.id " + "from institucion_detalle ins " + "join audiencia_cabecera ac  "
				+ "on ac.institucion_detail_id = ins.id " + "where ins.nombre like '%" + nombre + "%' "
				+ "and str_to_date(ac.fecha_inicio,'%Y-%m-%d') between '" + fechaDesde + "' AND '" + fechaHAsta + "' "
				+ "group by ac.nombres " + ", ac.apellidos");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoPasivoAudienciaDTO> personPasiveLst = new ArrayList<>();
		for (Object[] obj : objLst) {
			SujetoPasivoAudienciaDTO personPasive = new SujetoPasivoAudienciaDTO();
			personPasive.setNombreCompleto((String) obj[0]);
			personPasive.setCargo((String) obj[1]);
			personPasive.setCantidadDeAudiencias(((BigInteger) obj[2]).intValue());
			Integer audienciaId = (Integer) obj[3];
			Integer resultado = (audienciaId != null) ? getCantidadSujetosActivos(audienciaId) : 0;
			personPasive.setSujetoActivosCantidad(resultado);
			personPasiveLst.add(personPasive);
		}

		return personPasiveLst;
	}

	@Override
	public Integer getCantidadSujetosActivos(Integer audienciaId) throws Exception {
		Query query = entityManager.createNativeQuery(
				"   select " + "    count(ada.asistente_id) as sujetos_activos " + "    from audiencia_detalle ad "
						+ "    join audiencia_detalle_asistente ada on ada.audiencia_detalle_id = ad.id "
						+ "    where ad.id = " + audienciaId + "    group by ad.id, ada.audiencia_detalle_id ");
		Integer cantidadSujetosActivos = 0;
		try {
			if (query.getSingleResult() != null) {
				cantidadSujetosActivos = ((BigInteger) query.getSingleResult()).intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cantidadSujetosActivos;
	}

	@Override
	public List<SujetoActivoAudienciaDTO> findByActivoAudiencias(String rut, Date fechaDesde, Date fechaHasta)
			throws Exception {
		Query query = entityManager
				.createNativeQuery("select CONCAT(ca.sujeto_nombres, ' ', ca.sujeto_apellidos) as 'Nombre',\r\n"
						+ "date_format(ac.fecha_inicio, '%d-%m-%Y') as 'Fecha', \r\n" + "ac.referencia as 'Tema',\r\n"
						+ "am.nombre as 'Materia', id.nombre as 'Organismo', \r\n"
						+ "COUNT(ad.id) as 'Audiencias', ca.remunerado, ca.id\r\n"
						+ "from cargo_activo ca Join asistente asi\r\n" + " on(ca.id = asi.cargo_activo_id)\r\n"
						+ "Join audiencia_detalle_asistente ada \r\n" + "on (ada.asistente_id = asi.id)\r\n"
						+ "Join audiencia_detalle ad \r\n" + "on (ad.id = ada.audiencia_detalle_id)\r\n"
						+ "Join audiencia_detalle_materia adm\r\n" + " on (ad.id = adm.audiencia_detalle_id)\r\n"
						+ "Join audiencia_materia am \r\n" + "on (am.id = adm.audiencia_materia_id)\r\n"
						+ "Join audiencia_cabecera ac on (ac.id= ad.id)\r\n" + " Join institucion_detalle id \r\n"
						+ "on (id.id = ac.institucion_detail_id)\r\n" + "where asi.representa_rut = '" + rut + "' \r\n"
						+ "and str_to_date(ac.fecha_inicio,'%Y-%m-%d')\r\n" + "between '" + fechaDesde + "' and '"
						+ fechaHasta + "'\r\n" + "group by Nombre, asi.representa_rut;");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoActivoAudienciaDTO> personActiveLst = new ArrayList<>();
		for (Object[] obj : objLst) {
			SujetoActivoAudienciaDTO personActive = new SujetoActivoAudienciaDTO();
			personActive.setSujetoActivo((String) obj[0]);
			personActive.setFecha((String) obj[1].toString());
			personActive.setTema((String) obj[2]);
			personActive.setMaterias((String) obj[3]);
			personActive.setOrganismo((String) obj[4]);
			personActive.setCantidad(((BigInteger) obj[5]).intValue());
			Integer remunerado = (Integer) obj[6];
			Boolean resultado = (remunerado != null && remunerado == 1) ? Boolean.TRUE : Boolean.FALSE;
			personActive.setRemunerado(resultado);
			personActive.setCargoId(((Integer) obj[7]));
			personActive.setFechaDesde(fechaDesde);
			personActive.setFechaHasta(fechaHasta);

			personActiveLst.add(personActive);
		}

		return personActiveLst;
	}

	@Override
	public List<SujetoActivoAudienciaDTO> findByActivoAudienciasDetalle(String rut, Date fechaDesde, Date fechaHasta,
			Integer cargoId) throws Exception {
		Query query = entityManager
				.createNativeQuery("select CONCAT(ca.sujeto_nombres, ' ', ca.sujeto_apellidos) as 'Nombre',\r\n" + 
						"date_format(ac.fecha_inicio, '%d-%m-%Y') as 'Fecha', \r\n" + 
						"ac.referencia as 'Tema',\r\n" + 
						"am.nombre as 'Materia', CONCAT(sp.nombres, ' ', sp.apellidos) as 'Pasivo',\r\n" + 
						"sp.cargo as 'Cargo', id.nombre as 'Organismo'\r\n" + 
						"from cargo_activo ca Join asistente asi\r\n" + 
						" on(ca.id = asi.cargo_activo_id)\r\n" + 
						"Join audiencia_detalle_asistente ada \r\n" + 
						"on (ada.asistente_id = asi.id)\r\n" + 
						"Join audiencia_detalle ad \r\n" + 
						"on (ad.id = ada.audiencia_detalle_id)\r\n" + 
						"Join audiencia_detalle_materia adm\r\n" + 
						" on (ad.id = adm.audiencia_detalle_id)\r\n" + 
						"Join audiencia_materia am \r\n" + 
						"on (am.id = adm.audiencia_materia_id)\r\n" + 
						"Join audiencia_cabecera ac on (ac.id= ad.id)\r\n" + 
						" Join institucion_detalle id \r\n" + 
						"on (id.id = ac.institucion_detail_id)\r\n" + 
						"Join sujeto_pasivo_detalle sp on(sp.id = ad.sujeto_pasivo_id)\r\n" + 
						"where asi.representa_rut = '"+rut+"' and\r\n" + 
						"ca.id = "+cargoId+"\r\n" + 
						"and str_to_date(ac.fecha_inicio,'%Y-%m-%d')\r\n" + 
						"between '"+fechaDesde+"' and '"+fechaHasta+"';\r\n" + 
						"");

		@SuppressWarnings("unchecked")
		List<Object[]> objLst = query.getResultList();
		List<SujetoActivoAudienciaDTO> personActiveLst = new ArrayList<>();
		for (Object[] obj : objLst) {
			SujetoActivoAudienciaDTO personActive = new SujetoActivoAudienciaDTO();
			personActive.setSujetoActivo((String) obj[0]);
			personActive.setFecha((String) obj[1].toString());
			personActive.setTema((String) obj[2]);
			personActive.setMaterias((String) obj[3]);
			personActive.setSujetoPasivo((String) obj[4]);
			personActive.setCargoPasivo((String) obj[5]);
			personActive.setOrganismo((String) obj[6]);

			personActiveLst.add(personActive);
		}

		return personActiveLst;
	}

}
