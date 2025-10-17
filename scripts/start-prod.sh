#!/usr/bin/env bash
# start-prod.sh - inicia la app con el perfil 'prod'
set -e
export SPRING_PROFILES_ACTIVE=prod
if [ -f .env ]; then
  set -o allexport
  source .env
  set +o allexport
fi
# En producción normalmente ejecutamos el jar construido
if [ -f build/libs/tienda-online-0.0.1-SNAPSHOT.jar ]; then
  java -jar build/libs/tienda-online-0.0.1-SNAPSHOT.jar
else
  ./gradlew bootRun
fi

