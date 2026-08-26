package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PermisoNoEncontradoException extends RuntimeException {

    public PermisoNoEncontradoException(String message) {
        super(message);
    }

    public PermisoNoEncontradoException(Long id) {
        super("No se encontró el permiso con id: " + id);
    }
}
