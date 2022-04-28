<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : requestList
    Created on : Apr 20, 2022, 1:12:41 PM
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
        
        
            
        <c:forEach var="r" items="${requestScope.requests}">
            <div style="border: 1px dashed black;
                  width: 350px;
                   height: 100px;">
                Content: ${r.content}  <br/> 
            Created Date: ${r.createdDate} <br/>
            Category: ${r.category.name}<br/>
            From: ${r.username.username} /  To: ${r.toUser.username} <br/>
            </div>
            
            
    </c:forEach>
           
    </body>
</html>
