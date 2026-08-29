package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.AuditoriaEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditoriaEventoRepository extends JpaRepository<AuditoriaEvento, Long> {

    List<AuditoriaEvento> findByUsuario(String usuario);

    List<AuditoriaEvento> findByEntidadAndEntidadId(String entidad, Long entidadId);

    List<AuditoriaEvento> findByModulo(String modulo);
}
