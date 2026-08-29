package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.ArchivoAdjuntoDTO;
import cl.cesarquezada.proyecto.service.ArchivoAdjuntoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/archivos-adjuntos")
public class ArchivoAdjuntoController {

    private final ArchivoAdjuntoService archivoAdjuntoService;

    public ArchivoAdjuntoController(ArchivoAdjuntoService archivoAdjuntoService) {
        this.archivoAdjuntoService = archivoAdjuntoService;
    }

    @GetMapping
    public ResponseEntity<List<ArchivoAdjuntoDTO>> listar() {
        return ResponseEntity.ok(archivoAdjuntoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArchivoAdjuntoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(archivoAdjuntoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ArchivoAdjuntoDTO> crear(@Valid @RequestBody ArchivoAdjuntoDTO archivoAdjuntoDTO) {
        ArchivoAdjuntoDTO creado = archivoAdjuntoService.crear(archivoAdjuntoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArchivoAdjuntoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody ArchivoAdjuntoDTO archivoAdjuntoDTO) {
        return ResponseEntity.ok(archivoAdjuntoService.actualizar(id, archivoAdjuntoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        archivoAdjuntoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
