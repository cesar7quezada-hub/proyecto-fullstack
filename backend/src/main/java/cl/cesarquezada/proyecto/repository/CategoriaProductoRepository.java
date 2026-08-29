package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Long> {

    Optional<CategoriaProducto> findByCodigo(String codigo);

    List<CategoriaProducto> findByActivoTrue();
}
