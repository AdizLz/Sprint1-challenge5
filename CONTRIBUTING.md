# Contribuir al proyecto Tienda Online

Gracias por querer contribuir. Aquí una guía rápida para PRs y revisiones parciales.

1. Antes de crear la PR
- Asegúrate de que el proyecto compile localmente.
- Ejecuta tests si agregaste cambios de lógica.
- No committes secretos ni `.env` reales.

2. Pull Requests y revisiones parciales
- Usa la plantilla `.github/PULL_REQUEST_TEMPLATE.md`.
- Para cambios grandes, abre PRs parciales y bien descritos (feature flags opcionales).
- Incluye capturas o pasos de verificación si hay cambios en la UI o endpoints.

3. Checklist mínimo para revisores
- [ ] Código claro y legible
- [ ] No introducción de credenciales en el repo
- [ ] Revisa impacto en perfiles (`dev`, `test`, `prod`)
- [ ] Revisa la configuración de variables de entorno y documentación

4. Comunicaciones
- Incluye en la PR cualquier decisión de configuración para despliegue (por ejemplo: variables obligatorias en prod).

