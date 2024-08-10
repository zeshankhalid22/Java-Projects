<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
    <h1>Login to Java Servlet Project!</h1>
    <form action="loginServlet" method="post">
        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="Login" class="sign-button">
    </form>
    <div class="back_home">
        <a href="index.html">Home</a>
    </div>
    <%--    Display error message if login fails--%>
    <% String error = request.getParameter("error");
        if (error != null && error.equals("1")) { %>
    <p style="color: #ff9d00">Invalid username or password.</p>
    <% } %>

    <%-- Confirmation message if Register Successful --%>
    <%
        String rs = request.getParameter("registration");
        if (rs != null && rs.equals("success")) { %>
            <p style="color: green;">Your Registration is Successful. Please Login.</p>
    <% } %>

</div>
</body>
</html>
