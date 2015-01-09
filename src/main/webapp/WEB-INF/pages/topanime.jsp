<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/topanime" method="get">
   Тип производства:
    <select name="types">
        <option value="">не важно</option>
        <option value="1">ТВ</option>
        <option value="2">ТВ-спэшл</option>
        <option value="3">OVA</option>
        <option value="4">ONA</option>
        <option value="5">Полнометражный фильм</option>
        <option value="6">Специальный</option>
    </select><br>
    Год выхода:
    <select name="year_production">
        <option value = "">не важно</option>>
        <option value = "24">2014</option>
        <option value = "23">2013</option>
        <option value = "22">2012</option>
        <option value = "21">2011</option>
        <option value = "20">2010</option>
        <option value = "19">2009</option>
        <option value = "18">2008</option>
        <option value = "17">2007</option>
        <option value = "16">2006</option>
        <option value = "15">2005</option>
        <option value = "14">2004</option>
        <option value = "13">2003</option>
        <option value = "12">2002</option>
        <option value = "11">2001</option>
        <option value = "10">2000</option>
        <option value = "9">1999</option>
        <option value = "8">1998</option>
        <option value = "7">1997</option>
        <option value = "6">1996</option>
        <option value = "5">1995</option>
        <option value = "4">1994</option>
        <option value = "3">1993</option>
        <option value = "2">1992</option>
        <option value = "1">1991</option>
        <option value = "0">1990</option>
    </select><br>
    Жанр:
    <select multiple name="genres">
        <option value="">не важно</option>
        <option value="1">боевые искусства</option>
        <option value="2">война</option>
        <option value="3">детектив</option>
        <option value="4">драма</option>
        <option value="5">кодомо</option>
        <option value="6">комедия</option>
        <option value="7">махо-сёдзё</option>
        <option value="8">меха</option>
        <option value="9">музыкальный</option>
        <option value="10">образовательный</option>
        <option value="11">пародия</option>
        <option value="12">повседневность</option>
        <option value="13">приключения</option>
        <option value="14">романтика</option>
        <option value="15">самурайский боевик</option>
        <option value="16">сёдзё</option>
        <option value="17">сёдзё-ай</option>
        <option value="18">сёнен</option>
        <option value="19">сёнен-ай</option>
        <option value="20">сказка</option>
        <option value="21">спорт</option>
        <option value="22">триллер</option>
        <option value="23">школа</option>
        <option value="24">фантастика</option>
        <option value="25">фэнтези</option>
        <option value="26">эротика</option>
        <option value="27">этти</option>
        <option value="28">ужасы</option>
        <option value="29">хентай</option>
        <option value="30">юри</option>
        <option value="31">яой</option>
    </select><br>
    Тип сортировки:
    <select name="typesort">
        <option value = "">не важно</option>>
        <option value = "1">По алфавиту</option>>
        <option value = "2">По оценкам</option>>
        <option value = "3">По голосам</option>>
        <option value = "4">По годам</option>>
        <option value = "5">По рейтингу</option>>
    </select><br>
    <input type="submit" value="Сортировать"/>
</form>
<div>
  <p>

      <c:forEach var="anime" items="${animes}">
          --------------------------------------------------------<br>
          Id: <c:out value="${anime.id}"/><br>
          Main title: <c:out value="${anime.mainTitle}"/><br>
          <img src="${anime.mainImg}" alt="Main Img"><br>
          Genres: <c:out value="${anime.animeGenresById}" /><br>
          Date: <c:out value="${anime.yearProductionByYearProductionId}" /><br>
          Type: <c:out value="${anime.typesByAnimeTypeId}" /><br>
          <c:if test="${anime.review != null}">
              Description: <c:out value="${anime.review}"/><br>
          </c:if>

          --------------------------------------------------------<br>
      </c:forEach>

  </p>
</div>
</body>
</html>
