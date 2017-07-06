

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Ticket Price</title>
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
                    
<li>
    <a href="add_now_showing_movies.jsp" accesskey="r">Add Now Showing movies</a>
     <ul class="dropdown">
         <li><a href="add_now_showing_movies.jsp" accesskey="r">Add Now Showing movies</a></li>
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

            </div><!--navigationbar closed-->
            <br>
            <h7><Center>Add Ticket Prices</center></h7>
        <form action= "Ticket_Prices_Controller?action=add_ticket_prices" method="Post">
            <table>
                <tr><td>Day</td><td><input type="text" name="day" required/></td></tr>
                 <tr><td>Price</td><td><input type="text" name="price" required/></td></tr>
                 <tr><td><input type="submit" class=btn name="submit" value="Add Ticket Price"/></td></tr>
                
                
            </table>
            
            
        </form>
             <div class="footer">
                Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

            </div><!--footer-->
</div><!---wrapper closed-->
    </body>
</html>
