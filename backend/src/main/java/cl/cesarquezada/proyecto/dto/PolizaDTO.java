package cl.cesarquezada.proyecto.dto;

import cl.cesarquezada.proyecto.entity.EstadoPoliza;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PolizaDTO {

    private Long id;

    @NotBlank(message = "El número de póliza es obligatorio")
    private String numeroPoliza;

    private String ramo;

    private String cliente;

    private LocalDate fechaEfecto;

    private Double prima;

    @NotNull(message = "El estado es obligatorio")
    private EstadoPoliza estado;

    private Boolean activo;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaModificacion;

    public PolizaDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroPoliza() { return numeroPoliza; }
    public void setNumeroPoliza(String numeroPoliza) { this.numeroPoliza = numeroPoliza; }

    public String getRamo() { return ramo; }
    public void setRamo(String ramo) { this.ramo = ramo; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public LocalDate getFechaEfecto() { return fechaEfecto; }
    public void setFechaEfecto(LocalDate fechaEfecto) { this.fechaEfecto = fechaEfecto; }

    public Double getPrima() { return prima; }
    public void setPrima(Double prima) { this.prima = prima; }

    public EstadoPoliza getEstado() { return estado; }
    public void setEstado(EstadoPoliza estado) { this.estado = estado; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(LocalDateTime fechaModificacion) { this.fechaModificacion = fechaModificacion; }
}
