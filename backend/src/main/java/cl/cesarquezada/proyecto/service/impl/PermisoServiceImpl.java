package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.PermisoDTO;
import cl.cesarquezada.proyecto.entity.Permiso;
import cl.cesarquezada.proyecto.exception.PermisoNoEncontradoException;
import cl.cesarquezada.proyecto.mapper.PermisoMapper;
import cl.cesarquezada.proyecto.repository.PermisoRepository;
import cl.cesarquezada.proyecto.service.PermisoService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PermisoServiceImpl implements PermisoService {

    private final PermisoRepository permisoRepository;
    private final PermisoMapper permisoMapper;

    public PermisoServiceImpl(PermisoRepository permisoRepository, PermisoMapper permisoMapper) {
        this.permisoRepository = permisoRepository;
        this.permisoMapper = permisoMapper;
    }

    @Override
    public List<PermisoDTO> listar() {
        return permisoRepository.findByActivoTrue().stream()
                .map(permisoMapper::toDTO)
                .toList();
    }

    @Override
    public PermisoDTO buscarPorId(Long id) {
        Permiso permiso = permisoRepository.findById(id)
                .orElseThrow(() -> new PermisoNoEncontradoException(id));
        return permisoMapper.toDTO(permiso);
    }

    @Override
    public PermisoDTO crear(PermisoDTO permisoDTO) {
        Permiso permiso = permisoMapper.toEntity(permisoDTO);
        permiso.setId(null);
        permiso.setFechaCreacion(LocalDateTime.now());
        permiso.setFechaModificacion(LocalDateTime.now());
        return permisoMapper.toDTO(permisoRepository.save(permiso));
    }

    @Override
    public PermisoDTO actualizar(Long id, PermisoDTO permisoDTO) {
        Permiso permisoExistente = permisoRepository.findById(id)
                .orElseThrow(() -> new PermisoNoEncontradoException(id));

        permisoExistente.setCodigo(permisoDTO.getCodigo());
        permisoExistente.setNombre(permisoDTO.getNombre());
        permisoExistente.setModulo(permisoDTO.getModulo());
        permisoExistente.setDescripcion(permisoDTO.getDescripcion());
        permisoExistente.setActivo(permisoDTO.getActivo());
        permisoExistente.setFechaModificacion(LocalDateTime.now());

        return permisoMapper.toDTO(permisoRepository.save(permisoExistente));
    }

    @Override
    public void eliminar(Long id) {
        Permiso permiso = permisoRepository.findById(id)
                .orElseThrow(() -> new PermisoNoEncontradoException(id));
        permiso.setActivo(false);
        permiso.setFechaModificacion(LocalDateTime.now());
        permisoRepository.save(permiso);
    }
}
