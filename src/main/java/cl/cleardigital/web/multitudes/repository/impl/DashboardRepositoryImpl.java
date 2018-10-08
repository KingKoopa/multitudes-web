package cl.cleardigital.web.multitudes.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cl.cleardigital.web.multitudes.dto.dashboard.Top10AudienciasPublicasDTO;
import cl.cleardigital.web.multitudes.repository.leylobby.DashboardCustomRepository;

@Repository
public class DashboardRepositoryImpl implements DashboardCustomRepository {

	@Override
	public List<Top10AudienciasPublicasDTO> getTop10AudienciasPublicas() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
