package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.SesionUsuarioDTO;
import cl.cesarquezada.proyecto.entity.EstadoSesion;
import cl.cesarquezada.proyecto.entity.SesionUsuario;
import cl.cesarquezada.proyecto.entity.Usuario;
import cl.cesarquezada.proyecto.exception.SesionUsuarioNoEncontradaException;
import cl.cesarquezada.proyecto.exception.UsuarioNoEncontradoException;
import cl.cesarquezada.proyecto.mapper.SesionUsuarioMapper;
import cl.cesarquezada.proyecto.repository.SesionUsuarioRepository;
import cl.cesarquezada.proyecto.repository.UsuarioRepository;
import cl.cesarquezada.proyecto.service.SesionUsuarioService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SesionUsuarioServiceImpl implements SesionUsuarioService {

    private final SesionUsuarioRepository sesionUsuarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final SesionUsuarioMapper sesionUsuarioMapper;

    public SesionUsuarioServiceImpl(SesionUsuarioRepository sesionUsuarioRepository,
                                     UsuarioRepository usuarioRepository,
                                     SesionUsuarioMapper sesionUsuarioMapper) {
        this.sesionUsuarioRepository = sesionUsuarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.sesionUsuarioMapper = sesionUsuarioMapper;
    }

    @Override
    public List<SesionUsuarioDTO> listar() {
        return sesionUsuarioRepository.findAll().stream()
                .map(sesionUsuarioMapper::toDTO)
                .toList();
    }

    @Override
    public SesionUsuarioDTO buscarPorId(Long id) {
        SesionUsuario sesionUsuario = sesionUsuarioRepository.findById(id)
                .orElseThrow(() -> new SesionUsuarioNoEncontradaException(id));
        return sesionUsuarioMapper.toDTO(sesionUsuario);
    }

    @Override
    public SesionUsuarioDTO crear(SesionUsuarioDTO sesionUsuarioDTO) {
        Usuario usuario = usuarioRepository.findById(sesionUsuarioDTO.getUsuarioId())
                .orElseThrow(() -> new UsuarioNoEncontradoException(sesionUsuarioDTO.getUsuarioId()));

        SesionUsuario sesionUsuario = sesionUsuarioMapper.toEntity(sesionUsuarioDTO);
        sesionUsuario.setId(null);
        sesionUsuario.setUsuario(usuario);
        sesionUsuario.setFechaInicio(LocalDateTime.now());
        if (sesionUsuario.getEstado() == null) {
            sesionUsuario.setEstado(EstadoSesion.ACTIVA);
        }
        return sesionUsuarioMapper.toDTO(sesionUsuarioRepository.save(sesionUsuario));
    }

    @Override
    public SesionUsuarioDTO actualizar(Long id, SesionUsuarioDTO sesionUsuarioDTO) {
        SesionUsuario sesionExistente = sesionUsuarioRepository.findById(id)
                .orElseThrow(() -> new SesionUsuarioNoEncontradaException(id));

        Usuario usuario = usuarioRepository.findById(sesionUsuarioDTO.getUsuarioId())
                .orElseThrow(() -> new UsuarioNoEncontradoException(sesionUsuarioDTO.getUsuarioId()));

        sesionExistente.setUsuario(usuario);
        sesionExistente.setRefreshTokenHash(sesionUsuarioDTO.getRefreshTokenHash());
        sesionExistente.setFechaExpiracion(sesionUsuarioDTO.getFechaExpiracion());
        sesionExistente.setIpOrigen(sesionUsuarioDTO.getIpOrigen());
        sesionExistente.setUserAgent(sesionUsuarioDTO.getUserAgent());
        sesionExistente.setEstado(sesionUsuarioDTO.getEstado());

        return sesionUsuarioMapper.toDTO(sesionUsuarioRepository.save(sesionExistente));
    }

    @Override
    public void eliminar(Long id) {
        SesionUsuario sesionUsuario = sesionUsuarioRepository.findById(id)
                .orElseThrow(() -> new SesionUsuarioNoEncontradaException(id));
        sesionUsuario.setEstado(EstadoSesion.REVOCADA);
        sesionUsuarioRepository.save(sesionUsuario);
    }
}
