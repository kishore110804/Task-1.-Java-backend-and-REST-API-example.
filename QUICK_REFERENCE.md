# Quick Reference - Task 1 Commands

## 🚀 Quick Start (Copy-Paste Commands)

### 1. Build Project
```powershell
cd Z:\Career\task1
mvn clean install
```

### 2. Run Application
```powershell
mvn spring-boot:run
```

### 3. Run Tests
```powershell
mvn test
```

---

## 🧪 API Testing Commands (PowerShell)

### Create Task
```powershell
$headers = @{"Content-Type"="application/json"}
$body = @{
    name = "Print Hello World"
    owner = "YOUR_NAME_HERE"
    command = "echo Hello World!"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method PUT -Headers $headers -Body $body
```

### Get All Tasks
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method GET | ConvertTo-Json -Depth 5
```

### Search Tasks by Name
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/search?name=Hello" -Method GET | ConvertTo-Json -Depth 5
```

### Execute Task (Replace TASK_ID with actual ID)
```powershell
$taskId = "TASK_ID_HERE"
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/$taskId/execute" -Method PUT | ConvertTo-Json
```

### Get Execution History (Replace TASK_ID)
```powershell
$taskId = "TASK_ID_HERE"
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/$taskId/executions" -Method GET | ConvertTo-Json -Depth 5
```

### Delete Task (Replace TASK_ID)
```powershell
$taskId = "TASK_ID_HERE"
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/$taskId" -Method DELETE
```

---

## 🧪 API Testing Commands (cURL)

### Create Task
```bash
curl -X PUT http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Print Hello\",\"owner\":\"YOUR_NAME\",\"command\":\"echo Hello\"}"
```

### Get All Tasks
```bash
curl http://localhost:8080/api/tasks
```

### Get Task by ID
```bash
curl "http://localhost:8080/api/tasks?id=TASK_ID"
```

### Search by Name
```bash
curl "http://localhost:8080/api/tasks/search?name=Hello"
```

### Execute Task
```bash
curl -X PUT http://localhost:8080/api/tasks/TASK_ID/execute
```

### Delete Task
```bash
curl -X DELETE http://localhost:8080/api/tasks/TASK_ID
```

---

## 🗄️ MongoDB Commands

### Connect to Local MongoDB
```powershell
mongosh
```

### Switch to Database
```javascript
use taskmanager
```

### View All Tasks
```javascript
db.tasks.find().pretty()
```

### Count Tasks
```javascript
db.tasks.countDocuments()
```

### Delete All Tasks (for testing)
```javascript
db.tasks.deleteMany({})
```

### Find Task by Name
```javascript
db.tasks.find({name: /Hello/i}).pretty()
```

---

## 📦 Maven Commands

### Clean Build
```powershell
mvn clean install
```

### Skip Tests
```powershell
mvn clean install -DskipTests
```

### Run Tests Only
```powershell
mvn test
```

### Package JAR
```powershell
mvn clean package
```

### Run JAR Directly
```powershell
java -jar target/task-manager-1.0.0.jar
```

### Update Dependencies
```powershell
mvn clean install -U
```

---

## 🐙 Git Commands

### Initialize Repository
```powershell
cd Z:\Career\task1
git init
git add .
git commit -m "Initial commit: Task 1 - Java REST API with MongoDB"
```

### Create GitHub Repository
1. Go to https://github.com/new
2. Name: `kaiburr-task1-java-rest-api`
3. Make it **Public**
4. Don't initialize with README (we already have one)

### Push to GitHub
```powershell
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/kaiburr-task1-java-rest-api.git
git push -u origin main
```

### Check Status
```powershell
git status
```

### View Commit History
```powershell
git log --oneline
```

---

## 🔍 Useful URLs

| Service | URL | Description |
|---------|-----|-------------|
| Application | http://localhost:8080 | Main API endpoint |
| Swagger UI | http://localhost:8080/swagger-ui.html | Interactive API docs |
| API Docs JSON | http://localhost:8080/api-docs | OpenAPI specification |
| Health Check | http://localhost:8080/actuator/health | Application health |
| Tasks Endpoint | http://localhost:8080/api/tasks | Main REST endpoint |

---

## 🐛 Troubleshooting Commands

### Check Java Version
```powershell
java -version
javac -version
```

### Check Maven Version
```powershell
mvn -version
```

### Find Java Process on Port 8080
```powershell
netstat -ano | findstr :8080
```

### Kill Process on Port 8080
```powershell
# Find PID from above command, then:
taskkill /PID <PID_NUMBER> /F
```

### Check MongoDB Status
```powershell
net start | findstr MongoDB
```

### Start MongoDB Service
```powershell
net start MongoDB
```

### Stop MongoDB Service
```powershell
net stop MongoDB
```

### View Application Logs
```powershell
# Logs are in console where you ran mvn spring-boot:run
# Or check: target/logs/ (if file logging configured)
```

---

## 📸 Screenshot Tips

### Windows Snipping Tool
```
Press: Win + Shift + S
Select area
Screenshot saved to clipboard
Paste in Paint or image editor
Save as PNG
```

### Include in Screenshots:
1. ✅ Date/Time - Use Windows taskbar clock
2. ✅ Your Name - Show in:
   - Terminal prompt (username@hostname)
   - Open Notepad with your name
   - Desktop wallpaper with name
   - Command Prompt title
3. ✅ Full request/response in Postman or browser

---

## 🎯 Complete Test Sequence

Run these commands in order to test all functionality:

```powershell
# 1. Start application
mvn spring-boot:run

# 2. Open new PowerShell window and run tests:

# Create first task
$task1 = @{name="Print Date"; owner="Your Name"; command="date"} | ConvertTo-Json
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method PUT -Body $task1 -ContentType "application/json"

# Create second task
$task2 = @{name="Show Hostname"; owner="Your Name"; command="hostname"} | ConvertTo-Json
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method PUT -Body $task2 -ContentType "application/json"

# Get all tasks and save first ID
$tasks = Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method GET
$taskId = $tasks[0].id
Write-Host "Task ID: $taskId"

# Execute the task
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/$taskId/execute" -Method PUT

# Get execution history
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/$taskId" -Method GET | ConvertTo-Json -Depth 5

# Search by name
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/search?name=Print" -Method GET

# Test invalid command (should fail)
$badTask = @{name="Bad Command"; owner="Test"; command="rm -rf /"} | ConvertTo-Json
try {
    Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method PUT -Body $badTask -ContentType "application/json"
} catch {
    Write-Host "✅ Command validation working! Dangerous command blocked."
}

# Delete task
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/$taskId" -Method DELETE
```

---

## 📚 Additional Resources

- Spring Boot Docs: https://spring.io/projects/spring-boot
- MongoDB Docs: https://docs.mongodb.com/
- REST API Best Practices: https://restfulapi.net/
- Postman Learning: https://learning.postman.com/
- Git Basics: https://git-scm.com/book/en/v2/Getting-Started-Git-Basics

---

**Keep this file open while testing for quick reference!**
