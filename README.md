# K-PAC

K-PAC project is an application where you can store Knowledge Package and set of Knowledge Packages. 
It is a web application that is built using the Spring Framework.

## Technology Stack

* Java 8+
* Spring (JDBC, MVC)
* Maven
* Database - MySQL 8.0.31
* Server - Apache Tomcat
* JSP (JSTL, EL)
* DHTMLX 7 (grid)
* Bootstrap 5
* HTML 5
* JavaScript

## Installation

1. Clone this repository
2. Create database in MySQL with `data.sql` file in `src/main/resources` folder
3. Fill the database with `data.sql` file in `src/main/resources` folder
4. Open the project in your IDE
5. Pass environment variables to the project (if you want, you can use `application.properties` file)
    * `MYSQL_URL` - database url
    * `MYSQL_USER` - database username
    * `MYSQL_PASSWORD` - database password
6. Run the project
7. Open the browser and go to `http://localhost:8080`