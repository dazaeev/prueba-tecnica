package mx.com.boot.springframework.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.boot.springframework.domain.Incidencia;

/**
 * @author Nazario Dazaeev
 *
 */
public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {

	Incidencia findIncidenciaById(int id);

	List<Incidencia> findIncidenciaByTipo(String tipo);
}