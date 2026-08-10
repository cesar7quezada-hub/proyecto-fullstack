package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PolizaRepository extends JpaRepository<Poliza, Long> {

    Optional<Poliza> findByNumeroPoliza(String numeroPoliza);

    List<Poliza> findByActivoTrue();
}
