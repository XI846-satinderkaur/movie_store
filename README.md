# Spring Boot Application

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to use for development of new Spring Applications (version 2.x)
* 	[MySQL](https://www.mysql.com/) - Open-Source Relational Database Management System (Version 5.6)

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

## To-Do

- [x] Logger (Console, File)
- [x] RESTful Web Service (CRUD)
- [X] MySQL (Connect to Single Schemas)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `MoviestoreApplication` class from your IDE.

- Take the updated code.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
###Swagger 
Project also has the swagger configuration to check all the API's
Link for swagger : 'http://localhost:8080/swagger-ui.html#/'

### Actuator

To access the application

|  URL                                                                                 |  Method |
|--------------------------------------------------------------------------------------|---------|
|`http://localhost:8080/movie/v1/movies'  						                       |   GET   |
|`http://localhost:8080/movie/v1/movies/{id}'                                          |   GET   |
|`http://localhost:8080/movie/v1/movies'    	                                       |   POST  |
|`http://localhost:8080/movie/v1//movies/{id}'                                         |   DELETE|



## Files and Directories

The project moviestore has a particular directory structure. A representative project is shown below:

```
.
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── com.tech.india.moviestore
│           ├── com.tech.india.moviestore.controller
│           ├── com.tech.india.moviestore.entity
│           ├── com.tech.india.moviestore.repository
│           ├── com.tech.india.moviestore.service
│           ├── com.tech.india.moviestore.exception
├── src
│   └── main
│       └── resources
│           ├── application.properties
├── src
│   └── test
│       └── java
│           └── com.tech.india.moviestore
├── JRE System Library
├── Maven Dependencies
├── src
├── target
│   └──application-0.0.1-SNAPSHOT
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
