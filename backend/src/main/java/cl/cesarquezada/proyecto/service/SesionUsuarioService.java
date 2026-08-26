package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.SesionUsuarioDTO;
import java.util.List;

public interface SesionUsuarioService {
    List<SesionUsuarioDTO> listar();
    SesionUsuarioDTO buscarPorId(Long id);
    SesionUsuarioDTO crear(SesionUsuarioDTO sesionUsuarioDTO);
    SesionUsuarioDTO actualizar(Long id, SesionUsuarioDTO sesionUsuarioDTO);
    void eliminar(Long id);
}
