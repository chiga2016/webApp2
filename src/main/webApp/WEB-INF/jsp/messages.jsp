<%@ page import="sample.Message" %>
<%@ page import="sample.MessageService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.02.2019
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page contentType="text/html" pageEncoding="UTF-8"%> --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>messages</title>
</head>


<jsp:include page="/add.do" />

<div class="mes_messages">
    <ul>
        <c:forEach var="m" items="${messages}" >
            <li>
                <span class="mes_date"><c:out value="${m.date}"></c:out></span>
                : From  <a href="answer/${m.author}"><span class="mes_author"><c:out value="${m.author}"></c:out> </span></a>
                To <span class="mes_recipient"><c:out value="${m.recepient}"></c:out></span>
                : <span class="mes_text" ><c:out  value="${m.text}"></c:out></span>
            </li>
            <!--/// ***************** -->
        </c:forEach>
    </ul>
</div>

</body>
</html>
