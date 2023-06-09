# Auto-service
___
## Description
This project is a simple auto service system. It allows you to register your car for repair work and complete orders with some products and services!
___
## Project features
- Car: create, update
- Master: create, update, find all done orders, receive salary for done job
- Order: create, update, add product to order, change order status, get price of order
- Owner: create, update, find all orders of car owner
- Product: create, update
- Duty: create, update, change order status
___
## Project structure
This project has an 3-tier architecture
+ DAO - all communication with databases happens here
+ Service - all business logic on this level
+ Controller - this level allows the user to work with our application
___
## Technologies
+ Java 17
+ Maven
+ Spring Boot
+ PostgreSQL
+ Angular
___
## Quickstart
- Clone repository
- Edit in resources/application.properties to your parameters
- Run back-end part from folder /backend
- Run front-end part from folder /frontend
- Use injection by link: "http://localhost:8080/inject"
- After open "http://localhost:4200/" and research it
___
