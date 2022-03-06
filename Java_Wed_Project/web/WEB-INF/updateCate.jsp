<%-- 
    Document   : updateCate
    Created on : Feb 24, 2021, 4:53:25 PM
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
        <form action="CateManager" method="POST">
            <table border="0">
                   <tr>
                        <td>Category ID</td>
                        <td><input type="text" name="cateID" value="<%=rs1.getString(1)%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Category Name</td>
                        <td><input type="text" name="cateName" value="<%=rs1.getString(2)%>" required/></td>
                    </tr>
                    <tr>
                        <td>Image</td>
                        <td><input type="text" name="image" value="<%=rs1.getString(3)%>" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="updateCate" />
                            <input type="submit" value="Update Category" /></td>
                        <td><input type="reset" value="Clear" /></td>
                    </tr>
             </table>

        </form>
                
                <%}%>
                
        
    </body>
</html>
