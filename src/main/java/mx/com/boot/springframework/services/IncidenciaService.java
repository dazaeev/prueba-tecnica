package mx.com.boot.springframework.services;

import java.util.List;

import mx.com.boot.springframework.domain.Incidencia;

/**
 * @author Nazario Dazaeev
 *
 */
public interface IncidenciaService {

	void guardarIncidencia(Incidencia incidencia);

	List<Incidencia> getIncidenciaTipo(String tipo);
	
	Incidencia getIncidenciaId(int id);
}