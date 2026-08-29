package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.AuditoriaEventoDTO;
import cl.cesarquezada.proyecto.service.AuditoriaEventoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auditoria-eventos")
public class AuditoriaEventoController {

    private final AuditoriaEventoService auditoriaEventoService;

    public AuditoriaEventoController(AuditoriaEventoService auditoriaEventoService) {
        this.auditoriaEventoService = auditoriaEventoService;
    }

    @GetMapping
    public ResponseEntity<List<AuditoriaEventoDTO>> listar() {
        return ResponseEntity.ok(auditoriaEventoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditoriaEventoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(auditoriaEventoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AuditoriaEventoDTO> crear(@Valid @RequestBody AuditoriaEventoDTO auditoriaEventoDTO) {
        AuditoriaEventoDTO creado = auditoriaEventoService.crear(auditoriaEventoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}
