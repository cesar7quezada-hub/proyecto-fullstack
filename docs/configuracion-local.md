# Configuración local

## Requisitos

- Java 21
- Maven (o el wrapper `mvnw` incluido)
- Node.js 18+ y npm
- PostgreSQL 14+ corriendo localmente (o accesible por red)

## Backend

1. Crear la base de datos y el usuario que usará la app (los nombres por defecto
   están en `application-local.yml`, todos sobreescribibles por variable de entorno):

   | Variable | Default (perfil `local`) |
   |---|---|
   | `DB_HOST` | `localhost` |
   | `DB_PORT` | `5432` |
   | `DB_NAME` | `app_db` |
   | `DB_USER` | `app_user` |
   | `DB_PASSWORD` | *(obligatoria, sin default)* |
   | `JWT_SECRET` | tiene default de desarrollo, pero se recomienda definirla |
   | `JWT_EXPIRATION_MINUTES` | `60` |

2. Levantar el backend con el perfil `local`:

   ```bash
   cd backend
   DB_PASSWORD=tu_password ./mvnw spring-boot:run -Dspring-boot.run.profiles=local
   ```

3. Flyway ejecuta las migraciones automáticamente al arrancar (`db/migration/`).
   Esto incluye la tabla `usuario` con un usuario de prueba ya sembrado:

   - **Usuario:** `admin`
   - **Password:** `Admin123!`

   *(Solo para el perfil local, no usar en ambientes reales — ver
   [seguridad-jwt.md](seguridad-jwt.md).)*

4. Verificar que todo levantó:
   - API: `http://localhost:8080/api/polizas`
   - Swagger: `http://localhost:8080/swagger-ui.html`
   - Login: `POST http://localhost:8080/api/auth/login` con
     `{"username": "admin", "password": "Admin123!"}`

## Frontend

```bash
cd frontend
npm install
npm start
```

Sirve en `http://localhost:4200`, configurado en `CorsConfig` del backend como
origen permitido.
