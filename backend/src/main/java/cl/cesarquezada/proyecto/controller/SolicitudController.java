package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.SolicitudDTO;
import cl.cesarquezada.proyecto.service.SolicitudService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public ResponseEntity<List<SolicitudDTO>> listar() {
        return ResponseEntity.ok(solicitudService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<SolicitudDTO> crear(@Valid @RequestBody SolicitudDTO solicitudDTO) {
        SolicitudDTO creada = solicitudService.crear(solicitudDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudDTO> actualizar(@PathVariable Long id, @Valid @RequestBody SolicitudDTO solicitudDTO) {
        return ResponseEntity.ok(solicitudService.actualizar(id, solicitudDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        solicitudService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
