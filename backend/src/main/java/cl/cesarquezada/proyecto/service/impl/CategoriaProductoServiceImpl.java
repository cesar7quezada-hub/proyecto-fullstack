package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.CategoriaProductoDTO;
import cl.cesarquezada.proyecto.entity.CategoriaProducto;
import cl.cesarquezada.proyecto.exception.CategoriaProductoNoEncontradaException;
import cl.cesarquezada.proyecto.mapper.CategoriaProductoMapper;
import cl.cesarquezada.proyecto.repository.CategoriaProductoRepository;
import cl.cesarquezada.proyecto.service.CategoriaProductoService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    private final CategoriaProductoRepository categoriaProductoRepository;
    private final CategoriaProductoMapper categoriaProductoMapper;

    public CategoriaProductoServiceImpl(CategoriaProductoRepository categoriaProductoRepository,
                                         CategoriaProductoMapper categoriaProductoMapper) {
        this.categoriaProductoRepository = categoriaProductoRepository;
        this.categoriaProductoMapper = categoriaProductoMapper;
    }

    @Override
    public List<CategoriaProductoDTO> listar() {
        return categoriaProductoRepository.findByActivoTrue().stream()
                .map(categoriaProductoMapper::toDTO)
                .toList();
    }

    @Override
    public CategoriaProductoDTO buscarPorId(Long id) {
        CategoriaProducto categoriaProducto = categoriaProductoRepository.findById(id)
                .orElseThrow(() -> new CategoriaProductoNoEncontradaException(id));
        return categoriaProductoMapper.toDTO(categoriaProducto);
    }

    @Override
    public CategoriaProductoDTO crear(CategoriaProductoDTO categoriaProductoDTO) {
        CategoriaProducto categoriaProducto = categoriaProductoMapper.toEntity(categoriaProductoDTO);
        categoriaProducto.setId(null);
        categoriaProducto.setFechaCreacion(LocalDateTime.now());
        categoriaProducto.setFechaModificacion(LocalDateTime.now());
        return categoriaProductoMapper.toDTO(categoriaProductoRepository.save(categoriaProducto));
    }

    @Override
    public CategoriaProductoDTO actualizar(Long id, CategoriaProductoDTO categoriaProductoDTO) {
        CategoriaProducto categoriaProductoExistente = categoriaProductoRepository.findById(id)
                .orElseThrow(() -> new CategoriaProductoNoEncontradaException(id));

        categoriaProductoExistente.setCodigo(categoriaProductoDTO.getCodigo());
        categoriaProductoExistente.setNombre(categoriaProductoDTO.getNombre());
        categoriaProductoExistente.setDescripcion(categoriaProductoDTO.getDescripcion());
        categoriaProductoExistente.setActivo(categoriaProductoDTO.getActivo());
        categoriaProductoExistente.setFechaModificacion(LocalDateTime.now());

        return categoriaProductoMapper.toDTO(categoriaProductoRepository.save(categoriaProductoExistente));
    }

    @Override
    public void eliminar(Long id) {
        CategoriaProducto categoriaProducto = categoriaProductoRepository.findById(id)
                .orElseThrow(() -> new CategoriaProductoNoEncontradaException(id));
        categoriaProducto.setActivo(false);
        categoriaProducto.setFechaModificacion(LocalDateTime.now());
        categoriaProductoRepository.save(categoriaProducto);
    }
}
