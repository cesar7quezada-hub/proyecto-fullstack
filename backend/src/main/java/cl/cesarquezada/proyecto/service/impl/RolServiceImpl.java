package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.RolDTO;
import cl.cesarquezada.proyecto.entity.Rol;
import cl.cesarquezada.proyecto.exception.RolNoEncontradoException;
import cl.cesarquezada.proyecto.mapper.RolMapper;
import cl.cesarquezada.proyecto.repository.RolRepository;
import cl.cesarquezada.proyecto.service.RolService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolServiceImpl(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public List<RolDTO> listar() {
        return rolRepository.findByActivoTrue().stream()
                .map(rolMapper::toDTO)
                .toList();
    }

    @Override
    public RolDTO buscarPorId(Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RolNoEncontradoException(id));
        return rolMapper.toDTO(rol);
    }

    @Override
    public RolDTO crear(RolDTO rolDTO) {
        Rol rol = rolMapper.toEntity(rolDTO);
        rol.setId(null);
        rol.setFechaCreacion(LocalDateTime.now());
        rol.setFechaModificacion(LocalDateTime.now());
        return rolMapper.toDTO(rolRepository.save(rol));
    }

    @Override
    public RolDTO actualizar(Long id, RolDTO rolDTO) {
        Rol rolExistente = rolRepository.findById(id)
                .orElseThrow(() -> new RolNoEncontradoException(id));

        rolExistente.setCodigo(rolDTO.getCodigo());
        rolExistente.setNombre(rolDTO.getNombre());
        rolExistente.setDescripcion(rolDTO.getDescripcion());
        rolExistente.setActivo(rolDTO.getActivo());
        rolExistente.setFechaModificacion(LocalDateTime.now());

        return rolMapper.toDTO(rolRepository.save(rolExistente));
    }

    @Override
    public void eliminar(Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RolNoEncontradoException(id));
        rol.setActivo(false);
        rol.setFechaModificacion(LocalDateTime.now());
        rolRepository.save(rol);
    }
}
