package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.RolPermiso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RolPermisoRepository extends JpaRepository<RolPermiso, Long> {

    List<RolPermiso> findByActivoTrue();

    List<RolPermiso> findByRolIdAndActivoTrue(Long rolId);

    List<RolPermiso> findByPermisoIdAndActivoTrue(Long permisoId);
}
