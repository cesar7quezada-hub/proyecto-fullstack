package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.SolicitudDTO;
import cl.cesarquezada.proyecto.entity.Cliente;
import cl.cesarquezada.proyecto.entity.Poliza;
import cl.cesarquezada.proyecto.entity.Solicitud;
import org.springframework.stereotype.Component;

@Component
public class SolicitudMapper {

    public SolicitudDTO toDTO(Solicitud solicitud) {
        if (solicitud == null) return null;
        SolicitudDTO dto = new SolicitudDTO();
        dto.setId(solicitud.getId());
        dto.setClienteId(solicitud.getCliente() != null ? solicitud.getCliente().getId() : null);
        dto.setClienteNombre(solicitud.getCliente() != null ? solicitud.getCliente().getNombre() : null);
        dto.setPolizaId(solicitud.getPoliza() != null ? solicitud.getPoliza().getId() : null);
        dto.setPolizaNumero(solicitud.getPoliza() != null ? solicitud.getPoliza().getNumeroPoliza() : null);
        dto.setNumeroSolicitud(solicitud.getNumeroSolicitud());
        dto.setFechaSolicitud(solicitud.getFechaSolicitud());
        dto.setEstado(solicitud.getEstado());
        dto.setObservacion(solicitud.getObservacion());
        dto.setMontoTotal(solicitud.getMontoTotal());
        dto.setMoneda(solicitud.getMoneda());
        dto.setFechaCreacion(solicitud.getFechaCreacion());
        dto.setFechaModificacion(solicitud.getFechaModificacion());
        return dto;
    }

    public Solicitud toEntity(SolicitudDTO dto) {
        if (dto == null) return null;
        Solicitud solicitud = new Solicitud();
        solicitud.setId(dto.getId());
        if (dto.getClienteId() != null) {
            Cliente cliente = new Cliente();
            cliente.setId(dto.getClienteId());
            solicitud.setCliente(cliente);
        }
        if (dto.getPolizaId() != null) {
            Poliza poliza = new Poliza();
            poliza.setId(dto.getPolizaId());
            solicitud.setPoliza(poliza);
        }
        solicitud.setNumeroSolicitud(dto.getNumeroSolicitud());
        solicitud.setFechaSolicitud(dto.getFechaSolicitud());
        solicitud.setEstado(dto.getEstado());
        solicitud.setObservacion(dto.getObservacion());
        solicitud.setMontoTotal(dto.getMontoTotal());
        solicitud.setMoneda(dto.getMoneda());
        solicitud.setFechaCreacion(dto.getFechaCreacion());
        solicitud.setFechaModificacion(dto.getFechaModificacion());
        return solicitud;
    }
}
