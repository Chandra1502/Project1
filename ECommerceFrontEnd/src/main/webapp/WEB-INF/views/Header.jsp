<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="body">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-md-3 col-lg-2 myImage">
				<a href="Home"> <img src="resources/images/TMLogo.jpg"
					alt="TouchM" style="float: left; width: 100px; height: 90px;">
				</a>
			</div>
			<div class="col-xs-12 col-md-6 col-lg-8">
				<div class="middle">
					<h1 class="name">
						<b>TouchM</b>
					</h1>
					<p>The One stop site for Smart Phones.
				</div>
			</div>
			<div class="col-xs-12 col-md-3 col-lg-2 myGlyph">
				<p style="margin: 0px;font-size:15px">Contact Us:</p>
				<p style="margin: 0px">
					<span class="glyphicon glyphicon-earphone" style="color: #ffff00"></span>
					+91 9876543210
				</p>
				<p style="margin: 0px">
					<span class="glyphicon glyphicon-envelope" style="color: #ffff00"></span>
					touchm@gmail.com
				</p>
			</div>
		</div>
	</div>
	<nav class="navbar navbar-inverse" style="background-color:yellow">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">TouchM</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">OS<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Android</a></li>
            <li><a href="#">IOS</a></li>
            <li><a href="#">Windows</a></li>
            <li><a href="#">BlackBerry</a></li>
          </ul>
        </li>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Mobiles</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Login"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>