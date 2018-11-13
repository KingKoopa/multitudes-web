package cl.cleardigital.web.multitudes.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interfaz para conectarse a la api de ley del lobby.
 * 
 * @author Alfredo Lara
 *
 */
@FeignClient(value="leyLobbyClient", url="https://www.leylobby.gob.cl/api/v1/")
public interface LeyLobbyFeignClient {
	
	@RequestMapping(value = "/audiencias", method = RequestMethod.GET)
	public ResponseEntity<String> getAudienciasPorPagina(
			@RequestParam(value = "page", required = false) Integer page
			,@RequestParam(value = "per_page", required = false) Integer perPage
			,@RequestHeader("api-key") String apiKey
			) throws Exception;
	
	@RequestMapping(value = "/audiencias/{audiencia_id}", method = RequestMethod.GET)
	public ResponseEntity<String> getAudienciaDetalle(
			@PathVariable(name="audiencia_id") Integer audienciaId
			,@RequestHeader("api-key") String apiKey
			) throws Exception;
	
	@RequestMapping(value = "/instituciones/{institucion_id}", method = RequestMethod.GET)
	public ResponseEntity<String> getInstitucionDetalle(
			@PathVariable(name="institucion_id") Integer institucionId
			,@RequestHeader("api-key") String apiKey
			) throws Exception;
	
	@RequestMapping(value = "/cargos-activos/{cargo_id}", method = RequestMethod.GET)
	public ResponseEntity<String> getCargoActivo(
			@PathVariable(name="cargo_id") Integer cargoId
			,@RequestHeader("api-key") String apiKey
			) throws Exception;
	
	@RequestMapping(value = "/cargos-pasivos/{cargo_id}", method = RequestMethod.GET)
	public ResponseEntity<String> getCargoPasivo(
			@PathVariable(name="cargo_id") Integer cargoId
			,@RequestHeader("api-key") String apiKey
			) throws Exception;
}

