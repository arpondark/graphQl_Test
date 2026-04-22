# GraphQL Product API

A Spring Boot GraphQL application for managing products with a PostgreSQL database. This project demonstrates a modern GraphQL API implementation using Spring Boot 4.0.5 with integrated database operations.

## Project Overview

This application provides a GraphQL interface for querying and managing product information. It uses Spring Data JPA for database operations and PostgreSQL as the primary data store. The application includes GraphiQL interface for interactive query testing.

## Features

- GraphQL API for product queries
- PostgreSQL database integration
- GraphiQL interface for interactive queries
- Product management with filtering by category
- RESTful configuration with Spring Boot

## Technology Stack

- Java 25
- Spring Boot 4.0.5
- Spring Data JPA
- Spring GraphQL
- PostgreSQL Database
- Lombok
- Maven

## Project Structure

```
graphQl/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── site/shazan/graphQl/
│   │   │       ├── GraphQlApplication.java          # Main application entry point
│   │   │       ├── config/
│   │   │       │   └── ProductDataSeeder.java       # Database initialization
│   │   │       ├── controller/
│   │   │       │   └── ProductController.java       # GraphQL controller
│   │   │       ├── models/
│   │   │       │   └── Product.java                 # Product entity
│   │   │       ├── repo/
│   │   │       │   └── ProductRepo.java             # Data repository
│   │   │       └── service/
│   │   │           └── ProductService.java          # Business logic
│   │   └── resources/
│   │       ├── application.yaml                     # Configuration file
│   │       └── graphql/
│   │           └── schema.graphqls                  # GraphQL schema definition
│   └── test/
│       └── java/site/shazan/graphQl/
│           └── GraphQlApplicationTests.java         # Application tests
└── pom.xml                                          # Maven configuration

```

## Database Schema

### Product Entity

| Field    | Type   | Description          |
|----------|--------|----------------------|
| id       | ID     | Unique identifier    |
| name     | String | Product name         |
| category | String | Product category     |
| price    | Float  | Product price        |
| stock    | Int    | Available stock      |

## GraphQL Schema

### Queries

#### getProducts
Returns a list of all available products.

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

#### getProductByCategory
Returns products filtered by category.

```graphql
query {
  getProductByCategory(category: "Electronics") {
    id
    name
    category
    price
    stock
  }
}
```

## Getting Started

### Prerequisites

- Java 25 or higher
- PostgreSQL 12 or higher
- Maven 3.6 or higher

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd graphQl
```

2. Configure database connection in `application.yaml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/graphtest
    username: postgres
    password: arpon007
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Usage

### GraphiQL Interface

Access the interactive GraphQL interface at:
```
http://localhost:8080/graphiql
```

This provides a web-based IDE for writing and testing GraphQL queries.

### API Endpoint

The GraphQL API endpoint is available at:
```
http://localhost:8080/graphql
```

### Example Queries

1. Get all products:
```graphql
{
  getProducts {
    id
    name
    category
    price
    stock
  }
}
```

2. Get products by category:
```graphql
{
  getProductByCategory(category: "Electronics") {
    id
    name
    price
  }
}
```

## Configuration

The application configuration is managed through `application.yaml`:

```yaml
spring:
  application:
    name: graphQl
  datasource:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/graphtest}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:arpon007}
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    open-in-view: false
    properties:
      hibernate:
        format_sql: true
    show-sql: true
  graphql:
    graphiql:
      enabled: true
      path: /graphiql
```

### Environment Variables

You can override default database configuration using environment variables:

- `DB_URL`: Database connection URL
- `DB_USERNAME`: Database username
- `DB_PASSWORD`: Database password

## Development

### Building

```bash
mvn clean build
```

### Testing

Run the test suite:
```bash
mvn test
```

### Logging

SQL queries and Hibernate operations are logged at DEBUG and TRACE levels. Check the configuration in `application.yaml` for logging settings.

## Troubleshooting

### Database Connection Issues

Ensure PostgreSQL is running and accessible:
```bash
psql -U postgres -d graphtest
```

### GraphQL Schema Not Found

Verify that `schema.graphqls` exists in `src/main/resources/graphql/`

### Port Already in Use

Change the server port in `application.yaml`:
```yaml
server:
  port: 8081
```

## Dependencies

Key dependencies used in this project:

- **spring-boot-starter-data-jpa**: JPA/Hibernate support
- **spring-boot-starter-graphql**: Spring GraphQL integration
- **spring-boot-starter-webmvc**: Spring MVC support
- **postgresql**: PostgreSQL JDBC driver
- **lombok**: Annotation processing for boilerplate reduction

## License

This project is provided as-is without any specific license.

## Support

For issues or questions, please refer to:
- Spring Boot Documentation: https://spring.io/projects/spring-boot
- Spring GraphQL Documentation: https://spring.io/projects/spring-graphql
- GraphQL Documentation: https://graphql.org/learn/

## Notes

- The application uses Hibernate's automatic schema updates (ddl-auto: update)
- GraphiQL is enabled by default for development convenience
- Lombok is used to reduce boilerplate code
- The project follows Spring Boot best practices and conventions

