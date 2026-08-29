package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {
    List<ProductoDTO> listar();
    ProductoDTO buscarPorId(Long id);
    ProductoDTO crear(ProductoDTO productoDTO);
    ProductoDTO actualizar(Long id, ProductoDTO productoDTO);
    void eliminar(Long id);
}
