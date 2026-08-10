package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.PolizaDTO;
import cl.cesarquezada.proyecto.entity.Poliza;
import cl.cesarquezada.proyecto.exception.PolizaNoEncontradaException;
import cl.cesarquezada.proyecto.mapper.PolizaMapper;
import cl.cesarquezada.proyecto.repository.PolizaRepository;
import cl.cesarquezada.proyecto.service.PolizaService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PolizaServiceImpl implements PolizaService {

    private final PolizaRepository polizaRepository;
    private final PolizaMapper polizaMapper;

    public PolizaServiceImpl(PolizaRepository polizaRepository, PolizaMapper polizaMapper) {
        this.polizaRepository = polizaRepository;
        this.polizaMapper = polizaMapper;
    }

    @Override
    public List<PolizaDTO> listar() {
        return polizaRepository.findByActivoTrue().stream()
                .map(polizaMapper::toDTO)
                .toList();
    }

    @Override
    public PolizaDTO buscarPorId(Long id) {
        Poliza poliza = polizaRepository.findById(id)
                .orElseThrow(() -> new PolizaNoEncontradaException(id));
        return polizaMapper.toDTO(poliza);
    }

    @Override
    public PolizaDTO crear(PolizaDTO polizaDTO) {
        Poliza poliza = polizaMapper.toEntity(polizaDTO);
        poliza.setId(null);
        poliza.setFechaCreacion(LocalDateTime.now());
        poliza.setFechaModificacion(LocalDateTime.now());
        return polizaMapper.toDTO(polizaRepository.save(poliza));
    }

    @Override
    public PolizaDTO actualizar(Long id, PolizaDTO polizaDTO) {
        Poliza polizaExistente = polizaRepository.findById(id)
                .orElseThrow(() -> new PolizaNoEncontradaException(id));

        polizaExistente.setNumeroPoliza(polizaDTO.getNumeroPoliza());
        polizaExistente.setRamo(polizaDTO.getRamo());
        polizaExistente.setCliente(polizaDTO.getCliente());
        polizaExistente.setFechaEfecto(polizaDTO.getFechaEfecto());
        polizaExistente.setPrima(polizaDTO.getPrima());
        polizaExistente.setEstado(polizaDTO.getEstado());
        polizaExistente.setActivo(polizaDTO.getActivo());
        polizaExistente.setFechaModificacion(LocalDateTime.now());

        return polizaMapper.toDTO(polizaRepository.save(polizaExistente));
    }

    @Override
    public void eliminar(Long id) {
        Poliza poliza = polizaRepository.findById(id)
                .orElseThrow(() -> new PolizaNoEncontradaException(id));
        poliza.setActivo(false);
        poliza.setFechaModificacion(LocalDateTime.now());
        polizaRepository.save(poliza);
    }
}
