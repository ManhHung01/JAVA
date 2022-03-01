<%-- 
    Document   : addBill
    Created on : Mar 1, 2021, 5:48:48 PM
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
        <form action="BillManager">


            <table border="0" method="POST">
                
                <tr>
                    <td>Date Create</td>
                    <td><input type="text" name="dateCreate" value="" required/></td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td><input type="text" name="total" value="" /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="recName" value="" /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" value="" /></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="recPhone" value="" /></td>
                </tr>
               
                <tr>
                    <td>Customer Id</td>
                    <td><input type="text" name="cID" value="" /></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="action" value="insert" />
                        <input type="submit" value="Add Bill" /></td>
                    <td><input type="reset" value="Clear" /></td>
                </tr>
            </table>

        </form>
    </body>
</html>
