package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.UsuarioRolDTO;
import cl.cesarquezada.proyecto.entity.Rol;
import cl.cesarquezada.proyecto.entity.Usuario;
import cl.cesarquezada.proyecto.entity.UsuarioRol;
import cl.cesarquezada.proyecto.exception.RolNoEncontradoException;
import cl.cesarquezada.proyecto.exception.UsuarioNoEncontradoException;
import cl.cesarquezada.proyecto.exception.UsuarioRolNoEncontradoException;
import cl.cesarquezada.proyecto.mapper.UsuarioRolMapper;
import cl.cesarquezada.proyecto.repository.RolRepository;
import cl.cesarquezada.proyecto.repository.UsuarioRepository;
import cl.cesarquezada.proyecto.repository.UsuarioRolRepository;
import cl.cesarquezada.proyecto.service.UsuarioRolService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    private final UsuarioRolRepository usuarioRolRepository;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioRolMapper usuarioRolMapper;

    public UsuarioRolServiceImpl(UsuarioRolRepository usuarioRolRepository,
                                  UsuarioRepository usuarioRepository,
                                  RolRepository rolRepository,
                                  UsuarioRolMapper usuarioRolMapper) {
        this.usuarioRolRepository = usuarioRolRepository;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.usuarioRolMapper = usuarioRolMapper;
    }

    @Override
    public List<UsuarioRolDTO> listar() {
        return usuarioRolRepository.findByActivoTrue().stream()
                .map(usuarioRolMapper::toDTO)
                .toList();
    }

    @Override
    public UsuarioRolDTO buscarPorId(Long id) {
        UsuarioRol usuarioRol = usuarioRolRepository.findById(id)
                .orElseThrow(() -> new UsuarioRolNoEncontradoException(id));
        return usuarioRolMapper.toDTO(usuarioRol);
    }

    @Override
    public UsuarioRolDTO crear(UsuarioRolDTO usuarioRolDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioRolDTO.getUsuarioId())
                .orElseThrow(() -> new UsuarioNoEncontradoException(usuarioRolDTO.getUsuarioId()));
        Rol rol = rolRepository.findById(usuarioRolDTO.getRolId())
                .orElseThrow(() -> new RolNoEncontradoException(usuarioRolDTO.getRolId()));

        UsuarioRol usuarioRol = usuarioRolMapper.toEntity(usuarioRolDTO);
        usuarioRol.setId(null);
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        usuarioRol.setFechaAsignacion(LocalDateTime.now());
        if (usuarioRol.getActivo() == null) {
            usuarioRol.setActivo(true);
        }
        return usuarioRolMapper.toDTO(usuarioRolRepository.save(usuarioRol));
    }

    @Override
    public UsuarioRolDTO actualizar(Long id, UsuarioRolDTO usuarioRolDTO) {
        UsuarioRol usuarioRolExistente = usuarioRolRepository.findById(id)
                .orElseThrow(() -> new UsuarioRolNoEncontradoException(id));

        Usuario usuario = usuarioRepository.findById(usuarioRolDTO.getUsuarioId())
                .orElseThrow(() -> new UsuarioNoEncontradoException(usuarioRolDTO.getUsuarioId()));
        Rol rol = rolRepository.findById(usuarioRolDTO.getRolId())
                .orElseThrow(() -> new RolNoEncontradoException(usuarioRolDTO.getRolId()));

        usuarioRolExistente.setUsuario(usuario);
        usuarioRolExistente.setRol(rol);
        usuarioRolExistente.setUsuarioAsignacion(usuarioRolDTO.getUsuarioAsignacion());
        usuarioRolExistente.setActivo(usuarioRolDTO.getActivo());

        return usuarioRolMapper.toDTO(usuarioRolRepository.save(usuarioRolExistente));
    }

    @Override
    public void eliminar(Long id) {
        UsuarioRol usuarioRol = usuarioRolRepository.findById(id)
                .orElseThrow(() -> new UsuarioRolNoEncontradoException(id));
        usuarioRol.setActivo(false);
        usuarioRolRepository.save(usuarioRol);
    }
}
