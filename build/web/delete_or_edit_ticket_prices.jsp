
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>delete_or_edit_ticket_prices</title>
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
<h7><center>Ticket Prices</center></h7>

         <c:forEach items="${ticket_price_value}" var="items">

               <form>
            <table>
                <tr><td>Day</td><td><input type="text" name="day" value="${items.day}" required/></td></tr>
                <tr><td>Price</td><td><input type="text" name="price" value="${items.price}" required/></td></tr>
                 
                        
                
                
            </table>
                
                <div class="navigationbar2">
                <ul class="nav">
                    <li>
         <a href="Ticket_Prices_Controller?action=edit_ticket_prices&&tpid=${items.tpid}">Edit Price &nbsp;&nbsp;</a>
         
                        <a href="Ticket_Prices_Controller?action=delete_ticket_prices&tpid=${items.tpid}">Delete price</a>  
            </li>
            <br>
                </ul>
            <br>
            
                </div>
            <br>
        </form>
            <br>

            </c:forEach>

<div class="footer">
Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

</div><!--footer-->

  
</div><!---wrapper closed-->

    </body>
</html>
