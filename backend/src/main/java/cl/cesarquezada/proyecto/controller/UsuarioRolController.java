package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.UsuarioRolDTO;
import cl.cesarquezada.proyecto.service.UsuarioRolService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios-roles")
public class UsuarioRolController {

    private final UsuarioRolService usuarioRolService;

    public UsuarioRolController(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioRolDTO>> listar() {
        return ResponseEntity.ok(usuarioRolService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRolDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioRolService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioRolDTO> crear(@Valid @RequestBody UsuarioRolDTO usuarioRolDTO) {
        UsuarioRolDTO creado = usuarioRolService.crear(usuarioRolDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioRolDTO> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRolDTO usuarioRolDTO) {
        return ResponseEntity.ok(usuarioRolService.actualizar(id, usuarioRolDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioRolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
