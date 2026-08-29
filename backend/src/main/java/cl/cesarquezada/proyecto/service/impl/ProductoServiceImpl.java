package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.ProductoDTO;
import cl.cesarquezada.proyecto.entity.CategoriaProducto;
import cl.cesarquezada.proyecto.entity.EstadoProducto;
import cl.cesarquezada.proyecto.entity.Producto;
import cl.cesarquezada.proyecto.exception.CategoriaProductoNoEncontradaException;
import cl.cesarquezada.proyecto.exception.ProductoNoEncontradoException;
import cl.cesarquezada.proyecto.mapper.ProductoMapper;
import cl.cesarquezada.proyecto.repository.CategoriaProductoRepository;
import cl.cesarquezada.proyecto.repository.ProductoRepository;
import cl.cesarquezada.proyecto.service.ProductoService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaProductoRepository categoriaProductoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository,
                                CategoriaProductoRepository categoriaProductoRepository,
                                ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.categoriaProductoRepository = categoriaProductoRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public List<ProductoDTO> listar() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDTO)
                .toList();
    }

    @Override
    public ProductoDTO buscarPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        return productoMapper.toDTO(producto);
    }

    @Override
    public ProductoDTO crear(ProductoDTO productoDTO) {
        CategoriaProducto categoriaProducto = categoriaProductoRepository.findById(productoDTO.getCategoriaProductoId())
                .orElseThrow(() -> new CategoriaProductoNoEncontradaException(productoDTO.getCategoriaProductoId()));

        Producto producto = productoMapper.toEntity(productoDTO);
        producto.setId(null);
        producto.setCategoriaProducto(categoriaProducto);
        producto.setFechaCreacion(LocalDateTime.now());
        producto.setFechaModificacion(LocalDateTime.now());
        if (producto.getEstado() == null) {
            producto.setEstado(EstadoProducto.ACTIVO);
        }
        return productoMapper.toDTO(productoRepository.save(producto));
    }

    @Override
    public ProductoDTO actualizar(Long id, ProductoDTO productoDTO) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));

        CategoriaProducto categoriaProducto = categoriaProductoRepository.findById(productoDTO.getCategoriaProductoId())
                .orElseThrow(() -> new CategoriaProductoNoEncontradaException(productoDTO.getCategoriaProductoId()));

        productoExistente.setCategoriaProducto(categoriaProducto);
        productoExistente.setCodigo(productoDTO.getCodigo());
        productoExistente.setNombre(productoDTO.getNombre());
        productoExistente.setDescripcion(productoDTO.getDescripcion());
        productoExistente.setPrecio(productoDTO.getPrecio());
        productoExistente.setMoneda(productoDTO.getMoneda());
        productoExistente.setStock(productoDTO.getStock());
        productoExistente.setEstado(productoDTO.getEstado());
        productoExistente.setFechaModificacion(LocalDateTime.now());

        return productoMapper.toDTO(productoRepository.save(productoExistente));
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
        producto.setEstado(EstadoProducto.INACTIVO);
        producto.setFechaModificacion(LocalDateTime.now());
        productoRepository.save(producto);
    }
}
