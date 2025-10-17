#!/usr/bin/env bash
# Script para arrancar la aplicación en Unix/macOS (usa Gradle Wrapper)
DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$DIR"
./gradlew bootRun

