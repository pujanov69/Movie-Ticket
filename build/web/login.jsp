<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
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
<li><a href="index.jsp" accesskey="h">Home</a></li>
   
<li><a href="Movies?action=nowshowing" accesskey="n">Now Showing Movies</a></li>

<li><a href="Movies?action=upcoming" accesskey="u">Upcoming Movies</a></li>

<li><a href="Ticket_Prices_Controller?action=show_ticket_price" accesskey="t">Ticket Prices</a></li>

<li><a href="Movies?action=book" accesskey="b">Book Ticket</a></li>
<li><a href="Show_Time_Controller?action=show_showtime" accesskey="s">Showtimes</a></li>
<li class="current"><a href="login.jsp" accesskey="l">Login</a></li>
<li><a href="signup.jsp" accesskey="r">Register</a></li>

</ul>

</div><!--navigationbar closed-->

<div class="login">
<div class="loginbanner">
<img src="image/loginbanner.jpg" alt="login banner"/>
</div>
<div class="loginform">
<form name="form" method="post" action="UserController">

User Name:
<input type="text" name="username" size="40"/>
Password:
<input type="password" name="password" size="40"/>
<input type="submit" class="btn" value="Login" name="submit"/>



</form>

</div>


</div><!--login close-->

<div class="signup">
New To Sky Cinema?? <a href="signup.jsp">Click here to Sign-Up</a>

</div><!--signup close-->


<div class="footer">
Copyright © 2017 All Rights Reserved Designed By Gautam Bhattarai

</div><!--footer-->

  
</div><!---wrapper closed-->
</body>
</html>