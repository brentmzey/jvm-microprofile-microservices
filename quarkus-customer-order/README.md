# Quarkus Customer-Order Service

This project is a demonstration of a simple microservice built with Quarkus, mixing Java and Kotlin. It follows a standard Resource-Service-Repository pattern.

- **Framework**: Quarkus
- **Languages**: Java & Kotlin
- **Build Tool**: Gradle
- **Databases**:
  - PostgreSQL for Customer data
  - MongoDB for Order data

## Architecture

- `CustomerResource.kt`: A Kotlin-based JAX-RS endpoint for handling web requests.
- `CustomerService.kt`: A Kotlin-based service class containing business logic.
- `CustomerRepository.java`: A Java-based Panache repository for `Customer` entities (PostgreSQL).
- `OrderRepository.java`: A Java-based Panache repository for `Order` documents (MongoDB).
- `Customer.java`: A Java-based JPA entity with Lombok.
- `Order.java`: A Java-based MongoDB entity with Lombok.

## Prerequisites

- Java 21+
- Gradle 8.5+
- Docker and Docker Compose (for running databases)

## Configuration

The application is configured via `src/main/resources/application.properties`. It uses environment variables to define database connections, with sensible defaults for local development.

| Environment Variable | Default Value                        |
| -------------------- | ------------------------------------ |
| `POSTGRES_USER`      | `user`                               |
| `POSTGRES_PASSWORD`  | `password`                           |
| `POSTGRES_URL`       | `jdbc:postgresql://localhost:5430/quarkus_db` |
| `MONGO_URL`          | `mongodb://localhost:27015`          |
| `MONGO_DB_NAME`      | `quarkus_order_db`                   |

To run the required databases, a `docker-compose.yml` file is provided in the parent directory.

## Running the Application

1.  **Start the databases**:
    From the `jvm-microprofile-microservices` parent directory, run:
    ```bash
    docker-compose up -d
    ```

2.  **Run the application in development mode**:
    ```bash
    ./gradlew quarkusDev
    ```
    The application will be available at `http://localhost:8080`.

3.  **Build the application**:
    ```bash
    ./gradlew build
    ```

## API Endpoints

- `GET /customers`: Get all customers.
- `GET /customers/{id}`: Get a customer by ID.
- `POST /customers`: Create a new customer.
  ```json
  {
    "name": "New Customer",
    "email": "new@customer.com"
  }
  ```
- `GET /customers/{id}/orders`: Get all orders for a customer.
- `POST /customers/{id}/orders`: Create a new order for a customer.
  ```json
  {
    "description": "A new gadget",
    "total": 99.99,
    "date": "2025-10-02"
  }
  ```