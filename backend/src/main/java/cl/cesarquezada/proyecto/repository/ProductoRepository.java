package cl.cesarquezada.proyecto.repository;

import cl.cesarquezada.proyecto.entity.EstadoProducto;
import cl.cesarquezada.proyecto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findByCodigo(String codigo);

    List<Producto> findByEstado(EstadoProducto estado);

    List<Producto> findByCategoriaProductoId(Long categoriaProductoId);
}
