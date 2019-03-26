<%@ page import="java.io.PrintWriter" %><%--
    Document   : index
    Created on : 06.12.2010, 23:24:53
    Author     : Alexei
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        <%@include file="../css/style.css"   %>
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page newMessage</title>
</head>
<body>
<div class="header-panel">
    <span class="home_class"> <a href="index">Главная </a> </span>

    <span class="user">Пользователь <c:if test="${user!=null}">
        ${user} <a href="logout.do">(выйти)</a></c:if> <c:if test="${user==null}">
        Аноним  <a href="index">(войти)</a> </c:if> !</span>

    <div class="buttons">
        <form action="view.do" method="post"  class="bottom_form">
            <input type="submit" title="Показать сообщения" name="viewMessages" value="Показать сообщения" class="form-submit-button"></input>
        </form>

        <form action="viewPrivate.do" method="post"  class="bottom_form">
            <input type="submit" title="Показать личные сообщения" name="viewPrivateMessages" value="Показать личные сообщения" class="form-submit-button"></input>
        </form>
    </div>
</div>
<br/>



<br>
<div class="new_message">
    <h3>Добавить сообщение</h3>

    <form action="addMessage.do" method="POST" accept-charset="UTF-8">
        Ваше имя:<br/>
        <input name="user"  <c:if test="${user!=null}"> value=${user}</c:if>  /><br/>
        Кому:<br/>
        <!--/// ***************** -->
        <input name="user2" <c:if test="${author!=null}"> value=${author}</c:if> /><br/>
        <br/>
        Ваше сообщение:<br/>
        <textarea cols="50" rows="6"  name="msg"></textarea><br/>
        <input type="submit" title="Опубликовать"/>
    </form>
</div>
<br>

</body>
</html>
