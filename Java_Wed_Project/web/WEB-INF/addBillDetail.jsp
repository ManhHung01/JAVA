<%-- 
    Document   : addBillDetail
    Created on : Mar 1, 2021, 5:59:21 PM
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
        <form action="BillDetailManager" method="POST">
            <table border="0">
                   <tr>
                        <td>Bid</td>
                        <td><input type="text" name="bid" value="" required /></td>
                    </tr>
                    <tr>
                        <td>Pid</td>
                        <td><input type="text" name="pid" value="" required/></td>
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
                        <td><input type="hidden" name="action" value="insert" />
                            <input type="submit" value="Add BillDetail" /></td>
                        <td><input type="reset" value="Clear" /></td>
                    </tr>
             </table>
        </form>
    </body>
</html>
