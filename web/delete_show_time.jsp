

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action= "Show_Time_Controller?action=delete_show_time" method="Post">
              <table>
                  <input type="hidden" name="stid" value="${show_time.stid}">
                   <tr><td>Morning Show</td><td><input type="text" name="mshow" value="${show_time.morning_show_time}" required/></td></tr>
                        <tr><td>Afternoon Show</td><td><input type="text" name="afshow1" value="${show_time.afternoon1_show_time}" required/> <br><input type="text" name="afshow2" value="${show_time.afternoon2_show_time}" required/> </td></tr>
                        <tr><td>Night Show</td><td><input type="text" name="nshow1" value="${show_time.night1_show_time}" required/>  <br> <input type="text" name="nshow2" value="${show_time.night2_show_time}" required/></td></tr>
                        <tr><td><input type="submit" class=btn name="submit" value="Delete Show Time"/></td></tr>
                        
                 
              </table>
                        
              
          </form>
    </body>
</html>
