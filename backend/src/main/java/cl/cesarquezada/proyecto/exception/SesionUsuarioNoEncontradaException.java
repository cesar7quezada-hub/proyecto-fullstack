package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SesionUsuarioNoEncontradaException extends RuntimeException {

    public SesionUsuarioNoEncontradaException(String message) {
        super(message);
    }

    public SesionUsuarioNoEncontradaException(Long id) {
        super("No se encontró la sesión con id: " + id);
    }
}
