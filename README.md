# 🧾 Client Microservice

This repository contains the **Customer Microservice**, responsible for managing the customer within a microservice architecrute. The microservice can allow CRUD operations, validating data with, can be integrations with other service using APIs RESTfull

---

## 🚀 Technologies Used

- **Java 21**
- **Spring Boot 3.5.0**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
- **PostgreSQL**
- **Docker / Docker Compose**
- **Lombok**
- **Swagger/OpenAPI** (API Documentation)
- **JUnit + Mockito** (For tests)

---

## 🏗️ Estrutura do Projeto

```
customer-microservice/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── dev.stepherson.customer
│   │   │       ├── application/
│   │   │       │    ├── controller/
│   │   │       │    ├── dto/
│   │   │       │    ├── mapper/
│   │   │       │    └── validation/
│   │   │       ├── domain/
│   │   │       │    ├── entity/
│   │   │       │    ├── repository/
│   │   │       │    ├── service/
│   │   │       │    │    └── impl/
│   │   │       ├── exception/
│   │   │       │    └── dto/
│   │   │       ├── util/
│   │   │       └── CustomerMicroserviceApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db
│   │            └── migration

└── ...
```

---

## ⚙️ How to Run

### Requirements

- Docker e Docker Compose installed
- Java 21+
- Maven 4.0+

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/stephersongermano/customer-microservice.git
   cd customer-microservice
   ```

2. Upload the database with Docker:

   ```bash
   docker-compose up -d
   ```

3. Run local application:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Acess API documentation:
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 🧪 Tests

Execute the tests with:

```bash
./mvnw test
```

---

## 📄 Avaible Endpoints

| Método | Endpoint        | Descrição           |
| ------ | --------------- | ------------------- |
| GET    | /customers      | Get all Customers   |
| GET    | /customers/{id} | Get a client by ID  |
| POST   | /customers      | Create a new client |
| PUT    | /customers/{id} | Update client data  |
| DELETE | /customers/{id} | Delete a client     |

---

## 🔐 Security

This microservice **does not implements authentication/authorization** directly. This should be orchestrated an API Gateway or service with external authentication (Ex: Auth service with JWT)

---

## 📦 Integration with other servies

The `customer-microservice` can be integrated with other microservises through:

- Calls HTTP REST
- Messaging (RabbitMQ, Kafka)
- API Gateway (Zuul, Spring Cloud Gateway, etc)

---

## ⚙️ Configuration file (`application.properties`)

```properties
spring.application.name=customer-microservice

# Database
spring.datasource.url=jdbc:postgresql://localhost:5544/customer_microservice
spring.datasource.username=postgres
spring.datasource.password=pgroot
spring.datasource.driver-class-name=org.postgresql.Driver

# Initialize and scripts SQL
spring.sql.init.mode=always
spring.sql.init.continue-on-error=true
spring.sql.init.platform=postgresql

# JPA and Hibernate
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format-sql=false

# Logs details
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

# Schema generation ( optional )
spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create
spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-target=create.sql
spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-source=metadata
```

---

## 🧪 Load Sample Test Data

After starting the database, you can populate it with demo clients by executing:

```bash
psql -h localhost -p 5544 -U postgres -d client_microservice -f src/main/resources/db/test-data.sql

```

---

## 🔮 Future Features

```
- Implement pagination for the client list
- Add support for partial CPF/CNPJ search using SQL `LIKE` patterns combined with a time range (e.g., creation or update timestamps), enabling efficient queries (e.g., `%1231%` within the last 30 days) without overloading the database.
- Add audit logs for client data changes
- Add OAuth2 authentication support
- Implement service-to-service authentication with JWT
- Support bulk import/export of clients via CSV
```

---

## 👨‍💻 Author

```
**Stepherson**
Java Developer and Administrative Analyst
[LinkedIn](https://www.linkedin.com/stephersongermano) | [GitHub](https://github.com/stephersongermano)
```
