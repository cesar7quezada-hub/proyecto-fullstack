# Convenciones — Backend

## Paquetes

- Un paquete por responsabilidad (`controller`, `service`, `repository`, `entity`,
  `dto`, `mapper`, `exception`, `security`, `config`), cada uno con su
  `package-info.java` describiendo su propósito.
- `service` define la interfaz; `service/impl` la implementación.

## Nombres

- Clases y paquetes en español, alineados al dominio (`Poliza`, `PolizaService`,
  `PolizaNoEncontradaException`), consistente con el resto del proyecto.
- Entidades JPA sin sufijo (`Poliza`, `Usuario`), DTOs con sufijo `DTO`.

## Excepciones

- Excepciones de dominio (ej. `PolizaNoEncontradaException`) usan `@ResponseStatus`
  cuando son simples y no requieren un formato especial.
- Errores transversales (ej. fallas de autenticación) se manejan con un
  `@RestControllerAdvice` centralizado (`GlobalExceptionHandler`), devolviendo un
  `ErrorResponse` consistente.

## Migraciones (Flyway)

- Una migración por cambio lógico, nunca se edita una migración ya aplicada.
- Convención de nombre: `V{n}__descripcion_en_snake_case.sql`.
- Los seeds de datos (ej. usuario de prueba) van en su propia migración, separados
  de la creación de estructura.

## Commits

Se sigue Conventional Commits: `feat`, `fix`, `refactor`, `docs`, `test`, `chore`,
`build`. Cada sprint del proyecto cierra con al menos un commit consolidado.
