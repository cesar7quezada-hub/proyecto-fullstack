package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.SesionUsuarioDTO;
import cl.cesarquezada.proyecto.entity.SesionUsuario;
import cl.cesarquezada.proyecto.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class SesionUsuarioMapper {

    public SesionUsuarioDTO toDTO(SesionUsuario sesionUsuario) {
        if (sesionUsuario == null) return null;
        SesionUsuarioDTO dto = new SesionUsuarioDTO();
        dto.setId(sesionUsuario.getId());
        dto.setUsuarioId(sesionUsuario.getUsuario() != null ? sesionUsuario.getUsuario().getId() : null);
        dto.setUsuarioNombre(sesionUsuario.getUsuario() != null ? sesionUsuario.getUsuario().getUsername() : null);
        dto.setRefreshTokenHash(sesionUsuario.getRefreshTokenHash());
        dto.setFechaInicio(sesionUsuario.getFechaInicio());
        dto.setFechaExpiracion(sesionUsuario.getFechaExpiracion());
        dto.setIpOrigen(sesionUsuario.getIpOrigen());
        dto.setUserAgent(sesionUsuario.getUserAgent());
        dto.setEstado(sesionUsuario.getEstado());
        return dto;
    }

    public SesionUsuario toEntity(SesionUsuarioDTO dto) {
        if (dto == null) return null;
        SesionUsuario sesionUsuario = new SesionUsuario();
        sesionUsuario.setId(dto.getId());
        if (dto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            sesionUsuario.setUsuario(usuario);
        }
        sesionUsuario.setRefreshTokenHash(dto.getRefreshTokenHash());
        sesionUsuario.setFechaInicio(dto.getFechaInicio());
        sesionUsuario.setFechaExpiracion(dto.getFechaExpiracion());
        sesionUsuario.setIpOrigen(dto.getIpOrigen());
        sesionUsuario.setUserAgent(dto.getUserAgent());
        sesionUsuario.setEstado(dto.getEstado());
        return sesionUsuario;
    }
}
