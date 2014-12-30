<%@ page import="animedb.general.Factory" %>
<%@ page import="animedb.dao.AnimeDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="animedb.domain.AnimeEntity" %>
<%@ page import="animedb.domain.ScreenshotsEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="animedb.domain.AnimeGenreEntity" %>
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
            width: 260px;
            float: left;
        }
        .review {
             width: 100%;
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

        AnimeEntity anime = null;
        try {
            anime = animeDao.getAnimeById(Integer.parseInt(animeId));
        } catch (SQLException e) {
            e.printStackTrace();
            anime = new AnimeEntity();
        }
    %>

    <div class="content">
        <div class="image">
            <img src="<%= anime.getMainImg() %>" alt="<%= anime.getMainTitle() %>" width=240px>
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
                <%
                    String animeGenres = "";
                    for (AnimeGenreEntity genre : anime.getAnimeGenresById()) {

                        animeGenres += genre.getGenresByGenresId().getName();
                        animeGenres += " ";
                    }

                %>
                <tr class="genre">
                    <th class="field">Жанр</th>
                    <td class="value"><%= animeGenres %></td>
                </tr>
                <tr class="type">
                    <th class="field">Тип</th>
                    <td class="value"><%= anime.getAnimeTypesByAnimeTypeId().getName() %></td>
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
                <%
                    Integer countScreenshots = 1;
                    for (ScreenshotsEntity screenshot : anime.getScreenshotsesById()){
                        if(countScreenshots > 6)
                            return;%>
                    <img src="<%= screenshot.getUrl() %>" alt="<%= anime.getMainTitle() %>" width=300px>
                <%  countScreenshots++;
                    }%>
        </div>
    </div>
</body>
</html>