package cl.cesarquezada.proyecto.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poliza_id")
    private Poliza poliza;

    @Column(name = "numero_solicitud", unique = true, nullable = false)
    private String numeroSolicitud;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoSolicitud estado = EstadoSolicitud.BORRADOR;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "monto_total")
    private BigDecimal montoTotal;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    public Solicitud() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Poliza getPoliza() { return poliza; }
    public void setPoliza(Poliza poliza) { this.poliza = poliza; }
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
