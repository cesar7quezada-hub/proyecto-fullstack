package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PolizaNoEncontradaException extends RuntimeException {

    public PolizaNoEncontradaException(String message) {
        super(message);
    }

    public PolizaNoEncontradaException(Long id) {
        super("No se encontró la póliza con id: " + id);
    }
}
