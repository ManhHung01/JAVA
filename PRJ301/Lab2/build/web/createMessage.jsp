<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : createMessage
    Created on : Apr 19, 2022, 3:24:35 PM
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
        
        <form action="create" method="Post">
            Content:<input type="text" name="content" value="" /> <br/>
            To: <select name="to" style="width: 200px">
                <c:forEach var="a" items="${requestScope.accounts}">
                    <option value="${a.username}">${a.username}</option>
                </c:forEach>
                        
            </select><br/>
            <input type="submit" value="Save" /> 
        </form>
        
    </body>
</html>
