package cl.cesarquezada.proyecto.service;

import cl.cesarquezada.proyecto.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listar();
    ClienteDTO buscarPorId(Long id);
    ClienteDTO crear(ClienteDTO clienteDTO);
    ClienteDTO actualizar(Long id, ClienteDTO clienteDTO);
    void eliminar(Long id);
}
