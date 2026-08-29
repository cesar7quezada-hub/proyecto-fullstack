package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.ArchivoAdjunto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ArchivoAdjuntoRepository extends JpaRepository<ArchivoAdjunto, Long> {

    List<ArchivoAdjunto> findBySolicitudId(Long solicitudId);

    Optional<ArchivoAdjunto> findByHashArchivo(String hashArchivo);
}
