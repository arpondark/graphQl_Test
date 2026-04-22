# GraphQL Product API

Spring Boot GraphQL application for managing products with PostgreSQL and Spring Data JPA.

## Overview

This project exposes a small GraphQL API for reading products, filtering them by category, and updating stock. It also includes GraphiQL for interactive queries during development.

## Tech stack

- Java 25
- Spring Boot 4.0.5
- Spring GraphQL
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## Data model

`Product` is the only persisted entity.

| Field | Java type | Notes |
| --- | --- | --- |
| `id` | `Integer` | Auto-generated database ID |
| `name` | `String` | Product name |
| `category` | `String` | Product category |
| `price` | `Double` | Stored as a decimal value in Java |
| `stock` | `Integer` | Current inventory count |

## GraphQL schema

The schema is defined in `src/main/resources/graphql/schema.graphqls`.

### Queries

#### `getProducts`
Returns every product.

```graphql
query {
  getProducts {
    id
    name
    category
    price
    stock
  }
}
```

#### `getProductByCategory(category: String)`
Returns products that match the requested category.

```graphql
query {
  getProductByCategory(category: "Electronics") {
    id
    name
    price
    stock
  }
}
```

### Mutation

#### `updateStock(id: ID, stock: Int)`
Updates the stock value for an existing product and returns the saved product.

```graphql
mutation {
  updateStock(id: 1, stock: 25) {
    id
    name
    category
    price
    stock
  }
}
```

## Run locally

### Prerequisites

- Java 25+
- PostgreSQL running locally or remotely

### Database configuration

The application reads these environment variables:

- `DB_URL` — defaults to `jdbc:postgresql://localhost:5432/graphtest`
- `DB_USERNAME` — defaults to `postgres`
- `DB_PASSWORD` — defaults to `arpon007`

Example PowerShell setup:

```powershell
$env:DB_URL = "jdbc:postgresql://localhost:5432/graphtest"
$env:DB_USERNAME = "postgres"
$env:DB_PASSWORD = "arpon007"
```

### Build

```powershell
.\mvnw.cmd clean package
```

### Start the app

```powershell
.\mvnw.cmd spring-boot:run
```

The app starts on `http://localhost:8080`.

## Endpoints

- GraphQL endpoint: `http://localhost:8080/graphql`
- GraphiQL UI: `http://localhost:8080/graphiql`

## Configuration

Relevant settings are in `src/main/resources/application.yaml`:

- JPA `ddl-auto` is set to `update`
- SQL logging is enabled
- GraphiQL is enabled at `/graphiql`

## Testing

The project currently includes a basic Spring Boot context load test.

```powershell
.\mvnw.cmd test
```

## Notes

- `ProductDataSeeder.java` is currently commented out, so sample products are not seeded automatically.
- The GraphQL `price` field is exposed as a float in the schema, while the Java entity uses `Double`.

## Project structure

```text
src/main/java/site/shazan/graphQl/
├── GraphQlApplication.java
├── config/ProductDataSeeder.java
├── controller/ProductController.java
├── models/Product.java
├── repo/ProductRepo.java
└── service/ProductService.java
```

## License

No license has been specified for this project.Just test project By Arpon.

