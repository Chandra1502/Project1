<%@include file="Header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="col-sm-6">
				<div class="thumbnail">
					<img src="/ECommerceFrontEnd/resources/images/${product.product_name}.jpg" alt="product image">
				</div>
			</div>
			<div class="col-sm-6">
				<table class="table table-responsive">
					<tr>
						<td>Product Name</td>
						<td>${product.product_name}</td>
					</tr>
					<tr>
						<td>Product quantity</td>
						<td>${product.product_quantity}</td>
					</tr>
					<tr>
						<td>Product Price</td>
						<td>${product.product_price}</td>
					</tr>
					<tr>
						<td><a href="addcart"><input
								type="submit" value="Add to Cart" /></a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="col-sm-3"></div>
</div>

<%@include file="Footer.jsp"%>