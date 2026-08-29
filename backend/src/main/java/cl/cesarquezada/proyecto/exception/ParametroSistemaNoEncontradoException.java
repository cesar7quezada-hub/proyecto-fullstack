package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ParametroSistemaNoEncontradoException extends RuntimeException {

    public ParametroSistemaNoEncontradoException(String message) {
        super(message);
    }

    public ParametroSistemaNoEncontradoException(Long id) {
        super("No se encontró el parámetro de sistema con id: " + id);
    }
}
