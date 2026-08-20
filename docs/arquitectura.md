# Arquitectura

## Visión general

Arquitectura cliente-servidor clásica: SPA en Angular consumiendo una API REST en
Spring Boot, con PostgreSQL como base de datos y migraciones versionadas con Flyway.

```
Angular (SPA, :4200)  --HTTP/JSON-->  Spring Boot API (:8080)  -->  PostgreSQL
                                              |
                                       Spring Security + JWT
                                       Swagger/OpenAPI (/swagger-ui.html)
```

## Backend — capas

El backend sigue una arquitectura en capas por paquete:

| Paquete | Responsabilidad |
|---|---|
| `controller` | Expone los endpoints REST, delega en `service` |
| `service` / `service/impl` | Lógica de aplicación |
| `repository` | Acceso a datos (Spring Data JPA) |
| `entity` | Entidades JPA, mapeadas 1:1 a tablas |
| `dto` | Objetos de transferencia expuestos por la API |
| `mapper` | Conversión entre `entity` y `dto` |
| `exception` | Excepciones de dominio y manejo centralizado de errores |
| `security` | Configuración de Spring Security, filtro y servicio JWT |
| `config` | Beans de configuración transversal (CORS, OpenAPI) |

Los controladores nunca exponen entidades JPA directamente: siempre pasan por un DTO
y un mapper (ver `PolizaController` → `PolizaDTO` → `PolizaMapper`).

## Frontend — capas

| Carpeta | Responsabilidad |
|---|---|
| `core/` | Servicios singleton, guards, interceptors, configuración transversal |
| `features/` | Módulos de negocio (auth, clientes, productos, solicitudes, usuarios, dashboard) |
| `shared/` | Componentes, pipes, directivas y modelos reutilizables |
| `layout/` | Header, footer, sidebar y estructura visual general |

Estado actual: la estructura de carpetas existe pero las features aún no tienen
componentes — ver [convenciones-frontend.md](convenciones-frontend.md).

## Entornos

Ambos proyectos usan perfiles/entornos paralelos: `local`, `dev`, `qa`, `prod`
(`application-{perfil}.yml` en el backend, `environment.{perfil}.ts` en el frontend).
