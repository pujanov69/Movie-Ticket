

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
         <title>delete_or_edit_show_times</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>


<style type="text/css">
<!--

body {
	background: #f0f0f0;
	font: 14px/20px Arial, San-Serif;
	color: #404040;
}

-->
</style>
    </head>
    
    <body>
        <div class="wrapper">

<div class="banner">
<img src="image/banners.jpg" alt="Banner" />
</div><!--banner closed-->

<div class="navigationbar">
<ul class="nav">


    
<li>
    <a href="add_now_showing_movies.jsp" accesskey="r">Add Now Showing movies</a>
     <ul class="dropdown">
          <a href="add_now_showing_movies.jsp" accesskey="r">Add Now Showing movies</a>
                <li><a href="add_upcoming_movies.jsp" accesskey="n">Add Upcoming Movies</a></li>
                <li><a href="add_ticket_prices.jsp" accesskey="p">Add Ticket Prices</a></li>
                
            </ul>
</li>
<li><a href="Movies?action=d_or_E_nsm" accesskey="r">Delete or Edit Now Showing movies</a>
<ul class="dropdown">
    <li><a href="Movies?action=d_or_E_nsm" accesskey="r">Delete or Edit Now Showing movies</a>
                <li><a href="Movies?action=d_or_E_ucm" accesskey="r">Delete or Edit Upcoming movies</a></li>
                <li><a href="Ticket_Prices_Controller?action=d_or_E_tp" accesskey="p">Delete or Edit Ticket Prices</a></li>
                <li><a href="Show_Time_Controller?action=d_or_E_st" accesskey="p">Delete or Edit Show Times</a></li>
            </ul>


</li>

<li><a href="BookingController?action=show_booked_ticket" accesskey="s">View Booked Ticket</a></li>
<li><a href="UserController?action=logout" accesskey="s">Logout</a></li>
</ul>
</div>
<br></br>
<h7><center>Show Times</center></h7>

                
            
          <c:forEach items="${show_times_value}" var="items">
          <form>
              <table>
                   <tr><td>Morning Show</td><td><input type="text" name="mshow" value="${items.morning_show_time}" required/></td></tr>
                        <tr><td>Afternoon Show</td><td><input type="text" name="afshow1" value="${items.afternoon1_show_time}" required/> <br><input type="text" name="afshow2" value="${items.afternoon2_show_time}" required/> </td></tr>
                        <tr><td>Night Show</td><td><input type="text" name="nshow1" value="${items.night1_show_time}" required/>  <br> <input type="text" name="nshow2" value="${items.night2_show_time}" required/></td></tr>
                        
                 
              </table>
                        <div class="navigationbar3">
                <ul class="nav">
                    <li>
                         <a href="Show_Time_Controller?action=edit_show_time&&stid=${items.stid}">Edit Show Time &nbsp;&nbsp;</a>
                        <a href="Show_Time_Controller?action=delete_show_time&&stid=${items.stid}">Delete Show Time</a>  
              </li>
              
                </ul>
              
                </div>
              <br>

          </form>
              </c:forEach>
<br>
<div class="footer">
Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

</div><!--footer-->

  
</div><!---wrapper closed-->

            
    </body>
</html>
