<%-- 
    Document   : Adminview
    Created on : Jan 28, 2021, 8:00:19 PM
    Author     : DELL
--%>


<%@page import="model.AdminDao"%>
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
         <% /*
            DBConnection dbconn = new DBConnection();
            Connection conn = dbconn.getConn();
            String sql = "Select * from Product";
            ResultSet rs = dbconn.getData(sql);
            */
            ResultSet rs=(ResultSet)request.getAttribute("rs");
            String title=(String)request.getAttribute("title");
            
        %>
        
        <table border="1">
            <caption><%=title%></caption>
            <thead>
                <tr>
                    <th>username</th>
                    <th>password</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%while(rs.next()){%>
                <tr>
                    <td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><a href="AdminManager?action=preupdate&name=<%=rs.getString(1)%>">update</a></td>
                    <td><a href="AdminManager?action=predelete&name=<%=rs.getString(1)%>">delete</a></td>
                </tr>
                <%}%>
                
            </tbody>
        </table>
                <a href="addAd.jsp">add product</a>
            
    </body>
</html>
