# School Backend API

API REST para el sistema de gestion de un colegio.
Construida con Java 17 + Spring Boot 3 + PostgreSQL.

## Tecnologias
- Java 17
- Spring Boot 3.2.4
- Spring Data JPA + Hibernate
- PostgreSQL
- Lombok
- Swagger / OpenAPI 3
- Docker
- GitHub Actions (CI/CD)

## Endpoints (15 en total)

### Teachers
- GET    /api/teachers
- GET    /api/teachers/{id}
- POST   /api/teachers
- PUT    /api/teachers/{id}
- DELETE /api/teachers/{id}

### Students
- GET    /api/students
- GET    /api/students/{id}
- POST   /api/students
- PUT    /api/students/{id}
- DELETE /api/students/{id}

### Enrollments
- GET    /api/enrollments
- GET    /api/enrollments/{id}
- POST   /api/enrollments
- PUT    /api/enrollments/{id}
- DELETE /api/enrollments/{id}

## Correr el proyecto

```bash
mvn spring-boot:run
```

## Swagger UI
http://localhost:8080/swagger-ui.html

## Ejemplo Postman

POST /api/teachers
```json
{
  "name": "Andres Martinez",
  "email": "andres@colegio.edu",
  "subject": "Matematicas",
  "phone": "3101112233"
}
```

POST /api/students
```json
{
  "name": "Camila Torres",
  "email": "camila@estudiante.edu",
  "grade": "10A"
}
```

POST /api/enrollments
```json
{
  "studentId": 1,
  "teacherId": 1
}
```
