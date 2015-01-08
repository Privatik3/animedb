<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/anime" method="get">
        Аниме Id:
        <label>
            <input type="text" name="id"/>
        </label>
        <input type="submit" value="Найти" />
    </form>
</body>
</html>
