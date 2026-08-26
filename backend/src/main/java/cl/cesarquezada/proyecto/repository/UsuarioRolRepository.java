package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {

    List<UsuarioRol> findByActivoTrue();

    List<UsuarioRol> findByUsuarioIdAndActivoTrue(Long usuarioId);

    List<UsuarioRol> findByRolIdAndActivoTrue(Long rolId);
}
