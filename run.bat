@echo off
REM Script para arrancar la aplicación en Windows (usa Gradle Wrapper)
cd %~dp0
call gradlew.bat bootRun

