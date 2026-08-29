package cl.cesarquezada.proyecto.controller;

import cl.cesarquezada.proyecto.dto.CategoriaProductoDTO;
import cl.cesarquezada.proyecto.service.CategoriaProductoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias-productos")
public class CategoriaProductoController {

    private final CategoriaProductoService categoriaProductoService;

    public CategoriaProductoController(CategoriaProductoService categoriaProductoService) {
        this.categoriaProductoService = categoriaProductoService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaProductoDTO>> listar() {
        return ResponseEntity.ok(categoriaProductoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProductoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaProductoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaProductoDTO> crear(@Valid @RequestBody CategoriaProductoDTO categoriaProductoDTO) {
        CategoriaProductoDTO creada = categoriaProductoService.crear(categoriaProductoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProductoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CategoriaProductoDTO categoriaProductoDTO) {
        return ResponseEntity.ok(categoriaProductoService.actualizar(id, categoriaProductoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaProductoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
