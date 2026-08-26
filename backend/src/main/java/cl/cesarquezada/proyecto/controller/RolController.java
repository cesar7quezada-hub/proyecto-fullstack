package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.RolDTO;
import cl.cesarquezada.proyecto.service.RolService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listar() {
        return ResponseEntity.ok(rolService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RolDTO> crear(@Valid @RequestBody RolDTO rolDTO) {
        RolDTO creado = rolService.crear(rolDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> actualizar(@PathVariable Long id, @Valid @RequestBody RolDTO rolDTO) {
        return ResponseEntity.ok(rolService.actualizar(id, rolDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
