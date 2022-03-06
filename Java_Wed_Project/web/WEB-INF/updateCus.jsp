<%-- 
    Document   : updateCus
    Created on : Feb 24, 2021, 5:25:42 PM
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
         <%
            ResultSet rs1=(ResultSet)request.getAttribute("rs1");
        %>
        <%if (rs1.next()) {%>
        <form action="CustomerManager" method="POST">
            <table border="0">
                <tr>
                    <td>Cid</td>
                    <td><input type="text" name="cid" value="<%=rs1.getInt(1)%>" readonly /></td>
                </tr>
                <tr>
                    <td>Full Name</td>
                    <td><input type="text" name="fullName" value="<%=rs1.getString(2)%>" required /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" value="<%=rs1.getString(3)%>" required/></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="phone" value="<%=rs1.getString(4)%>" /></td>
                </tr>
                <tr>
                    <td>User Name</td>
                    <td><input type="text" name="username" value="<%=rs1.getString(5)%>" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value="<%=rs1.getString(6)%>" /></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="action" value="updatecu" />
                        <input type="submit" value="update Customer" /></td>
                    <td><input type="reset" value="Clear" /></td>
                </tr>
            </table>
        </form>
        <%}%>
    </body>
</html>
