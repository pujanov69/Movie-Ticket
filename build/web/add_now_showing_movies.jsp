<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Add Now Showing Movies</title>
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

    <body background="image/background.jpg">
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
            <div class="register">
                <form action= "FileUploadHandler" method="Post" enctype="multipart/form-data">
                    <table>
                        <tr><td colspan="2"><h7>Add Now Showing Movies</h7></td></tr>
                        <tr><td>Movie Name:</td><td><input type="text" name="movie_name" required/></td></tr>
                        
                        <tr><td>Movie Photo:</td><td><input type="file" name="movie_photo" required></td></tr>

                        <tr><td><input type="submit" class=btn name="submit" value="Add Movie"/></td></tr>
                    </table>
                </form>
            
            </div><!--register close-->
            <div class="footer">
                Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

            </div><!--footer-->
</div><!---wrapper closed-->
    </body>
</html>


