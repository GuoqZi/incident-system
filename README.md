# Incident Management Application

## Overview
This application is designed for incident management, allowing users to create, read, update, and delete incidents.

## Setup
1. Clone the repository: `git clone https://github.com/yourusername/incident-management.git`
2. Navigate to the project directory: `cd incident-management`
3. Run the application: `./mvnw spring-boot:run`

## Tech Stack
- Java
- Spring Boot
- SQLite
- JPA
- Docker

## API Documentation
-  GET /incidents: 
Returns a list of all incidents.

-  GET /incidents/{id}: 
Returns an incidents.

-  PUT /incident: 
Creates a new incident with the provided data.

-  POST /incident: 
Update an incident with the provided data.

-  DELETE /incidents/{id}: 
Delete an incident.


## Unit Tests
UTs are performed with 
1. JUnit for single functions.
2. Postman for API testing. evidence could be found in folder src/test/manual_test_files.


## Stress Tests
it is performed with JMeter.
evidence and statics could be found in folder src/test/manual_test_files.


## Known Issues
~~- initialization of SQLite database is not working properly.
   initialization file of schema.sql cannot be executed, therefore indexing is not created. table structure is created with wrong data types.~~
- a global Exception Handling class is not implemented.
- warnings are not resolved.
- stress test should be performed with docker container.


## Main Dependencies
-  Spring Boot Data JPA Starter (org.springframework.boot:spring-boot-starter-data-jpa): 
Simplifies the development of data access layers using Spring Data JPA by providing autoconfiguration and default implementations.
-  Spring Boot Web Starter (org.springframework.boot:spring-boot-starter-web): 
   Includes all the dependencies required to build a Spring Boot web application, such as Spring Web and an embedded Tomcat server.
-  Spring Boot Test Starter (org.springframework.boot:spring-boot-starter-test):  Provides dependencies for writing and running tests, including JUnit, Hamcrest, Mockito, etc.
-  Spring Boot Validation Starter (org.springframework.boot:spring-boot-starter-validation): 
Provides the Bean Validation API implementation, such as Hibernate Validator, for validating entity objects.
-  SQLite JDBC Driver (org.xerial:sqlite-jdbc): 
Provides a JDBC driver for connecting to SQLite databases, suitable for development environments or lightweight applications.

