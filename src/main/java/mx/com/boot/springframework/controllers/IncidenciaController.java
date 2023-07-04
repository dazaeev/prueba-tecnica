package mx.com.boot.springframework.controllers;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.boot.springframework.config.ControllerDocumentation;
import mx.com.boot.springframework.config.WebResponse;
import mx.com.boot.springframework.domain.Incidencia;
import mx.com.boot.springframework.services.IncidenciaService;

/**
 * @author Nazario Dazaeev
 *
 */
@RestController
@RequestMapping("/adm")
@ControllerDocumentation
public class IncidenciaController {

	@Autowired
	private IncidenciaService incidenciaService;
	
	@ApiOperation(code = HttpStatus.SC_OK, value = "Guarda incidencia.", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = HttpStatus.SC_OK, message = "Guarda incidencia."),
			@ApiResponse(code = HttpStatus.SC_BAD_REQUEST, 
			message = "Error al Guardar incidencia") })
	@ResponseStatus(value = org.springframework.http.HttpStatus.ACCEPTED)
	@PostMapping(value = "/incidencia/guardar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void guardarIncidencia(@RequestBody Incidencia incidencia) {
		incidenciaService.guardarIncidencia(incidencia);
	}
	
	@ApiOperation(code = HttpStatus.SC_OK, value = "Consulta incidencia por ID.", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = HttpStatus.SC_OK, message = "Consulta incidencia por ID."),
			@ApiResponse(code = HttpStatus.SC_BAD_REQUEST, 
			message = "Error al Consultar incidencia") })
	@ResponseStatus(value = org.springframework.http.HttpStatus.ACCEPTED)
	@GetMapping(value = "/consulta/incidencia/id", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<WebResponse> consultaIncidenciaTipo(@RequestParam int id) {
		return ResponseEntity.ok(WebResponse.builder()
                .payload(this.incidenciaService.getIncidenciaId(id)).build());
	}

	@ApiOperation(code = HttpStatus.SC_OK, value = "Consulta incidencia por tipo.", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = HttpStatus.SC_OK, message = "Consulta incidencia por tipo."),
			@ApiResponse(code = HttpStatus.SC_BAD_REQUEST, 
			message = "Error al Consultar incidencia") })
	@ResponseStatus(value = org.springframework.http.HttpStatus.ACCEPTED)
	@GetMapping(value = "/consulta/incidencia/tipo/{tipo}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<WebResponse> consultaIncidenciaTipo(@PathVariable String tipo) {
		return ResponseEntity.ok(WebResponse.builder()
                .payload(this.incidenciaService.getIncidenciaTipo(tipo)).build());
	}
}