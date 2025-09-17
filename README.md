WeCARE - Online Life Coaching Application
WeCARE is a comprehensive online platform that connects users with renowned life coaches across various specialties. This application allows users to easily find, book, and manage appointments with a life coach, all in one place.

Features
User-facing Features
User Authentication: Secure sign-up and log-in functionality for users.

Life Coach Search: Users can search for a life coach based on their specific specialty.

Appointment Booking: Allows users to book an appointment with a life coach up to 7 days in advance.

Appointment Management: Users can view, reschedule, and cancel upcoming appointments.

Automated Notifications: An automated email is sent to the user's registered email ID upon booking, rescheduling, or canceling an appointment.

Life Coach-facing Features
Coach Authentication: Secure sign-up and log-in functionality for life coaches.

Schedule Management: Life coaches can view their upcoming appointment schedules.

Tech Stack
Backend
Spring Boot: Provides a robust framework for building the backend.

Spring REST: Used to create RESTful APIs for communication between the frontend and backend.

Spring Data JPA: Simplifies database interactions by providing a JPA repository abstraction.

Database
In-Memory Database: The database is automatically generated and managed by Spring Boot.

JPA: Used for object-relational mapping to manage the database schema and data.

Getting Started
Prerequisites
Java Development Kit (JDK) 11 or higher

Maven

Installation
Clone the Repository:

Bash

git clone https://github.com/your-username/wecare.git
cd wecare
Configure Database:
The application uses an in-memory database that is auto-generated. No specific database setup is required, but you can modify application.properties for different configurations.

Build the Project:

Bash

mvn clean install
Run the Application:

Bash

mvn spring-boot:run
The application will start on http://localhost:8080.
