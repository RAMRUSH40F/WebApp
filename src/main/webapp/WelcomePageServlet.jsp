<%@ page contentType="text/html;charset=UTF-8" language = "java" %>

<html>
<body>
    <h2>WelcomePageServlet</h2>
    <h2>/redirect /time /main</h2>
    <p>

    <%
        String name = request.getParameter("name");

    %>

    <%="Hello, "+name  %>

    </p>

</body>
</html>
