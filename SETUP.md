# Quick Setup Guide for Task 1

## Step-by-Step Setup (Windows)

### 1. Install Java 17
```powershell
# Check if Java is installed
java -version

# If not installed, download from:
# https://adoptium.net/temurin/releases/?version=17
```

### 2. Install Maven
```powershell
# Check if Maven is installed
mvn -version

# If not installed, download from:
# https://maven.apache.org/download.cgi
# Extract to C:\Program Files\Apache\maven
# Add to PATH: C:\Program Files\Apache\maven\bin
```

### 3. Install MongoDB

#### Option A: Local MongoDB
```powershell
# Download MongoDB Community Edition
# https://www.mongodb.com/try/download/community

# Install and start service
net start MongoDB

# Verify it's running
mongosh
# Should connect to mongodb://localhost:27017
```

#### Option B: MongoDB Atlas (Cloud - Easier!)
1. Go to https://www.mongodb.com/cloud/atlas
2. Sign up for free account
3. Create a free cluster (M0)
4. Create database user
5. Whitelist your IP (0.0.0.0/0 for testing)
6. Get connection string
7. Update `application.properties`:
   ```
   spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/taskmanager
   ```

### 4. Build and Run

```powershell
# Navigate to project directory
cd Z:\Career\task1

# Build project
mvn clean install

# Run application
mvn spring-boot:run
```

### 5. Test the API

Open browser and go to:
- http://localhost:8080/swagger-ui.html (API Documentation)
- http://localhost:8080/actuator/health (Health Check)

Or use Postman/cURL to test endpoints.

### 6. Install Postman (Recommended)
```
Download from: https://www.postman.com/downloads/
```

## Quick Test Commands

### Create a Task
```powershell
curl -X PUT http://localhost:8080/api/tasks `
  -H "Content-Type: application/json" `
  -d '{\"name\":\"Test Task\",\"owner\":\"Your Name\",\"command\":\"echo Hello\"}'
```

### Get All Tasks
```powershell
curl http://localhost:8080/api/tasks
```

### Execute Task (Replace {id} with actual task ID)
```powershell
curl -X PUT http://localhost:8080/api/tasks/{id}/execute
```

## Troubleshooting

### MongoDB Connection Error
```
Error: MongoTimeoutException: Timed out after 30000 ms

Solution:
1. Check if MongoDB is running: mongosh
2. Or use MongoDB Atlas (cloud option)
```

### Port Already in Use
```
Error: Port 8080 already in use

Solution:
Change port in application.properties:
server.port=8081
```

### Build Errors
```
Solution:
mvn clean install -U -DskipTests
```

## Next Steps After Setup

1. ✅ Test all API endpoints
2. ✅ Take screenshots with date/time and your name
3. ✅ Save screenshots to screenshots/ folder
4. ✅ Create GitHub repository
5. ✅ Push code to GitHub
6. ✅ Update README.md with your actual screenshots
7. ✅ Proceed to Task 2 (Kubernetes)
