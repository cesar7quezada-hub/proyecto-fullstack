-- Categorías de producto
CREATE TABLE IF NOT EXISTS categoria_producto (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Clientes
CREATE TABLE IF NOT EXISTS cliente (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    tipo_cliente VARCHAR(20) NOT NULL,
    rut VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(150) NOT NULL,
    apellido_paterno VARCHAR(100),
    apellido_materno VARCHAR(100),
    email VARCHAR(200),
    telefono VARCHAR(30),
    direccion VARCHAR(255),
    comuna VARCHAR(100),
    region VARCHAR(100),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Productos
CREATE TABLE IF NOT EXISTS producto (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    categoria_producto_id BIGINT NOT NULL REFERENCES categoria_producto (id),
    codigo VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(255),
    precio NUMERIC(14,2),
    moneda VARCHAR(10),
    stock INTEGER,
    estado VARCHAR(20) DEFAULT 'ACTIVO',
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Solicitudes
CREATE TABLE IF NOT EXISTS solicitud (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    cliente_id BIGINT NOT NULL REFERENCES cliente (id),
    poliza_id BIGINT REFERENCES poliza (id),
    numero_solicitud VARCHAR(50) NOT NULL UNIQUE,
    fecha_solicitud TIMESTAMP,
    estado VARCHAR(20) DEFAULT 'BORRADOR',
    observacion VARCHAR(500),
    monto_total NUMERIC(14,2),
    moneda VARCHAR(10),
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Detalle de solicitud
CREATE TABLE IF NOT EXISTS solicitud_detalle (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    solicitud_id BIGINT NOT NULL REFERENCES solicitud (id),
    producto_id BIGINT NOT NULL REFERENCES producto (id),
    descripcion VARCHAR(255),
    cantidad INTEGER,
    precio_unitario NUMERIC(14,2),
    subtotal NUMERIC(14,2),
    descuento NUMERIC(14,2),
    total NUMERIC(14,2),
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Archivos adjuntos de solicitud
CREATE TABLE IF NOT EXISTS archivo_adjunto (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    solicitud_id BIGINT NOT NULL REFERENCES solicitud (id),
    nombre_archivo VARCHAR(255) NOT NULL,
    nombre_storage VARCHAR(255),
    extension VARCHAR(20),
    content_type VARCHAR(100),
    tamano_bytes BIGINT,
    ruta VARCHAR(500),
    hash_archivo VARCHAR(128),
    estado VARCHAR(20) DEFAULT 'CARGADO',
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);

-- Índices sobre columnas FK y de búsqueda frecuente
CREATE INDEX IF NOT EXISTS idx_producto_categoria ON producto (categoria_producto_id);
CREATE INDEX IF NOT EXISTS idx_producto_estado ON producto (estado);

CREATE INDEX IF NOT EXISTS idx_solicitud_cliente ON solicitud (cliente_id);
CREATE INDEX IF NOT EXISTS idx_solicitud_poliza ON solicitud (poliza_id);
CREATE INDEX IF NOT EXISTS idx_solicitud_estado ON solicitud (estado);

CREATE INDEX IF NOT EXISTS idx_solicitud_detalle_solicitud ON solicitud_detalle (solicitud_id);
CREATE INDEX IF NOT EXISTS idx_solicitud_detalle_producto ON solicitud_detalle (producto_id);

CREATE INDEX IF NOT EXISTS idx_archivo_adjunto_solicitud ON archivo_adjunto (solicitud_id);
CREATE INDEX IF NOT EXISTS idx_archivo_adjunto_estado ON archivo_adjunto (estado);
CREATE INDEX IF NOT EXISTS idx_archivo_adjunto_hash ON archivo_adjunto (hash_archivo);
