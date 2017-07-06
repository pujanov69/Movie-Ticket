

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <form action= "Ticket_Prices_Controller?action=delete_ticket_prices" method="Post">
            <table>
                <input type="hidden" name="tpid" value="${ticket_price.tpid}">
                <tr><td>Day:</td><td><input type="text" name="day" value="${ticket_price.day}" required/></td></tr>
                <tr><td>Price:</td><td><input type="text" name="price" value="${ticket_price.price}" required/></td></tr>
                <tr><td><input type="submit" class=btn name="submit" value="Delete Ticket Price"/></td></tr>
            </table>
            
            
        </form>
    </body>
</html>
