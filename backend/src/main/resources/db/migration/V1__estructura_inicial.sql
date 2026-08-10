CREATE TABLE IF NOT EXISTS poliza (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    numero_poliza VARCHAR(50) NOT NULL UNIQUE,
    ramo VARCHAR(100),
    cliente VARCHAR(200),
    fecha_efecto DATE,
    prima DECIMAL(12,2),
    estado VARCHAR(30),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP,
    fecha_modificacion TIMESTAMP
);
