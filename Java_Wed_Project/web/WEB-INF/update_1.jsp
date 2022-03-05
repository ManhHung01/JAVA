<%-- 
    Document   : update
    Created on : Feb 22, 2021, 7:40:38 PM
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
        <form action="ProductManager" method="POST">
            
            <table border="0">
                <tr>
                    <td>Product ID</td>
                    <td><input type="text" name="proId" value="<%=rs1.getString(1)%>" readonly /></td>
                </tr>
                <tr>
                    <td>Category Name</td>
                    <td><input type="text" name="proName" value="<%=rs1.getString(2)%>" required/></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><input type="text" name="quantity" value="<%=rs1.getString(3)%>" /></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="<%=rs1.getString(4)%>" /></td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td><input type="text" name="image" value="<%=rs1.getString(5)%>" /></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="descriptions" value="<%=rs1.getString(6)%>" /></td>
                </tr>
                <tr>
                    <td>Category Id</td>
                    <td><input type="text" name="cateId" value="<%=rs1.getString(7)%>" /></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="action" value="updatepro" />
                        <input type="submit" value="Update Product" /></td>
                    <td><input type="reset" value="Clear" /></td>
                </tr>
            </table>
        </form>
              <%}%>   
    </body>
</html>
