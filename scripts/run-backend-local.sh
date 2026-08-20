#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
BACKEND_DIR="$SCRIPT_DIR/../backend"
ENV_FILE="$BACKEND_DIR/.env"

if [ ! -f "$ENV_FILE" ]; then
  echo "No existe $ENV_FILE. Crea uno con DB_HOST, DB_PORT, DB_NAME, DB_USER, DB_PASSWORD." >&2
  exit 1
fi

set -a
source "$ENV_FILE"
set +a

cd "$BACKEND_DIR"
./mvnw spring-boot:run -Dspring-boot.run.profiles="${SPRING_PROFILES_ACTIVE:-local}"
