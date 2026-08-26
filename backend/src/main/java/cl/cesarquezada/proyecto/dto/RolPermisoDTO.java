package cl.cesarquezada.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RolPermisoDTO {

    private Long id;

    @NotNull(message = "El rol es obligatorio")
    private Long rolId;

    @NotNull(message = "El permiso es obligatorio")
    private Long permisoId;

    private String rolNombre;
    private String permisoNombre;

    private Boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public RolPermisoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getRolId() { return rolId; }
    public void setRolId(Long rolId) { this.rolId = rolId; }
    public Long getPermisoId() { return permisoId; }
    public void setPermisoId(Long permisoId) { this.permisoId = permisoId; }
    public String getRolNombre() { return rolNombre; }
    public void setRolNombre(String rolNombre) { this.rolNombre = rolNombre; }
    public String getPermisoNombre() { return permisoNombre; }
    public void setPermisoNombre(String permisoNombre) { this.permisoNombre = permisoNombre; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(LocalDateTime fechaModificacion) { this.fechaModificacion = fechaModificacion; }
}
