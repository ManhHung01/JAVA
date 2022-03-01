<%-- 
    Document   : addAd
    Created on : Feb 23, 2021, 12:45:21 PM
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
        <form action="AdminManager" method="POST">
            <table border="0">
                   <tr>
                        <td>UserName</td>
                        <td><input type="text" name="userName" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="password" value="" required/></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="action" value="insert" />
                            <input type="submit" value="Add admin" /></td>
                        <td><input type="reset" value="Clear" /></td>
                    </tr>
             </table>

        </form>
    </body>
</html>
