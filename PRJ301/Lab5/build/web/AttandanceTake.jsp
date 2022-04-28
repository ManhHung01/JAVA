<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : AttandanceTake
    Created on : Apr 27, 2022, 2:07:03 PM
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
        <h3>Điểm danh  </h3>
        <form action="take" method="POST">
            Student: 
            <select name="student">
                <c:forEach var="s" items="${requestScope.students}">
                    <option value="${s.sid}">${s.sname}</option>
                </c:forEach>
            </select> <br/>
            
            Subject: 
            <select name="subject">
                <c:forEach var="su" items="${requestScope.subjects}">
                    <option value="${su.suid}">${su.suname}</option>
                </c:forEach>
            </select> <br/>
            
            Date: <input type="date" name="date" value="" /> <br/>
            Session: <input type="text" name="session" value="" /> <br/>
            <input type="submit" value="Save" />
            
        </form>
        
    </body>
</html>
