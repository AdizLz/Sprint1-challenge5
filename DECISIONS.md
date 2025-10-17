Decisiones clave del equipo

1. Framework y versión
- Se eligió Spring Boot 3.x con Java 17 para aprovechar la compatibilidad con Jakarta EE y mejoras de rendimiento.

2. Persistencia
- H2 en memoria se configura por defecto en `application.properties` para facilitar desarrollo y pruebas locales.
- Se incluyó el driver de PostgreSQL en `build.gradle` como dependencia de runtime para despliegues a producción.

3. Validación y contratos
- Se usan anotaciones de Jakarta Validation (`@NotBlank`, `@Email`, `@Min`, `@PositiveOrZero`) directamente en la entidad `Order` para asegurar integridad de datos en la entrada.
- El controlador usa `@Valid` para activar la validación automática.

4. Manejo de errores
- Se implementó `GlobalExceptionHandler` para capturar errores de validación y devolver un mapa de campos->mensaje con código 400.
- También se captura cualquier excepción no manejada y se devuelve 500 con un mensaje.

5. Fechas y estado
- `createdAt` se inicializa en el constructor de `Order` para garantizar que siempre haya una marca temporal.
- El estado por defecto es `PENDING`.

6. API y contratos
- Endpoints REST en `/api/orders` que soportan CRUD completo.
- Se devolvió uso de `ResponseEntity` con códigos HTTP adecuados (201, 200, 204, 404, 400).

7. Documentación y pruebas manuales
- Se añadió un `postman_collection.json` con ejemplos para crear/leer/actualizar/eliminar órdenes.
- Incluido `README.md` con instrucciones de arranque y ejemplos de payload.

Notas de futuras mejoras
- Añadir pruebas unitarias e integración.
- Añadir paginación/filtrado para listados.
- Añadir OpenAPI/Swagger para documentación interactiva.
- Añadir autenticación/autorization para exponer el API públicamente.

