# Project Name

## Overview
This project is a web application built using Spring Boot and Java. It includes user authentication, registration, and various other features.

## Features
- User Registration
- User Login
- User Dashboard
- Static Pages (Home, About, Services, Contact)
- Form Validation
- Session Management

## Technologies Used
- Java
- Spring Boot
- Spring Security
- Maven
- Tailwind CSS
- Thymeleaf
- Jakarta Validation
- SLF4J
- NPM

## Endpoints

### Public Endpoints
- **GET `/`**: Redirects to `/home`.
- **GET `/home`**: Displays the home page.
- **GET `/about`**: Displays the about page.
- **GET `/services`**: Displays the services page.
- **GET `/contact`**: Displays the contact page.
- **GET `/login`**: Displays the login page.
- **GET `/register`**: Displays the registration page.
- **POST `/do-register`**: Processes the registration form.

### Protected Endpoints
- **GET `/user/dashboard`**: Displays the user dashboard. (Requires authentication)

## Endpoint Mappings

### `PageController`
- **GET `/`**: `index()`
- **GET `/home`**: `home()`
- **GET `/about`**: `about(Model model)`
- **GET `/services`**: `services(Model model)`
- **GET `/contact`**: `contact()`
- **GET `/login`**: `login()`
- **GET `/register`**: `register(Model model)`
- **POST `/do-register`**: `processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, HttpSession session)`

### `SecurityConfig`
- **POST `/authenticate`**: Processes login form.
- **POST `/logout`**: Logs out the user.

## User Service Mappings

### `UserServiceImpl`
- **saveUser(User user)**: Saves a new user.
- **getUserById(String id)**: Retrieves a user by ID.
- **updateUser(User user)**: Updates an existing user.
- **deleteUser(String id)**: Deletes a user by ID.
- **isUserExist(String userId)**: Checks if a user exists by ID.
- **isUserExistByUseEmail(String email)**: Checks if a user exists by email.
- **getAllUsers()**: Retrieves all users.

### `SecurityUserDetailService`
- **loadUserByUsername(String username)**: Loads user details by username (email).

## Configuration

### `SecurityConfig`
- Configures Spring Security for form-based login and logout.
- Customizes login and logout URLs.
- Sets up password encoding with BCrypt.

## Build and Run

### Prerequisites
- Java 11+
- Maven
- Node.js and NPM

### Steps
1. **Install Dependencies**:
   ```sh
   mvn clean install
   npm install