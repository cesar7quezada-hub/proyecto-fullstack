package cl.cesarquezada.proyecto.dto;

import cl.cesarquezada.proyecto.entity.EstadoSesion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SesionUsuarioDTO {

    private Long id;

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    private String usuarioNombre;

    @NotBlank(message = "El hash del refresh token es obligatorio")
    private String refreshTokenHash;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaExpiracion;
    private String ipOrigen;
    private String userAgent;

    @NotNull(message = "El estado es obligatorio")
    private EstadoSesion estado;

    public SesionUsuarioDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }
    public String getRefreshTokenHash() { return refreshTokenHash; }
    public void setRefreshTokenHash(String refreshTokenHash) { this.refreshTokenHash = refreshTokenHash; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDateTime getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(LocalDateTime fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }
    public String getIpOrigen() { return ipOrigen; }
    public void setIpOrigen(String ipOrigen) { this.ipOrigen = ipOrigen; }
    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }
    public EstadoSesion getEstado() { return estado; }
    public void setEstado(EstadoSesion estado) { this.estado = estado; }
}
