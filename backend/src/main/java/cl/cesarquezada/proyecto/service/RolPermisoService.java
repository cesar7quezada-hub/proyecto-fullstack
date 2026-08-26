package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.RolPermisoDTO;
import java.util.List;

public interface RolPermisoService {
    List<RolPermisoDTO> listar();
    RolPermisoDTO buscarPorId(Long id);
    RolPermisoDTO crear(RolPermisoDTO rolPermisoDTO);
    RolPermisoDTO actualizar(Long id, RolPermisoDTO rolPermisoDTO);
    void eliminar(Long id);
}
