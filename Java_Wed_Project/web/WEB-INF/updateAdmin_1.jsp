<%-- 
    Document   : updateAdmin
    Created on : Feb 24, 2021, 4:41:20 PM
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
        <form action="AdminManager" method="POST">
            <table border="0">
                <tr>
                    <td>UserName</td>
                    <td><input type="text" name="username" value="<%=rs1.getString(1)%>" readonly /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="password" value="<%=rs1.getString(2)%>" required/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="action" value="updateAd" />
                        <input type="submit" value="update admin" /></td>
                    <td><input type="reset" value="Clear" /></td>
                </tr>
            </table>
        </form>
                <%}%> 
    </body>
</html>
