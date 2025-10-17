#!/usr/bin/env bash
# start-dev.sh - inicia la app con el perfil 'dev' usando Gradle Wrapper
# Usa H2 en memoria y logging más verboso para desarrollo local
set -e
export SPRING_PROFILES_ACTIVE=dev
# Carga variables desde .env si existe
if [ -f .env ]; then
  set -o allexport
  source .env
  set +o allexport
fi
./gradlew bootRun

