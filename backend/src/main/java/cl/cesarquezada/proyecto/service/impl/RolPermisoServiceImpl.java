package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.RolPermisoDTO;
import cl.cesarquezada.proyecto.entity.Permiso;
import cl.cesarquezada.proyecto.entity.Rol;
import cl.cesarquezada.proyecto.entity.RolPermiso;
import cl.cesarquezada.proyecto.exception.PermisoNoEncontradoException;
import cl.cesarquezada.proyecto.exception.RolNoEncontradoException;
import cl.cesarquezada.proyecto.exception.RolPermisoNoEncontradoException;
import cl.cesarquezada.proyecto.mapper.RolPermisoMapper;
import cl.cesarquezada.proyecto.repository.PermisoRepository;
import cl.cesarquezada.proyecto.repository.RolPermisoRepository;
import cl.cesarquezada.proyecto.repository.RolRepository;
import cl.cesarquezada.proyecto.service.RolPermisoService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RolPermisoServiceImpl implements RolPermisoService {

    private final RolPermisoRepository rolPermisoRepository;
    private final RolRepository rolRepository;
    private final PermisoRepository permisoRepository;
    private final RolPermisoMapper rolPermisoMapper;

    public RolPermisoServiceImpl(RolPermisoRepository rolPermisoRepository,
                                  RolRepository rolRepository,
                                  PermisoRepository permisoRepository,
                                  RolPermisoMapper rolPermisoMapper) {
        this.rolPermisoRepository = rolPermisoRepository;
        this.rolRepository = rolRepository;
        this.permisoRepository = permisoRepository;
        this.rolPermisoMapper = rolPermisoMapper;
    }

    @Override
    public List<RolPermisoDTO> listar() {
        return rolPermisoRepository.findByActivoTrue().stream()
                .map(rolPermisoMapper::toDTO)
                .toList();
    }

    @Override
    public RolPermisoDTO buscarPorId(Long id) {
        RolPermiso rolPermiso = rolPermisoRepository.findById(id)
                .orElseThrow(() -> new RolPermisoNoEncontradoException(id));
        return rolPermisoMapper.toDTO(rolPermiso);
    }

    @Override
    public RolPermisoDTO crear(RolPermisoDTO rolPermisoDTO) {
        Rol rol = rolRepository.findById(rolPermisoDTO.getRolId())
                .orElseThrow(() -> new RolNoEncontradoException(rolPermisoDTO.getRolId()));
        Permiso permiso = permisoRepository.findById(rolPermisoDTO.getPermisoId())
                .orElseThrow(() -> new PermisoNoEncontradoException(rolPermisoDTO.getPermisoId()));

        RolPermiso rolPermiso = rolPermisoMapper.toEntity(rolPermisoDTO);
        rolPermiso.setId(null);
        rolPermiso.setRol(rol);
        rolPermiso.setPermiso(permiso);
        rolPermiso.setFechaCreacion(LocalDateTime.now());
        rolPermiso.setFechaModificacion(LocalDateTime.now());
        if (rolPermiso.getActivo() == null) {
            rolPermiso.setActivo(true);
        }
        return rolPermisoMapper.toDTO(rolPermisoRepository.save(rolPermiso));
    }

    @Override
    public RolPermisoDTO actualizar(Long id, RolPermisoDTO rolPermisoDTO) {
        RolPermiso rolPermisoExistente = rolPermisoRepository.findById(id)
                .orElseThrow(() -> new RolPermisoNoEncontradoException(id));

        Rol rol = rolRepository.findById(rolPermisoDTO.getRolId())
                .orElseThrow(() -> new RolNoEncontradoException(rolPermisoDTO.getRolId()));
        Permiso permiso = permisoRepository.findById(rolPermisoDTO.getPermisoId())
                .orElseThrow(() -> new PermisoNoEncontradoException(rolPermisoDTO.getPermisoId()));

        rolPermisoExistente.setRol(rol);
        rolPermisoExistente.setPermiso(permiso);
        rolPermisoExistente.setActivo(rolPermisoDTO.getActivo());
        rolPermisoExistente.setFechaModificacion(LocalDateTime.now());

        return rolPermisoMapper.toDTO(rolPermisoRepository.save(rolPermisoExistente));
    }

    @Override
    public void eliminar(Long id) {
        RolPermiso rolPermiso = rolPermisoRepository.findById(id)
                .orElseThrow(() -> new RolPermisoNoEncontradoException(id));
        rolPermiso.setActivo(false);
        rolPermiso.setFechaModificacion(LocalDateTime.now());
        rolPermisoRepository.save(rolPermiso);
    }
}
