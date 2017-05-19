<%@include file="AdminHome.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<center>
	<h2>Add Category</h2>

	<div id="addcategory" class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-5">

				<form:form method="POST" action="addcat" modelAttribute="category">

					<table style="width: 300px; height: 200px; cellpadding: 20px;">
						<c:if test="${!empty category.category_name}">
							<tr>
								<td><form:label path="category_id">ID</form:label></td>
								<td><form:input path="category_id" readonly="true" size="8"
										disabled="true" /> <form:hidden path="category_id" /></td>
							</tr>
						</c:if>
						<tr>
							<td><form:label path="category_name">Category-Name:</form:label></td>
							<td><form:input path="category_name" /></td>
						</tr>
						<tr>
							<td><form:label path="category_description">Description:</form:label></td>
							<td><form:input path="category_description" /></td>
						</tr>
						<tr>
							<c:if test="${empty category.category_name}">
								<td><input type="submit" value="Submit"
									style="color: blue; font-size: 13pt" /></td>
								<td><input type="reset" value="Cancel"
									style="color: red; font-size: 13pt" /></td>
							</c:if>
							<td colspan="2"><c:if
									test="${!empty category.category_name}">
									<input type="submit" value="Edit category" />
								</c:if></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>

	<br> <br>

	<h2>Category List</h2>
	<c:if test="${!empty categoryList}">
		<table class="tg">
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
</center>
<a href="AdminHome">Back</a>