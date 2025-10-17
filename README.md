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

Contacto
- Proporciona el repositorio en GitHub y otorga acceso al equipo Digital NAO (añadir como colaboradores o equipo con permisos).

