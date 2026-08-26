package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioRolNoEncontradoException extends RuntimeException {

    public UsuarioRolNoEncontradoException(String message) {
        super(message);
    }

    public UsuarioRolNoEncontradoException(Long id) {
        super("No se encontró la asignación usuario-rol con id: " + id);
    }
}
