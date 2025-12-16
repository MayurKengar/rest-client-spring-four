# RestClientProducer

A Spring Boot REST API producer application using H2 in-memory database.

## Features
- RESTful endpoints for Employee management
- H2 in-memory database with web console
- JPA/Hibernate integration
- Global exception handling

## Requirements
- Java 17 or higher
- Maven 3.6+

## Getting Started

### Build
```
mvn clean package
```

### Run
```
mvn spring-boot:run
```
Or run the jar:
```
java -jar target/rest-client-producer-*.jar
```

### API Base URL
```
http://localhost:9090/producer-app/
```

### H2 Console
- URL: [http://localhost:9090/producer-app/h2-console](http://localhost:9090/producer-app/h2-console)
- JDBC URL: `jdbc:h2:mem:producer-app`
- User: `sa`
- Password: (leave blank)

## Configuration
See `src/main/resources/application.yaml` for all configuration options:
- `server.port`: 9090
- `server.servlet.context-path`: /producer-app
- `spring.datasource.url`: jdbc:h2:mem:producer-app
- `spring.h2.console.enabled`: true

## Testing
Run all tests:
```
mvn test
```

## Project Structure
- `src/main/java/com/rest/client/producer/` - Main source code
- `src/main/resources/` - Configuration files
- `src/test/java/` - Tests

## License
This project is for demonstration and educational purposes.

