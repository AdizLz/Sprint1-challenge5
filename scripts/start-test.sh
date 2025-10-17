#!/usr/bin/env bash
# start-test.sh - inicia la app con el perfil 'test'
set -e
export SPRING_PROFILES_ACTIVE=test
if [ -f .env ]; then
  set -o allexport
  source .env
  set +o allexport
fi
./gradlew bootRun

