

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Times</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                background: #f0f0f0;
                font: 14px/20px Arial, San-Serif;
                color: #404040;
            }
            
        </style>

</head>
    
    <body>
        <div class="wrapper">

<div class="banner">
<img src="image/banners.jpg" alt="Banner" />
</div><!--banner closed-->

<div class="navigationbar">
<ul class="nav">
    <c:if test="${loginuser.type==2}">

<li><a href="Movies?action=nowshowing" accesskey="n">Now Showing Movies</a></li>
<li><a href="Movies?action=upcoming" accesskey="n">Upcoming Movies</a></li>
<li><a href="Ticket_Prices_Controller?action=show_ticket_price" accesskey="t">Ticket Prices</a></li>
<li><a href="Movies?action=book" accesskey="b">Book Ticket</a></li>
<li class="current"><a href="Show_Time_Controller?action=show_showtime" accesskey="s">Showtimes</a></li>
<li><a href="UserController?action=logout" accesskey="s">Logout</a></li>
</c:if>
    <c:if test="${loginuser==null}">
<li><a href="index.jsp" accesskey="h">Home</a></li>
   
<li><a href="Movies?action=nowshowing" accesskey="n">Now Showing Movies</a></li>

<li><a href="Movies?action=upcoming" accesskey="u">Upcoming Movies</a></li>

<li><a href="Ticket_Prices_Controller?action=show_ticket_price" accesskey="t">Ticket Prices</a></li>

<li><a href="Movies?action=book" accesskey="b">Book Ticket</a></li>
<li class="current"><a href="Show_Time_Controller?action=show_showtime" accesskey="s">Showtimes</a></li>
<li><a href="login.jsp" accesskey="l">Login</a></li>
<li><a href="signup.jsp" accesskey="r">Register</a></li>
</c:if>

</ul>

</div><!--navigationbar closed-->
      <table ><br>
          
          <tr><td>
          <h7>Showtime</h7> </td>
              
          </tr>
          <tr>  
              <th>Show</th>   <th>Time</th>
                    </tr>
                    <tr>
                        <td>Morning Show</td><td>${show_times_value.get(0).morning_show_time}</td>
                    </tr>
                    <tr>
                        <td>Afternoon Show</td><td colspan="2">  ${show_times_value.get(0).afternoon1_show_time} <br>
                                                    ${show_times_value.get(0).afternoon2_show_time}   </td>
                    </tr>
                    <tr><td>Night Show</td><td colspan="2">  ${show_times_value.get(0).night1_show_time} <br>
                                                 ${show_times_value.get(0).night2_show_time}</td>
                    </tr>
                        
                    </table>
       
                        
                        
                        <div class="footer">
Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

</div><!--footer-->

  
</div><!---wrapper closed-->
    </body>
</html>
