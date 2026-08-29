package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuditoriaEventoNoEncontradoException extends RuntimeException {

    public AuditoriaEventoNoEncontradoException(String message) {
        super(message);
    }

    public AuditoriaEventoNoEncontradoException(Long id) {
        super("No se encontró el evento de auditoría con id: " + id);
    }
}
