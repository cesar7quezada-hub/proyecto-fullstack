package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.EstadoSesion;
import cl.cesarquezada.proyecto.entity.SesionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SesionUsuarioRepository extends JpaRepository<SesionUsuario, Long> {

    Optional<SesionUsuario> findByRefreshTokenHash(String refreshTokenHash);

    List<SesionUsuario> findByUsuarioIdAndEstado(Long usuarioId, EstadoSesion estado);

    List<SesionUsuario> findByEstado(EstadoSesion estado);
}
