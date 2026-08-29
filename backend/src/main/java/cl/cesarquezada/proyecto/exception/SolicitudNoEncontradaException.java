package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SolicitudNoEncontradaException extends RuntimeException {

    public SolicitudNoEncontradaException(String message) {
        super(message);
    }

    public SolicitudNoEncontradaException(Long id) {
        super("No se encontró la solicitud con id: " + id);
    }
}
