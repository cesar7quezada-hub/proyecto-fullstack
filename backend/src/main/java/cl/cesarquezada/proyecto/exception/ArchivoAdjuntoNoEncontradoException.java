package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArchivoAdjuntoNoEncontradoException extends RuntimeException {

    public ArchivoAdjuntoNoEncontradoException(String message) {
        super(message);
    }

    public ArchivoAdjuntoNoEncontradoException(Long id) {
        super("No se encontró el archivo adjunto con id: " + id);
    }
}
