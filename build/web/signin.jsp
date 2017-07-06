<?php
session_start();
mysql_connect("localhost","root","");
mysql_select_db("registercustomer");

$username=$_POST['username'];
$password=$_POST['password'];

$query="SELECT * FROM customerinfo where Username='$username' and Password='$password'";
$res=mysql_query($query);
$num=mysql_num_rows($res);


if($num==1)
{
	$_SESSION['permission'] ="granted";
	$_SESSION['username']=$username;
	header("location:insidelogin.php");
	}
	else
	{
		header("location:errorlogin.php");
		
		}
?>
</body>
</html>