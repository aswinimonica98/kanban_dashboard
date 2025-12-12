# API Endpoints Documentation

## Authentication
### POST /api/auth/register
### POST http://localhost:8080/api/auth/register
Registers a new user.
{
"username": "monica",
"password": "password123",
"email": "monica@example.com"
}
----->
{
"id": 1,
"username": "monica",
"email": "monica@example.com",
"password": "$2a$10$GzKumbGvAekS6y4g9L.a1eDtSVOI.e0JcFsWTopKvLfIvOagjdNgy",
"name": null,
"role": "USER"
}


### POST /api/auth/login
### POST http://localhost:8080/api/auth/login
Logs in a user and returns JWT token.
{
"email": "monica@example.com",
"password": "password123"
}
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb25pY2FAZXhhbXBsZS5jb20iLCJ1c2VySWQiOjEsImlhdCI6MTc2NTQ4NTYxNiwiZXhwIjoxNzY1NTcyMDE2fQ.-WJjXzBpeUl6RWvGnGlNYEXImiRbbxqsVv-w9k4-soQ

---
## Boards
### POST /api/boards
### POST http://localhost:8080/api/boards
Create a new board.
{
"title": "Project Dashboard",
"description": "Kanban workspace for my project"
}
--->
{
"boardId": "df7db8dd-4157-4549-a629-47cc7982b670",
"name": null,
"description": "Kanban workspace for my project",
"createdBy": 1,
"memberIds": null,
"columns": [
{
"columnId": "f91935cc-b5de-480e-95a2-51679a8ec53d",
"title": "TO_BE_DONE",
"position": 0
},
{
"columnId": "28503fbe-2686-41f1-b9c3-bf4944a24c7e",
"title": "WORK_IN_PROGRESS",
"position": 1
},
{
"columnId": "a28ae536-901f-4969-aa17-ff7b1198c16b",
"title": "COMPLETED",
"position": 2
}
],
"createdAt": null,
"updatedAt": "2025-12-11T20:42:20.223+00:00"
}




### GET /api/boards
### GET http://localhost:8080/api/boards
Get all boards for logged‑in user.
[
{
"boardId": "df7db8dd-4157-4549-a629-47cc7982b670",
"name": null,
"description": "Kanban workspace for my project",
"createdBy": 1,
"memberIds": null,
"columns": [
{
"columnId": "f91935cc-b5de-480e-95a2-51679a8ec53d",
"title": "TO_BE_DONE",
"position": 0
},
{
"columnId": "28503fbe-2686-41f1-b9c3-bf4944a24c7e",
"title": "WORK_IN_PROGRESS",
"position": 1
},
{
"columnId": "a28ae536-901f-4969-aa17-ff7b1198c16b",
"title": "COMPLETED",
"position": 2
}
],
"createdAt": null,
"updatedAt": "2025-12-11T20:42:20.223+00:00"
}
]


### GET /api/boards/{boardId}
Get board by ID.


### PUT /api/boards/{boardId}
Update board.

### DELETE /api/boards/{boardId}
Delete board.

---
## Cards
### POST /api/cards
### POST http://localhost:8080/api/cards
Create a new card.
{
"boardId": "df7db8dd-4157-4549-a629-47cc7982b670",
"columnId": "f91935cc-b5de-480e-95a2-51679a8ec53d",
"title": "Create frontend UI",
"description": "React components",
"assignedTo": 1
}---->{
"cardId": "a6f41292-ec2c-41f1-a130-74c126cf9414",
"boardId": "df7db8dd-4157-4549-a629-47cc7982b670",
"columnId": "f91935cc-b5de-480e-95a2-51679a8ec53d",
"title": "Create frontend UI",
"description": "React components",
"assignedTo": 1,
"createdAt": "2025-12-11T20:50:39.526+00:00",
"updatedAt": "2025-12-11T20:50:39.527+00:00"
}



### GET /api/cards/board/{boardId}
### GET http://localhost:8080/api/cards/board/df7db8dd-4157-4549-a629-47cc7982b670
Get all cards for a board.
[
{
"cardId": "a6f41292-ec2c-41f1-a130-74c126cf9414",
"boardId": "df7db8dd-4157-4549-a629-47cc7982b670",
"columnId": "f91935cc-b5de-480e-95a2-51679a8ec53d",
"title": "Create frontend UI",
"description": "React components",
"assignedTo": 1,
"createdAt": "2025-12-11T20:50:39.526+00:00",
"updatedAt": "2025-12-11T20:50:39.527+00:00"
}
]



### PUT /api/cards/{cardId}
### PUT http://localhost:8080/api/cards/a6f41292-ec2c-41f1-a130-74c126cf9414
Update card.
{
"title": "Updated task",
"description": "Updated desc",
"assignedTo": 1,
"columnId": "another-column-id"
}

### DELETE /api/cards/{cardId}
### DELETE http://localhost:8080/api/cards/a6f41292-ec2c-41f1-a130-74c126cf9414
Delete card.



### if more than 3 tasks gets assigned to a user, it will reach the limit and cant add 4th task