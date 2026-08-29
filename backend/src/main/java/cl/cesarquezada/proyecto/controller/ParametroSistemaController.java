package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.ParametroSistemaDTO;
import cl.cesarquezada.proyecto.service.ParametroSistemaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parametros-sistema")
public class ParametroSistemaController {

    private final ParametroSistemaService parametroSistemaService;

    public ParametroSistemaController(ParametroSistemaService parametroSistemaService) {
        this.parametroSistemaService = parametroSistemaService;
    }

    @GetMapping
    public ResponseEntity<List<ParametroSistemaDTO>> listar() {
        return ResponseEntity.ok(parametroSistemaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParametroSistemaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(parametroSistemaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ParametroSistemaDTO> crear(@Valid @RequestBody ParametroSistemaDTO parametroSistemaDTO) {
        ParametroSistemaDTO creado = parametroSistemaService.crear(parametroSistemaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParametroSistemaDTO> actualizar(@PathVariable Long id, @Valid @RequestBody ParametroSistemaDTO parametroSistemaDTO) {
        return ResponseEntity.ok(parametroSistemaService.actualizar(id, parametroSistemaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        parametroSistemaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
