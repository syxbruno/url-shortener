![Java](https://img.shields.io/badge/JAVA-E65100?style=for-the-badge&labelColor=FFFFFF)
![Spring](https://img.shields.io/badge/SPRING-4CAF50?style=for-the-badge&labelColor=FFFFFF)
![Maven](https://img.shields.io/badge/MAVEN-0074D9?style=for-the-badge&labelColor=FFFFFF)
![Docker](https://img.shields.io/badge/DOCKER-0074D9?style=for-the-badge&labelColor=FFFFFF)
![PostgreSQL](https://img.shields.io/badge/POSTGRESQL-316192?style=for-the-badge&labelColor=FFFFFF)
![Flyway](https://img.shields.io/badge/FLYWAY-C92626?style=for-the-badge&labelColor=FFFFFF)

# url-shortener

Monolithic project that works as a URL shortener, developed with Java and Spring Boot.  
Allows shortening long URLs with automatic expiration and redirection to the original URL.

---

## Project Overview

The application is built on the Spring Boot ecosystem, using JPA for persistence, validation, and a REST architecture to expose services.  
PostgreSQL is used as the database to store URLs and manage their expiration, with migrations handled by Flyway.  
Docker images are built using Google JIB, removing the need for a Dockerfile.

A scheduled job runs daily at 12 PM to check and clean expired URLs automatically.

---

## Tech Stack

| Category           | Technology                                     |
|--------------------|------------------------------------------------|
| **Language**       | Java 21                                        |
| **Frameworks**     | Spring (JPA, Validation, Web, DevTools)        |
| **Database**       | PostgreSQL                                     |
| **Migrations**     | Flyway                                         |
| **Containerization**| Docker, Google JIB                             |

---

## API Endpoints

### LinkController

`POST /shorten`Receives a JSON body with the field `"url"` and returns the shortened link.  
`GET /{code}` Redirects to the original URL associated with the short code.  

---

## Features

URL shortening with automatic expiration (default set in months).  
Scheduled daily job to check and remove expired URLs.

---

## How to Run

1. **Clone the repository:**

   ```bash
   git clone https://github.com/syxbruno/url-shortener.git
   cd authentication-project

2. **Build the Docker image of the API:**

   ```bash
   mvn compile jib:dockerBuild

3. **Start the containers:**

   ```bash
   docker-compose up
