package cl.cesarquezada.proyecto.dto;

import cl.cesarquezada.proyecto.entity.EstadoArchivoAdjunto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ArchivoAdjuntoDTO {

    private Long id;

    @NotNull(message = "La solicitud es obligatoria")
    private Long solicitudId;

    private String solicitudNumero;

    @NotBlank(message = "El nombre del archivo es obligatorio")
    private String nombreArchivo;

    private String nombreStorage;
    private String extension;
    private String contentType;
    private Long tamanoBytes;
    private String ruta;
    private String hashArchivo;
    private EstadoArchivoAdjunto estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public ArchivoAdjuntoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getSolicitudId() { return solicitudId; }
    public void setSolicitudId(Long solicitudId) { this.solicitudId = solicitudId; }
    public String getSolicitudNumero() { return solicitudNumero; }
    public void setSolicitudNumero(String solicitudNumero) { this.solicitudNumero = solicitudNumero; }
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
