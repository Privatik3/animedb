<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Anime list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Main title</th>
        <th>Directed name</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.mainTitle}</td>
            <td>${user.directedByDirectedId.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
