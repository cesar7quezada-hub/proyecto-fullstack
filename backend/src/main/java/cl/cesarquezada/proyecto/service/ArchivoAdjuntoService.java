package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.ArchivoAdjuntoDTO;
import java.util.List;

public interface ArchivoAdjuntoService {
    List<ArchivoAdjuntoDTO> listar();
    ArchivoAdjuntoDTO buscarPorId(Long id);
    ArchivoAdjuntoDTO crear(ArchivoAdjuntoDTO archivoAdjuntoDTO);
    ArchivoAdjuntoDTO actualizar(Long id, ArchivoAdjuntoDTO archivoAdjuntoDTO);
    void eliminar(Long id);
}
