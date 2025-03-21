# Market - Spring
Simple market backend for ARK using spring boot

## How to run

### setup github OAuth2
in src/main/resources/application.yml put:
```yml
spring:
  security:
    oauth2:
      client:
        registration:
          github:
            client-id: your-client-client-id
            client-secret: your-client-secret
```

---

The docker compose should setup the rest, so just run:
```
mvn spring-boot:run
```
