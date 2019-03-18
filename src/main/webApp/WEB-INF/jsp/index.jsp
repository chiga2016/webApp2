<%--suppress XmlPathReference --%>
<%--
    Document   : index
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
        <title>Чат</title>
    </head>
    <body>
    <div style="
    margin: 0;padding: 0;
    margin-left: 40%;
     margin-right: 30%;
	 font-size: medium;
	 margin-top: 10%;" >
        <%
        //String login = (String) request.getSession().getAttribute("username");
        %>

        <h2>Добро пожаловать <c:if test="${user!=null}"> <font color="#4b0082">${user}   </font> <a href="logout.do">(выйти)</a> </c:if> !!!!!</h2>


        <jsp:include page="/login" />



        <br/> <br/>
        <c:if test="${user==null}">
        <a href="add.do"><font size="+3" color="#008b8b"> Начать чат анонимно </font> </a>
        </c:if>





        
        
        
    </div>>

        </body>
</html>
