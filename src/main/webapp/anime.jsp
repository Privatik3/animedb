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
    <style type="text/css">
        .content {
            width: 1024px;
            background: #E5E5E5;
            padding: 20px;
            border: solid 1px #C3C3C3;
            margin: auto;
        }
        .image {
            width: 300px;
            float: left;
        }
        .review {
             width: 100%;
             height: 150px;
             padding: 10px;
        }
        .screenshots {
            margin: 55px;
        }
    </style>
</head>
<body>

    <%@include file="index.jsp"%>

    <%
        String animeId = request.getParameter("animeID");

        Factory instance = Factory.getInstance();
        AnimeDao animeDao = instance.getAnimeDao();
        ScreenshotsDao screenshotsDao = instance.getScreenshotsDao();

        AnimeEntity anime = new AnimeEntity();
        List<ScreenshotsEntity> screenshots = new ArrayList<>();
        try {
            anime = animeDao.getAnimeById(animeId);
            screenshots = screenshotsDao.getSchreenshotsByAnimeId(animeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>

    <div class="content">
        <div class="image">
            <img src="<%= anime.getMainImg() %>" alt="<%= anime.getMainTitle() %>">
        </div>
        <div class="info">
            <table>
                <tbody>
                <tr class="main_title">
                    <th class="field">Название</th>
                    <td class="value"><%= anime.getMainTitle() %></td>
                </tr>
                <tr class="other_title">
                    <th class="field">Другие названия</th>
                    <td class="value"><%= anime.getOtherTitle() %></td>
                </tr>
                <tr class="genre">
                    <th class="field">Жанр</th>
                    <td class="value">Ещё не вытянул с базы</td>
                </tr>
                <tr class="type">
                    <th class="field">Тип</th>
                    <td class="value">Пока нет</td>
                </tr>
                <tr class="year">
                    <th class="field">Дата выпуска</th>
                    <td class="value">c <%= anime.getYearProduction() %> по (тут будет дата)</td>
                </tr>
                <tr class="direction">
                    <th class="field">Режиссер</th>
                    <td class="value">Пока нет</td>
                </tr>
                <tr class="original_work">
                    <th class="field">Автор оригинала</th>
                    <td class="value">Тоже нет</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="review">
            Краткое содержание:
            <p><%= anime.getReview() %></p>
        </div>
        <div class="screenshots">
                <% for (int i = 0; i < screenshots.size() && i < 9; i++) {%>
                    <img src="<%= screenshots.get(i).getUrl() %>" alt="<%= anime.getMainTitle() %>" width=300px>
                <%}%>
        </div>
    </div>
</body>
</html>