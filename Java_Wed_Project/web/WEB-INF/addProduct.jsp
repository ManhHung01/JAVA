<%-- 
Document   : addProduct
Created on : Feb 22, 2021, 5:06:53 PM
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

        <form action="ProductManager">


            <table border="0" method="POST">
                <tr>
                    <td>Product ID</td>
                    <td><input type="text" name="proId" value="" required /></td>
                </tr>
                <tr>
                    <td>Category Name</td>
                    <td><input type="text" name="proName" value="" required/></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><input type="text" name="quantity" value="" /></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="" /></td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td><input type="text" name="image" value="" /></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="descriptions" value="" /></td>
                </tr>
                <tr>
                    <td>Category Id</td>
                    <td><input type="text" name="cateId" value="" /></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="action" value="insert" />
                        <input type="submit" value="Add Product" /></td>
                    <td><input type="reset" value="Clear" /></td>
                </tr>
            </table>

        </form>

    </body>
</html>
