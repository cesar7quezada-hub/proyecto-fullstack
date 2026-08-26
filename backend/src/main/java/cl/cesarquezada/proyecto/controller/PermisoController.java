package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.PermisoDTO;
import cl.cesarquezada.proyecto.service.PermisoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    private final PermisoService permisoService;

    public PermisoController(PermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @GetMapping
    public ResponseEntity<List<PermisoDTO>> listar() {
        return ResponseEntity.ok(permisoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermisoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(permisoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PermisoDTO> crear(@Valid @RequestBody PermisoDTO permisoDTO) {
        PermisoDTO creado = permisoService.crear(permisoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermisoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody PermisoDTO permisoDTO) {
        return ResponseEntity.ok(permisoService.actualizar(id, permisoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        permisoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
