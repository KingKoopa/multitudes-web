package cl.cleardigital.web.multitudes.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interfaz para conectarse a la api de mercado publico.
 * 
 * @author Alfredo Lara
 *
 */
@FeignClient(value="mercadoPublicoClient", url="http://api.mercadopublico.cl/servicios/v1/publico")
public interface MercadoPublicoFeignClient {
	
	@RequestMapping(value = "/licitaciones.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getLicitacionPorDia(
			@RequestParam(value = "estado", required = true) String estado
			,@RequestParam(value = "fecha", required = true) String fecha
			,@RequestParam(value = "ticket", required = true) String ticket
			) throws Exception;
	
	@RequestMapping(value = "/licitaciones.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getDetalleLicitacion(
			@RequestParam(value = "codigo", required = true) String codigo
			,@RequestParam(value = "ticket", required = true) String ticket
			) throws Exception;
}

