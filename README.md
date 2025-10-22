# Tienda Online

Proyecto de ejemplo Spring Boot con recurso `Order`.

Instrucciones rápidas:

1. Ejecutar tests:

```cmd
cd C:\Users\Soporte\Downloads\tienda-online
.\gradlew.bat clean test
```

2. Arrancar la aplicación (puerto 8080 por defecto):

```cmd
cd C:\Users\Soporte\Downloads\tienda-online
.\gradlew.bat bootRun
```

Para arrancar en otro puerto (ej. 8082):

```cmd
.\gradlew.bat -Dserver.port=8082 bootRun
```

3. Swagger UI y OpenAPI:

- Swagger UI: `http://localhost:8080/swagger-ui/index.html` (o ajusta el puerto si cambiaslo)
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

Para exportar el OpenAPI a un archivo (Windows PowerShell):

```powershell
Invoke-RestMethod http://localhost:8080/v3/api-docs | ConvertTo-Json -Depth 100 > docs\openapi.json
```

4. Perfil de pruebas (H2) ya configurado en `src/main/resources/application-test.properties`.

Archivos añadidos:
- `src/main/java/com/tienda/config/OpenApiConfig.java` (config OpenAPI)
- `src/main/resources/swagger-config.yaml`
- Tests unitarios y de integración en `src/test/java/com/tienda/...`
- `docs/openapi.json` (generarlo tras arrancar la app y exportarlo)

Cómo contribuir / subir al repositorio:

```cmd
git add .
git commit -m "Add OpenAPI config, tests and README"
git push origin main
```

Si quieres, puedo generar `docs/openapi.json` aquí y añadirlo al repo (arrancando la app y descargándolo)."}]}
