package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.ProductoDTO;
import cl.cesarquezada.proyecto.entity.CategoriaProducto;
import cl.cesarquezada.proyecto.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoDTO toDTO(Producto producto) {
        if (producto == null) return null;
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setCategoriaProductoId(producto.getCategoriaProducto() != null ? producto.getCategoriaProducto().getId() : null);
        dto.setCategoriaProductoNombre(producto.getCategoriaProducto() != null ? producto.getCategoriaProducto().getNombre() : null);
        dto.setCodigo(producto.getCodigo());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setMoneda(producto.getMoneda());
        dto.setStock(producto.getStock());
        dto.setEstado(producto.getEstado());
        dto.setFechaCreacion(producto.getFechaCreacion());
        dto.setFechaModificacion(producto.getFechaModificacion());
        return dto;
    }

    public Producto toEntity(ProductoDTO dto) {
        if (dto == null) return null;
        Producto producto = new Producto();
        producto.setId(dto.getId());
        if (dto.getCategoriaProductoId() != null) {
            CategoriaProducto categoriaProducto = new CategoriaProducto();
            categoriaProducto.setId(dto.getCategoriaProductoId());
            producto.setCategoriaProducto(categoriaProducto);
        }
        producto.setCodigo(dto.getCodigo());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setMoneda(dto.getMoneda());
        producto.setStock(dto.getStock());
        producto.setEstado(dto.getEstado());
        producto.setFechaCreacion(dto.getFechaCreacion());
        producto.setFechaModificacion(dto.getFechaModificacion());
        return producto;
    }
}
