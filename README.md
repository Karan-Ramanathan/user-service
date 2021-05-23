# User Service Application

## Requirements

For building and running the application you will need:

- An IDE (preferably IntelliJ)
- [JDK 1.13](https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5672538.html)
- [Maven 3](https://maven.apache.org)
- To test the API endpoints, A tool like [Postman](https://www.postman.com/downloads/)


## Setting up the environment

- For the persistence layer,h2 database has been used.
- H2 is an embedded database so it does not persist records between each restart of the application.
- To insert a records into the table run the below query:
```
insert into User values ('abc@gmail.com', 'password', 'First', 'Last');
```
- Database is now setup and ready to accept user records!

## Running the Application

- To run the application, navigate to src/main/java/com.example.user/UserApplication
- Simply click on the Run button, to activate the application.


## Assumptions made while developing this Application

- 3 API's are defined in this application - a method to retrieve a user from the persistence layer, a method to create a new user, a method to update a user based on email and deleting a user.
- Appropriate exceptions have been added to address conflicts and resource not found issues.