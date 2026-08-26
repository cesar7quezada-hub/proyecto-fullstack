package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.PermisoDTO;
import cl.cesarquezada.proyecto.entity.Permiso;
import org.springframework.stereotype.Component;

@Component
public class PermisoMapper {

    public PermisoDTO toDTO(Permiso permiso) {
        if (permiso == null) return null;
        PermisoDTO dto = new PermisoDTO();
        dto.setId(permiso.getId());
        dto.setCodigo(permiso.getCodigo());
        dto.setNombre(permiso.getNombre());
        dto.setModulo(permiso.getModulo());
        dto.setDescripcion(permiso.getDescripcion());
        dto.setActivo(permiso.getActivo());
        dto.setFechaCreacion(permiso.getFechaCreacion());
        dto.setFechaModificacion(permiso.getFechaModificacion());
        return dto;
    }

    public Permiso toEntity(PermisoDTO dto) {
        if (dto == null) return null;
        Permiso permiso = new Permiso();
        permiso.setId(dto.getId());
        permiso.setCodigo(dto.getCodigo());
        permiso.setNombre(dto.getNombre());
        permiso.setModulo(dto.getModulo());
        permiso.setDescripcion(dto.getDescripcion());
        permiso.setActivo(dto.getActivo());
        permiso.setFechaCreacion(dto.getFechaCreacion());
        permiso.setFechaModificacion(dto.getFechaModificacion());
        return permiso;
    }
}
