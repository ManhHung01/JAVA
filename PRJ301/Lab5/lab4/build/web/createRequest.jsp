<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : createRequest
    Created on : Apr 26, 2022, 1:44:28 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="insert" method="Post">
            Content: <input type="text" name="content" value="" /> <br/>
            Category: 
            <select name="category">
                <c:forEach var="c" items="${requestScope.categories}">
                    <option value="${c.cid}" >${c.name}</option>
                </c:forEach>
                
            </select><br/>
            Status: <select name="status">
                <c:forEach var="s" items="${requestScope.statuses}">
                    <option value="${s.sid}" >${s.name}</option>
                </c:forEach>
                
            </select><br/>
            <input type="submit" value="Save" />
        </form>
        
    </body>
</html>
