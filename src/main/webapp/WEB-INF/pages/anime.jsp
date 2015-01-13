<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${anime.mainTitle}</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div id="context">
    <div id="mainImg">
        <img src="${anime.mainImg}" width="250px" height="320px" />
    </div>

    <div id="info">
        <p>
            <font size="6pt">${anime.mainTitle}</font><br>
            <c:forEach var="i" begin="0" end="2">
                <c:out value="${anime.otherTitlesById.toArray()[i].name}"/><br>
            </c:forEach>
        </p>

        <p>
            <b>Производство:</b>  Япония<br>
            <b>Жанр:</b> Ещё не вытянул с базы<br>
            <b>Тип:</b> ${anime.typeInfo}<br>

            <c:choose>
                <c:when test="${anime.yearProductionByYearProductionId.ended eq '1000-01-01'}">
                    <b>Премьера:</b> ${anime.yearProductionByYearProductionId.begin}<br>
                </c:when>
                <c:otherwise>
                    <b>Выпуск:</b> с ${anime.yearProductionByYearProductionId.begin} по ${anime.yearProductionByYearProductionId.ended}<br>
                </c:otherwise>
            </c:choose>
        </p>

        <p>
            <b>Режиссёр:</b>  ${anime.directedByDirectedId.name}<br>
            <b>Студия:</b> ${anime.studioByStudioId.name}<br>
        </p>

        <p>
            <c:if test="${anime.average > 0}">
                <b>Средний балл:</b>  <c:out value="${anime.average}"/> из 10<br>
            </c:if>

            <c:if test="${anime.ranced > 0}">
                <b>Место в рейтинге:</b>  <c:out value="${anime.ranced}"/> из 2747<br>
            </c:if>

            <c:if test="${anime.voted > 0}">
                <b>Место в рейтинге:</b>  <c:out value="${anime.voted}"/> чел.<br>
            </c:if>
        </p>
    </div>

    <c:if test="${anime.review ne ''}">
        <div id="review">
            <span class="title">Краткое содержания:</span>
            <p>
                <c:out value="${anime.review}"/>
            </p>
        </div>
    </c:if>

    <c:if test="${anime.screenshotsesById.size() > 0}">
        <div class="screenshots">
            <span class="title">Кадры из аниме:</span><br>
            <div id="img">
                <c:forEach var="i" begin="0" end="2">
                    <img src="<c:out value="${(anime.screenshotsesById.toArray()[i]).url}"/>" width="300px">
                </c:forEach>
            </div>
        </div>
    </c:if>

    <c:if test="${anime.connectionsesById.size() > 0}">
        <div class="connections">
            <span class="title">Связаные аниме:</span>
            <div id="conect">
                <table>
                    <tbody>
                    <c:forEach var="i" begin="0" end="${anime.connectionsesById.size() - 1}">
                        <tr>
                            <td><b>#<c:out value="${i + 1}" /></b> <a href="/anime?id=<c:out value="${anime.connectionsesById.toArray()[i].idConnection}" />">Ещё не вытянул с базы</a> - <c:out value="${anime.connectionsesById.toArray()[i].text}" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:if>

</div>
</body>
</html>