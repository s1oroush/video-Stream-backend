# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


Starting by using Spring Initializr and for building application using Maven build with Java 17.
then using project Lombok as developer tools and Spring Reactive Web for web application.
For Database, we used Spring Data JPA and H2 in memory Database.
For test the application, at the initializing the app one sample video is added into db and has access by (http://localhost:8083/video/sample) 



For running in frondEnd you need to have Node.js for react installed.
For creating React frontend application in Spring Boot we need the following command in directory:
                   --- npx create-react-app frontend
After the app creation process is complete, we'll install Bootstrap, React Router, and reactstrap in the frontend directory:
                   --- npm install --save bootstrap@5.1 react-cookie@4.1.1 react-router-dom@5.3.0 reactstrap@8.10.0
Then we add Bootstrap's CSS file as an import in app/src/index.js:  
                   --- import 'bootstrap/dist/css/bootstrap.min.css';

after you running the process in index.html, you can add a movie and after that you can watch in online and stream it in react frontend.
you can use localhost:3000/{name of the saved file} to watch it on react web frame.
