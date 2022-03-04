<%-- 
    Document   : Cateview
    Created on : Jan 28, 2021, 9:38:49 PM
    Author     : DELL
--%>


<%@page import="model.CategoryDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% ResultSet rs=(ResultSet)request.getAttribute("rs");
            String title=(String)request.getAttribute("title");
        %>
        
        <table border=\"1\">
            <caption><%=title%></caption>
            <thead>
            <tr>
                <th>ID</th>
                <th>Category Name</th>
                <th>image</th>
                 <th>Status</th>
                <th>update </th>
                <th>delete</th>
            </tr>
            </thead>
            <tbody>
                <%while(rs.next()){%>
                <tr>
                    <td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><img src="<%=rs.getString(3)%>"></td>
                    <td><%=(rs.getInt(4) == 1 ? "active" : "deActive")%></td>
                    <td><a href="CateManager?action=preUpdate&id=<%=rs.getString(1)%>">update</a></td>
                    <td><a href="CateManager?action=predelete&id=<%=rs.getString(1)%>">delete</a></td>
                </tr>
                <%}%>
                
            </tbody>
        </table>
                    <h1><a href="addCate.jsp">add product</a></h1>
  
    </body>
</html>
