<%@ page contentType="text/html;charset=UTF-8" language = "java" %>

<html>
<body>
    <h2>Time</h2>
    <p>

    <%@ page import = "java.util.Date, logic.TestLogic" %>
    <%
        String someString = "Текущая дата :" + new Date();
        out.println("");
    %>

    <%
        TestLogic testclass  = new TestLogic();
        out.println(testclass.getTestString());
    %>

    <%= someString %>

    </p>

</body>
</html>
