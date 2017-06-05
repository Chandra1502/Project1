<%@include file="AdminHome.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Add Supplier</title>
<style>
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: black;
}

.tg td {
	font-family: calibri;
	font-size: 14px;
	font-weight: bold;
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
	font-family: calibri;
	font-size: 18px;
	font-weight: bold;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: midnightblue;
	background-color: lightgrey;
	text-align : center;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
<center>

	
				<form:form method="POST" action="addcat" modelAttribute="category">
					<h2>Add Category</h2>
					<table class="tg text-center">
						<c:if test="${!empty category.category_name}">
							<tr>
								<td><form:label path="category_id">ID</form:label></td>
								<td><form:input path="category_id" readonly="true" size="8"
										disabled="true" /> <form:hidden path="category_id" /></td>
							</tr>
						</c:if>
						<tr>
							<td><form:label path="category_name">Category-Name:</form:label></td>
							<td><form:input path="category_name" required="required"/></td>
						</tr>
						<tr>
							<td><form:label path="category_description">Description:</form:label></td>
							<td><form:input path="category_description" required="required" /></td>
						</tr>
						<tr>
							<c:if test="${empty category.category_name}">
								<td><input type="submit"
							value="Submit" style="font-size: 15px;" /></td>
							<td><input type="reset" value="Cancel"
							style="font-size: 15px" /></td>
							</c:if></tr>
							<tr>
							<c:if
									test="${!empty category.category_name}">
									<td><input type="submit" value="Edit category" /></td>
								</c:if></tr>
			
					</table>
				</form:form>

	<br> <br>

	<h2>Category List</h2>
	<c:if test="${!empty categoryList}">
		<table class="tg text-center">
			<tr>
				<th>Category Id</th>
				<th>Category Name</th>
				<th>Description</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.category_id}</td>
					<td>${category.category_name}</td>
					<td>${category.category_description}</td>
					<td><a
						href="<c:url value='editcategory${category.category_id}'/>">Edit</a></td>
					<td><a
						href="<c:url value='deletecategory${category.category_id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

<a href="AdminHome">Back</a>