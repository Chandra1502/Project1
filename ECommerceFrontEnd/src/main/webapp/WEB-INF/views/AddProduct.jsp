<%@include file="AdminHome.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Add product</title>
<style>
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: blue;
	background-color: red;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<center>
		<form:form method="POST" action="addprod" commandName="product"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td><h2>Add Product</h2></td>
				</tr>
				<c:if test="${!empty product.product_name}">
					<tr>
						<td><form:label path="product_id">ID</form:label></td>
						<td><form:input path="product_id" readonly="true" size="8"
								disabled="true" /> <form:hidden path="product_id" /></td>
					</tr>
				</c:if>

				<tr>
					<td><form:label path="product_name">Product Name</form:label></td>
					<td><form:input path="product_name" /></td>
				</tr>

				<tr>
					<td><form:label path="product_price">Price</form:label></td>
					<td><form:input path="product_price" /></td>
				</tr>

				<tr>
					<td><form:label path="product_quantity">Quantity</form:label></td>
					<td><form:input path="product_quantity" /></td>
				</tr>

				<tr>
					<td><form:label path="product_weight">Weight</form:label></td>
					<td><form:input path="product_weight" /></td>
				</tr>
				<!--  select:dropdown, items:collection ,itemValue: name to item-->
				<tr>
					<td>Category</td>
					<td><form:select path="category_id" items="${categoryList}"
							itemValue="category_id" itemLabel="category_id">
						</form:select></td>
				</tr>

				<tr>
					<td>Supplier</td>
					<td><form:select path="supplier_id" items="${supplierList}"
							itemValue="supplier_id" itemLabel="supplier_id">
						</form:select></td>
				</tr>

				<tr>
					<td><form:label path="image">Select Image:</form:label></td>

					<td><form:input type="file" path="image" /></td>
				</tr>
				<tr>
					<c:if test="${empty product.product_name}">
						<td style="text-align: center;"><input type="submit"
							value="Submit" style="font-size: 15pt;" /></td>
						<td><input type="reset" value="Cancel"
							style="font-size: 15pt" /></td>
					</c:if>

					<c:if test="${!empty product.product_name}">
						<td><input type="submit" value="Edit Product" /></td>
					</c:if>

				</tr>
			</table>
		</form:form>

		<h2>Product List</h2>

		<!-- core tags ,if or choose  ,$-expression language -->

		<c:if test="${!empty productList}">
			<table class="tg">
				<tr>
					<th>Product Id</th>
					<th>ProductName</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Weight</th>
					<th>Category Id</th>
					<th>Supplier Id</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.product_id}</td>
						<td>${product.product_name}</td>
						<td>${product.product_price}</td>
						<td>${product.product_quantity}</td>
						<td>${product.product_weight}</td>
						<td>${product.category.category_id}</td>
						<td>${product.supplier.supplier_id}</td>
						<td><a
							href="<c:url value='/editproducts${product.product_id}'/>">Edit</a></td>
						<td><a
							href="<c:url value='/deleteproduct${product.product_id}'/>">Delete</a></td>
					</tr>
				</c:forEach>


			</table>
		</c:if>

		<a href="AdminHome">Back</a>
</body>
</html>