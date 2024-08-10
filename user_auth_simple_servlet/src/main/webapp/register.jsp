<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
    <h1>Register for Java Servlet Project!</h1>
    <form action="registerServlet" method="post">
        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" required><br>
        <label for="email">Email: </label><br>
        <input type="email" id="email" name="email" required> <br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="Sign Up" class="sign-button">
    </form>
    <div class="back_home">
        <a href="index.html">Home</a>
    </div>
    <% String error = request.getParameter("error");
        if (error != null && error.equals("1")) { %>
    <p style="color: red;">Registration failed. Please try again.</p>
    <% } %>
</div>
</body>
</html>