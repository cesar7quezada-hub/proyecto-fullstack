package cl.cesarquezada.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoriaProductoNoEncontradaException extends RuntimeException {

    public CategoriaProductoNoEncontradaException(String message) {
        super(message);
    }

    public CategoriaProductoNoEncontradaException(Long id) {
        super("No se encontró la categoría de producto con id: " + id);
    }
}
