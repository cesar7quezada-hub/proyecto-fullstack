# Convenciones — Frontend

## Estructura de carpetas

- `core/`: servicios singleton (ej. `AuthService`), guards de ruta, interceptors
  HTTP (ej. adjuntar el JWT), configuración transversal. Se importa una sola vez.
- `features/`: un subdirectorio por dominio de negocio (`auth`, `clientes`,
  `productos`, `solicitudes`, `usuarios`, `dashboard`). Cada feature es
  autocontenida: sus propios componentes, servicios y rutas.
- `shared/`: componentes, pipes, directivas y modelos reutilizables entre features.
- `layout/`: estructura visual general (`header`, `footer`, `sidebar`).

## Estado actual

Las carpetas están creadas pero sin implementación (solo `.gitkeep`). El próximo
trabajo real de frontend debería empezar por `core/services` (un `AuthService` que
hable con `/api/auth/login`) y `features/auth` (pantalla de login), ya que sin eso
ninguna otra feature puede autenticarse contra el backend.

## Convenciones a seguir

- Componentes standalone (Angular 22 sin NgModules).
- Un servicio por feature en `features/<feature>/` para las llamadas HTTP propias
  de ese dominio; los servicios verdaderamente transversales van en `core/services`.
- Variables de entorno (URL de API, nombre de la app) siempre vía
  `src/environments/environment.ts` y sus variantes por perfil, nunca hardcodeadas
  en componentes o servicios.
- Rutas declaradas en `app.routes.ts`, delegando a rutas hijas por feature cuando
  corresponda.
