package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RolPermisoNoEncontradoException extends RuntimeException {

    public RolPermisoNoEncontradoException(String message) {
        super(message);
    }

    public RolPermisoNoEncontradoException(Long id) {
        super("No se encontró la asignación rol-permiso con id: " + id);
    }
}
