# Java Servlet Project

This project is a simple web application built using Java Servlets. It provides basic user authentication functionality including registration, login, and logout.

## Project Structure

The project follows a standard Maven project structure. The main components of the project are:

- `src/main/java/org/example/Servlet`: This directory contains all the servlet classes which handle HTTP requests and responses.
- `src/main/webapp`: This directory contains all the JSP and HTML files along with the CSS stylesheets.

## Key Files

- `loginServlet.java`: Handles the login functionality. It checks if a user is valid and then redirects to the welcome page or back to the login page with an error message.
- `registerServlet.java`: Handles the user registration functionality. It adds a new user to the system and then redirects to the login page or back to the registration page with an error message.
- `logoutServlet.java`: Handles the logout functionality. It invalidates the user's session and then redirects to the home page.
- `UserDao.java` and `UserDaoImpl.java`: These files handle the data access object (DAO) operations for the User entity.
- `User.java`: This is the User entity class.

## Requirements

Before running this project, you need to set up the following:

1. **PostgreSQL Database**: This project uses PostgreSQL as its database. Make sure you have it installed and running on your system. You can download it from [here](https://www.postgresql.org/download/).

2. **Database Table**: You need to create a table in your PostgreSQL database to store user information. Here's the SQL command to create the table:

    ```sql
CREATE TABLE users (
    username VARCHAR(50) UNIQUE NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL
);
    ```

    Run this command in your PostgreSQL command line or GUI tool.

3. **Database Configuration**: The project needs to connect to your PostgreSQL database. You should use your own username and password to authenticate with PostgreSQL. Update the database configuration in the project with your PostgreSQL username and password.

Remember to replace the placeholders with your actual PostgreSQL username and password.

Please note that storing sensitive information like database username and password in the code is not a good practice for production applications. Consider using environment variables or external configuration files that are not committed with your code for production applications.

## Setup and Running

To set up and run the project:

1. Clone the repository.
2. Open the project in your favorite IDE (preferably IntelliJ IDEA).
3. Make sure you have the Java Development Kit (JDK) and Maven installed.
4. Build the project using Maven.
5. Run the project on a server (like Tomcat).

## Features

- User Registration: New users can register by providing a username, email, and password.
- User Login: Registered users can log in by providing their username and password.
- User Logout: Logged in users can log out.

## Future Enhancements

This project is designed to be easily extendable. Here are some guidelines on how to add new features or make improvements:

1. **Changing the Database**: If you want to change the database from PostgreSQL to another database, you will need to update the `UserDaoImpl.java` class. This class contains all the database operations. Make sure the new database driver is added to the project dependencies.

2. **Adding a New Servlet**: If you want to add a new servlet, create a new class in the `org.example.Servlet` package. This class should extend `HttpServlet` and override the `doGet` and `doPost` methods as needed. Don't forget to add the `@WebServlet` annotation to map the servlet to a URL.

3. **Adding a New JSP**: If you want to add a new JSP file, create it in the `src/main/webapp` directory. You can use EL (Expression Language) and JSTL (JSP Standard Tag Library) to dynamically generate the HTML based on the data in the request and session.

4. **Adding a New Entity and DAO**: If you want to add a new entity (like `Product`), create a new class in the `org.example.dao` package. Also, create a new DAO interface and its implementation for the new entity.

5. **Improving Security**: The passwords are currently stored as plain text in the database which is not secure. Consider implementing password hashing using a library like BCrypt. Also, consider adding CSRF (Cross-Site Request Forgery) protection to the forms.

Remember to always follow good coding practices and maintain the code clean and readable.
- Password encryption: Currently, the passwords are stored as plain text which is not secure. Future enhancements should include password encryption.
- Email verification: After registration, an email verification step can be added.