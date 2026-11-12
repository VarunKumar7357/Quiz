# Quiz Application – Spring Boot Microservices

A Quiz Application built using **Spring Boot Microservices** that demonstrates service discovery, inter-service communication, and REST API development.

The application consists of independent microservices that communicate with each other to manage questions and quizzes.

## Architecture

```text
                 Client / Postman
                        |
                +---------------+
                |  Quiz Service |
                +---------------+
                        |
                  OpenFeign Client
                        |
                +-----------------+
                | Question Service|
                +-----------------+

                        |
                +-----------------+
                | Service Registry|
                |  (Eureka Server)|
                +-----------------+
```

## Microservices

### 1. Question Service
Responsible for managing quiz questions.

Responsibilities:
- Manage questions.
- Retrieve questions from the database.
- Provide REST APIs for question-related operations.
- Communicate with Quiz Service.

### 2. Quiz Service
Responsible for managing quizzes.

Responsibilities:
- Create quizzes.
- Retrieve questions from Question Service.
- Generate quizzes using available questions.
- Calculate quiz scores.
- Provide REST APIs for quiz-related operations.

### 3. Service Registry
Uses Netflix Eureka for service discovery.

Responsibilities:
- Register microservices.
- Maintain information about registered services.
- Allow services to discover and communicate with each other.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Spring Boot | Microservice development |
| Spring Cloud | Microservices infrastructure |
| Netflix Eureka | Service discovery |
| OpenFeign | Inter-service communication |
| Spring Data JPA | Database operations |
| Hibernate | ORM |
| REST APIs | Service communication |
| Maven | Dependency management |
| SQL Database | Data persistence |
| Postman | API testing |

## Project Structure

```text
Quiz/
│
├── question-service/
│   ├── src/
│   └── pom.xml
│
├── quiz-service/
│   ├── src/
│   └── pom.xml
│
├── service-registry/
│   ├── src/
│   └── pom.xml
│
├── README.md
└── .gitignore
```

## How the Application Works

1. Start the Service Registry (Eureka Server).
2. Start the Question Service, which registers itself with Eureka.
3. Start the Quiz Service, which also registers itself with Eureka.
4. Quiz Service communicates with Question Service using OpenFeign.
5. Clients interact with the application through the REST APIs exposed by the services.
6. Quiz Service retrieves questions and processes quiz-related operations.

## Key Concepts Demonstrated

- Microservices Architecture
- Service Discovery using Netflix Eureka
- Inter-Service Communication using OpenFeign
- RESTful API Development
- Spring Data JPA and Hibernate
- Database Integration
- Independent Service Development and Execution
- API Testing using Postman

## Running the Project

Run the services in the following order:

1. Service Registry
2. Question Service
3. Quiz Service

Make sure the database configurations and service ports are correctly configured in each service's `application.properties` file.

## API Testing

Use Postman to test the REST APIs exposed by Question Service and Quiz Service.

## Author

**Gajjala Varun Kumar**

GitHub: [VarunKumar7357](https://github.com/VarunKumar7357)

## License

This project is available under the MIT License.
