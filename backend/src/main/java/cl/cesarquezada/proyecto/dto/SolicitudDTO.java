package cl.cesarquezada.proyecto.dto;

import cl.cesarquezada.proyecto.entity.EstadoSolicitud;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SolicitudDTO {

    private Long id;

    @NotNull(message = "El cliente es obligatorio")
    private Long clienteId;

    private String clienteNombre;

    private Long polizaId;
    private String polizaNumero;

    @NotBlank(message = "El número de solicitud es obligatorio")
    private String numeroSolicitud;

    private LocalDateTime fechaSolicitud;
    private EstadoSolicitud estado;
    private String observacion;
    private BigDecimal montoTotal;
    private String moneda;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public SolicitudDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }
    public Long getPolizaId() { return polizaId; }
    public void setPolizaId(Long polizaId) { this.polizaId = polizaId; }
    public String getPolizaNumero() { return polizaNumero; }
    public void setPolizaNumero(String polizaNumero) { this.polizaNumero = polizaNumero; }
    public String getNumeroSolicitud() { return numeroSolicitud; }
    public void setNumeroSolicitud(String numeroSolicitud) { this.numeroSolicitud = numeroSolicitud; }
    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(LocalDateTime fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }
    public EstadoSolicitud getEstado() { return estado; }
    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }
    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
    public BigDecimal getMontoTotal() { return montoTotal; }
    public void setMontoTotal(BigDecimal montoTotal) { this.montoTotal = montoTotal; }
    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(LocalDateTime fechaModificacion) { this.fechaModificacion = fechaModificacion; }
}
