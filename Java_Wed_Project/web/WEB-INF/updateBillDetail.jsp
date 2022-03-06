<%-- 
    Document   : updateBillDetail
    Created on : Mar 1, 2021, 6:22:02 PM
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
        <form action="BillDetailManager" method="POST">
            <table border="0">
                   <tr>
                        <td>Bid</td>
                        <td><input type="text" name="bid" value="<%=rs1.getString(1)%>" readonly /></td>
                    </tr>
                    <tr>
                        <td>Pid</td>
                        <td><input type="text" name="pid" value="<%=rs1.getString(2)%>" readonly/></td>
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
                        <td><input type="hidden" name="action" value="update" />
                            <input type="submit" value="Update BillDetail" /></td>
                        <td><input type="reset" value="Clear" /></td>
                    </tr>
             </table>

        </form>
                
                <%}%>
                
    </body>
</html>
