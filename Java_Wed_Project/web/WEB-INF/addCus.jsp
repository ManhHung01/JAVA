<%-- 
    Document   : addCus
    Created on : Feb 23, 2021, 8:10:48 PM
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
        <form action="CustomerManager" method="POST">
            <table border="0">
                   <tr>
                        <td>Full Name</td>
                        <td><input type="text" name="fullName" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="address" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input type="text" name="phone" value="" /></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="insert" />
                            <input type="submit" value="Add Customer" /></td>
                        <td><input type="reset" value="Clear" /></td>
                    </tr>
             </table>
        </form>
    </body>
</html>
