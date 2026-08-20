# Proyecto Full Stack — Spring Boot + Angular

Proyecto personal de práctica full stack: backend en Spring Boot 4 (Java 21) con
PostgreSQL, Flyway y seguridad JWT, y frontend en Angular 22. Sirve como base de
portafolio — no implementa lógica de negocio completa, sino la estructura,
configuración y capas típicas de un proyecto real (ver [docs/arquitectura.md](docs/arquitectura.md)).

## Estructura

```
proyecto-fullstack/
├── backend/    Spring Boot (API REST, JWT, PostgreSQL, Flyway, Swagger)
├── frontend/   Angular (estructura por features, aún sin componentes)
├── docker/     (pendiente) compose para levantar el stack local
├── docs/       Documentación de arquitectura, convenciones y seguridad
└── scripts/    (pendiente) scripts de apoyo
```

## Backend

- Java 21, Spring Boot 4.1, PostgreSQL, Flyway, Spring Security + JWT, Swagger/OpenAPI.
- CRUD completo de `Poliza` en `/api/polizas`.
- Autenticación con `/api/auth/login`.
- Detalle de arranque local en [docs/configuracion-local.md](docs/configuracion-local.md).
- Convenciones de código en [docs/convenciones-backend.md](docs/convenciones-backend.md).
- Detalle de seguridad JWT en [docs/seguridad-jwt.md](docs/seguridad-jwt.md).

## Frontend

- Angular 22, estructura de carpetas por feature (`core/`, `features/`, `shared/`, `layout/`).
- Aún sin componentes implementados — ver [docs/convenciones-frontend.md](docs/convenciones-frontend.md).

## Modelo de datos

El modelo completo planificado (14 entidades) y su estado de implementación está
documentado en [docs/modelo-datos.md](docs/modelo-datos.md).

## Estado del proyecto

Este repo se construyó siguiendo un cronograma de 4 sprints (inicialización,
configuración, modelo de datos, seguridad y documentación). El alcance definido es
"estructura base del proyecto", priorizando tener las capas y la configuración
correctas por sobre una implementación de negocio completa.
