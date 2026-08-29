package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByRut(String rut);

    List<Cliente> findByActivoTrue();
}
