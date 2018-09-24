package cl.cleardigital.web.multitudes.repository.leylobby;


import org.springframework.data.jpa.repository.JpaRepository;

import cl.cleardigital.web.multitudes.model.leylobby.AudienciaCabecera;

public interface CabeceraAudienciaRepository extends JpaRepository<AudienciaCabecera, Integer>, CabeceraAudienciaCustomRepository{
	
	
}
