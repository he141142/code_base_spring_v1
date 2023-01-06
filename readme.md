# Table of contents

- [INSTALLATION GUIDE:](#installation-guide)
    - [DOCKER](#docker)
    - [START PGADMIN4](#start-pgadmin4)
    - [Config application.yalm:](#config-applicationyalm)
    - [Start your application](#start-your-application)
    
# INSTALLATION GUIDE:
## DOCKER

using cmd:
```shell
    docker pull
    docker compose-up -d
```

Note: *config `docker-compose.yml` by yourself*

docker-compose.yml:

```yaml
version: "3.9"
services:
  postgres:
    container_name: postgres-14
    #    image: postgres:latest
    image: postgres:latest
    restart: unless-stopped
    ports:
      - "5432:5432"
    volumes:
      - ./create-databases.sh:/docker-entrypoint-initdb.d/create-databases.sh
      - ./db_persist:/var/lib/postgresql/data
    environment:
      - POSTGRES_HOST_AUTH_METHOD=trust
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=postgres
      - POSTGRES_DB=long_db
    hostname: postgres
  pgadmin:
    container_name: pgadmin4
    image: dpage/pgadmin4:6.12
    restart: unless-stopped
    ports:
      - "8088:80"
    environment:
      - POSTGRES_HOST_AUTH_METHOD=trust
      - PGADMIN_DEFAULT_EMAIL=long@vmo.net
      - PGADMIN_DEFAULT_PASSWORD=123456a@
    hostname: pgadmin
```

## START PGADMIN4
- open browser then type `localhost:{pgadmin-port}` then login to use

## Config application.yalm:
- apply your config  [application.yaml](/src/main/resources/application.yaml)

## Start your application
```shell
./gradlew bootRun
```
using maven:
```shell
./mvnw spring-boot:run
```

using springboot cli:
```shell
spring run app.groovy
```

If dont have the tool, install [here](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#getting-started-installing-the-cli)