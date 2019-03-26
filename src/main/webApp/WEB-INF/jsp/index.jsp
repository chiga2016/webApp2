<%--suppress XmlPathReference --%>
<%--
    Document   : index<a href="../css/style.css">../css/style.css</a>
    Created on : 06.12.2010, 23:24:53
    Author     : Alexei
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
    		<%@include file="../css/style.css"   %>
		</style>
        <title>Чат</title>

    </head>
    <body>
    <div class="div_index">
        <%
        //String login = (String) request.getSession().getAttribute("username");
        %>
        <h2>Добро пожаловать  <c:if test="${user!=null}"> <span class="user"> ${user}</span> <a href="logout.do">(выйти)</a> </c:if> !!!!!</h2>
        <br/> <br/>
        <c:if test="${user==null}">
            <jsp:include page="/login" />
            <br/>
        </c:if>

      <c:if test="${user==null}"><a href="add.do"><span class="begin_chat"> Начать чат анонимно </span></a></c:if>

      <c:if test="${user==null}"> </c:if>
        <c:if test="${user!=null}">
            <br/>
            <a href="add.do"><span class="begin_chat"> Начать чат </span> </a>
        </c:if>

</div>

        </body>
</html>
