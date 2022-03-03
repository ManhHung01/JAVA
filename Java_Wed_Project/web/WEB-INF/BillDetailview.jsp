<%-- 
    Document   : BillDetailview
    Created on : Mar 1, 2021, 5:46:43 PM
    Author     : DELL
--%>

<%@page import="java.sql.ResultSet"%>
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
                    <th>bid</th>
                    <th>pid</th>
                    <th>quantity</th>
                    <th>price</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%while (rs.next()) {%>
                <tr>
                    <td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getString(4)%></td>
                    <td><a href="BillDetailManager?action=preUpdate&bid=<%=rs.getString(1)%>">update</a></td>
                    <td><a href="BillDetailManager?action=predelete&bid=<%=rs.getString(1)%>">delete</a></td>
                </tr>
                <%}%>

            </tbody>
        </table>
            <h1><a href="addBillDetail.jsp">add BillDetail</a></h1>
            
    </body>
</html>
