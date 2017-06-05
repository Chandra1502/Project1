<%@include file="Header.jsp"%>

<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="/ECommerceFrontEnd/resources/css/login.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>

	<div class="container">
		<div class="wrapper">
			<form action="perform_login" method="post" name="Login_Form"
				class="form-signin">
				<div class="row text-center bol">
					<i class="fa fa-circle"></i>
				</div>
				<h3 class="form-signin-heading text-center">
					<img src="/ECommerceFrontEnd/resources/images/TMLogo.jpg"
						alt="TouchM" />
				</h3>
				<hr class="spartan">
				<div class="input-group">
					<span class="input-group-addon" id="sizing-addon1"> <i
						class="fa fa-user"></i>
					</span> <input type="email" class="form-control" name="username"
						placeholder="abc@xxx.com" required />
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="sizing-addon1"> <i
						class="fa fa-lock"></i>
					</span> <input type="password" class="form-control" name="password"
						placeholder="Password" required />
				</div>
				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="Entrar" type="Submit">Submit</button>
			</form>
		</div>
	</div>

</body>
</html>

<%@include file="Footer.jsp"%>