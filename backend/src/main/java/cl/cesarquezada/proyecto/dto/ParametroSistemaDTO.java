package cl.cesarquezada.proyecto.dto;

import cl.cesarquezada.proyecto.entity.TipoDatoParametro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ParametroSistemaDTO {

    private Long id;

    @NotBlank(message = "El código del parámetro es obligatorio")
    private String codigo;

    @NotBlank(message = "El nombre del parámetro es obligatorio")
    private String nombre;

    private String valor;

    @NotNull(message = "El tipo de dato es obligatorio")
    private TipoDatoParametro tipoDato;

    private String descripcion;
    private Boolean editable;
    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public ParametroSistemaDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }
    public TipoDatoParametro getTipoDato() { return tipoDato; }
    public void setTipoDato(TipoDatoParametro tipoDato) { this.tipoDato = tipoDato; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Boolean getEditable() { return editable; }
    public void setEditable(Boolean editable) { this.editable = editable; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(LocalDateTime fechaModificacion) { this.fechaModificacion = fechaModificacion; }
}
