# Bibliotecas - Backend

API REST con Spring Boot para gestionar bibliotecas y sus libros.

## Requisitos
- Java 17 o superior
- Maven (o el Maven Wrapper incluido: `mvnw`)

## Ejecución
```bash
./mvnw spring-boot:run        # Linux / macOS
.\mvnw spring-boot:run        # Windows
```
También se puede ejecutar desde VS Code con el Spring Boot Dashboard.

La aplicación queda en `http://localhost:8080`.

## Base de datos
H2 en memoria. Consola disponible en `http://localhost:8080/h2-console`
(JDBC URL: `jdbc:h2:mem:bibliotecasdb`).

Al iniciar se cargan datos de prueba (2 bibliotecas y 2 libros) mediante `CommandLineRunner`.

## Endpoints
| Método | Ruta | Descripción |
| --- | --- | --- |
| POST | /bibliotecas | Registra una biblioteca |
| GET | /bibliotecas | Lista las bibliotecas con sus libros |

Ejemplo de cuerpo para POST:
```json
{ "nombre": "Biblioteca Sur", "direccion": "Calle 1 #2-3", "ciudad": "Bogotá" }
```

## Estructura
`entity`, `repository`, `service`, `controller`, `dto`, `config`.

El frontend (puerto 4200) está permitido por CORS.