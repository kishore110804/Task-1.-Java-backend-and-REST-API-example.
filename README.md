# Task Manager API - Kaiburr Assessment Task 1# Task 1: Java REST API with MongoDB# Task 1: Java REST API with MongoDB# Task Manager API - Kaiburr Assessment Task 1



**Author:** Kishore  

**Date:** October 20, 2025

**Author:** Kishore  

---

**Date:** October 20, 2025

## What This Does

**Kaiburr Technical Assessment - Task 1**  ![Java](https://img.shields.io/badge/Java-17-orange)

A REST API built with **Spring Boot** and **MongoDB** that manages task objects. Tasks represent shell commands that can be executed, with full execution history tracking.

---

**Tech Stack:** Java 17 | Spring Boot 3.2.0 | MongoDB Atlas | Maven

**Author:** Kishore  ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)

---

## 📋 Overview

## API Endpoints

**Date:** October 20, 2025![MongoDB](https://img.shields.io/badge/MongoDB-7.0-brightgreen)

| Method | Endpoint | Description |

|--------|----------|-------------|A RESTful web service built with **Spring Boot** and **MongoDB** that manages task objects. Tasks represent shell commands that can be executed, with full execution history tracking stored in the database.

| `GET` | `/api/tasks` | Get all tasks |

| `GET` | `/api/tasks?id={id}` | Get task by ID |![Maven](https://img.shields.io/badge/Maven-3.9+-blue)

| `PUT` | `/api/tasks` | Create/update task |

| `DELETE` | `/api/tasks/{id}` | Delete task |---

| `GET` | `/api/tasks/search?name={name}` | Search by name |

| `PUT` | `/api/tasks/{id}/execute` | Execute command |---



---## 🛠️ Tech Stack



## Quick Start## 📋 Overview



```bash- Java 17

git clone https://github.com/kishore110804/Task-1.-Java-backend-and-REST-API-example..git

cd Task-1.-Java-backend-and-REST-API-example.- Spring Boot 3.2.0## 📋 Overview

mvn clean install

mvn spring-boot:run- Spring Data MongoDB

```

- MongoDB Atlas (Cloud Database)A RESTful API for managing and executing shell commands in tasks. Each task represents a shell command that can be executed, with full execution history tracking. Built with Spring Boot and MongoDB for the Kaiburr technical assessment.

**Access:** http://localhost:8080/swagger-ui.html

- Maven

---

- LombokA RESTful web service built with **Spring Boot** and **MongoDB** that manages task objects representing shell commands. The application provides endpoints for creating, reading, updating, deleting, and executing tasks, with execution history tracking.

## Demo Screenshots

- Swagger UI

### Create Task

![Create Task](screenshots/01-create-task.png)## 🎯 Features



### Get All Tasks---

![Get All Tasks](screenshots/02-get-all-tasks.png)

---

### Get Task by ID

![Get Task by ID](screenshots/03-get-task-by-id.png)## 🚀 Features



### Search Tasks- ✅ **CRUD Operations** - Create, Read, Update, Delete tasks

![Search Tasks](screenshots/04-search-tasks.png)

- ✅ Create, read, update, and delete tasks

### Execute Task

![Execute Task](screenshots/05-execute-task.png)- ✅ Execute shell commands and capture output## 🛠️ Technology Stack- ✅ **Command Execution** - Execute shell commands and track results



### Delete Task- ✅ Track execution history with timestamps

![Delete Task](screenshots/06-delete-task.png)

- ✅ Search tasks by name- ✅ **Search Functionality** - Search tasks by name (case-insensitive)

---

- ✅ Security validation to block dangerous commands

**Features:** CRUD operations • Command execution • Search functionality • Security validation • MongoDB storage • Swagger UI documentation

- ✅ REST API with JSON responses- **Java:** 17- ✅ **Execution History** - Track all command executions with timestamps and output

- ✅ MongoDB persistent storage

- **Spring Boot:** 3.2.0- ✅ **Security Validation** - Validates commands to prevent malicious code execution

---

- **Spring Data MongoDB:** Database integration- ✅ **REST API** - JSON-based REST endpoints

## 📡 API Endpoints

- **MongoDB Atlas:** Cloud database- ✅ **MongoDB Integration** - Persistent storage with MongoDB

| Method | Endpoint | Description |

|--------|----------|-------------|- **Maven:** Build tool- ✅ **API Documentation** - Swagger UI for interactive API testing

| `GET` | `/api/tasks` | Get all tasks |

| `GET` | `/api/tasks?id={id}` | Get task by ID |- **Lombok:** Reduce boilerplate code- ✅ **Cross-Platform** - Works on Windows, Linux, and macOS

| `PUT` | `/api/tasks` | Create/update task |

| `DELETE` | `/api/tasks/{id}` | Delete task |- **Swagger/OpenAPI:** API documentation

| `GET` | `/api/tasks/search?name={name}` | Search by name |

| `PUT` | `/api/tasks/{id}/execute` | Execute command |## 🏗️ Architecture



------



## ⚙️ Setup & Run```



### Prerequisites## 📊 Data ModelTask Manager API

- Java 17+

- Maven 3.9+├── Model Layer (Task, TaskExecution)



### Steps### Task Object├── Repository Layer (MongoDB integration)



1. **Clone the repository**```json├── Service Layer (Business logic & validation)

```bash

git clone https://github.com/kishore110804/Task-1.-Java-backend-and-REST-API-example..git{├── Controller Layer (REST endpoints)

cd Task-1.-Java-backend-and-REST-API-example.

```  "id": "671527abc456def789",└── Exception Handling (Global error handling)



2. **Configure MongoDB**  "name": "Print Hello World",```



Edit `src/main/resources/application.properties` with your MongoDB connection string.  "owner": "Kishore",



3. **Build & Run**  "command": "echo Hello World!",## 📊 Data Model

```bash

mvn clean install  "taskExecutions": [

mvn spring-boot:run

```    {### Task Object



Application starts at: `http://localhost:8080`      "startTime": "2025-10-20T19:30:00.000Z",```json



4. **Test API**      "endTime": "2025-10-20T19:30:00.500Z",{



Open Swagger UI: `http://localhost:8080/swagger-ui.html`      "output": "Hello World!",  "id": "123",



---      "status": "success"  "name": "Print Hello",



## 📸 Demo Screenshots    }  "owner": "John Smith",



### 1. Create Task  ]  "command": "echo Hello World!",



![Create Task](screenshots/01-create-task.png)}  "taskExecutions": [



---```    {



### 2. Get All Tasks      "startTime": "2023-04-21T15:51:42.276Z",



![Get All Tasks](screenshots/02-get-all-tasks.png)### Properties      "endTime": "2023-04-21T15:51:43.276Z",



---      "output": "Hello World!",



### 3. Get Task by ID**Task:**      "status": "success"



![Get Task by ID](screenshots/03-get-task-by-id.png)- `id` (String) - Unique task identifier    }



---- `name` (String) - Task name  ]



### 4. Search Tasks by Name- `owner` (String) - Task owner}



![Search Tasks](screenshots/04-search-tasks.png)- `command` (String) - Shell command to execute```



---- `taskExecutions` (List) - Execution history



### 5. Execute Task## 🚀 Prerequisites



![Execute Task](screenshots/05-execute-task.png)**TaskExecution:**



---- `startTime` (Date) - Execution start timestampBefore running this application, ensure you have:



### 6. Delete Task- `endTime` (Date) - Execution end timestamp



![Delete Task](screenshots/06-delete-task.png)- `output` (String) - Command output- ☑️ **Java 17 or higher** - [Download JDK](https://adoptium.net/)



---- `status` (String) - Execution status- ☑️ **Maven 3.9+** - [Download Maven](https://maven.apache.org/download.cgi)



## 🔒 Security- ☑️ **MongoDB 7.0+** - Choose one:



Commands are validated before execution. Dangerous operations are blocked:---  - **Option 1:** [MongoDB Community Edition](https://www.mongodb.com/try/download/community) (Local)

- File deletion (`rm`, `del`)

- Privilege escalation (`sudo`, `su`)  - **Option 2:** [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) (Cloud - Free Tier)

- Network operations (`curl`, `wget`)

- System control (`shutdown`, `reboot`)## 🚀 Features- ☑️ **Postman or cURL** - For API testing

- File redirection and command chaining



---

- ✅ RESTful API with 5+ endpoints### Verify Installations

## 📁 Project Structure

- ✅ CRUD operations for tasks

```

src/- ✅ Command execution with output capture```powershell

├── main/java/com/kaiburr/taskmanager/

│   ├── controller/      # REST endpoints- ✅ Execution history tracking# Check Java version

│   ├── model/          # Task & TaskExecution entities

│   ├── repository/     # MongoDB repository- ✅ Security validation for dangerous commandsjava -version

│   ├── service/        # Business logic & validation

│   └── exception/      # Error handling- ✅ MongoDB persistent storage

└── resources/

    └── application.properties- ✅ Comprehensive error handling# Check Maven version

```

- ✅ Swagger UI for API testingmvn -version

---

- ✅ Cross-platform support (Windows/Linux/Mac)

## 🎯 Implementation Highlights

# Check MongoDB (if running locally)

- **Task Model:** Contains id, name, owner, command, and taskExecutions list

- **TaskExecution Model:** Tracks startTime, endTime, and output for each execution---mongosh --version

- **Command Validation:** Blocks dangerous commands before execution

- **Error Handling:** Returns appropriate HTTP status codes (200, 201, 404, 400, 500)```

- **Cross-Platform:** Works on Windows, Linux, and macOS

## 📡 API Endpoints

---

## 🛠️ MongoDB Setup

## 📚 API Documentation

| Method | Endpoint | Description |

Interactive API documentation available at: `http://localhost:8080/swagger-ui.html`

|--------|----------|-------------|### Option 1: Local MongoDB (Recommended for Development)

---

| `GET` | `/api/tasks` | Get all tasks |

## 👤 Author

| `GET` | `/api/tasks?id={id}` | Get task by ID |1. **Install MongoDB Community Edition**

Kishore - Kaiburr Technical Assessment Task 1

| `PUT` | `/api/tasks` | Create or update task |   - Download from: https://www.mongodb.com/try/download/community

| `DELETE` | `/api/tasks/{id}` | Delete task |   - Follow installation wizard

| `GET` | `/api/tasks/search?name={name}` | Search tasks by name |

| `PUT` | `/api/tasks/{id}/execute` | Execute task command |2. **Start MongoDB Service**

   ```powershell

---   # Windows - Start MongoDB service

   net start MongoDB

## 🔧 Prerequisites   

   # Or run manually

- Java 17 or higher   mongod --dbpath C:\data\db

- Maven 3.9+   ```

- MongoDB Atlas account (free tier) or local MongoDB

3. **Verify MongoDB is Running**

---   ```powershell

   mongosh

## ⚙️ Setup Instructions   # Should connect to mongodb://localhost:27017

   ```

### 1. Clone the Repository

### Option 2: MongoDB Atlas (Cloud)

```bash

git clone https://github.com/kishore110804/Task-1.-Java-backend-and-REST-API-example..git1. **Create Free Account**

cd Task-1.-Java-backend-and-REST-API-example.   - Go to https://www.mongodb.com/cloud/atlas

```   - Sign up for free tier



### 2. Configure MongoDB2. **Create Cluster**

   - Click "Build a Database" → "Free Shared Cluster"

Edit `src/main/resources/application.properties`:   - Choose cloud provider and region

   - Click "Create Cluster"

```properties

spring.data.mongodb.uri=mongodb+srv://USERNAME:PASSWORD@cluster.mongodb.net/taskmanager?retryWrites=true&w=majority3. **Setup Database Access**

```   - Go to "Database Access" → "Add New Database User"

   - Create username and password

Replace `USERNAME` and `PASSWORD` with your MongoDB credentials.   - Set privileges to "Read and write to any database"



### 3. Build the Project4. **Setup Network Access**

   - Go to "Network Access" → "Add IP Address"

```bash   - Click "Allow Access from Anywhere" (for testing)

mvn clean install   - Add IP: `0.0.0.0/0`

```

5. **Get Connection String**

### 4. Run the Application   - Go to "Database" → "Connect" → "Connect your application"

   - Copy connection string

```bash   - Replace `<password>` with your database user password

mvn spring-boot:run

```6. **Update application.properties**

   ```properties

The application will start at `http://localhost:8080`   # Comment out local MongoDB config

   # spring.data.mongodb.host=localhost

---   # spring.data.mongodb.port=27017

   

## 🧪 Testing the API   # Add Atlas connection string

   spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/taskmanager?retryWrites=true&w=majority

### Using Swagger UI (Recommended)   ```



Open your browser: `http://localhost:8080/swagger-ui.html`## 📦 Installation & Running



### Using cURL### 1. Clone the Repository



#### Create a Task```powershell

```bashgit clone <your-repo-url>

curl -X PUT http://localhost:8080/api/tasks \cd task1

  -H "Content-Type: application/json" \```

  -d '{

    "name": "Print Hello",### 2. Configure MongoDB Connection

    "owner": "Kishore",

    "command": "echo Hello World"Edit `src/main/resources/application.properties`:

  }'

``````properties

# For Local MongoDB (default)

#### Get All Tasksspring.data.mongodb.host=localhost

```bashspring.data.mongodb.port=27017

curl http://localhost:8080/api/tasksspring.data.mongodb.database=taskmanager

```

# For MongoDB Atlas (uncomment and add your connection string)

#### Execute a Task# spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster>.mongodb.net/taskmanager

```bash```

curl -X PUT http://localhost:8080/api/tasks/{taskId}/execute

```### 3. Build the Project



---```powershell

# Clean and build

## 🔒 Security Featuresmvn clean install



The application validates all commands to prevent execution of dangerous operations:# Skip tests (if needed)

mvn clean install -DskipTests

**Blocked Commands:**```

- File operations: `rm`, `del`, `delete`, `format`

- Privilege escalation: `sudo`, `su`, `chmod`### 4. Run the Application

- Network operations: `curl`, `wget`, `nc`

- System control: `reboot`, `shutdown`, `halt````powershell

- File redirection: `>`, `>>`, `<`# Using Maven

- Command chaining: `|`, `&&`, `||`mvn spring-boot:run



---# Or using Java directly

java -jar target/task-manager-1.0.0.jar

## 📸 Screenshots```



### 1. Create Task (PUT Request)### 5. Verify Application Started



Creating a new task with name, owner, and command.You should see:

```

![Create Task](screenshots/01-create-task.png)=================================================

✅ Task Manager API Started Successfully!

---📍 Server: http://localhost:8080

📚 API Docs: http://localhost:8080/swagger-ui.html

### 2. Get All Tasks (GET Request)📊 Health Check: http://localhost:8080/actuator/health

=================================================

Retrieving all tasks from the database.```



![Get All Tasks](screenshots/02-get-all-tasks.png)## 📡 API Endpoints



---### Base URL: `http://localhost:8080/api/tasks`



### 3. Get Task by ID (GET Request)| Method | Endpoint | Description | Request Body |

|--------|----------|-------------|--------------|

Fetching a specific task using its ID.| **GET** | `/api/tasks` | Get all tasks | - |

| **GET** | `/api/tasks?id={id}` | Get task by ID | - |

![Get Task by ID](screenshots/03-get-task-by-id.png)| **PUT** | `/api/tasks` | Create/Update task | Task JSON |

| **DELETE** | `/api/tasks/{id}` | Delete task | - |

---| **GET** | `/api/tasks/search?name={name}` | Search tasks by name | - |

| **PUT** | `/api/tasks/{id}/execute` | Execute task command | - |

### 4. Search Tasks by Name (GET Request)| **GET** | `/api/tasks/{id}/executions` | Get execution history | - |



Searching for tasks containing "Hello" in the name.## 🧪 Testing with Postman/cURL



![Search Tasks](screenshots/04-search-tasks.png)### 1. Create a Task (PUT)



---**Request:**

```bash

### 5. Execute Task (PUT Request)curl -X PUT http://localhost:8080/api/tasks \

  -H "Content-Type: application/json" \

Executing the shell command and capturing the output.  -d '{

    "name": "Print Hello World",

![Execute Task](screenshots/05-execute-task.png)    "owner": "John Smith",

    "command": "echo Hello World!"

---  }'

```

### 6. Delete Task (DELETE Request)

**Response (201 Created):**

Removing a task from the database.```json

{

![Delete Task](screenshots/06-delete-task.png)  "id": "6734abc123def456",

  "name": "Print Hello World",

---  "owner": "John Smith",

  "command": "echo Hello World!",

## 📁 Project Structure  "taskExecutions": []

}

``````

src/

├── main/### 2. Get All Tasks (GET)

│   ├── java/com/kaiburr/taskmanager/

│   │   ├── TaskManagerApplication.java    # Main application**Request:**

│   │   ├── controller/```bash

│   │   │   ├── TaskController.java        # REST endpointscurl -X GET http://localhost:8080/api/tasks

│   │   │   └── HomeController.java        # Home redirect```

│   │   ├── model/

│   │   │   ├── Task.java                  # Task entity**Response (200 OK):**

│   │   │   └── TaskExecution.java         # Execution entity```json

│   │   ├── repository/[

│   │   │   └── TaskRepository.java        # MongoDB repository  {

│   │   ├── service/    "id": "6734abc123def456",

│   │   │   └── TaskService.java           # Business logic    "name": "Print Hello World",

│   │   └── exception/    "owner": "John Smith",

│   │       ├── GlobalExceptionHandler.java    "command": "echo Hello World!",

│   │       ├── InvalidCommandException.java    "taskExecutions": []

│   │       └── ResourceNotFoundException.java  }

│   └── resources/]

│       └── application.properties          # Configuration```

└── test/

    └── java/com/kaiburr/taskmanager/### 3. Get Task by ID (GET)

        └── controller/

            └── TaskControllerTest.java     # Unit tests**Request:**

``````bash

curl -X GET "http://localhost:8080/api/tasks?id=6734abc123def456"

---```



## 🎯 Implementation Highlights### 4. Search Tasks by Name (GET)



### Command Validation**Request:**

```bash

The `TaskService` class implements comprehensive validation to block potentially dangerous commands:curl -X GET "http://localhost:8080/api/tasks/search?name=Hello"

```

```java

private static final List<String> DANGEROUS_COMMANDS = Arrays.asList(### 5. Execute Task (PUT)

    "rm", "delete", "sudo", "curl", "wget", 

    "shutdown", "reboot", "format", ...**Request:**

);```bash

```curl -X PUT http://localhost:8080/api/tasks/6734abc123def456/execute

```

### Cross-Platform Execution

**Response (200 OK):**

The application automatically detects the operating system and uses the appropriate shell:```json

{

```java  "startTime": "2025-10-14T10:30:00.000Z",

if (os.contains("win")) {  "endTime": "2025-10-14T10:30:00.500Z",

    processBuilder = new ProcessBuilder("cmd.exe", "/c", command);  "output": "Hello World!",

} else {  "status": "success"

    processBuilder = new ProcessBuilder("sh", "-c", command);}

}```

```

### 6. Delete Task (DELETE)

### Error Handling

**Request:**

Global exception handler provides meaningful error messages with appropriate HTTP status codes:```bash

curl -X DELETE http://localhost:8080/api/tasks/6734abc123def456

- `404 Not Found` - Task not found```

- `400 Bad Request` - Invalid command or validation error

- `500 Internal Server Error` - Execution failure**Response (200 OK):**

```

---Task deleted successfully: 6734abc123def456

```

## 🧪 Running Tests

## 🔒 Command Validation

```bash

mvn testThe API validates all commands to prevent malicious code execution. The following are **blocked**:

```

❌ **File Operations:** `rm`, `delete`, `del`, `format`, `mkfs`  

---❌ **Privilege Escalation:** `sudo`, `su`, `chmod`, `chown`  

❌ **Network Tools:** `curl`, `wget`, `nc`, `netcat`  

## 📚 API Documentation❌ **Disk Operations:** `dd`, `fdisk`, `parted`  

❌ **Process Control:** `killall`, `pkill`  

Once the application is running, access the interactive API documentation:❌ **System Control:** `reboot`, `shutdown`, `halt`  

❌ **User Management:** `useradd`, `userdel`, `passwd`  

**Swagger UI:** `http://localhost:8080/swagger-ui.html`❌ **File Redirection:** `>`, `>>`, `<`  

❌ **Command Chaining:** `|`, `&&`, `||`  

---

**Example Safe Commands:**

## 🐛 Troubleshooting- ✅ `echo Hello World`

- ✅ `date`

### MongoDB Connection Issues- ✅ `hostname`

- ✅ `pwd`

**Error:** `MongoTimeoutException`- ✅ `whoami`

- ✅ `dir` (Windows) / `ls` (Linux)

**Solution:** 

- Verify MongoDB Atlas connection string## 📸 Screenshots

- Check IP whitelist in MongoDB Atlas

- Ensure network connectivity### Screenshot Requirements

- ✅ Include system date/time in screenshot

### Port Already in Use- ✅ Include your name (username, desktop, or editor)

- ✅ Show request and response for each endpoint

**Error:** `Port 8080 is already in use`

---

**Solution:** Change port in `application.properties`:

```properties### 1️⃣ Create Task - PUT Request

server.port=8081![Create Task](screenshots/01-create-task.png)

```*Screenshot showing PUT request to create a task with response*



------



## 🎓 What I Learned### 2️⃣ Get All Tasks - GET Request

![Get All Tasks](screenshots/02-get-all-tasks.png)

Through this project, I gained hands-on experience with:*Screenshot showing GET request to retrieve all tasks*



- Building RESTful APIs with Spring Boot---

- Integrating MongoDB with Spring Data

- Implementing security validation for user input### 3️⃣ Get Task by ID - GET Request

- Shell command execution with ProcessBuilder![Get Task by ID](screenshots/03-get-task-by-id.png)

- Global exception handling in Spring*Screenshot showing GET request with ID parameter*

- API documentation with Swagger/OpenAPI

- Writing maintainable and well-structured code---



---### 4️⃣ Search Tasks by Name - GET Request

![Search Tasks](screenshots/04-search-tasks.png)

## 📝 Notes*Screenshot showing search functionality*



- All commands are validated before execution to prevent security vulnerabilities---

- Execution timeout is set to 30 seconds to prevent long-running commands

- The application uses MongoDB Atlas (cloud database) for easy deployment### 5️⃣ Execute Task - PUT Request

- CORS is enabled for frontend integration (Task 3)![Execute Task](screenshots/05-execute-task.png)

*Screenshot showing task execution and output*

---

---

## 🔗 Repository

### 6️⃣ Get Execution History - GET Request

**GitHub:** https://github.com/kishore110804/Task-1.-Java-backend-and-REST-API-example.![Execution History](screenshots/06-execution-history.png)

*Screenshot showing task execution history*

---

---

## 👤 Author

### 7️⃣ Delete Task - DELETE Request

**Kishore**  ![Delete Task](screenshots/07-delete-task.png)

Kaiburr Technical Assessment  *Screenshot showing task deletion*

October 2025

---

---

### 8️⃣ Command Validation Error

## 📄 License![Validation Error](screenshots/08-validation-error.png)

*Screenshot showing blocked dangerous command*

This project was created for the Kaiburr technical assessment.

---

### 9️⃣ MongoDB Data
![MongoDB Data](screenshots/09-mongodb-data.png)
*Screenshot showing data in MongoDB Compass or mongosh*

---

### 🔟 Swagger UI
![Swagger UI](screenshots/10-swagger-ui.png)
*Screenshot of Swagger API documentation at http://localhost:8080/swagger-ui.html*

---

## 🐛 Troubleshooting

### MongoDB Connection Issues

**Error:** `Connection refused: connect`
```
Solution:
1. Verify MongoDB is running: mongosh
2. Check application.properties for correct host/port
3. Check MongoDB service status: net start MongoDB
```

**Error:** `Authentication failed`
```
Solution:
1. Remove authentication if using local MongoDB
2. Or add correct credentials in application.properties
```

### Application Won't Start

**Error:** `Port 8080 already in use`
```
Solution:
Change port in application.properties:
server.port=8081
```

**Error:** `Could not find or load main class`
```
Solution:
Rebuild the project:
mvn clean install
```

## 📁 Project Structure

```
task1/
├── src/
│   ├── main/
│   │   ├── java/com/kaiburr/taskmanager/
│   │   │   ├── controller/
│   │   │   │   └── TaskController.java
│   │   │   ├── model/
│   │   │   │   ├── Task.java
│   │   │   │   └── TaskExecution.java
│   │   │   ├── repository/
│   │   │   │   └── TaskRepository.java
│   │   │   ├── service/
│   │   │   │   └── TaskService.java
│   │   │   ├── exception/
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   ├── InvalidCommandException.java
│   │   │   │   └── ResourceNotFoundException.java
│   │   │   └── TaskManagerApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── screenshots/
├── pom.xml
└── README.md
```

## 🔗 Useful Links

- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **API Docs JSON:** http://localhost:8080/api-docs
- **Health Check:** http://localhost:8080/actuator/health
- **MongoDB Compass:** https://www.mongodb.com/products/compass (GUI for MongoDB)

## 📝 Notes for Assessment

- ✅ All required endpoints implemented
- ✅ MongoDB integration with proper data model
- ✅ Command validation for security
- ✅ Execution history tracking
- ✅ Error handling with appropriate HTTP status codes
- ✅ API documentation with Swagger
- ✅ Cross-platform command execution (Windows/Linux)
- ✅ Ready for Task 2 (Kubernetes deployment)
- ✅ Ready for Task 3 (React frontend integration)

## 👤 Author

**[Your Name]**  
Kaiburr Technical Assessment - Task 1  
Date: October 14, 2025

---

## 🎯 Next Steps

After completing Task 1:
1. ✅ Take screenshots of all API requests/responses
2. ✅ Add screenshots to `screenshots/` folder
3. ✅ Commit code to GitHub
4. ✅ Proceed to **Task 2** - Kubernetes deployment
5. ✅ Proceed to **Task 3** - React frontend

---

**📧 For questions or issues, please contact: [your-email]**
