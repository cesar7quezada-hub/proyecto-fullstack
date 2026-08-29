package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.ParametroSistemaDTO;
import java.util.List;

public interface ParametroSistemaService {
    List<ParametroSistemaDTO> listar();
    ParametroSistemaDTO buscarPorId(Long id);
    ParametroSistemaDTO crear(ParametroSistemaDTO parametroSistemaDTO);
    ParametroSistemaDTO actualizar(Long id, ParametroSistemaDTO parametroSistemaDTO);
    void eliminar(Long id);
}
