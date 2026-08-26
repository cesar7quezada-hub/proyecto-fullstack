package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.RolDTO;
import cl.cesarquezada.proyecto.entity.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {

    public RolDTO toDTO(Rol rol) {
        if (rol == null) return null;
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setCodigo(rol.getCodigo());
        dto.setNombre(rol.getNombre());
        dto.setDescripcion(rol.getDescripcion());
        dto.setActivo(rol.getActivo());
        dto.setFechaCreacion(rol.getFechaCreacion());
        dto.setFechaModificacion(rol.getFechaModificacion());
        return dto;
    }

    public Rol toEntity(RolDTO dto) {
        if (dto == null) return null;
        Rol rol = new Rol();
        rol.setId(dto.getId());
        rol.setCodigo(dto.getCodigo());
        rol.setNombre(dto.getNombre());
        rol.setDescripcion(dto.getDescripcion());
        rol.setActivo(dto.getActivo());
        rol.setFechaCreacion(dto.getFechaCreacion());
        rol.setFechaModificacion(dto.getFechaModificacion());
        return rol;
    }
}
