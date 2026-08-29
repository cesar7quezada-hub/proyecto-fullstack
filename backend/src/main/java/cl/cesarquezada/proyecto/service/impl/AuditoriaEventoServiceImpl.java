package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.AuditoriaEventoDTO;
import cl.cesarquezada.proyecto.entity.AuditoriaEvento;
import cl.cesarquezada.proyecto.exception.AuditoriaEventoNoEncontradoException;
import cl.cesarquezada.proyecto.mapper.AuditoriaEventoMapper;
import cl.cesarquezada.proyecto.repository.AuditoriaEventoRepository;
import cl.cesarquezada.proyecto.service.AuditoriaEventoService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaEventoServiceImpl implements AuditoriaEventoService {

    private final AuditoriaEventoRepository auditoriaEventoRepository;
    private final AuditoriaEventoMapper auditoriaEventoMapper;

    public AuditoriaEventoServiceImpl(AuditoriaEventoRepository auditoriaEventoRepository,
                                       AuditoriaEventoMapper auditoriaEventoMapper) {
        this.auditoriaEventoRepository = auditoriaEventoRepository;
        this.auditoriaEventoMapper = auditoriaEventoMapper;
    }

    @Override
    public List<AuditoriaEventoDTO> listar() {
        return auditoriaEventoRepository.findAll().stream()
                .map(auditoriaEventoMapper::toDTO)
                .toList();
    }

    @Override
    public AuditoriaEventoDTO buscarPorId(Long id) {
        AuditoriaEvento auditoriaEvento = auditoriaEventoRepository.findById(id)
                .orElseThrow(() -> new AuditoriaEventoNoEncontradoException(id));
        return auditoriaEventoMapper.toDTO(auditoriaEvento);
    }

    @Override
    public AuditoriaEventoDTO crear(AuditoriaEventoDTO auditoriaEventoDTO) {
        AuditoriaEvento auditoriaEvento = auditoriaEventoMapper.toEntity(auditoriaEventoDTO);
        auditoriaEvento.setId(null);
        auditoriaEvento.setFechaEvento(LocalDateTime.now());
        return auditoriaEventoMapper.toDTO(auditoriaEventoRepository.save(auditoriaEvento));
    }
}
