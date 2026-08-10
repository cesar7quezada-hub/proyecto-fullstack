package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.PolizaDTO;
import java.util.List;

public interface PolizaService {

    List<PolizaDTO> listar();

    PolizaDTO buscarPorId(Long id);

    PolizaDTO crear(PolizaDTO polizaDTO);

    PolizaDTO actualizar(Long id, PolizaDTO polizaDTO);

    void eliminar(Long id);
}
