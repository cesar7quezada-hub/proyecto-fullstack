package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.SesionUsuarioDTO;
import cl.cesarquezada.proyecto.service.SesionUsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sesiones")
public class SesionUsuarioController {

    private final SesionUsuarioService sesionUsuarioService;

    public SesionUsuarioController(SesionUsuarioService sesionUsuarioService) {
        this.sesionUsuarioService = sesionUsuarioService;
    }

    @GetMapping
    public ResponseEntity<List<SesionUsuarioDTO>> listar() {
        return ResponseEntity.ok(sesionUsuarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SesionUsuarioDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(sesionUsuarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<SesionUsuarioDTO> crear(@Valid @RequestBody SesionUsuarioDTO sesionUsuarioDTO) {
        SesionUsuarioDTO creada = sesionUsuarioService.crear(sesionUsuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SesionUsuarioDTO> actualizar(@PathVariable Long id, @Valid @RequestBody SesionUsuarioDTO sesionUsuarioDTO) {
        return ResponseEntity.ok(sesionUsuarioService.actualizar(id, sesionUsuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        sesionUsuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
