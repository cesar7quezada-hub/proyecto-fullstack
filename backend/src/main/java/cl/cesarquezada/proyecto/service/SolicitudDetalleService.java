package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.SolicitudDetalleDTO;
import java.util.List;

public interface SolicitudDetalleService {
    List<SolicitudDetalleDTO> listar();
    SolicitudDetalleDTO buscarPorId(Long id);
    SolicitudDetalleDTO crear(SolicitudDetalleDTO solicitudDetalleDTO);
    SolicitudDetalleDTO actualizar(Long id, SolicitudDetalleDTO solicitudDetalleDTO);
    void eliminar(Long id);
}
