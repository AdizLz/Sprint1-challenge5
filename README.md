# Tienda Online - Servicio de Órdenes

Proyecto demostrativo en Spring Boot 3.0 (Java 17) que expone un recurso REST para gestionar órdenes (CRUD) y persiste en base de datos.

Características:
- Spring Boot 3.x
- Java 17 (toolchain configurado en Gradle)
- JPA + H2 (desarrollo) y soporte para PostgreSQL (runtime dependency)
- Validación de entrada con Jakarta Validation
- Controlador REST con endpoints CRUD para `Order`
- Manejo global de errores para devolver mensajes claros en validaciones

Archivos añadidos / modificados relevantes:
- `src/main/java/com/tienda/model/Order.java` - Entidad con validaciones y JavaDoc
- `src/main/java/com/tienda/repository/OrderRepository.java` - Repositorio JPA
- `src/main/java/com/tienda/service/OrderService.java` - Lógica CRUD
- `src/main/java/com/tienda/controller/OrderController.java` - Endpoints REST
- `src/main/java/com/tienda/exception/GlobalExceptionHandler.java` - Manejo global de errores
- `src/main/resources/application.properties` - Configuración (H2 por defecto)
- `postman_collection.json` - Colección para probar la API con Postman
- `run.bat`, `run.sh` - Scripts para arrancar la aplicación

Requisitos
- Java 17+
- Gradle (se usa Gradle Wrapper incluido)

Ejecutar en desarrollo (H2 in-memory)
Desde Windows (cmd.exe):

```bat
cd C:\ruta\a\tienda-online
gradlew.bat bootRun
```

O construir el JAR y ejecutarlo:

```bat
gradlew.bat build
java -jar build\libs\tienda-online-0.0.1-SNAPSHOT.jar
```

En Linux/macOS (bash):

```bash
./gradlew bootRun
# o
./gradlew build
java -jar build/libs/tienda-online-0.0.1-SNAPSHOT.jar
```

Endpoints principales (base: http://localhost:8080)
- POST /api/orders : crear orden
- GET /api/orders : listar órdenes
- GET /api/orders/{id} : obtener orden por id
- PUT /api/orders/{id} : actualizar orden
- DELETE /api/orders/{id} : eliminar orden

Ejemplo JSON para crear orden:

```json
{
  "customerName": "Juan Perez",
  "customerEmail": "juan@example.com",
  "productDescription": "Camiseta roja talla M",
  "quantity": 2,
  "totalPrice": 39.98,
  "status": "PENDING"
}
```

Postman
- Importa `postman_collection.json` para probar los endpoints (contiene ejemplos y descripciones).

Despliegue a PostgreSQL
- Cambia `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password` en `application.properties` o usa variables de entorno.

Decisiones del equipo
- Se usa H2 en memoria para facilitar pruebas locales.
- Validación en la entidad y manejo global para devolver 400 con detalles.
- `createdAt` se inicializa en el constructor para registrar fecha de creación automáticamente.

Siguientes pasos sugeridos
- Añadir tests unitarios/integración.
- Añadir autenticación/autorization si el API será público.
- Añadir documentación OpenAPI/Swagger.

---

Perfiles de entorno y configuración (añadido)

He añadido soporte por perfiles para facilitar el despliegue en distintos entornos. Archivos creados en `src/main/resources`:

- `application.properties` (base) — ya existía y mantiene configuración por defecto (H2 y puerto 8080).
- `application-dev.properties` — perfil de desarrollo (H2 en memoria, logging DEBUG).
- `application-test.properties` — perfil para pruebas automatizadas (H2, puerto 8081, logging INFO).
- `application-prod.properties` — perfil de producción (preparado para PostgreSQL; usa variables de entorno para credenciales y URL).

Uso de variables de entorno
- En `application-prod.properties` las credenciales y la URL de la BD se leen desde variables:
  - `SPRING_DATASOURCE_URL`
  - `SPRING_DATASOURCE_USERNAME`
  - `SPRING_DATASOURCE_PASSWORD`
  - `SERVER_PORT` (opcional)
- No incluyas secretos en el repositorio. Usa `.env` (local) o tu sistema de secretos en producción (Kubernetes Secrets, Vault, KeyVault, etc.).

Plantilla de variables
- He añadido `.env.example` en la raíz del proyecto. Cópiala a `.env` y ajusta localmente si lo necesitas. Nunca commitees tu `.env` con secretos.

Scripts de arranque
- `scripts/start-dev.sh`  (bash) y `scripts/start-dev.bat` (Windows) — arranca con el perfil `dev`.
- `scripts/start-test.sh` / `scripts/start-test.bat` — arranca con el perfil `test`.
- `scripts/start-prod.sh` / `scripts/start-prod.bat` — arranca con el perfil `prod` y ejecuta el JAR si está construido.

Ejemplos rápidos
- Windows (cmd):
  - Desarrollo: `scripts\start-dev.bat`
  - Pruebas: `scripts\start-test.bat`
  - Producción: `scripts\start-prod.bat` (asegúrate de tener variables de entorno configuradas)

- Bash (Linux/macOS):
  - Desarrollo: `./scripts/start-dev.sh`
  - Pruebas: `./scripts/start-test.sh`
  - Producción: `./scripts/start-prod.sh`

Activar perfil manualmente
- Puedes activar un perfil también con la variable `SPRING_PROFILES_ACTIVE` o con la opción JVM `-Dspring.profiles.active=prod`.

Buenas prácticas y seguridad
- Nunca commitees credenciales. Usa `.env.example` para documentar claves necesarias.
- En producción, el proveedor de despliegue debe inyectar las credenciales mediante mecanismos seguros.

Revisiones parciales y control de calidad
- He añadido una plantilla de PR en `.github/PULL_REQUEST_TEMPLATE.md` y un `CONTRIBUTING.md` con un checklist para revisiones parciales (revisión temprana de integración, comprobación de configuración por perfil, no exponer secretos, pruebas mínimas, etc.).

Si quieres, puedo:
- Convertir estos `*.properties` a `*.yml` (solo dime si prefieres YAML en lugar de properties).
- Añadir validaciones al arranque que fallen si variables críticas en producción no están definidas (p.ej. URL o credenciales).

---

Contacto
- Proporciona el repositorio en GitHub y otorga acceso al equipo Digital NAO (añadir como colaboradores o equipo con permisos).
