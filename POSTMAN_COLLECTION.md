# Postman Collection for Task Manager API

Import this into Postman for easy testing.

## Collection: Task Manager API

### 1. Create Task
- **Method:** PUT
- **URL:** http://localhost:8080/api/tasks
- **Headers:** Content-Type: application/json
- **Body (raw JSON):**
```json
{
  "name": "Print Hello World",
  "owner": "Your Name",
  "command": "echo Hello World!"
}
```

### 2. Get All Tasks
- **Method:** GET
- **URL:** http://localhost:8080/api/tasks

### 3. Get Task by ID
- **Method:** GET
- **URL:** http://localhost:8080/api/tasks?id={{taskId}}
- **Note:** Replace {{taskId}} with actual task ID

### 4. Search Tasks by Name
- **Method:** GET
- **URL:** http://localhost:8080/api/tasks/search?name=Hello

### 5. Execute Task
- **Method:** PUT
- **URL:** http://localhost:8080/api/tasks/{{taskId}}/execute
- **Note:** Replace {{taskId}} with actual task ID

### 6. Get Execution History
- **Method:** GET
- **URL:** http://localhost:8080/api/tasks/{{taskId}}/executions

### 7. Delete Task
- **Method:** DELETE
- **URL:** http://localhost:8080/api/tasks/{{taskId}}

### 8. Test Invalid Command (Should Fail)
- **Method:** PUT
- **URL:** http://localhost:8080/api/tasks
- **Body:**
```json
{
  "name": "Dangerous Command",
  "owner": "Test User",
  "command": "rm -rf /"
}
```
- **Expected:** 400 Bad Request with validation error

### 9. Create Multiple Sample Tasks
```json
// Task 1 - Date Command
{
  "name": "Show Current Date",
  "owner": "Your Name",
  "command": "date"
}

// Task 2 - Hostname
{
  "name": "Show Hostname",
  "owner": "Your Name",
  "command": "hostname"
}

// Task 3 - Directory Listing (Windows)
{
  "name": "List Directory",
  "owner": "Your Name",
  "command": "dir"
}

// Task 4 - Directory Listing (Linux/Mac)
{
  "name": "List Files",
  "owner": "Your Name",
  "command": "ls -la"
}

// Task 5 - Environment Variables
{
  "name": "Show User",
  "owner": "Your Name",
  "command": "whoami"
}
```

## PowerShell Commands (Alternative to Postman)

### Create Task
```powershell
$body = @{
    name = "Print Hello"
    owner = "Your Name"
    command = "echo Hello World"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method PUT -Body $body -ContentType "application/json"
```

### Get All Tasks
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method GET
```

### Execute Task (replace {id})
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/{id}/execute" -Method PUT
```

### Delete Task (replace {id})
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/{id}" -Method DELETE
```
