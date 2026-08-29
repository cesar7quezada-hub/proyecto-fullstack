package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.ArchivoAdjuntoDTO;
import cl.cesarquezada.proyecto.entity.ArchivoAdjunto;
import cl.cesarquezada.proyecto.entity.EstadoArchivoAdjunto;
import cl.cesarquezada.proyecto.entity.Solicitud;
import cl.cesarquezada.proyecto.exception.ArchivoAdjuntoNoEncontradoException;
import cl.cesarquezada.proyecto.exception.SolicitudNoEncontradaException;
import cl.cesarquezada.proyecto.mapper.ArchivoAdjuntoMapper;
import cl.cesarquezada.proyecto.repository.ArchivoAdjuntoRepository;
import cl.cesarquezada.proyecto.repository.SolicitudRepository;
import cl.cesarquezada.proyecto.service.ArchivoAdjuntoService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArchivoAdjuntoServiceImpl implements ArchivoAdjuntoService {

    private final ArchivoAdjuntoRepository archivoAdjuntoRepository;
    private final SolicitudRepository solicitudRepository;
    private final ArchivoAdjuntoMapper archivoAdjuntoMapper;

    public ArchivoAdjuntoServiceImpl(ArchivoAdjuntoRepository archivoAdjuntoRepository,
                                      SolicitudRepository solicitudRepository,
                                      ArchivoAdjuntoMapper archivoAdjuntoMapper) {
        this.archivoAdjuntoRepository = archivoAdjuntoRepository;
        this.solicitudRepository = solicitudRepository;
        this.archivoAdjuntoMapper = archivoAdjuntoMapper;
    }

    @Override
    public List<ArchivoAdjuntoDTO> listar() {
        return archivoAdjuntoRepository.findAll().stream()
                .map(archivoAdjuntoMapper::toDTO)
                .toList();
    }

    @Override
    public ArchivoAdjuntoDTO buscarPorId(Long id) {
        ArchivoAdjunto archivoAdjunto = archivoAdjuntoRepository.findById(id)
                .orElseThrow(() -> new ArchivoAdjuntoNoEncontradoException(id));
        return archivoAdjuntoMapper.toDTO(archivoAdjunto);
    }

    @Override
    public ArchivoAdjuntoDTO crear(ArchivoAdjuntoDTO archivoAdjuntoDTO) {
        Solicitud solicitud = solicitudRepository.findById(archivoAdjuntoDTO.getSolicitudId())
                .orElseThrow(() -> new SolicitudNoEncontradaException(archivoAdjuntoDTO.getSolicitudId()));

        ArchivoAdjunto archivoAdjunto = archivoAdjuntoMapper.toEntity(archivoAdjuntoDTO);
        archivoAdjunto.setId(null);
        archivoAdjunto.setSolicitud(solicitud);
        if (archivoAdjunto.getEstado() == null) {
            archivoAdjunto.setEstado(EstadoArchivoAdjunto.CARGADO);
        }
        archivoAdjunto.setFechaCreacion(LocalDateTime.now());
        archivoAdjunto.setFechaModificacion(LocalDateTime.now());

        return archivoAdjuntoMapper.toDTO(archivoAdjuntoRepository.save(archivoAdjunto));
    }

    @Override
    public ArchivoAdjuntoDTO actualizar(Long id, ArchivoAdjuntoDTO archivoAdjuntoDTO) {
        ArchivoAdjunto archivoExistente = archivoAdjuntoRepository.findById(id)
                .orElseThrow(() -> new ArchivoAdjuntoNoEncontradoException(id));

        Solicitud solicitud = solicitudRepository.findById(archivoAdjuntoDTO.getSolicitudId())
                .orElseThrow(() -> new SolicitudNoEncontradaException(archivoAdjuntoDTO.getSolicitudId()));

        archivoExistente.setSolicitud(solicitud);
        archivoExistente.setNombreArchivo(archivoAdjuntoDTO.getNombreArchivo());
        archivoExistente.setNombreStorage(archivoAdjuntoDTO.getNombreStorage());
        archivoExistente.setExtension(archivoAdjuntoDTO.getExtension());
        archivoExistente.setContentType(archivoAdjuntoDTO.getContentType());
        archivoExistente.setTamanoBytes(archivoAdjuntoDTO.getTamanoBytes());
        archivoExistente.setRuta(archivoAdjuntoDTO.getRuta());
        archivoExistente.setHashArchivo(archivoAdjuntoDTO.getHashArchivo());
        archivoExistente.setEstado(archivoAdjuntoDTO.getEstado());
        archivoExistente.setFechaModificacion(LocalDateTime.now());

        return archivoAdjuntoMapper.toDTO(archivoAdjuntoRepository.save(archivoExistente));
    }

    @Override
    public void eliminar(Long id) {
        ArchivoAdjunto archivoAdjunto = archivoAdjuntoRepository.findById(id)
                .orElseThrow(() -> new ArchivoAdjuntoNoEncontradoException(id));
        archivoAdjunto.setEstado(EstadoArchivoAdjunto.ELIMINADO);
        archivoAdjunto.setFechaModificacion(LocalDateTime.now());
        archivoAdjuntoRepository.save(archivoAdjunto);
    }
}
