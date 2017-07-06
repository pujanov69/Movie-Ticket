

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        populateForm();
});

function populateForm(){
    var form = document.forms['form'];
    form.elements["showtime"].value="${showtime}";
    form.elements['day'].value="${day}";
    
}


    function AddData(){

   var formInfo = document.forms['form'];

   formInfo.elements["seatData"].value=newArrayList;
    

  

  }</script>

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

<h7><center>Welcome ${loginuser.username} please Choose ShowTime And Day Below</center></h7><br>

        <form name="form" method="post" action="BookingController?action=SemiFinal">
            <table>
                <input type="hidden" value="${movie.get(0).nsmid}" name="nsmid">
                <tr><td>Choose Showtime</td>
                    <td>
                        <select name="showtime">
                            
                            <option value="${st.get(0).morning_show_time}">Morning Showtime &nbsp;&nbsp;&nbsp;(${st.get(0).morning_show_time})</option>
                            <option value="${st.get(0).afternoon1_show_time}">Afternoon Showtime &nbsp;(${st.get(0).afternoon1_show_time})</option>
                            <option value="${st.get(0).afternoon2_show_time}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                
                                (${st.get(0).afternoon2_show_time})</option>
                            <option value="${st.get(0).night1_show_time}">Night Showtime &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(${st.get(0).night1_show_time})</option>
                            <option value="${st.get(0).night2_show_time}">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                (${st.get(0).night2_show_time})</opton>
                        </select></td>
                </tr>
                
                <tr>
                    <td>Choose Day</td>
                    <td>
                        <select name="day">
                            
                            <option>Sunday</option>
                            <option>Monday</option>
                            <option>Tuesday</option>
                            <option>Wednesday</option>
                            <option>Thursday</option>
                            <option>Friday</option>
                            <option>Saturday</option>
                            
                        </select></td>
                </tr>
                <input type="hidden" value="" name="seatData">
                <input type="hidden" value="${movie.get(0).movie_name}" name="movie_name">
                <tr><td><input type="submit" class=btn value="view" name="Submit">
                        <input type="Submit" class=btn name="Submit" value="Submit" onclick="AddData();"></td></tr>

            </table>
                        
<%@include file="bookMap.jsp" %>
        </form>
                        <div class="footer">
Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

</div><!--footer-->

  
</div><!---wrapper closed-->
    </body>
</html>
