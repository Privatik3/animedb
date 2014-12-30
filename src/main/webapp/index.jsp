<%@ page import="home.privatik.general.Factory" %>
<%@ page import="home.privatik.dao.AnimeDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="home.privatik.domain.AnimeEntity" %>
<%@ page import="home.privatik.dao.ScreenshotsDao" %>
<%@ page import="home.privatik.domain.ScreenshotsEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GTO</title>
</head>
<body>
<form action="anime.jsp" method="post" >
    Anime id: <input type="text" name="animeID" />
    <input type="submit" name="enter" value="найти">
</form>
</body>
</html>