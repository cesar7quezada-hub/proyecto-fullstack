package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.PolizaDTO;
import cl.cesarquezada.proyecto.service.PolizaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/polizas")
public class PolizaController {

    private final PolizaService polizaService;

    public PolizaController(PolizaService polizaService) {
        this.polizaService = polizaService;
    }

    @GetMapping
    public ResponseEntity<List<PolizaDTO>> listar() {
        return ResponseEntity.ok(polizaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolizaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(polizaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PolizaDTO> crear(@Valid @RequestBody PolizaDTO polizaDTO) {
        PolizaDTO creada = polizaService.crear(polizaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolizaDTO> actualizar(@PathVariable Long id, @Valid @RequestBody PolizaDTO polizaDTO) {
        return ResponseEntity.ok(polizaService.actualizar(id, polizaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        polizaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
