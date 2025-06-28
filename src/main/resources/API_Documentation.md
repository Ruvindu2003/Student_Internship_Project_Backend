# 📚 Internship Application API Documentation

## 🚀 Quick Start

### 1. Start the Application
```bash
mvn spring-boot:run
```

### 2. Setup Test Data
```bash
curl -X POST http://localhost:8080/api/test/setup
```

### 3. Check Available Data
```bash
curl http://localhost:8080/api/test/data
```

---

## 🔐 Authentication APIs

### Register User
**POST** `/api/auth/register`

**Request:**
```json
{
  "username": "john_doe",
  "password": "password123",
  "role": "STUDENT"
}
```

**Response:**
```json
{
  "id": 1,
  "username": "john_doe",
  "role": "STUDENT"
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_doe",
    "password": "password123",
    "role": "STUDENT"
  }'
```

### Login
**POST** `/api/auth/login`

**Request:**
```json
{
  "username": "student1",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9..."
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "student1",
    "password": "password123"
  }'
```

---

## 🎓 Student APIs

### Apply for Internship
**POST** `/api/student/applications/apply`

**Request:**
```json
{
  "studentId": 1,
  "postId": 1,
  "resumeLink": "https://drive.google.com/file/d/123456789/view"
}
```

**Response:**
```json
{
  "id": 1,
  "studentId": 1,
  "postId": 1,
  "status": "APPLIED",
  "resumeLink": "https://drive.google.com/file/d/123456789/view"
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/api/student/applications/apply \
  -H "Content-Type: application/json" \
  -d '{
    "studentId": 1,
    "postId": 1,
    "resumeLink": "https://drive.google.com/file/d/123456789/view"
  }'
```

### Get Student Applications
**GET** `/api/student/applications?studentId=1`

**Response:**
```json
[
  {
    "id": 1,
    "studentId": 1,
    "postId": 1,
    "status": "APPLIED",
    "resumeLink": "https://drive.google.com/file/d/123456789/view"
  }
]
```

**cURL:**
```bash
curl "http://localhost:8080/api/student/applications?studentId=1"
```

---

## 🏢 Company APIs

### Create Internship Post
**POST** `/api/company/posts?userId=2`

**Request:**
```json
{
  "title": "Software Engineering Intern",
  "description": "We are looking for a talented software engineering intern to join our team.",
  "location": "New York, NY",
  "duration": "3 months"
}
```

**Response:**
```json
{
  "id": 1,
  "title": "Software Engineering Intern",
  "description": "We are looking for a talented software engineering intern to join our team.",
  "location": "New York, NY",
  "duration": "3 months",
  "createdById": 2,
  "createdByUsername": "company1"
}
```

**cURL:**
```bash
curl -X POST "http://localhost:8080/api/company/posts?userId=2" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Software Engineering Intern",
    "description": "We are looking for a talented software engineering intern to join our team.",
    "location": "New York, NY",
    "duration": "3 months"
  }'
```

### Get All Posts
**GET** `/api/company/posts`

**Response:**
```json
[
  {
    "id": 1,
    "title": "Software Engineering Intern",
    "description": "We are looking for a talented software engineering intern...",
    "location": "New York, NY",
    "duration": "3 months",
    "createdById": 2,
    "createdByUsername": "company1"
  }
]
```

**cURL:**
```bash
curl http://localhost:8080/api/company/posts
```

### Search Posts
**GET** `/api/company/posts/search?keyword=software`

**Response:**
```json
[
  {
    "id": 1,
    "title": "Software Engineering Intern",
    "description": "We are looking for a talented software engineering intern...",
    "location": "New York, NY",
    "duration": "3 months",
    "createdById": 2,
    "createdByUsername": "company1"
  }
]
```

**cURL:**
```bash
curl "http://localhost:8080/api/company/posts/search?keyword=software"
```

### Filter Posts
**GET** `/api/company/posts/filter?location=New York&duration=3 months`

**Response:**
```json
[
  {
    "id": 1,
    "title": "Software Engineering Intern",
    "description": "We are looking for a talented software engineering intern...",
    "location": "New York, NY",
    "duration": "3 months",
    "createdById": 2,
    "createdByUsername": "company1"
  }
]
```

**cURL:**
```bash
curl "http://localhost:8080/api/company/posts/filter?location=New York&duration=3 months"
```

---

## 👨‍💼 Admin APIs

### Get All Users
**GET** `/api/admin/users`

**Response:**
```json
[
  {
    "id": 1,
    "username": "student1",
    "role": "STUDENT"
  },
  {
    "id": 2,
    "username": "company1",
    "role": "COMPANY"
  },
  {
    "id": 3,
    "username": "admin1",
    "role": "ADMIN"
  }
]
```

**cURL:**
```bash
curl http://localhost:8080/api/admin/users
```

### Get All Posts
**GET** `/api/admin/posts`

**Response:**
```json
[
  {
    "id": 1,
    "title": "Software Engineering Intern",
    "description": "We are looking for a talented software engineering intern...",
    "location": "New York, NY",
    "duration": "3 months",
    "createdById": 2,
    "createdByUsername": "company1"
  }
]
```

**cURL:**
```bash
curl http://localhost:8080/api/admin/posts
```

### Delete User
**DELETE** `/api/admin/user/1`

**Response:** `204 No Content`

**cURL:**
```bash
curl -X DELETE http://localhost:8080/api/admin/user/1
```

### Delete Post
**DELETE** `/api/admin/post/1`

**Response:** `204 No Content`

**cURL:**
```bash
curl -X DELETE http://localhost:8080/api/admin/post/1
```

---

## 🧪 Test Data APIs

### Setup Test Data
**POST** `/api/test/setup`

**Response:**
```json
{
  "message": "Test data created successfully!",
  "users": {
    "student": {
      "id": 1,
      "username": "student1"
    },
    "company": {
      "id": 2,
      "username": "company1"
    },
    "admin": {
      "id": 3,
      "username": "admin1"
    }
  },
  "posts": {
    "post1": {
      "id": 1,
      "title": "Software Engineering Intern"
    },
    "post2": {
      "id": 2,
      "title": "Marketing Intern"
    }
  }
}
```

**cURL:**
```bash
curl -X POST http://localhost:8080/api/test/setup
```

### Get Test Data
**GET** `/api/test/data`

**Response:**
```json
{
  "users": [
    {
      "id": 1,
      "username": "student1",
      "role": "STUDENT"
    },
    {
      "id": 2,
      "username": "company1",
      "role": "COMPANY"
    },
    {
      "id": 3,
      "username": "admin1",
      "role": "ADMIN"
    }
  ],
  "posts": [
    {
      "id": 1,
      "title": "Software Engineering Intern",
      "location": "New York, NY"
    },
    {
      "id": 2,
      "title": "Marketing Intern",
      "location": "Los Angeles, CA"
    }
  ]
}
```

**cURL:**
```bash
curl http://localhost:8080/api/test/data
```

---

## 📋 Complete Testing Workflow

### Step 1: Start Application
```bash
mvn spring-boot:run
```

### Step 2: Setup Test Data
```bash
curl -X POST http://localhost:8080/api/test/setup
```

### Step 3: Check Available Data
```bash
curl http://localhost:8080/api/test/data
```

### Step 4: Test Authentication
```bash
# Register new user
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "newstudent",
    "password": "password123",
    "role": "STUDENT"
  }'

# Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "student1",
    "password": "password123"
  }'
```

### Step 5: Test Company Operations
```bash
# Create internship post
curl -X POST "http://localhost:8080/api/company/posts?userId=2" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Data Science Intern",
    "description": "Join our data science team",
    "location": "San Francisco",
    "duration": "4 months"
  }'

# Get all posts
curl http://localhost:8080/api/company/posts

# Search posts
curl "http://localhost:8080/api/company/posts/search?keyword=data"
```

### Step 6: Test Student Operations
```bash
# Apply for internship
curl -X POST http://localhost:8080/api/student/applications/apply \
  -H "Content-Type: application/json" \
  -d '{
    "studentId": 1,
    "postId": 1,
    "resumeLink": "https://drive.google.com/file/d/123456789/view"
  }'

# Get student applications
curl "http://localhost:8080/api/student/applications?studentId=1"
```

### Step 7: Test Admin Operations
```bash
# Get all users
curl http://localhost:8080/api/admin/users

# Get all posts
curl http://localhost:8080/api/admin/posts
```

---

## ⚠️ Common Errors & Solutions

### 1. "No value present" Error
**Cause:** Using non-existent IDs
**Solution:** Check available IDs with `/api/test/data`

### 2. "Required request parameter 'userId' for method parameter type Long is not present"
**Cause:** Missing userId parameter in company posts API
**Solution:** Add `?userId=2` to the URL

### 3. "JSON parse error: Cannot deserialize value of type InternshipPostDTO from Array value"
**Cause:** Sending array instead of single object
**Solution:** Remove square brackets `[]` from JSON

### 4. "404 Not Found"
**Cause:** Wrong endpoint URL
**Solution:** Use correct endpoints from this documentation

---

## 🔑 Authentication Headers

For protected endpoints, include JWT token:
```
Authorization: Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9...
```

---

## 📝 Field Descriptions

### User Roles
- `STUDENT`: Can apply for internships
- `COMPANY`: Can create internship posts
- `ADMIN`: Can manage users and posts

### Application Status
- `APPLIED`: Initial application status
- `PENDING`: Under review
- `ACCEPTED`: Application accepted
- `REJECTED`: Application rejected

### Required Fields
- All fields marked with `*` are required
- IDs must be valid and exist in database
- URLs must be valid format

---

## 🌐 Base URL
```
http://localhost:8080
```

## 📞 Support
For issues or questions, check the application logs and ensure all required fields are provided correctly. 