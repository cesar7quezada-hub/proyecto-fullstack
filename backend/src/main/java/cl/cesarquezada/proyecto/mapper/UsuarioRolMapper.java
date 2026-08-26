package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.UsuarioRolDTO;
import cl.cesarquezada.proyecto.entity.Rol;
import cl.cesarquezada.proyecto.entity.Usuario;
import cl.cesarquezada.proyecto.entity.UsuarioRol;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRolMapper {

    public UsuarioRolDTO toDTO(UsuarioRol usuarioRol) {
        if (usuarioRol == null) return null;
        UsuarioRolDTO dto = new UsuarioRolDTO();
        dto.setId(usuarioRol.getId());
        dto.setUsuarioId(usuarioRol.getUsuario() != null ? usuarioRol.getUsuario().getId() : null);
        dto.setRolId(usuarioRol.getRol() != null ? usuarioRol.getRol().getId() : null);
        dto.setUsuarioNombre(usuarioRol.getUsuario() != null ? usuarioRol.getUsuario().getUsername() : null);
        dto.setRolNombre(usuarioRol.getRol() != null ? usuarioRol.getRol().getNombre() : null);
        dto.setFechaAsignacion(usuarioRol.getFechaAsignacion());
        dto.setUsuarioAsignacion(usuarioRol.getUsuarioAsignacion());
        dto.setActivo(usuarioRol.getActivo());
        return dto;
    }

    public UsuarioRol toEntity(UsuarioRolDTO dto) {
        if (dto == null) return null;
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setId(dto.getId());
        if (dto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            usuarioRol.setUsuario(usuario);
        }
        if (dto.getRolId() != null) {
            Rol rol = new Rol();
            rol.setId(dto.getRolId());
            usuarioRol.setRol(rol);
        }
        usuarioRol.setFechaAsignacion(dto.getFechaAsignacion());
        usuarioRol.setUsuarioAsignacion(dto.getUsuarioAsignacion());
        usuarioRol.setActivo(dto.getActivo());
        return usuarioRol;
    }
}
