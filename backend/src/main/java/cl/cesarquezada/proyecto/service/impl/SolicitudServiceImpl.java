package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.SolicitudDTO;
import cl.cesarquezada.proyecto.entity.Cliente;
import cl.cesarquezada.proyecto.entity.EstadoSolicitud;
import cl.cesarquezada.proyecto.entity.Poliza;
import cl.cesarquezada.proyecto.entity.Solicitud;
import cl.cesarquezada.proyecto.exception.ClienteNoEncontradoException;
import cl.cesarquezada.proyecto.exception.PolizaNoEncontradaException;
import cl.cesarquezada.proyecto.exception.SolicitudNoEncontradaException;
import cl.cesarquezada.proyecto.mapper.SolicitudMapper;
import cl.cesarquezada.proyecto.repository.ClienteRepository;
import cl.cesarquezada.proyecto.repository.PolizaRepository;
import cl.cesarquezada.proyecto.repository.SolicitudRepository;
import cl.cesarquezada.proyecto.service.SolicitudService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final ClienteRepository clienteRepository;
    private final PolizaRepository polizaRepository;
    private final SolicitudMapper solicitudMapper;

    public SolicitudServiceImpl(SolicitudRepository solicitudRepository,
                                 ClienteRepository clienteRepository,
                                 PolizaRepository polizaRepository,
                                 SolicitudMapper solicitudMapper) {
        this.solicitudRepository = solicitudRepository;
        this.clienteRepository = clienteRepository;
        this.polizaRepository = polizaRepository;
        this.solicitudMapper = solicitudMapper;
    }

    @Override
    public List<SolicitudDTO> listar() {
        return solicitudRepository.findAll().stream()
                .map(solicitudMapper::toDTO)
                .toList();
    }

    @Override
    public SolicitudDTO buscarPorId(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new SolicitudNoEncontradaException(id));
        return solicitudMapper.toDTO(solicitud);
    }

    @Override
    public SolicitudDTO crear(SolicitudDTO solicitudDTO) {
        Cliente cliente = clienteRepository.findById(solicitudDTO.getClienteId())
                .orElseThrow(() -> new ClienteNoEncontradoException(solicitudDTO.getClienteId()));

        Solicitud solicitud = solicitudMapper.toEntity(solicitudDTO);
        solicitud.setId(null);
        solicitud.setCliente(cliente);

        if (solicitudDTO.getPolizaId() != null) {
            Poliza poliza = polizaRepository.findById(solicitudDTO.getPolizaId())
                    .orElseThrow(() -> new PolizaNoEncontradaException(solicitudDTO.getPolizaId()));
            solicitud.setPoliza(poliza);
        } else {
            solicitud.setPoliza(null);
        }

        solicitud.setFechaSolicitud(LocalDateTime.now());
        if (solicitud.getEstado() == null) {
            solicitud.setEstado(EstadoSolicitud.BORRADOR);
        }
        solicitud.setFechaCreacion(LocalDateTime.now());
        solicitud.setFechaModificacion(LocalDateTime.now());

        return solicitudMapper.toDTO(solicitudRepository.save(solicitud));
    }

    @Override
    public SolicitudDTO actualizar(Long id, SolicitudDTO solicitudDTO) {
        Solicitud solicitudExistente = solicitudRepository.findById(id)
                .orElseThrow(() -> new SolicitudNoEncontradaException(id));

        Cliente cliente = clienteRepository.findById(solicitudDTO.getClienteId())
                .orElseThrow(() -> new ClienteNoEncontradoException(solicitudDTO.getClienteId()));

        solicitudExistente.setCliente(cliente);

        if (solicitudDTO.getPolizaId() != null) {
            Poliza poliza = polizaRepository.findById(solicitudDTO.getPolizaId())
                    .orElseThrow(() -> new PolizaNoEncontradaException(solicitudDTO.getPolizaId()));
            solicitudExistente.setPoliza(poliza);
        } else {
            solicitudExistente.setPoliza(null);
        }

        solicitudExistente.setNumeroSolicitud(solicitudDTO.getNumeroSolicitud());
        solicitudExistente.setEstado(solicitudDTO.getEstado());
        solicitudExistente.setObservacion(solicitudDTO.getObservacion());
        solicitudExistente.setMontoTotal(solicitudDTO.getMontoTotal());
        solicitudExistente.setMoneda(solicitudDTO.getMoneda());
        solicitudExistente.setFechaModificacion(LocalDateTime.now());

        return solicitudMapper.toDTO(solicitudRepository.save(solicitudExistente));
    }

    @Override
    public void eliminar(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new SolicitudNoEncontradaException(id));
        solicitud.setEstado(EstadoSolicitud.ANULADA);
        solicitud.setFechaModificacion(LocalDateTime.now());
        solicitudRepository.save(solicitud);
    }
}
