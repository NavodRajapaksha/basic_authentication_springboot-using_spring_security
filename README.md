# Spring Security Starter

A Spring Boot project demonstrating Spring Security fundamentals including custom `AuthenticationProvider`, BCrypt password encoding, role-based authorization, and database-backed user authentication with MySQL.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Lombok

---

## Getting Started

### Prerequisites

- Java 17+
- MySQL running on `localhost:3306`

### Setup

1. Clone the repository
   ```bash
   git clone https://github.com/NavodRajapaksha/basic_authentication_springboot-using_spring_security.git
   ```

2. Update `application.yaml` with your MySQL credentials

3. Run the application
   ```bash
   ./mvnw spring-boot:run
   ```

> Database will be created automatically on first run.

---

## API Endpoints

### Public Routes

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/user/register` | Register a new user |
| GET | `/api/v1/notice/my-notice` | Get notices |

### Protected Routes (Authentication Required)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/account/my-account` | Get account details |
| GET | `/api/v1/loan/my-loan` | Get loan details |

---

## How Authentication Works

1. User registers via `/api/v1/user/register` — password is hashed using **BCrypt**
2. On login, the custom `AuthenticationProvider` fetches the user from MySQL by email
3. Password is verified against the stored hash
4. Role-based authorities are granted upon successful authentication

---

## Register Request Example

```json
POST /api/v1/user/register

{
  "name": "Navod",
  "email": "navod@example.com",
  "password": "1234",
  "role": "ROLE_USER"
}
```
