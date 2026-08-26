package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.RolPermisoDTO;
import cl.cesarquezada.proyecto.entity.Permiso;
import cl.cesarquezada.proyecto.entity.Rol;
import cl.cesarquezada.proyecto.entity.RolPermiso;
import org.springframework.stereotype.Component;

@Component
public class RolPermisoMapper {

    public RolPermisoDTO toDTO(RolPermiso rolPermiso) {
        if (rolPermiso == null) return null;
        RolPermisoDTO dto = new RolPermisoDTO();
        dto.setId(rolPermiso.getId());
        dto.setRolId(rolPermiso.getRol() != null ? rolPermiso.getRol().getId() : null);
        dto.setPermisoId(rolPermiso.getPermiso() != null ? rolPermiso.getPermiso().getId() : null);
        dto.setRolNombre(rolPermiso.getRol() != null ? rolPermiso.getRol().getNombre() : null);
        dto.setPermisoNombre(rolPermiso.getPermiso() != null ? rolPermiso.getPermiso().getNombre() : null);
        dto.setActivo(rolPermiso.getActivo());
        dto.setFechaCreacion(rolPermiso.getFechaCreacion());
        dto.setFechaModificacion(rolPermiso.getFechaModificacion());
        return dto;
    }

    public RolPermiso toEntity(RolPermisoDTO dto) {
        if (dto == null) return null;
        RolPermiso rolPermiso = new RolPermiso();
        rolPermiso.setId(dto.getId());
        if (dto.getRolId() != null) {
            Rol rol = new Rol();
            rol.setId(dto.getRolId());
            rolPermiso.setRol(rol);
        }
        if (dto.getPermisoId() != null) {
            Permiso permiso = new Permiso();
            permiso.setId(dto.getPermisoId());
            rolPermiso.setPermiso(permiso);
        }
        rolPermiso.setActivo(dto.getActivo());
        rolPermiso.setFechaCreacion(dto.getFechaCreacion());
        rolPermiso.setFechaModificacion(dto.getFechaModificacion());
        return rolPermiso;
    }
}
