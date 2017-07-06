

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>

<link rel="stylesheet" href="blueberry.css" />
<style type="text/css">
<!--
* {
	margin: 0;
	border: 0;
	padding: 0;
}
body {
	background: #f0f0f0;
	font: 14px/20px Arial, San-Serif;
	color: #404040;
}
a { color: #264c99; text-decoration: none; }
a:hover { text-decoration: underline; }

h1,h2,h3,h4,p { margin-bottom: 20px; }
h1 {
	font-size: 48px;
	line-height: 60px;
	color: #ffffff;
	text-transform: lowercase;
}
h2, h3 {
	font-weight: normal;
	font-size: 22px;
	line-height: 40px;
	color: #808080;
}
h3 { font-size: 18px; color: #404040; }
h5 { font-weight: bold; font-size: 14px; color: #000; }

#header {
	height: 60px;
	padding-top: 20px; padding-bottom: 20px;
	text-align: center;
	background: #405580;
}
#header h1 {
	margin: 0 auto;
	min-width: 740px;
	max-width: 1140px;
}

.blueberry { max-width: 960px; margin : 0 auto;
padding : 0;}

-->
</style>

<script src="jquery.min.js"></script>
<script src="hairsaloon.js"></script>

<script>
$(window).load(function() {
	$('.blueberry').blueberry();
});
</script>
    </head>
    <body>
        <div class="wrapper">

<div class="banner">
<img src="image/banners.jpg" alt="Banner" />
</div><!--banner closed-->

<div class="navigationbar">
<ul class="nav">

   
<li><a href="Movies?action=nowshowing" accesskey="n">Now Showing Movies</a></li>
<li><a href="Movies?action=upcoming" accesskey="n">Upcoming Movies</a></li>
<li><a href="Ticket_Prices_Controller?action=show_ticket_price" accesskey="t">Ticket Prices</a></li>
<li class="current"><a href="Movies?action=book" accesskey="b">Book Ticket</a></li>
<li><a href="Show_Time_Controller?action=show_showtime" accesskey="s">Showtimes</a></li>
<li><a href="UserController?action=logout" accesskey="s">Logout</a></li>
 

</ul>

</div><!--navigationbar closed-->
<br>

    
    
<h7><center>Your Booking Information</center></h7>
<br>

        <form action="BookingController?action=finalbooking" method="Post">
            <table>
                <tr><td>User Name:</td><td>${loginuser.username}</td></tr><input type="hidden" name="username" value="${loginuser.username}">
                <tr><td>Movie You Choosed:</td><td>${movie.get(0).movie_name}</td></tr><input type="hidden" name="movie_choosen" value="${movie.get(0).movie_name}">
                <tr><td>Showtime You Choosed:</td><td>${showtime}</td></tr><input type="hidden" name="showtime_choosen" value="${showtime}">
                <tr><td>Day You Choosed:</td><td>${day}</td></tr><input type="hidden" name="day_choosen" value="${day}">
                <tr><td>You Should Pay:</td><td>${price}</td></tr><input type="hidden" name="payment" value="${price}">
                <tr><td>Seats</td><td>${seatData}</td></tr><input type="hidden" name="seatData" value="${seatData}">
                <tr><td>Your Gender:</td><td>${loginuser.gender}</td></tr><input type="hidden" name="gender" value="${loginuser.gender}">
                <tr><td>Your Mobile:</td><td>${loginuser.mobile}</td></tr><input type="hidden" name="address" value="${loginuser.mobile}">
               
                <tr><td>Your Email:</td><td>${loginuser.email}</td></tr><input type="hidden" name="email" value="${loginuser.email}">
                
                <tr><td><input type="submit" class=btn name="submit" value="Click Here to Confirm Your Booking"/></td></tr>
            </table>
            
        </form>
        
        <div class="footer">
Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

</div><!--footer-->

  
</div><!---wrapper closed-->
    </body>
</html>
