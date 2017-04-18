<%@include file="AdminHome.jsp" %>
<body>
Welcome ${loggedInUser}
<form action="validate">
<table>
<tr>
<td><label for="Categoryname">Category Name:</label></td>
<td><input type="text" id="categoryname" name="categoryname"></td></tr>
<tr>
<td><label for="categoryid">Category ID:</label></td>
<td><input type="text" id="categoryid" name="categoryid"></td></tr>
<tr>
<td><label for="categorydesc">Category Description:</label></td>
<td><input type="text" id="categorydesc" name="categorydesc"></td></tr>
<!-- <div id="lower"> -->
<tr>
<td><input type="submit" value="Submit"></td>
<td><input type="reset" value="Cancel"/></td></tr>
</table>
</form>

</body>
</html>