package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.ArchivoAdjuntoDTO;
import cl.cesarquezada.proyecto.entity.ArchivoAdjunto;
import cl.cesarquezada.proyecto.entity.Solicitud;
import org.springframework.stereotype.Component;

@Component
public class ArchivoAdjuntoMapper {

    public ArchivoAdjuntoDTO toDTO(ArchivoAdjunto archivoAdjunto) {
        if (archivoAdjunto == null) return null;
        ArchivoAdjuntoDTO dto = new ArchivoAdjuntoDTO();
        dto.setId(archivoAdjunto.getId());
        dto.setSolicitudId(archivoAdjunto.getSolicitud() != null ? archivoAdjunto.getSolicitud().getId() : null);
        dto.setSolicitudNumero(archivoAdjunto.getSolicitud() != null ? archivoAdjunto.getSolicitud().getNumeroSolicitud() : null);
        dto.setNombreArchivo(archivoAdjunto.getNombreArchivo());
        dto.setNombreStorage(archivoAdjunto.getNombreStorage());
        dto.setExtension(archivoAdjunto.getExtension());
        dto.setContentType(archivoAdjunto.getContentType());
        dto.setTamanoBytes(archivoAdjunto.getTamanoBytes());
        dto.setRuta(archivoAdjunto.getRuta());
        dto.setHashArchivo(archivoAdjunto.getHashArchivo());
        dto.setEstado(archivoAdjunto.getEstado());
        dto.setFechaCreacion(archivoAdjunto.getFechaCreacion());
        dto.setFechaModificacion(archivoAdjunto.getFechaModificacion());
        return dto;
    }

    public ArchivoAdjunto toEntity(ArchivoAdjuntoDTO dto) {
        if (dto == null) return null;
        ArchivoAdjunto archivoAdjunto = new ArchivoAdjunto();
        archivoAdjunto.setId(dto.getId());
        if (dto.getSolicitudId() != null) {
            Solicitud solicitud = new Solicitud();
            solicitud.setId(dto.getSolicitudId());
            archivoAdjunto.setSolicitud(solicitud);
        }
        archivoAdjunto.setNombreArchivo(dto.getNombreArchivo());
        archivoAdjunto.setNombreStorage(dto.getNombreStorage());
        archivoAdjunto.setExtension(dto.getExtension());
        archivoAdjunto.setContentType(dto.getContentType());
        archivoAdjunto.setTamanoBytes(dto.getTamanoBytes());
        archivoAdjunto.setRuta(dto.getRuta());
        archivoAdjunto.setHashArchivo(dto.getHashArchivo());
        archivoAdjunto.setEstado(dto.getEstado());
        archivoAdjunto.setFechaCreacion(dto.getFechaCreacion());
        archivoAdjunto.setFechaModificacion(dto.getFechaModificacion());
        return archivoAdjunto;
    }
}
