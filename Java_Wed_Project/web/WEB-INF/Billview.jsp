<%-- 
    Document   : Billview
    Created on : Mar 1, 2021, 5:44:56 PM
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
        <% ResultSet rs = (ResultSet) request.getAttribute("rs");
            String title = (String) request.getAttribute("title");
        %>
        <table border="1">
            <caption><%=title%></caption>
            <thead>
                <tr>
                    <th>Bill ID</th>
                    <th>Date Create</th>
                    <th>Total</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Status</th>
                    <th>Customer Id</th>
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
                    <td><%=rs.getString(5)%></td>
                    <td><%=rs.getString(6)%></td>
                    <td><%=rs.getString(7)%></td>
                    <td><%=rs.getString(8)%></td>
                    <td><a href="BillManager?action=preupdate&bID=<%=rs.getString(1)%>&cID=<%=rs.getString(8)%>">update</a></td>
                    <td><a href="BillManager?action=predelete&bID=<%=rs.getString(1)%>&cID=<%=rs.getString(8)%>">delete</a></td>
                </tr>
                <%}%>

            </tbody>
        </table>
        <a href="addBill.jsp">Add Bill</a>

    </body>
</html>
