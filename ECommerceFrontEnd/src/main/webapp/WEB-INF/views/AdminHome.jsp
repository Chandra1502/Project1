<%@include file="AdminHeader.jsp"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">TouchM</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="AddProduct">Add Products</a></li>
					<li><a href="#">View</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Categories <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="AddCategory"> Add Categories</a></li>
					<li><a href="#">View</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Suppliers <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="AddSupplier">Add Suppliers</a></li>
					<li><a href="#">View</a></li>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="perform_logout"><span
					class="glyphicon glyphicon-log-out"></span>Logout</a></li>
		</ul>
	</div>
</nav>

