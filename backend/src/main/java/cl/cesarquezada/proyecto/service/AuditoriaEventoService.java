package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.AuditoriaEventoDTO;
import java.util.List;

public interface AuditoriaEventoService {
    List<AuditoriaEventoDTO> listar();
    AuditoriaEventoDTO buscarPorId(Long id);
    AuditoriaEventoDTO crear(AuditoriaEventoDTO auditoriaEventoDTO);
}
