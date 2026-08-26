-- Roles
CREATE TABLE IF NOT EXISTS rol (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Permisos
CREATE TABLE IF NOT EXISTS permiso (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(150) NOT NULL,
    modulo VARCHAR(100),
    descripcion VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Asignación de roles a usuarios
CREATE TABLE IF NOT EXISTS usuario_rol (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario_id BIGINT NOT NULL REFERENCES usuario (id),
    rol_id BIGINT NOT NULL REFERENCES rol (id),
    fecha_asignacion TIMESTAMP,
    usuario_asignacion VARCHAR(100),
    activo BOOLEAN DEFAULT TRUE
);

-- Asignación de permisos a roles
CREATE TABLE IF NOT EXISTS rol_permiso (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    rol_id BIGINT NOT NULL REFERENCES rol (id),
    permiso_id BIGINT NOT NULL REFERENCES permiso (id),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Sesiones de usuario (refresh tokens)
CREATE TABLE IF NOT EXISTS sesion_usuario (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario_id BIGINT NOT NULL REFERENCES usuario (id),
    refresh_token_hash VARCHAR(255) NOT NULL,
    fecha_inicio TIMESTAMP,
    fecha_expiracion TIMESTAMP,
    ip_origen VARCHAR(45),
    user_agent VARCHAR(255),
    estado VARCHAR(20) DEFAULT 'ACTIVA'
);

-- Índices sobre columnas FK y de búsqueda frecuente
CREATE INDEX IF NOT EXISTS idx_usuario_rol_usuario ON usuario_rol (usuario_id);
CREATE INDEX IF NOT EXISTS idx_usuario_rol_rol ON usuario_rol (rol_id);

CREATE INDEX IF NOT EXISTS idx_rol_permiso_rol ON rol_permiso (rol_id);
CREATE INDEX IF NOT EXISTS idx_rol_permiso_permiso ON rol_permiso (permiso_id);

CREATE INDEX IF NOT EXISTS idx_sesion_usuario_usuario ON sesion_usuario (usuario_id);
CREATE INDEX IF NOT EXISTS idx_sesion_usuario_estado ON sesion_usuario (estado);
CREATE INDEX IF NOT EXISTS idx_sesion_usuario_refresh_token ON sesion_usuario (refresh_token_hash);
