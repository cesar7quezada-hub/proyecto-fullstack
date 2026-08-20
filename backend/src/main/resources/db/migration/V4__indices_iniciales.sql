CREATE INDEX IF NOT EXISTS idx_poliza_estado ON poliza (estado);
CREATE INDEX IF NOT EXISTS idx_poliza_cliente ON poliza (cliente);
CREATE INDEX IF NOT EXISTS idx_poliza_fecha_efecto ON poliza (fecha_efecto);

CREATE INDEX IF NOT EXISTS idx_usuario_estado ON usuario (estado);
