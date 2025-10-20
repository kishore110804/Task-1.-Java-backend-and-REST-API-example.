# Task Manager API - Kaiburr Assessment Task 1

**Author:** Kishore  
**Date:** October 20, 2025

---

## What This Does

A REST API built with **Spring Boot** and **MongoDB** that manages task objects. Tasks represent shell commands that can be executed, with full execution history tracking.

**Tech Stack:** Java 17 | Spring Boot 3.2.0 | MongoDB Atlas | Maven

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/tasks` | Get all tasks |
| `GET` | `/api/tasks?id={id}` | Get task by ID |
| `PUT` | `/api/tasks` | Create/update task |
| `DELETE` | `/api/tasks/{id}` | Delete task |
| `GET` | `/api/tasks/search?name={name}` | Search by name |
| `PUT` | `/api/tasks/{id}/execute` | Execute command |

---

## Quick Start

```bash
git clone https://github.com/kishore110804/Task-1.-Java-backend-and-REST-API-example..git
cd Task-1.-Java-backend-and-REST-API-example.
mvn clean install
mvn spring-boot:run
```

**Access:** http://localhost:8080/swagger-ui.html

---

## Screenshots

### Create Task
![Create Task](screenshots/01-create-task.png)

### Get All Tasks
![Get All Tasks](screenshots/02-get-all-tasks.png)

### Get Task by ID
![Get Task by ID](screenshots/03-get-task-by-id.png)

### Search Tasks
![Search Tasks](screenshots/04-search-tasks.png)

### Execute Task
![Execute Task](screenshots/05-execute-task.png)

### Delete Task
![Delete Task](screenshots/06-delete-task.png)

---

**Features:** CRUD operations • Command execution • Search functionality • Security validation • MongoDB storage • Swagger UI documentation
