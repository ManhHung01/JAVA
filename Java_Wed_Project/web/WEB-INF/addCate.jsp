<%-- 
    Document   : addCate
    Created on : Feb 23, 2021, 7:48:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CateManager" method="POST">
            <table border="0">
                   <tr>
                        <td>Category ID</td>
                        <td><input type="text" name="cateID" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Category Name</td>
                        <td><input type="text" name="cateName" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Image</td>
                        <td><input type="text" name="image" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="insert" />
                            <input type="submit" value="Add Category" /></td>
                        <td><input type="reset" value="Clear" /></td>
                    </tr>
             </table>

        </form>
    </body>
</html>
