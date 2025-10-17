@echo off
rem start-prod.bat - inicia la app con el perfil 'prod'
if exist .env (
  for /f "usebackq tokens=1* delims==" %%a in (.env) do set "%%a=%%b"
)
set SPRING_PROFILES_ACTIVE=prod
rem Ejecutar JAR si existe (nombre por defecto del build)
if exist build\libs\tienda-online-0.0.1-SNAPSHOT.jar (
  java -jar build\libs\tienda-online-0.0.1-SNAPSHOT.jar
) else (
  gradlew.bat bootRun
)
@echo off
rem start-test.bat - inicia la app con el perfil 'test' usando Gradle Wrapper
if exist .env (
  for /f "usebackq tokens=1* delims==" %%a in (.env) do set "%%a=%%b"
)
set SPRING_PROFILES_ACTIVE=test
gradlew.bat bootRun

