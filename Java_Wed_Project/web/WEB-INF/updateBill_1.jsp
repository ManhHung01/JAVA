<%-- 
    Document   : updateBill
    Created on : Mar 1, 2021, 6:22:43 PM
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
        <form action="BillManager" method="POST">
            <table border="0">
                <tr>
                    <td>Bill ID</td>
                    <td><input type="text" name="bID" value="<%=rs1.getString(1)%>" readonly/></td>
                </tr>
                
                <tr>
                    <td>Date Create</td>
                    <td><input type="text" name="dateCreate" value="<%=rs1.getString(2)%>" required/></td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td><input type="text" name="total" value="<%=rs1.getString(3)%>" /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="recName" value="<%=rs1.getString(4)%>" /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" value="<%=rs1.getString(5)%>" /></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="recPhone" value="<%=rs1.getString(6)%>" /></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td><input type="text" name="status" value="<%=rs1.getString(7)%>" /></td>
                </tr>
               
                <tr>
                    <td>Customer Id</td>
                    <td><input type="text" name="cID" value="<%=rs1.getString(8)%>" readonly/></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="action" value="updatebill" />
                        <input type="submit" value="update Bill" /></td>
                    <td><input type="reset" value="Clear" /></td>
                </tr>
            </table>
        </form>
        <%}%>
    </body>
</html>
