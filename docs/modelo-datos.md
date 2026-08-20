# Modelo de datos

## Alcance planificado

El diseño original contempla 14 entidades para un sistema de gestión de clientes,
productos y solicitudes con control de acceso por rol:

`usuario`, `rol`, `permiso`, `usuario_rol`, `rol_permiso`, `sesion_usuario`,
`cliente`, `categoria_producto`, `producto`, `solicitud`, `solicitud_detalle`,
`archivo_adjunto`, `parametro_sistema`, `auditoria_evento`.

Dado que el alcance del proyecto es "estructura base, sin lógica de negocio
completa", no todas están implementadas. Este documento refleja el estado real.

## Estado de implementación

| Entidad | Estado | Notas |
|---|---|---|
| `usuario` | ✅ Implementada | Tabla + entidad JPA + repositorio. Usada por el login JWT. |
| `poliza` | ✅ Implementada (fuera del modelo original) | CRUD completo de ejemplo; no forma parte de las 14 entidades planificadas, se usó como caso de prueba para las capas del backend. |
| `rol` | ⬜ Planificada | Necesaria para autorización por rol (ver [seguridad-jwt.md](seguridad-jwt.md)). |
| `permiso` | ⬜ Planificada | — |
| `usuario_rol` | ⬜ Planificada | Tabla de relación N:N `usuario`–`rol`. |
| `rol_permiso` | ⬜ Planificada | Tabla de relación N:N `rol`–`permiso`. |
| `sesion_usuario` | ⬜ Planificada | Tracking de sesiones/tokens activos. |
| `cliente` | ⬜ Planificada | — |
| `categoria_producto` | ⬜ Planificada | — |
| `producto` | ⬜ Planificada | — |
| `solicitud` | ⬜ Planificada | — |
| `solicitud_detalle` | ⬜ Planificada | Detalle 1:N de `solicitud`. |
| `archivo_adjunto` | ⬜ Planificada | — |
| `parametro_sistema` | ⬜ Planificada | — |
| `auditoria_evento` | ⬜ Planificada | — |

## `usuario` — implementada

```
usuario
├── id                BIGINT, PK, identity
├── username           VARCHAR(100), NOT NULL, UNIQUE
├── email               VARCHAR(200), NOT NULL, UNIQUE
├── password_hash      VARCHAR(255), NOT NULL   (BCrypt)
├── nombre              VARCHAR(100)
├── apellido            VARCHAR(100)
├── estado              VARCHAR(20), default 'ACTIVO'  (ACTIVO | BLOQUEADO | INACTIVO)
├── ultimo_acceso       TIMESTAMP
├── intentos_fallidos   INTEGER, default 0        (sin lógica asociada aún)
├── fecha_bloqueo       TIMESTAMP                 (sin lógica asociada aún)
├── fecha_creacion      TIMESTAMP
└── fecha_modificacion  TIMESTAMP
```

Migraciones: `V2__crear_tabla_usuario.sql` (estructura), `V3__seed_usuario_admin.sql`
(usuario de prueba), `V4__indices_iniciales.sql` (índice sobre `estado`).

## `poliza` — implementada

```
poliza
├── id                  BIGINT, PK, identity
├── numero_poliza       VARCHAR(50), NOT NULL, UNIQUE
├── ramo                 VARCHAR(100)
├── cliente              VARCHAR(200)
├── fecha_efecto         DATE
├── prima                DECIMAL(12,2)
├── estado               VARCHAR(30)   (ALTA | EMISION | VIGENTE | SINIESTRO | RENOVACION | TERMINADA)
├── activo                BOOLEAN, default TRUE
├── fecha_creacion       TIMESTAMP
└── fecha_modificacion   TIMESTAMP
```

Migración: `V1__estructura_inicial.sql`. Índices en `estado`, `cliente` y
`fecha_efecto` vía `V4__indices_iniciales.sql`.

## Relaciones planificadas (no implementadas)

- `usuario` N:N `rol` vía `usuario_rol`; `rol` N:N `permiso` vía `rol_permiso`.
- `usuario` 1:N `sesion_usuario`.
- `cliente` 1:N `solicitud`; `solicitud` 1:N `solicitud_detalle`.
- `producto` N:1 `categoria_producto`; `solicitud_detalle` N:1 `producto`.
- `solicitud` 1:N `archivo_adjunto`.
- `auditoria_evento` referencia genérica a `usuario` (quién) y a la entidad afectada.

## Próximo paso si se retoma este módulo

Priorizar `rol`, `permiso`, `usuario_rol` y `rol_permiso` primero — son las que
desbloquean autorización real en el JWT. `cliente`, `producto` y `solicitud` son
el siguiente bloque lógico (dominio de negocio), y `sesion_usuario`,
`archivo_adjunto`, `parametro_sistema` y `auditoria_evento` son las de menor
prioridad para una demo.
