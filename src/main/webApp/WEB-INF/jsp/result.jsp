<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>
<h2>Submitted Student Information</h2>
<table>
    <tr>
        <td>Name</td>
        <td>${user1}</td>
    </tr>
    <tr>
        <td>Age</td>
        <td>${user2}</td>
    </tr>
    <tr>
        <td>ID</td>
        <td>${msg}</td>
    </tr>
</table>
</body>

</html>