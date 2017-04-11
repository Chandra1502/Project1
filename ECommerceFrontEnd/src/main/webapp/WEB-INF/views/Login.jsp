<%@include file="Header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-xs-6">
			<form action="Validate">
				<table style="float:left">
					<tr>
						<th align="left" style="color: midnightblue">Existing User,
							Login here:</th>
					</tr>
					<tr>
						<th>Username</th>
						<td align="left"><input type="text" name="username"></td>
					</tr>
					<tr>
						<th>Password</th>
						<td align="left"><input type="password" name="password"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><input type="submit" name="submitlogin"
							value="Ok"></td>
				</table>
			</form>
		</div>
		<div class="col-xs-6">
			<table style="float:right">
				<tr>
					<th></th>
					<th style="color: midnightblue; float: right;">New User, Register here:</th>
				</tr>
				<tr>
					<th style="float: left">Username</th>
					<td><input type="text" name="user"></td>
				</tr>
				<tr>
					<th style="float: left">Password</th>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<th style="float: left">Confirm Password</th>
					<td><input type="password" name="confirmpassword"></td>
				</tr>
				<tr>
					<th style="float: left">E-mail</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th></th>
					<td style="float: right"><input type="submit"
						name="submitregister"></td>
			</table>

		</div>
	</div>
</div>
<%@include file="Footer.jsp"%>