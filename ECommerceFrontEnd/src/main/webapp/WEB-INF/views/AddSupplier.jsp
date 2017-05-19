<%@include file="AdminHome.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<center>
	<h2>Add Supplier</h2>

	<div id="addsupplier" class="container-fluid bg-grey">
		<div class="row">
			<div class="col-sm-5">

				<form:form method="POST" action="addsup" modelAttribute="supplier">

					<table style="width: 300px; height: 200px; cellpadding: 20px;">
						<c:if test="${!empty supplier.supplier_name}">
							<tr>
								<td><form:label path="supplier_id">ID</form:label></td>
								<td><form:input path="supplier_id" readonly="true" size="8"
										disabled="true" /> <form:hidden path="supplier_id" /></td>
							</tr>
						</c:if>
						<tr>
							<td><form:label path="supplier_name">Supplier-Name:</form:label></td>
							<td><form:input path="supplier_name" /></td>
						</tr>
						<tr>
							<td><form:label path="supplier_location">Location:</form:label></td>
							<td><form:input path="supplier_location" /></td>
						</tr>
						<tr>
							<c:if test="${empty supplier.supplier_name}">
								<td><input type="submit" value="Submit"
									style="color: blue; font-size: 13pt" /></td>
								<td><input type="reset" value="Cancel"
									style="color: red; font-size: 13pt" /></td>
							</c:if>
							<td colspan="2"><c:if
									test="${!empty supplier.supplier_name}">
									<input type="submit" value="Edit Supplier" />
								</c:if></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>

	<br> <br>

	<h2>Supplier List</h2>
	<c:if test="${!empty supplierList}">
		<table class="tg">
			<tr>
				<th>Supplier Id</th>
				<th>Supplier Name</th>
				<th>Location</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.supplier_id}</td>
					<td>${supplier.supplier_name}</td>
					<td>${supplier.supplier_location}</td>
					<td><a
						href="<c:url value='editsupplier${supplier.supplier_id}'/>">Edit</a></td>
					<td><a
						href="<c:url value='deletesupplier${supplier.supplier_id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</center>
<a href="AdminHome">Back</a>