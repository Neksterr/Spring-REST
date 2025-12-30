# Spring-REST

Santa workshop is a spring boot application for managing gifts, elves, deliveries

Tech stack
java
spring boot
spring mvc
spring data jpa
thymeleaf
MySQL

Data models
Gift
-id
-name-
-category
-targetAge
-wrapped
-status
-createdAt

Elf
id
name
skillLevel

Delivery
id
recipientName
address
gift
elf
trackingCode
deliveryStatus
estimatedArrival


Base URL :
http://localhost:8087/api

Get all gifts
GET /api/gifts
Get Gift by ID
GET /api/gifts/{id}
Update gift
PUT /api/gifts/{id}
Wrap gift
PATCH /ap/gifts/{id}/wrap
Delete gift
DELETE /api/gifts/{id}

Elves API
Create Elf
POST /api/elves
{
  "name": "Buddy",
  "skillLevel": "JUNIOR"
}
Get all elves
GET /api/elves
Get elf by id
GET /api/elves/{id}
Delete elf
DELETE /api/elves/{id}
Assign gift to elf
POST /api/elves/{elfId}/assign/{giftId}
Rules:
Elf must exist
Gift must exist
Gift must NOT be DELIVERED
Errors:
404 Not Found – missing elf or gift
409 Conflict – gift already delivered

Delivery API
Create delivery
POST /api/deliveries
Rules:
Gift must exist
Elf must exist
Gift must be READY or LOADED
Get all deliveries
GET /api/deliveries
Update delivery status
PATCH /api/deliveries/{id}/status


Database Overview
The application uses a relational database (MySQL) and is managed via Spring Data JPA (Hibernate).
All tables are automatically generated from JPA entities.
<img width="1233" height="821" alt="Screenshot 2025-12-30 210054" src="https://github.com/user-attachments/assets/48896c17-8017-440a-9a93-928d8881c12f" />
