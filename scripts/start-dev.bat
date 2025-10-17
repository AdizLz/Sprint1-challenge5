@echo off
rem start-dev.bat - inicia la app con el perfil 'dev' usando Gradle Wrapper
rem Carga variables desde .env si existe (formato KEY=VALUE)
if exist .env (
  for /f "usebackq tokens=1* delims==" %%a in (.env) do set "%%a=%%b"
)
set SPRING_PROFILES_ACTIVE=dev
gradlew.bat bootRun

