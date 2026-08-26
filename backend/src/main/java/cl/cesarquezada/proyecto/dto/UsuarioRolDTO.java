package cl.cesarquezada.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class UsuarioRolDTO {

    private Long id;

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "El rol es obligatorio")
    private Long rolId;

    private String usuarioNombre;
    private String rolNombre;

    private LocalDateTime fechaAsignacion;
    private String usuarioAsignacion;
    private Boolean activo;

    public UsuarioRolDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getRolId() { return rolId; }
    public void setRolId(Long rolId) { this.rolId = rolId; }
    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }
    public String getRolNombre() { return rolNombre; }
    public void setRolNombre(String rolNombre) { this.rolNombre = rolNombre; }
    public LocalDateTime getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDateTime fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }
    public String getUsuarioAsignacion() { return usuarioAsignacion; }
    public void setUsuarioAsignacion(String usuarioAsignacion) { this.usuarioAsignacion = usuarioAsignacion; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}
