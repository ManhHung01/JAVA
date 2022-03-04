<%-- 
    Document   : ProductView
    Created on : Jan 27, 2021, 4:58:15 PM
    Author     : DELL
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection,model.DBConnection"%>

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
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>price</th>
                    <th>image</th>
                    <th>description</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
            </thead>
            <tbody>
                <%while (rs.next()) {%>
                <tr>
                    <td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getString(4)%></td>
                    <td><img src="<%=rs.getString(5)%>"></td>
                    <td><%=rs.getString(6)%></td>
                    <td><a href="ProductManager?action=preUpdate&pid=<%=rs.getString(1)%>">update</a></td>
                    <td><a href="ProductManager?action=predelete&pid=<%=rs.getString(1)%>">delete</a></td>
                </tr>
                <%}%>

            </tbody>
        </table>
            <h1><a href="addProduct.jsp">add product</a></h1>
            

    </body>
</html>
