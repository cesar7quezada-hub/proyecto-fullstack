package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.CategoriaProductoDTO;
import java.util.List;

public interface CategoriaProductoService {
    List<CategoriaProductoDTO> listar();
    CategoriaProductoDTO buscarPorId(Long id);
    CategoriaProductoDTO crear(CategoriaProductoDTO categoriaProductoDTO);
    CategoriaProductoDTO actualizar(Long id, CategoriaProductoDTO categoriaProductoDTO);
    void eliminar(Long id);
}
