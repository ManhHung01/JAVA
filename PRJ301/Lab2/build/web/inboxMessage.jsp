<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : inbox
    Created on : Apr 19, 2022, 3:50:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Message Inbox: </h3>
        <c:forEach var="m" items="${requestScope.messages}">
            From: <input type="text" name="from" value="${m.from.username}" disabled/><br/>
            Date: <input type="date" name="from" value="${m.createdDate}" disabled/><br/>
            Content:<input type="text" name="content" value="${m.content}" disabled/> <br/>
            <br/>
    </c:forEach>
        
    </body>
</html>
