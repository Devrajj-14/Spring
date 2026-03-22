# Spring Boot Hello REST API Messaging App

A Spring Boot REST API that demonstrates different HTTP methods (GET, POST, PUT) and returns hello messages.

## Tech Stack

- **Language**: Java 21
- **Framework**: Spring Boot 3.4.4
- **Build Tool**: Maven
- **Dependencies**: Spring Web

## Project Structure

```
Spring/
├── pom.xml                                              # Maven build file with spring-boot-starter-web
├── src/
│   ├── main/
│   │   ├── java/com/bridgelabz/spring/
│   │   │   ├── SpringApp.java                           # Main application class (@SpringBootApplication)
│   │   │   ├── controller/
│   │   │   │   └── HelloController.java                 # REST Controller with all API endpoints
│   │   │   └── dto/
│   │   │       └── UserDTO.java                         # DTO bean with firstName and lastName
│   │   └── resources/
│   │       └── application.properties                   # Application configuration
│   └── test/
│       └── java/com/bridgelabz/spring/
│           └── SpringAppTests.java                      # Spring Boot test class
└── .gitignore                                           # Git ignore rules
```

## What Each File Does

| File | Description |
|------|-------------|
| `pom.xml` | Maven project configuration with Spring Boot parent and `spring-boot-starter-web` dependency |
| `SpringApp.java` | Entry point of the application. Uses `@SpringBootApplication` annotation. Placed in base package for component scanning |
| `HelloController.java` | `@RestController` that defines all 5 REST API endpoints (UC1–UC5) |
| `UserDTO.java` | Data Transfer Object with `firstName` and `lastName` fields, used as `@RequestBody` in the POST endpoint |
| `application.properties` | Spring Boot configuration file |
| `SpringAppTests.java` | Default test class for context loading |

## Use Cases and API Endpoints

| UC | HTTP Method | Endpoint | Description | Example Response |
|----|-------------|----------|-------------|------------------|
| UC1 | `GET` | `/hello` | Returns a simple hello message | `Hello from BridgeLabz` |
| UC2 | `GET` | `/hello/query?name=Mark` | Uses `@RequestParam` to accept name | `Hello Mark from BridgeLabz` |
| UC3 | `GET` | `/hello/param/Mark` | Uses `@PathVariable` to accept name | `Hello Mark from BridgeLabz` |
| UC4 | `POST` | `/hello/post` | Uses `@RequestBody` with UserDTO (JSON) | `Hello Mark Taylor from BridgeLabz` |
| UC5 | `PUT` | `/hello/put/Mark?lastName=Taylor` | Uses `@PathVariable` + `@RequestParam` | `Hello Mark Taylor from BridgeLabz` |

## Curl Commands for Testing

```bash
# UC1 - Simple GET
curl localhost:8080/hello -w "\n"

# UC2 - GET with Query Parameter
curl localhost:8080/hello/query?name=Mark -w "\n"

# UC3 - GET with Path Variable
curl localhost:8080/hello/param/Mark -w "\n"

# UC4 - POST with JSON Body
curl -X POST -H "Content-Type: application/json" -d '{"firstName":"Mark","lastName":"Taylor"}' "http://localhost:8080/hello/post" -w "\n"

# UC5 - PUT with Path Variable and Query Parameter
curl -X PUT "localhost:8080/hello/put/Mark?lastName=Taylor" -w "\n"
```

## Git Flow Branches

| Branch | Purpose |
|--------|---------|
| `master` | Production-ready code |
| `develop` | Integration branch with all features merged |
| `feature/uc1` | GET `/hello` endpoint |
| `feature/uc2` | GET `/hello/query` with query parameter |
| `feature/uc3` | GET `/hello/param/{name}` with path variable |
| `feature/uc4` | POST `/hello/post` with request body DTO |
| `feature/uc5` | PUT `/hello/put/{firstName}` with path variable + query param |

All feature branches are kept alive after merge using `git flow feature finish -k`.

## How to Run

```bash
mvn spring-boot:run
```

The application starts on `http://localhost:8080`.
