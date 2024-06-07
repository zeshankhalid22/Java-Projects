<%@ page import="jakarta.servlet.http.HttpSession" %>

<body>
<%
    HttpSession session1 = request.getSession();

    if (session1 != null && session1.getAttribute("username") != null) {
        String username = (String) session1.getAttribute("username");
%>
    <div class="container">
        <h2> Welcome, <%= username%> at FSCS</h2>
        <div class="auth_links">
            <a href="logoutServlet">LOGOUT</a>
        </div>
    </div>
<%
    } else {
        response.sendRedirect("login.jsp");
    }
%>
</body>
