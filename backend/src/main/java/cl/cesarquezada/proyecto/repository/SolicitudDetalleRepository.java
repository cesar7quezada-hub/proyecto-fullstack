package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.SolicitudDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SolicitudDetalleRepository extends JpaRepository<SolicitudDetalle, Long> {

    List<SolicitudDetalle> findBySolicitudId(Long solicitudId);
}
