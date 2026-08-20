INSERT INTO usuario (username, email, password_hash, nombre, apellido, estado, fecha_creacion, fecha_modificacion)
VALUES (
    'admin',
    'admin@proyecto.local',
    '$2a$10$rqNbytRrBM7Xai0BJs/CQeLJzx0Lro4NgeNYxmc/mxa9wUi7SHGbO',
    'Admin',
    'Sistema',
    'ACTIVO',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
)
ON CONFLICT (username) DO NOTHING;
