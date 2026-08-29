package cl.cesarquezada.proyecto.dto;

import cl.cesarquezada.proyecto.entity.EstadoProducto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductoDTO {

    private Long id;

    @NotNull(message = "La categoría del producto es obligatoria")
    private Long categoriaProductoId;

    private String categoriaProductoNombre;

    @NotBlank(message = "El código del producto es obligatorio")
    private String codigo;

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombre;

    private String descripcion;
    private BigDecimal precio;
    private String moneda;
    private Integer stock;
    private EstadoProducto estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public ProductoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCategoriaProductoId() { return categoriaProductoId; }
    public void setCategoriaProductoId(Long categoriaProductoId) { this.categoriaProductoId = categoriaProductoId; }
    public String getCategoriaProductoNombre() { return categoriaProductoNombre; }
    public void setCategoriaProductoNombre(String categoriaProductoNombre) { this.categoriaProductoNombre = categoriaProductoNombre; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public EstadoProducto getEstado() { return estado; }
    public void setEstado(EstadoProducto estado) { this.estado = estado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(LocalDateTime fechaModificacion) { this.fechaModificacion = fechaModificacion; }
}
