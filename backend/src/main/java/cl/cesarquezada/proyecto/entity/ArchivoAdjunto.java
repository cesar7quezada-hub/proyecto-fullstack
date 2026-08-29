package cl.cesarquezada.proyecto.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "archivo_adjunto")
public class ArchivoAdjunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    @Column(name = "nombre_archivo", nullable = false)
    private String nombreArchivo;

    @Column(name = "nombre_storage")
    private String nombreStorage;

    @Column(name = "extension")
    private String extension;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "tamano_bytes")
    private Long tamanoBytes;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "hash_archivo")
    private String hashArchivo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoArchivoAdjunto estado = EstadoArchivoAdjunto.CARGADO;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    public ArchivoAdjunto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Solicitud getSolicitud() { return solicitud; }
    public void setSolicitud(Solicitud solicitud) { this.solicitud = solicitud; }
    public String getNombreArchivo() { return nombreArchivo; }
    public void setNombreArchivo(String nombreArchivo) { this.nombreArchivo = nombreArchivo; }
    public String getNombreStorage() { return nombreStorage; }
    public void setNombreStorage(String nombreStorage) { this.nombreStorage = nombreStorage; }
    public String getExtension() { return extension; }
    public void setExtension(String extension) { this.extension = extension; }
    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }
    public Long getTamanoBytes() { return tamanoBytes; }
    public void setTamanoBytes(Long tamanoBytes) { this.tamanoBytes = tamanoBytes; }
    public String getRuta() { return ruta; }
    public void setRuta(String ruta) { this.ruta = ruta; }
    public String getHashArchivo() { return hashArchivo; }
    public void setHashArchivo(String hashArchivo) { this.hashArchivo = hashArchivo; }
    public EstadoArchivoAdjunto getEstado() { return estado; }
    public void setEstado(EstadoArchivoAdjunto estado) { this.estado = estado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(LocalDateTime fechaModificacion) { this.fechaModificacion = fechaModificacion; }
}
