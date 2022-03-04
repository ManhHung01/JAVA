<%-- 
    Document   : Customerview
    Created on : Jan 28, 2021, 9:42:34 PM
    Author     : DELL
--%>

<%@page import="model.CustomerDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <% 
            ResultSet rs = (ResultSet) request.getAttribute("rs");
        %>
       
        <table border=\"1\">
            <thead>
                <tr>
                    <th>cid</th>
                    <th>full name</th>
                    <th>address</th>
                    <th>phone</th>
                    <th>username</th>
                    <th>password</th>
                    <th>Status</th>
                    <th>update </th>
                    <th>delete</th>
                </tr>
            </thead>
            <tbody>
                <%while (rs.next()) {%>
                <tr>
                    <td><%=rs.getInt(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getString(4)%></td>
                    <td><%=rs.getString(5)%></td>
                    <td><%=rs.getString(6)%></td>
                    <td><%=rs.getInt(7)%></td>
                    <td><a href="CustomerManager?action=preUpdate&cid1=<%=rs.getString(1)%>">update</a></td>
                    <td><a href="CustomerManager?action=predelete&cid1=<%=rs.getString(1)%>">delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
                        <h1><a href="addCus.jsp">add product</a></h1>

    </body>
</html>
