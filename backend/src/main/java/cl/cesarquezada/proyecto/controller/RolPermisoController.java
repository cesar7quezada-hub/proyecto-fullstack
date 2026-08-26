package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.RolPermisoDTO;
import cl.cesarquezada.proyecto.service.RolPermisoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles-permisos")
public class RolPermisoController {

    private final RolPermisoService rolPermisoService;

    public RolPermisoController(RolPermisoService rolPermisoService) {
        this.rolPermisoService = rolPermisoService;
    }

    @GetMapping
    public ResponseEntity<List<RolPermisoDTO>> listar() {
        return ResponseEntity.ok(rolPermisoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolPermisoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rolPermisoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RolPermisoDTO> crear(@Valid @RequestBody RolPermisoDTO rolPermisoDTO) {
        RolPermisoDTO creado = rolPermisoService.crear(rolPermisoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolPermisoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody RolPermisoDTO rolPermisoDTO) {
        return ResponseEntity.ok(rolPermisoService.actualizar(id, rolPermisoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rolPermisoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
