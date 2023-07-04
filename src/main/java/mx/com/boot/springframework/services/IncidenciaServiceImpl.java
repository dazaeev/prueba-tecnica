package mx.com.boot.springframework.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.boot.springframework.domain.Incidencia;
import mx.com.boot.springframework.repositories.IncidenciaRepository;

/**
 * @author Nazario Dazaeev
 *
 */
@Service
public class IncidenciaServiceImpl implements IncidenciaService {

	@Autowired
	private IncidenciaRepository incidenciaRepository;

	@Override
	public void guardarIncidencia(Incidencia incidencia) {
		incidenciaRepository.save(incidencia);
	}

	@Override
	public List<Incidencia> getIncidenciaTipo(String tipo) {
		return incidenciaRepository.findIncidenciaByTipo(tipo);
	}

	@Override
	public Incidencia getIncidenciaId(int id) {
		return incidenciaRepository.findIncidenciaById(id);
	}
}