# Mopo Backend (Spring Boot) - Cadastro de Cliente

Projeto minimal para cadastro de clientes (API REST).

## Como executar

Requisitos: Java 17+, Maven

```bash
mvn spring-boot:run
```

A API ficará disponível em `http://localhost:8080/api/clientes`.
H2 Console: `http://localhost:8080/h2-console` (JDBC URL: jdbc:h2:mem:mopo)

Endpoints:
- POST /api/clientes  (cadastrar)
- GET  /api/clientes  (listar)
