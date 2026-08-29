package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.SolicitudDetalleDTO;
import cl.cesarquezada.proyecto.entity.Producto;
import cl.cesarquezada.proyecto.entity.Solicitud;
import cl.cesarquezada.proyecto.entity.SolicitudDetalle;
import org.springframework.stereotype.Component;

@Component
public class SolicitudDetalleMapper {

    public SolicitudDetalleDTO toDTO(SolicitudDetalle solicitudDetalle) {
        if (solicitudDetalle == null) return null;
        SolicitudDetalleDTO dto = new SolicitudDetalleDTO();
        dto.setId(solicitudDetalle.getId());
        dto.setSolicitudId(solicitudDetalle.getSolicitud() != null ? solicitudDetalle.getSolicitud().getId() : null);
        dto.setProductoId(solicitudDetalle.getProducto() != null ? solicitudDetalle.getProducto().getId() : null);
        dto.setProductoNombre(solicitudDetalle.getProducto() != null ? solicitudDetalle.getProducto().getNombre() : null);
        dto.setDescripcion(solicitudDetalle.getDescripcion());
        dto.setCantidad(solicitudDetalle.getCantidad());
        dto.setPrecioUnitario(solicitudDetalle.getPrecioUnitario());
        dto.setSubtotal(solicitudDetalle.getSubtotal());
        dto.setDescuento(solicitudDetalle.getDescuento());
        dto.setTotal(solicitudDetalle.getTotal());
        dto.setFechaCreacion(solicitudDetalle.getFechaCreacion());
        dto.setFechaModificacion(solicitudDetalle.getFechaModificacion());
        return dto;
    }

    public SolicitudDetalle toEntity(SolicitudDetalleDTO dto) {
        if (dto == null) return null;
        SolicitudDetalle solicitudDetalle = new SolicitudDetalle();
        solicitudDetalle.setId(dto.getId());
        if (dto.getSolicitudId() != null) {
            Solicitud solicitud = new Solicitud();
            solicitud.setId(dto.getSolicitudId());
            solicitudDetalle.setSolicitud(solicitud);
        }
        if (dto.getProductoId() != null) {
            Producto producto = new Producto();
            producto.setId(dto.getProductoId());
            solicitudDetalle.setProducto(producto);
        }
        solicitudDetalle.setDescripcion(dto.getDescripcion());
        solicitudDetalle.setCantidad(dto.getCantidad());
        solicitudDetalle.setPrecioUnitario(dto.getPrecioUnitario());
        solicitudDetalle.setSubtotal(dto.getSubtotal());
        solicitudDetalle.setDescuento(dto.getDescuento());
        solicitudDetalle.setTotal(dto.getTotal());
        solicitudDetalle.setFechaCreacion(dto.getFechaCreacion());
        solicitudDetalle.setFechaModificacion(dto.getFechaModificacion());
        return solicitudDetalle;
    }
}
