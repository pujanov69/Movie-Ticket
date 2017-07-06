

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <div class="register">
                <form action= "Show_Time_Controller?action=add_show_time" method="Post">
                    
                    
                    <table border="5"><br>
                        
                        <tr><td alignment="center">Show</td><td>Time</td></tr>
                        <tr><td>Morning Show</td><td><input type="text" name="morning_show_time" required/></td></tr>
                        <tr><td>Afternoon</td><td><input type="text" name="afternoon1_show_time" required/></td><td><input type="text" name="afternoon2_show_time" required/></td></tr>
                        <tr><td>Night</td><td><input type="text" name="night1_show_time" required/></td><td><input type="text" name="night2_show_time" required/></td></tr>
                        <tr><td><input type="submit" class=btn name="submit" value="Add Show Time"/></td></tr>
                    </table>
                    
                    <table border="5"><br>
                        
                        <tr><td alignment="center">Show</td><td>Time</td></tr>
                        <tr><td>Morning Show</td><td>8:00 AM-11:00AM</td></tr>
                        <tr><td>Afternoon</td><td>11:15 AM-2:15 PM</td><td>2:30 PM-5:30 PM</td></tr>
                        <tr><td>Night</td><td>6:00 PM-9:00 PM</td><td>9:15 PM-12:00 PM</td></tr>
                        
                    </table>
                </form>
            
            </div><!--register close-->
    </body>
</html>
