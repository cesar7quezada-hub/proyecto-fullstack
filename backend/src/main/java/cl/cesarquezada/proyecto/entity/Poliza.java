package cl.cesarquezada.proyecto.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "poliza")
public class Poliza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_poliza", unique = true, nullable = false)
    private String numeroPoliza;

    @Column(name = "ramo")
    private String ramo;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "fecha_efecto")
    private LocalDate fechaEfecto;

    @Column(name = "prima")
    private Double prima;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoPoliza estado;

    @Column(name = "activo")
    private Boolean activo = true;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    public Poliza() {}

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
