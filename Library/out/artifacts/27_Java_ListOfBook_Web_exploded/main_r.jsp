<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<%@ page import="web.beans.Author" %>--%>
<%--<%@ page import="web.beans.AuthorList" %>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Онлайн библиотека</title>
    <link href="../css/style_main.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="container">

    <div class="header">

        <div class="logo">
            <img src="../images/superkid_kid.png" alt="Место для логотипа" name="logo"/>

        </div>

        <div class="descrb">
            <h3>Онлайн библиотека</h3>

            <%--<img src="../images/superkid_kid.png" alt="Место для логотипа" name="logo"/>--%>

        </div>

        <div class="search_form">
            <form name="search_form" method="POST">

                <%--<img src="../images/superkid_kid.png"/>--%>

                <input type="text" name="search_String" value="" size="80"/>
                <input class="search_button" type="submit" value="Поиск" name="search_button"/>
                <select name="search_option">
                    <option>Название</option>
                    <option>Автор</option>
                </select>

            </form>
        </div>
    </div>
    <%--end header--%>

    <div class="sidebar1">
        <h4>Список авторов:</h4>
        <ul class="nav">

            <%--<% AuthorList authorList = new AuthorList();--%>
            <%--for (Author author : authorList.getAuthorArrayList()) {--%>
            <%--%>--%>
            <%--<li><a href="#"><%=author.getName()%>--%>
            <%--</a></li>--%>
            <%--<%}%>--%>


            <jsp:useBean id="authorArrayList" class="net.ukr.ksm.beans.AuthorList" scope="application"/>
            <c:forEach var="author" items="${authorArrayList.getAuthorArrayList()}">
                <li class="ClassAuthorName"><a href="#">${author.name}</a></li>
            </c:forEach>

        </ul>

        <p>&nbsp;</p>
    </div>
    <%--end sidebar1--%>

    <div class="content">
        <h1>&nbsp;</h1>

        <p>&nbsp;</p>
    </div>
    <%--end content--%>

</div>
<%--end container--%>

</body>
</html>