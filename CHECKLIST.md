# Task 1 - Verification Checklist

Use this checklist to ensure Task 1 is complete before submission.

## ✅ Environment Setup

- [ ] Java 17+ installed and verified (`java -version`)
- [ ] Maven 3.9+ installed and verified (`mvn -version`)
- [ ] MongoDB installed (local or Atlas account created)
- [ ] MongoDB running and accessible
- [ ] Postman or cURL installed for API testing

## ✅ Code Implementation

- [x] pom.xml with all dependencies configured
- [x] application.properties with MongoDB configuration
- [x] Task model with all required fields
- [x] TaskExecution model with all required fields
- [x] TaskRepository with search methods
- [x] TaskService with business logic
- [x] Command validation implemented
- [x] TaskController with all 5+ endpoints
- [x] Exception handling (GlobalExceptionHandler)
- [x] Main application class

## ✅ Build & Run

- [ ] Project builds successfully (`mvn clean install`)
- [ ] No compilation errors
- [ ] Application starts without errors
- [ ] Can access http://localhost:8080
- [ ] Swagger UI accessible at http://localhost:8080/swagger-ui.html
- [ ] MongoDB connection successful

## ✅ API Endpoints Testing

Test each endpoint and verify it works:

### 1. Create Task (PUT /api/tasks)
- [ ] Creates task successfully
- [ ] Returns 201 Created
- [ ] Returns task with generated ID
- [ ] Data saved in MongoDB

### 2. Get All Tasks (GET /api/tasks)
- [ ] Returns all tasks
- [ ] Returns 200 OK
- [ ] Returns JSON array

### 3. Get Task by ID (GET /api/tasks?id={id})
- [ ] Returns specific task
- [ ] Returns 200 OK for existing ID
- [ ] Returns 404 for non-existent ID

### 4. Search by Name (GET /api/tasks/search?name={name})
- [ ] Finds tasks by name (case-insensitive)
- [ ] Returns matching tasks
- [ ] Returns 404 when no matches

### 5. Execute Task (PUT /api/tasks/{id}/execute)
- [ ] Executes command successfully
- [ ] Returns execution result
- [ ] Stores execution in taskExecutions list
- [ ] Shows startTime, endTime, output

### 6. Delete Task (DELETE /api/tasks/{id})
- [ ] Deletes task successfully
- [ ] Returns 200 OK
- [ ] Task removed from MongoDB

### 7. Command Validation
- [ ] Blocks dangerous commands (rm, sudo, curl, etc.)
- [ ] Returns 400 Bad Request for invalid commands
- [ ] Shows appropriate error message

## ✅ Screenshots (CRITICAL!)

Take screenshots with date/time and your name visible:

- [ ] 01-create-task.png - PUT request creating a task
- [ ] 02-get-all-tasks.png - GET all tasks
- [ ] 03-get-task-by-id.png - GET single task by ID
- [ ] 04-search-tasks.png - Search by name
- [ ] 05-execute-task.png - Execute task with output
- [ ] 06-execution-history.png - View execution history
- [ ] 07-delete-task.png - Delete task
- [ ] 08-validation-error.png - Invalid command blocked
- [ ] 09-mongodb-data.png - MongoDB Compass/mongosh showing data
- [ ] 10-swagger-ui.png - Swagger API documentation

**Screenshot Requirements:**
- ✅ System date/time widget visible
- ✅ Your name visible (username, editor, or desktop)
- ✅ Request URL visible
- ✅ Request body visible (for PUT/POST)
- ✅ Response body visible
- ✅ HTTP status code visible

## ✅ Documentation

- [x] README.md complete with:
  - [x] Project overview
  - [x] Features list
  - [x] Prerequisites
  - [x] MongoDB setup instructions
  - [x] Installation steps
  - [x] Running instructions
  - [x] API endpoints documentation
  - [ ] Screenshots embedded (add after taking)
  - [x] Troubleshooting section
  - [x] Project structure
- [x] SETUP.md with quick setup guide
- [x] POSTMAN_COLLECTION.md with test examples
- [x] .gitignore configured
- [x] Code comments and documentation

## ✅ Code Quality

- [x] Code follows Java naming conventions
- [x] Proper error handling
- [x] Input validation on models
- [x] Security validation for commands
- [x] Logging implemented
- [x] No hardcoded sensitive data
- [x] Cross-platform compatibility (Windows/Linux)

## ✅ GitHub Repository

- [ ] Create new GitHub repository (e.g., "kaiburr-task1-java-rest-api")
- [ ] Initialize git in project folder
- [ ] Add all files to git
- [ ] Commit with meaningful message
- [ ] Push to GitHub
- [ ] Verify all files are uploaded
- [ ] README.md displays correctly on GitHub
- [ ] Screenshots display correctly in README

### Git Commands:
```powershell
cd Z:\Career\task1
git init
git add .
git commit -m "Task 1: Java REST API with MongoDB - Complete implementation"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/REPO_NAME.git
git push -u origin main
```

## ✅ Final Checks

- [ ] All endpoints tested and working
- [ ] All screenshots taken with date/time and name
- [ ] Screenshots added to screenshots/ folder
- [ ] Screenshots embedded in README.md
- [ ] Code pushed to GitHub
- [ ] README renders correctly on GitHub
- [ ] No TODO comments left in code
- [ ] No sensitive data (passwords, tokens) in code
- [ ] Application can be run by following README instructions

## ✅ Bonus Points (Optional but Recommended)

- [x] Swagger UI documentation
- [x] Unit tests included
- [ ] Docker support added (for Task 2 preparation)
- [ ] Video demonstration recorded
- [x] Additional endpoints (execution history)
- [x] Detailed error messages

## 📊 Submission Readiness Score

Count completed items: _____ / Total items

**Minimum for submission:** 90% complete

---

## 🎯 Next Steps After Task 1

Once checklist is 100% complete:

1. ✅ Create GitHub repository
2. ✅ Push code with all screenshots
3. ✅ Verify repository is public and accessible
4. ✅ Test cloning and running from fresh directory
5. ✅ Proceed to **Task 2** - Kubernetes deployment

---

**Date Completed:** ______________

**Repository URL:** ______________

**Notes:** 
________________________________________________________________
________________________________________________________________
________________________________________________________________
