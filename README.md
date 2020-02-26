# spring-restful-webservice

## social-media
  
  ### Service URLS
    - GET http://localhost:8080/users
    - POST http://localhost:8080/users
    - GET http://localhost:8080/users/1
    - DELETE http://localhost:8080/users/3
    
  ### Swagger URLS
    - http://localhost:8080/v2/api-docs
    - http://localhost:8080/swagger-ui.html
    
  ### Actuator URLS
    - http://localhost:8080/actuator
    - http://localhost:8080 (http://localhost:8080/browser/index.html)

  ### H2 Console
    - http://localhost:8080/h2-console
    JDBC URL = jdbc:h2:mem:testdb
    
  ### Urls Without JPA
    - GET http://localhost:8080/users
    - GET http://localhost:8080/users/{id}
    - POST http://localhost:8080/users
    - DELETE http://localhost:8080/users/{id}
   
  ### Urls With JPA
    - GET http://localhost:8080/jpa/users
    - GET http://localhost:8080/jpa/users/{id}
    - POST http://localhost:8080/jpa/users
    - DELETE http://localhost:8080/jpa/users/{id}
    - GET http://localhost:8080/jpa/users/{id}/posts
    - POST http://localhost:8080/jpa/users/{id}/posts
