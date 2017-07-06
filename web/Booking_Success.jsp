
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Ticket</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
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
         
        <div id="ticket">
            <h1><center>Congratulation Your Booking is Successful <br> Your-E ticket Of Sky Cinema </center></h1> 
            <table border="5">
                <tr><td>User Name:</td><td>${booking.user_name}</td></tr>
                <input type="hidden" name="username" value="${loginuser.username}">
                <tr><td>Movie You Choosed:</td><td>${booking.movie_choosen}</td></tr>
                <input type="hidden" name="movie_choosen" value="${showtime}">
                
                <tr><td>Show Time Chosen</td><td>${booking.showtime_choosen}</td></tr>
                <tr><td>Day Chosen</td><td>${booking.day_choosen}</td></tr>
                <tr><td>Paid Amount</td><td>${booking.payment}</td>
            </table>
        </div>
            <br>
         <h1><center><a class="btn" href="#" onclick="savePdf()">click here to get E-Ticket</a></center></h1>
         <br>
        <script src='jquery.min.js'></script>
        <script src='jspdf/dist/jspdf.debug.js'></script>
	<script src='jspdf/libs/html2pdf.js'></script>
        <script>
            function savePdf(){
		var source = $("#ticket")[0];
		var pdf = new jsPDF('l', 'pt', 'letter');
                
                var margins={
                    top:50,
                    left:60,
                    width:600
                };
                pdf.fromHTML(
                    source,
                    margins.left,
                    margins.top,
                    {
                        'width':margins.width
                    },
                    function(dispose){
                        pdf.save("pdf.pdf");
                    }
                )
            }
     </script>
     
     <div class="footer">
Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

</div><!--footer-->
     </div><!---wrapper closed-->
    </body>
</html>
