<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : requestAdd
    Created on : Apr 20, 2022, 1:12:29 PM
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

        <form action="add" method="post"> 
            Content:<input type="text" name="content" value="" /> <br/>

            Category: <select name="category" style="width: 200px">
                <c:forEach var="a" items="${requestScope.categories}">
                    <option value="${a.cid}">${a.name}</option>
                </c:forEach>

            </select><br/>

            To User: <select name="toUser" style="width: 200px">
                <c:forEach var="u" items="${requestScope.users}">
                    <option value="${u.username}">${u.username}</option>
                </c:forEach>

            </select><br/>
            <input type="submit" value="Save" /> 
        </form>

    </body>
</html>
