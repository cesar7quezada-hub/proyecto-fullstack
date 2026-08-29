package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.SolicitudDetalleDTO;
import cl.cesarquezada.proyecto.entity.Producto;
import cl.cesarquezada.proyecto.entity.Solicitud;
import cl.cesarquezada.proyecto.entity.SolicitudDetalle;
import cl.cesarquezada.proyecto.exception.ProductoNoEncontradoException;
import cl.cesarquezada.proyecto.exception.SolicitudDetalleNoEncontradoException;
import cl.cesarquezada.proyecto.exception.SolicitudNoEncontradaException;
import cl.cesarquezada.proyecto.mapper.SolicitudDetalleMapper;
import cl.cesarquezada.proyecto.repository.ProductoRepository;
import cl.cesarquezada.proyecto.repository.SolicitudDetalleRepository;
import cl.cesarquezada.proyecto.repository.SolicitudRepository;
import cl.cesarquezada.proyecto.service.SolicitudDetalleService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SolicitudDetalleServiceImpl implements SolicitudDetalleService {

    private final SolicitudDetalleRepository solicitudDetalleRepository;
    private final SolicitudRepository solicitudRepository;
    private final ProductoRepository productoRepository;
    private final SolicitudDetalleMapper solicitudDetalleMapper;

    public SolicitudDetalleServiceImpl(SolicitudDetalleRepository solicitudDetalleRepository,
                                        SolicitudRepository solicitudRepository,
                                        ProductoRepository productoRepository,
                                        SolicitudDetalleMapper solicitudDetalleMapper) {
        this.solicitudDetalleRepository = solicitudDetalleRepository;
        this.solicitudRepository = solicitudRepository;
        this.productoRepository = productoRepository;
        this.solicitudDetalleMapper = solicitudDetalleMapper;
    }

    @Override
    public List<SolicitudDetalleDTO> listar() {
        return solicitudDetalleRepository.findAll().stream()
                .map(solicitudDetalleMapper::toDTO)
                .toList();
    }

    @Override
    public SolicitudDetalleDTO buscarPorId(Long id) {
        SolicitudDetalle solicitudDetalle = solicitudDetalleRepository.findById(id)
                .orElseThrow(() -> new SolicitudDetalleNoEncontradoException(id));
        return solicitudDetalleMapper.toDTO(solicitudDetalle);
    }

    @Override
    public SolicitudDetalleDTO crear(SolicitudDetalleDTO solicitudDetalleDTO) {
        Solicitud solicitud = solicitudRepository.findById(solicitudDetalleDTO.getSolicitudId())
                .orElseThrow(() -> new SolicitudNoEncontradaException(solicitudDetalleDTO.getSolicitudId()));
        Producto producto = productoRepository.findById(solicitudDetalleDTO.getProductoId())
                .orElseThrow(() -> new ProductoNoEncontradoException(solicitudDetalleDTO.getProductoId()));

        SolicitudDetalle solicitudDetalle = solicitudDetalleMapper.toEntity(solicitudDetalleDTO);
        solicitudDetalle.setId(null);
        solicitudDetalle.setSolicitud(solicitud);
        solicitudDetalle.setProducto(producto);
        solicitudDetalle.setFechaCreacion(LocalDateTime.now());
        solicitudDetalle.setFechaModificacion(LocalDateTime.now());

        return solicitudDetalleMapper.toDTO(solicitudDetalleRepository.save(solicitudDetalle));
    }

    @Override
    public SolicitudDetalleDTO actualizar(Long id, SolicitudDetalleDTO solicitudDetalleDTO) {
        SolicitudDetalle solicitudDetalleExistente = solicitudDetalleRepository.findById(id)
                .orElseThrow(() -> new SolicitudDetalleNoEncontradoException(id));

        Solicitud solicitud = solicitudRepository.findById(solicitudDetalleDTO.getSolicitudId())
                .orElseThrow(() -> new SolicitudNoEncontradaException(solicitudDetalleDTO.getSolicitudId()));
        Producto producto = productoRepository.findById(solicitudDetalleDTO.getProductoId())
                .orElseThrow(() -> new ProductoNoEncontradoException(solicitudDetalleDTO.getProductoId()));

        solicitudDetalleExistente.setSolicitud(solicitud);
        solicitudDetalleExistente.setProducto(producto);
        solicitudDetalleExistente.setDescripcion(solicitudDetalleDTO.getDescripcion());
        solicitudDetalleExistente.setCantidad(solicitudDetalleDTO.getCantidad());
        solicitudDetalleExistente.setPrecioUnitario(solicitudDetalleDTO.getPrecioUnitario());
        solicitudDetalleExistente.setSubtotal(solicitudDetalleDTO.getSubtotal());
        solicitudDetalleExistente.setDescuento(solicitudDetalleDTO.getDescuento());
        solicitudDetalleExistente.setTotal(solicitudDetalleDTO.getTotal());
        solicitudDetalleExistente.setFechaModificacion(LocalDateTime.now());

        return solicitudDetalleMapper.toDTO(solicitudDetalleRepository.save(solicitudDetalleExistente));
    }

    @Override
    public void eliminar(Long id) {
        if (!solicitudDetalleRepository.existsById(id)) {
            throw new SolicitudDetalleNoEncontradoException(id);
        }
        solicitudDetalleRepository.deleteById(id);
    }
}
