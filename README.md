# Library Management System - Backend

- This repository is the backend of a library management system, implemented using the Spring Boot framework. 
- It handles book management, author management, and provides RESTful API endpoints to interact with the library database.

## Features

- Manage authors and their books
- Store and retrieve book details
- RESTful API for accessing and modifying data

## Technologies Used

- Spring Boot: The framework for building the backend API.
- Spring Data JPA: For database interaction using Java Persistence API.
- MySQL: The relational database used to store library data.
- Swagger: API documentation and testing tool.
- Lombok: For reducing boilerplate code (e.g., getters, setters, etc.).
- Mapstruct: For mapping DTOs to the relevant entities and vice versa

## Setup

### Prerequisites

- Java 17+ (or the version compatible with your Spring Boot version)
- Maven for building the project
- MySQL for the database

#### 1. Clone the Repository
- Clone the repository to your local machine:

```
git clone https://github.com/Madhavi96/library-management-backend.git
cd library-management-backend
```

#### 2. Setup MySQL Database
- Use Docker to spin up a mysql container.

- Create a database called library (or modify the application.properties for a different name).

```
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=library -p 3306:3306 -d mysql:latest
```

- As an additional step, we can also open a terminal session inside the mysql-container, to check the database and tables.

```
docker exec -it mysql-container mysql -u root -p
```
- After authenticating with the password, below commands can be used to interact with the database and tables.

```
use library;
show tables;
```


#### 3. Configure the database credentials in src/main/resources/application.properties file:

```
spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=root
spring.datasource.password=root
```

#### 4. Build and Run the Application

- To run the application, use the following command:

```
mvn spring-boot:run
```

- The application will start on the default port 8080. You can change this in the application.properties if needed.

#### 5. Swagger API Documentation
The backend exposes API documentation via Swagger UI. Once the application is running, visit:

```
http://localhost:8080/swagger-ui/
```
This will show the API endpoints with details on how to interact with them.

![Screenshot (77)](https://github.com/user-attachments/assets/020b8c8e-97a5-4399-a284-cf899d94ef22)
