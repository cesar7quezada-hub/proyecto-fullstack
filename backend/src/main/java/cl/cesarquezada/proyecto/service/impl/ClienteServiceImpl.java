package cl.cesarquezada.proyecto.service.impl;

import cl.cesarquezada.proyecto.dto.ClienteDTO;
import cl.cesarquezada.proyecto.entity.Cliente;
import cl.cesarquezada.proyecto.exception.ClienteNoEncontradoException;
import cl.cesarquezada.proyecto.mapper.ClienteMapper;
import cl.cesarquezada.proyecto.repository.ClienteRepository;
import cl.cesarquezada.proyecto.service.ClienteService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<ClienteDTO> listar() {
        return clienteRepository.findByActivoTrue().stream()
                .map(clienteMapper::toDTO)
                .toList();
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));
        return clienteMapper.toDTO(cliente);
    }

    @Override
    public ClienteDTO crear(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.setId(null);
        cliente.setFechaCreacion(LocalDateTime.now());
        cliente.setFechaModificacion(LocalDateTime.now());
        return clienteMapper.toDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDTO actualizar(Long id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));

        clienteExistente.setTipoCliente(clienteDTO.getTipoCliente());
        clienteExistente.setRut(clienteDTO.getRut());
        clienteExistente.setNombre(clienteDTO.getNombre());
        clienteExistente.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        clienteExistente.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        clienteExistente.setEmail(clienteDTO.getEmail());
        clienteExistente.setTelefono(clienteDTO.getTelefono());
        clienteExistente.setDireccion(clienteDTO.getDireccion());
        clienteExistente.setComuna(clienteDTO.getComuna());
        clienteExistente.setRegion(clienteDTO.getRegion());
        clienteExistente.setActivo(clienteDTO.getActivo());
        clienteExistente.setFechaModificacion(LocalDateTime.now());

        return clienteMapper.toDTO(clienteRepository.save(clienteExistente));
    }

    @Override
    public void eliminar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNoEncontradoException(id));
        cliente.setActivo(false);
        cliente.setFechaModificacion(LocalDateTime.now());
        clienteRepository.save(cliente);
    }
}
