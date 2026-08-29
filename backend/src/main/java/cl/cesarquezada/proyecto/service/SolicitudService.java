package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.SolicitudDTO;
import java.util.List;

public interface SolicitudService {
    List<SolicitudDTO> listar();
    SolicitudDTO buscarPorId(Long id);
    SolicitudDTO crear(SolicitudDTO solicitudDTO);
    SolicitudDTO actualizar(Long id, SolicitudDTO solicitudDTO);
    void eliminar(Long id);
}
