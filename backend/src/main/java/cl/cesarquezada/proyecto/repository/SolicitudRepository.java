package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.EstadoSolicitud;
import cl.cesarquezada.proyecto.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    Optional<Solicitud> findByNumeroSolicitud(String numeroSolicitud);

    List<Solicitud> findByClienteId(Long clienteId);

    List<Solicitud> findByEstado(EstadoSolicitud estado);
}
