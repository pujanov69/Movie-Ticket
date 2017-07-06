
<?php
mysql_connect("localhost","root","");
mysql_select_db("registercustomer");
?>
<?php
$username = $_POST['username'];	
$password = $_POST['password'];		
$phone = $_POST['phone'];	
$gender = $_POST['gender'];
$country = $_POST['country'];
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																										
$query= "insert into customerinfo (`ID`, `Username`, `Password`, `Phone`, `Gender`, `Country`) VALUES(Null,'$username','$password','$phone','$gender','$country')";
mysql_query($query);
header("location:finish.php");

//header("location:complete.php");

?>
