
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Онлайн библиотека: Вход</title>
    <link href="css/style_index.css" rel="stylesheet" type="text/css">

</head>

<body>
<div class="main">

    <div class="content">
        <p class="title">
            <span class="text">
                <img src="images/superkid_kid.png" width="76" height="77" hspace="10" vspace="10" algin="middle">
            </span>
        </p>

        <p class="title">Онлайн библиотека</p>
        <p class="title">Добро пожаловать в онлайн библиотеку, где вы сможете найти любую книгу на ваш вкус.</p>
        <p class="title">Проект находится в разработке поэтому дизайн и функционал будет постоянно дорабатываться.</p>
        <p class="title">По всем вопросам обращайтесь по адресу <a href="mailto:support@testlibrary.com">support@testlibrary.com</a></p>
        <p>&nbsp;</p>
    </div>

    <div class="login_div">
        <p class="title">Для входа введите свои данные:</p>
        <form class="login_form" name="username" action="pages/main.jsp" method="POST">
            Имя: <input type="text" name="username" value="" size="20" />
            <input type="submit" value="Войти" />
        </form>
    </div>

    <div class="footer">
        Разработчик: Сергей Крохмальный, 2016 г
    </div>

</div>
</body>
</html>