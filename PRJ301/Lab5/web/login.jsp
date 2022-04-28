<%-- 
    Document   : login
    Created on : Apr 27, 2022, 1:56:18 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <form action="login" method="POST">
            Username: <input type="text" name="userid" value="" /><br/>
            Password: <input type="text" name="pass" value="" /><br/>
            <input type="submit" value="Login" />    
        </form>
    </body>
</html>
