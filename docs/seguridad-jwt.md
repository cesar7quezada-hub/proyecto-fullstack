# Seguridad — JWT

## Alcance actual

Esta es una implementación de **esqueleto**: autenticación funcional con JWT, sin
autorización por rol (no existen aún las entidades `rol`/`permiso` del modelo de
datos planificado — ver [modelo-datos.md](modelo-datos.md)) y sin funcionalidades
de cuenta como registro, refresh token, logout o bloqueo por intentos fallidos.

## Flujo

1. `POST /api/auth/login` con `{ username, password }`.
2. `AuthController` delega en `AuthenticationManager` (Spring Security), que usa
   `UserDetailsServiceImpl` para cargar el `Usuario` por `username` y
   `BCryptPasswordEncoder` para verificar el hash.
3. Si es válido, `JwtService` genera un token HS256 firmado con `jwt.secret`,
   con expiración configurable (`jwt.expiration-minutes`, default 60 min).
4. El cliente debe enviar el token en cada request subsecuente:
   `Authorization: Bearer <token>`.
5. `JwtAuthenticationFilter` (antes de `UsernamePasswordAuthenticationFilter`)
   valida el token en cada request y puebla el `SecurityContext`.

## Rutas públicas vs protegidas

`SecurityConfig` permite sin autenticación: `/api/auth/**` y la documentación
Swagger (`/swagger-ui/**`, `/v3/api-docs/**`). El resto de rutas exige un JWT
válido (`anyRequest().authenticated()`), pero **no** distingue roles todavía.

## Configuración

`jwt.secret` y `jwt.expiration-minutes` se leen desde variables de entorno
(`JWT_SECRET`, `JWT_EXPIRATION_MINUTES`). Solo el perfil `local` trae un secreto
por defecto para poder levantar el proyecto sin configuración adicional — los
perfiles `dev`, `qa` y `prod` lo exigen explícitamente y fallan al arrancar si no
está definido.

## Usuario de prueba (solo perfil local)

Sembrado por la migración `V3__seed_usuario_admin.sql`:

- Usuario: `admin`
- Password: `Admin123!`

## Pendiente si se retoma este módulo

- Roles y permisos (`rol`, `permiso`, `usuario_rol`, `rol_permiso`) y autorización
  por endpoint (`@PreAuthorize` o equivalente).
- Endpoint de registro de usuario (hoy el único usuario existente es el seed).
- Refresh token y logout (invalidación de token).
- Uso real de `intentos_fallidos` / `fecha_bloqueo` en `Usuario` para bloqueo de
  cuenta — hoy esas columnas existen pero no tienen lógica asociada.
