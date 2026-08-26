package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.UsuarioRolDTO;
import java.util.List;

public interface UsuarioRolService {
    List<UsuarioRolDTO> listar();
    UsuarioRolDTO buscarPorId(Long id);
    UsuarioRolDTO crear(UsuarioRolDTO usuarioRolDTO);
    UsuarioRolDTO actualizar(Long id, UsuarioRolDTO usuarioRolDTO);
    void eliminar(Long id);
}
