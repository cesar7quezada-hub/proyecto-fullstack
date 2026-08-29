package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.ParametroSistemaDTO;
import cl.cesarquezada.proyecto.entity.ParametroSistema;
import cl.cesarquezada.proyecto.exception.ParametroSistemaNoEncontradoException;
import cl.cesarquezada.proyecto.mapper.ParametroSistemaMapper;
import cl.cesarquezada.proyecto.repository.ParametroSistemaRepository;
import cl.cesarquezada.proyecto.service.ParametroSistemaService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ParametroSistemaServiceImpl implements ParametroSistemaService {

    private final ParametroSistemaRepository parametroSistemaRepository;
    private final ParametroSistemaMapper parametroSistemaMapper;

    public ParametroSistemaServiceImpl(ParametroSistemaRepository parametroSistemaRepository,
                                        ParametroSistemaMapper parametroSistemaMapper) {
        this.parametroSistemaRepository = parametroSistemaRepository;
        this.parametroSistemaMapper = parametroSistemaMapper;
    }

    @Override
    public List<ParametroSistemaDTO> listar() {
        return parametroSistemaRepository.findByActivoTrue().stream()
                .map(parametroSistemaMapper::toDTO)
                .toList();
    }

    @Override
    public ParametroSistemaDTO buscarPorId(Long id) {
        ParametroSistema parametroSistema = parametroSistemaRepository.findById(id)
                .orElseThrow(() -> new ParametroSistemaNoEncontradoException(id));
        return parametroSistemaMapper.toDTO(parametroSistema);
    }

    @Override
    public ParametroSistemaDTO crear(ParametroSistemaDTO parametroSistemaDTO) {
        ParametroSistema parametroSistema = parametroSistemaMapper.toEntity(parametroSistemaDTO);
        parametroSistema.setId(null);
        parametroSistema.setFechaCreacion(LocalDateTime.now());
        parametroSistema.setFechaModificacion(LocalDateTime.now());
        return parametroSistemaMapper.toDTO(parametroSistemaRepository.save(parametroSistema));
    }

    @Override
    public ParametroSistemaDTO actualizar(Long id, ParametroSistemaDTO parametroSistemaDTO) {
        ParametroSistema parametroExistente = parametroSistemaRepository.findById(id)
                .orElseThrow(() -> new ParametroSistemaNoEncontradoException(id));

        parametroExistente.setCodigo(parametroSistemaDTO.getCodigo());
        parametroExistente.setNombre(parametroSistemaDTO.getNombre());
        parametroExistente.setValor(parametroSistemaDTO.getValor());
        parametroExistente.setTipoDato(parametroSistemaDTO.getTipoDato());
        parametroExistente.setDescripcion(parametroSistemaDTO.getDescripcion());
        parametroExistente.setEditable(parametroSistemaDTO.getEditable());
        parametroExistente.setActivo(parametroSistemaDTO.getActivo());
        parametroExistente.setFechaModificacion(LocalDateTime.now());

        return parametroSistemaMapper.toDTO(parametroSistemaRepository.save(parametroExistente));
    }

    @Override
    public void eliminar(Long id) {
        ParametroSistema parametroSistema = parametroSistemaRepository.findById(id)
                .orElseThrow(() -> new ParametroSistemaNoEncontradoException(id));
        parametroSistema.setActivo(false);
        parametroSistema.setFechaModificacion(LocalDateTime.now());
        parametroSistemaRepository.save(parametroSistema);
    }
}
