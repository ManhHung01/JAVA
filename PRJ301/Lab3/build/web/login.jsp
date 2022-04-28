<%-- 
    Document   : login
    Created on : Apr 19, 2022, 3:01:05 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/login" method="POST">
            username: <input type="text" name="username" value="" /> <br/>
            password: <input type="password" name="password" value="" /> <br/>
            <input type="submit" value="login"  style="margin-left: 200px"/>

        </form>


    </body>
</html>
