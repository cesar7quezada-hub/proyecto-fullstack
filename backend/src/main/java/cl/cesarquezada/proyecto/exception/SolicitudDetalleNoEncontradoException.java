package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SolicitudDetalleNoEncontradoException extends RuntimeException {

    public SolicitudDetalleNoEncontradoException(String message) {
        super(message);
    }

    public SolicitudDetalleNoEncontradoException(Long id) {
        super("No se encontró el detalle de solicitud con id: " + id);
    }
}
