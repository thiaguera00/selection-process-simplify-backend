# 🎓 Student Dashboard - Backend

Este é o **backend** da aplicação **Student Dashboard**, desenvolvido em **Java com Spring Boot** e utilizando banco de dados **PostgreSQL** via **Docker**.

---

## 🚀 Tecnologias utilizadas

- [Java 21+](https://www.oracle.com/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [Docker](https://www.docker.com/)
- [Cloudinary SDK](https://cloudinary.com/documentation/java_integration) (para upload de imagens)
- [Gradle (wrapper)](https://docs.gradle.org/current/userguide/gradle_wrapper.html)

---

## ⚙️ Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- Docker + Docker Compose
- Java 21+
- Git
- (Opcional) Postman ou Insomnia para testar as rotas

---

## 🐳 Subindo o banco com Docker

1. Certifique-se de que o Docker está instalado e rodando.
2. No diretório raiz do projeto, execute:

```bash
docker-compose up -d
```
## 📁 Configuração

1. No arquivo src/main/resources/application.properties, configure as variáveis necessárias:
```bash
spring.application.name=backend
server.port=8080

# Datasource
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```
## ▶️ Rodando o projeto
Use o wrapper do Gradle incluso no projeto:
```bash
./gradlew bootRun
```
Ou rode pelo arquivo BackendApplication

## 📦 Estrutura do projeto

```bash
src
├── config
├── controller
├── dto
├── enums
├── mapper
├── model
├── repository
├── service
└── resources
    └── application.properties
```
## 📘 Observações
1. As imagens de estudantes são enviadas para o Cloudinary.
2. As disciplinas são associadas diretamente no backend por meio da rota de associação.

