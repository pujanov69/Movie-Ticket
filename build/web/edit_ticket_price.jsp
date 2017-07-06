

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Ticket Prices</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">


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
    
        <form action= "Ticket_Prices_Controller?action=edit_ticket_prices" method="Post">
            <table>
                <input type="hidden" name="tpid" value="${ticket_price.tpid}">
                <tr><td>Day:</td><td><input type="text" name="day" value="${ticket_price.day}" required/></td></tr>
                <tr><td>Price:</td><td><input type="text" name="price" value="${ticket_price.price}" required/></td></tr>
                <tr><td><input type="submit" class=btn name="submit" value="Edit Ticket Price"/></td></tr>
            </table>
            
            
        </form>
                <div class="footer">
                Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

            </div><!--footer-->
                
</div>
    </body>
</html>
