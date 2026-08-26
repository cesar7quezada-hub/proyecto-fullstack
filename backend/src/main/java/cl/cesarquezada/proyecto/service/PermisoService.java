package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.PermisoDTO;
import java.util.List;

public interface PermisoService {
    List<PermisoDTO> listar();
    PermisoDTO buscarPorId(Long id);
    PermisoDTO crear(PermisoDTO permisoDTO);
    PermisoDTO actualizar(Long id, PermisoDTO permisoDTO);
    void eliminar(Long id);
}
