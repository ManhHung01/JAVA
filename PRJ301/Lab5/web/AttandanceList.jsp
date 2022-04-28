<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : AttandanceList
    Created on : Apr 27, 2022, 2:39:25 PM
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
        <h3>Bảng Điểm Danh</h3>
        
        <table border="1">
            
            <tbody>
                <tr>
                    <th>Student Name</th>
                    <th>Subject Name</th>
                    <th>Date</th>
                    <th>Session</th>
                </tr>
                <c:forEach var="at" items="${requestScope.attandances}">
                <tr>
                    <td>${at.student.sname}</td>
                    <td>${at.subject.suname}</td>
                    <td>${at.date}</td>
                    <td>${at.session}</td>
                </tr>
                
            </c:forEach>
                
                
            </tbody>
        </table>

    </body>
</html>
