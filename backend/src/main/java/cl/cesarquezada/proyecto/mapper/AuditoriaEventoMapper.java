package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.AuditoriaEventoDTO;
import cl.cesarquezada.proyecto.entity.AuditoriaEvento;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaEventoMapper {

    public AuditoriaEventoDTO toDTO(AuditoriaEvento auditoriaEvento) {
        if (auditoriaEvento == null) return null;
        AuditoriaEventoDTO dto = new AuditoriaEventoDTO();
        dto.setId(auditoriaEvento.getId());
        dto.setUsuario(auditoriaEvento.getUsuario());
        dto.setAccion(auditoriaEvento.getAccion());
        dto.setModulo(auditoriaEvento.getModulo());
        dto.setEntidad(auditoriaEvento.getEntidad());
        dto.setEntidadId(auditoriaEvento.getEntidadId());
        dto.setValorAnterior(auditoriaEvento.getValorAnterior());
        dto.setValorNuevo(auditoriaEvento.getValorNuevo());
        dto.setIpOrigen(auditoriaEvento.getIpOrigen());
        dto.setUserAgent(auditoriaEvento.getUserAgent());
        dto.setFechaEvento(auditoriaEvento.getFechaEvento());
        dto.setResultado(auditoriaEvento.getResultado());
        dto.setMensaje(auditoriaEvento.getMensaje());
        return dto;
    }

    public AuditoriaEvento toEntity(AuditoriaEventoDTO dto) {
        if (dto == null) return null;
        AuditoriaEvento auditoriaEvento = new AuditoriaEvento();
        auditoriaEvento.setId(dto.getId());
        auditoriaEvento.setUsuario(dto.getUsuario());
        auditoriaEvento.setAccion(dto.getAccion());
        auditoriaEvento.setModulo(dto.getModulo());
        auditoriaEvento.setEntidad(dto.getEntidad());
        auditoriaEvento.setEntidadId(dto.getEntidadId());
        auditoriaEvento.setValorAnterior(dto.getValorAnterior());
        auditoriaEvento.setValorNuevo(dto.getValorNuevo());
        auditoriaEvento.setIpOrigen(dto.getIpOrigen());
        auditoriaEvento.setUserAgent(dto.getUserAgent());
        auditoriaEvento.setFechaEvento(dto.getFechaEvento());
        auditoriaEvento.setResultado(dto.getResultado());
        auditoriaEvento.setMensaje(dto.getMensaje());
        return auditoriaEvento;
    }
}
