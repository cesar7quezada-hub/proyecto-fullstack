package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.RolDTO;
import java.util.List;

public interface RolService {
    List<RolDTO> listar();
    RolDTO buscarPorId(Long id);
    RolDTO crear(RolDTO rolDTO);
    RolDTO actualizar(Long id, RolDTO rolDTO);
    void eliminar(Long id);
}
