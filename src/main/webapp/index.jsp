<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Welcome to ZHSec!" %></h1>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<jsp:include page="index.html" />
</body>
</html>