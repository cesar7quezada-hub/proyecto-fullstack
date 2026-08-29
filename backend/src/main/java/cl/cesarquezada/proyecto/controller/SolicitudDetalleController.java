package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.SolicitudDetalleDTO;
import cl.cesarquezada.proyecto.service.SolicitudDetalleService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solicitudes-detalle")
public class SolicitudDetalleController {

    private final SolicitudDetalleService solicitudDetalleService;

    public SolicitudDetalleController(SolicitudDetalleService solicitudDetalleService) {
        this.solicitudDetalleService = solicitudDetalleService;
    }

    @GetMapping
    public ResponseEntity<List<SolicitudDetalleDTO>> listar() {
        return ResponseEntity.ok(solicitudDetalleService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDetalleDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudDetalleService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<SolicitudDetalleDTO> crear(@Valid @RequestBody SolicitudDetalleDTO solicitudDetalleDTO) {
        SolicitudDetalleDTO creado = solicitudDetalleService.crear(solicitudDetalleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudDetalleDTO> actualizar(@PathVariable Long id, @Valid @RequestBody SolicitudDetalleDTO solicitudDetalleDTO) {
        return ResponseEntity.ok(solicitudDetalleService.actualizar(id, solicitudDetalleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        solicitudDetalleService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
