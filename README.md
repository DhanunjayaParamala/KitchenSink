# KitchenSink API

## Overview

The KitchenSink API is a Spring Boot application designed for managing members. It provides endpoints for member registration, retrieval, and deletion, using a MongoDB database.

## Features

- Register new members
- Retrieve all members with pagination support
- Fetch member details by email or phone number
- Delete members by phone number

## Technologies Used

- Spring Boot
- Spring Data MongoDB
- MongoDB
- Validation

## Setup Instructions

### Prerequisites

- Java 21
- Maven
- MongoDB Server
- STS 4.0

# API's Which I implemented
# 1. Create a New Member -> POST http://localhost:8080/api/members -H "Content-Type: application/json" -d '{"name": "Kiran", "email": "kiran@example.com", "phoneNumber": "6400567890"}'
Endpoint: POST /api/members
Request Body:
json
Copy code
{
  "name": "Jay",
  "email": "jay@example.com",
  "phoneNumber": "6300430537"
}
Responses:
200 OK - Registration successful.
400 Bad Request - Registration failed. Validation errors may occur.

# 2. List All Members -> GET http://localhost:8080/api/members
Endpoint: GET /api/members
Responses:
200 OK - Returns a list of all members in JSON format.
Example Response:
json
Copy code
[
  {
    "id": "1",
    "name": "John Doe",
    "email": "john@example.com",
    "phoneNumber": "1234567890"
  }
]

# 3. List Members with Pagination -> GET "http://localhost:8080/api/members/page?page=0&size=10"
Endpoint: GET /api/members/page
Query Parameters:
page: The page number (default is 0).
size: The number of members per page (default is 10).
Responses:
200 OK - Returns a paginated list of members.

# 4. Get Member by Email -> GET http://localhost:8080/api/members/email/john@example.com
Endpoint: GET /api/members/email/{email}
Path Parameter:
email: The email of the member to retrieve.
Responses:
200 OK - Returns the member details.
404 Not Found - Member not found.

# 5. Get Member by Phone Number -> GET http://localhost:8080/api/members/phone/1234567890
Endpoint: GET /api/members/phone/{phoneNumber}
Path Parameter:
phoneNumber: The phone number of the member to retrieve.
Responses:
200 OK - Returns the member details.
404 Not Found - Member not found.

# 6. Delete Member by Phone Number -> DELETE http://localhost:8080/api/members/phone/1234567890
Endpoint: DELETE /api/members/phone/{phoneNumber}
Path Parameter:
phoneNumber: The phone number of the member to delete.
Responses:
200 OK - Member deleted successfully.
404 Not Found - Member not found.

Note : I tested these API's using POSTMAN..

# ......Thank you..... #
