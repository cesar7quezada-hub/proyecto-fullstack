-- Parámetros de sistema
CREATE TABLE IF NOT EXISTS parametro_sistema (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(150) NOT NULL,
    valor VARCHAR(500),
    tipo_dato VARCHAR(20) NOT NULL,
    descripcion VARCHAR(255),
    editable BOOLEAN DEFAULT TRUE,
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Auditoría de eventos (log inmutable)
CREATE TABLE IF NOT EXISTS auditoria_evento (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario VARCHAR(100) NOT NULL,
    accion VARCHAR(100) NOT NULL,
    modulo VARCHAR(100),
    entidad VARCHAR(100),
    entidad_id BIGINT,
    valor_anterior TEXT,
    valor_nuevo TEXT,
    ip_origen VARCHAR(45),
    user_agent VARCHAR(255),
    fecha_evento TIMESTAMP,
    resultado VARCHAR(30),
    mensaje VARCHAR(500)
);

-- Índices
CREATE INDEX IF NOT EXISTS idx_parametro_sistema_activo ON parametro_sistema (activo);

CREATE INDEX IF NOT EXISTS idx_auditoria_evento_usuario ON auditoria_evento (usuario);
CREATE INDEX IF NOT EXISTS idx_auditoria_evento_modulo ON auditoria_evento (modulo);
CREATE INDEX IF NOT EXISTS idx_auditoria_evento_entidad ON auditoria_evento (entidad, entidad_id);
CREATE INDEX IF NOT EXISTS idx_auditoria_evento_fecha ON auditoria_evento (fecha_evento);
