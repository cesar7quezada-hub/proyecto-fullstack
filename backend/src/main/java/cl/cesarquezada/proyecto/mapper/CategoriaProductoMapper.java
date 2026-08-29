package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.CategoriaProductoDTO;
import cl.cesarquezada.proyecto.entity.CategoriaProducto;
import org.springframework.stereotype.Component;

@Component
public class CategoriaProductoMapper {

    public CategoriaProductoDTO toDTO(CategoriaProducto categoriaProducto) {
        if (categoriaProducto == null) return null;
        CategoriaProductoDTO dto = new CategoriaProductoDTO();
        dto.setId(categoriaProducto.getId());
        dto.setCodigo(categoriaProducto.getCodigo());
        dto.setNombre(categoriaProducto.getNombre());
        dto.setDescripcion(categoriaProducto.getDescripcion());
        dto.setActivo(categoriaProducto.getActivo());
        dto.setFechaCreacion(categoriaProducto.getFechaCreacion());
        dto.setFechaModificacion(categoriaProducto.getFechaModificacion());
        return dto;
    }

    public CategoriaProducto toEntity(CategoriaProductoDTO dto) {
        if (dto == null) return null;
        CategoriaProducto categoriaProducto = new CategoriaProducto();
        categoriaProducto.setId(dto.getId());
        categoriaProducto.setCodigo(dto.getCodigo());
        categoriaProducto.setNombre(dto.getNombre());
        categoriaProducto.setDescripcion(dto.getDescripcion());
        categoriaProducto.setActivo(dto.getActivo());
        categoriaProducto.setFechaCreacion(dto.getFechaCreacion());
        categoriaProducto.setFechaModificacion(dto.getFechaModificacion());
        return categoriaProducto;
    }
}
