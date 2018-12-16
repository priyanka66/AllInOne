**ALL IN ONE**

A web application that hosts a wide range of products across different areas from where people can purchase/view the product of their choice. Minimize the time spent looking for stuff across platforms as everything is found in
one place. 

**Prerequisites**

```
Java 8 or above

MySQL server

Maven 
```

**Installing**

Any IDE that supports Maven Spring framework 

Create a database with the username and password in MySQL

In applications.properties file of the project update the necessary fields.

```
spring.jpa.hibernate.ddl-auto=create  
spring.datasource.url=jdbc:mysql://localhost:3306/db_example
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
```

**Commands**

Instal all the package (Maven installed)
```
mvn clean package 
```
Maven not installed 
```
./mvnw clean package 
```

Run the project  (Maven installed)

```
mvn spring-boot:run

```

Maven not installed 
```
./mvnw spring-boot:run

```
