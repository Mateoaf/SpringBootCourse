# Reuniones

Aplicación de gestión de reuniones y asistentes desarrollada con Spring Boot.

## Descripción

Este proyecto permite gestionar reuniones y personas asistentes, mostrando listados y permitiendo la autenticación de usuarios. Incluye endpoints REST, vistas Thymeleaf, seguridad con roles, integración con H2 en memoria y ejemplos de configuración para distintos entornos.

Como proyecto educativo y de aprendizaje, muchas de las funcionalidades no están desarrolladas al 100%.

## Características

- Listado de reuniones y asistentes.
- Listado de personas.
- Autenticación de usuarios con roles (`USER`, `API_USER`).
- Endpoints REST para reuniones y personas.
- Vistas web con Thymeleaf.
- Base de datos H2 en memoria, inicializada con scripts SQL.
- Ejemplo de integración con RabbitMQ (asíncrono).
- Endpoint Actuator personalizado.
- Configuración multi-entorno (`desarrollo`, `pruebas`, `produccion`).

## Estructura del proyecto

- `src/main/java/com/example/reuniones/`  
  Código fuente principal (controladores, servicios, modelos, configuración).
- `src/main/resources/templates/`  
  Vistas Thymeleaf (`login.html`, `reuniones.html`, `personas.html`).
- `src/main/resources/static/`  
  Archivos estáticos (`index.html`).
- `src/main/resources/application.yaml`  
  Configuración de Spring Boot y perfiles.
- `src/main/resources/schema.sql`  
  Script de creación de tablas.
- `src/main/resources/data.sql`  
  Datos de ejemplo para la base de datos.
- `src/test/java/com/example/reuniones/`  
  Pruebas unitarias.

## Requisitos

- Java 21
- Maven 3.9.x

## Instalación y ejecución

1. Clona el repositorio:
   ```sh
   git clone https://github.com/tu-usuario/reuniones.git
   cd reuniones
   ```

2. Compila y ejecuta la aplicación:
   ```sh
   ./mvnw spring-boot:run
   ```

   O bien, para Windows:
   ```sh
   mvnw.cmd spring-boot:run
   ```

3. Accede a la aplicación en [http://localhost:8080](http://localhost:8080)

## Acceso

- Página de login: `/login`
- Usuarios de ejemplo:
  - **Usuario:** `******` &nbsp; **Contraseña:** `*****` &nbsp; *(roles: USER, API_USER)*
  - **Usuario:** `currito` &nbsp; **Contraseña:** `pasapasa` &nbsp; *(rol: USER)*

## Endpoints principales

- **Web**
  - `/reuniones` — Listado de reuniones (requiere login)
  - `/personas` — Listado de personas (requiere login)
- **REST**
  - `/api/reuniones` — Listado de reuniones (requiere rol `API_USER`)
  - `/api/personas` — Listado de personas (requiere rol `API_USER`)
  - `/api/rest/reuniones` y `/api/rest/personas` — Endpoints generados por Spring Data REST
- **Actuator**
  - `/actuator/personalizado` — Endpoint personalizado

## Base de datos

- Se utiliza H2 en memoria.
- El esquema y los datos de ejemplo se cargan automáticamente desde [`schema.sql`](src/main/resources/schema.sql) y [`data.sql`](src/main/resources/data.sql).

## Seguridad

- Configurada en [`SecurityConfig`](src/main/java/com/example/reuniones/config/SecurityConfig.java).
- Acceso a endpoints REST restringido por roles.
- Login personalizado con página propia.

## Integración asíncrona

- Configuración de colas y listeners con RabbitMQ en [`AsyncConfig`](src/main/java/com/example/reuniones/config/AsyncConfig.java) y [`BuscaListener`](src/main/java/com/example/reuniones/async/BuscaListener.java).

## Personalización de perfiles

- Perfiles disponibles: `desarrollo`, `pruebas`, `produccion` (ver puertos y configuración en [`application.yaml`](src/main/resources/application.yaml)).

## Licencia

Este proyecto es solo para fines educativos y de demostración.

---

**Desarrollado con Spring Boot
