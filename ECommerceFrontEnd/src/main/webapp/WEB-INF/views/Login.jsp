<%@include file="Header.jsp"%>


<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<center><b><h2 style="font-size: 350%; color: RGB(26, 92, 183);">Login Form</h2></b></center>
			<br>
			<form action="perform_login" method="post">
				<div class="login" style="position: auto">
					<div class="form-group">
						<label for="username">User Name</label><br>
						<label><input type="text"
							name="username" placeholder="Enter your username"></label>
					</div>
					<div class="form-group">
						<label for="username">Password</label><br>
						<label><input type="password"
							name="password" placeholder="Enter your password"></label>
					</div>
					<button class="btn-login">Login</button>
				</div>
			</form>
		</div>
		<div class="col-sm-4"></div>
	</div>
</div>

<%@include file="Footer.jsp"%>