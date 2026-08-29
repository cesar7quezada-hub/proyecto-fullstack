package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.ParametroSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ParametroSistemaRepository extends JpaRepository<ParametroSistema, Long> {

    Optional<ParametroSistema> findByCodigo(String codigo);

    List<ParametroSistema> findByActivoTrue();
}
