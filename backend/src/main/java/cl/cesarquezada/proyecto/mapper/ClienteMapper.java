package cl.cesarquezada.proyecto.mapper;

import cl.cesarquezada.proyecto.dto.ClienteDTO;
import cl.cesarquezada.proyecto.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) return null;
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setTipoCliente(cliente.getTipoCliente());
        dto.setRut(cliente.getRut());
        dto.setNombre(cliente.getNombre());
        dto.setApellidoPaterno(cliente.getApellidoPaterno());
        dto.setApellidoMaterno(cliente.getApellidoMaterno());
        dto.setEmail(cliente.getEmail());
        dto.setTelefono(cliente.getTelefono());
        dto.setDireccion(cliente.getDireccion());
        dto.setComuna(cliente.getComuna());
        dto.setRegion(cliente.getRegion());
        dto.setActivo(cliente.getActivo());
        dto.setFechaCreacion(cliente.getFechaCreacion());
        dto.setFechaModificacion(cliente.getFechaModificacion());
        return dto;
    }

    public Cliente toEntity(ClienteDTO dto) {
        if (dto == null) return null;
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setTipoCliente(dto.getTipoCliente());
        cliente.setRut(dto.getRut());
        cliente.setNombre(dto.getNombre());
        cliente.setApellidoPaterno(dto.getApellidoPaterno());
        cliente.setApellidoMaterno(dto.getApellidoMaterno());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        cliente.setComuna(dto.getComuna());
        cliente.setRegion(dto.getRegion());
        cliente.setActivo(dto.getActivo());
        cliente.setFechaCreacion(dto.getFechaCreacion());
        cliente.setFechaModificacion(dto.getFechaModificacion());
        return cliente;
    }
}
