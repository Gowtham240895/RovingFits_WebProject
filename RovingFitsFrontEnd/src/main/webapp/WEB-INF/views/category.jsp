<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="cr2" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	font-family: Calibri;
	background-color: white;
}

* {
	box-sizing: border-box;
}

.container {
	padding: 16px;
	background-color: white;
}

input[type=text] {
	width: 100%;
	padding: 10px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	font-size: 100%;
}

input[type=text]:focus, input[type=password]:focus, input[type=email]:focus,
	input[type=tel]:focus {
	background-color: #ddd;
	outline: none;
}
/* Overwrite default styles of hr */
hr {
	border: 1px solid #5eff9f;
	margin-bottom: 25px;
}
/* Set a style for the submit button */
.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 4px 8px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}
}
</style>
</head>
<body>
	<div style="width: 50%; height: 50%; margin-left: 25%;">
		<c:if test="${info}">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<c:if test="${edit}">
			<c:set value="${cr2}/admin/updatecategory" var="url"></c:set>
		</c:if>

		<c:if test="${!edit}">
			<c:set value="${cr2}/admin/addcategory" var="url"></c:set>
		</c:if>
		<!-- we need to make this form a spring form to do this we will add the tag lib of my spring form -->
		<form:form action="${url}" method="post"
			modelAttribute="categoryobject">
			<c:if test="${edit}">
				<form:hidden path="category_Id"/>
			</c:if>

			<div class="container">
				<p style="text-align: center;">
					<ins>Categories</ins>
				</p>
				<p style="text-align: center">Please Enter The Category Details.</p>
				<hr>
				<label for="category_Name"><b style="text-align: center;">Category Name</b></label>
				<form:input type="text" placeholder="Enter The Category Name" name="category_Name" path="category_Name" />
				<form:errors path="category_Name" Cssstyle="color:Red"></form:errors>
				<button type="submit" class="registerbtn" style="font-size: 100%;">Submit</button>
				<br> <br>
				<hr>
			</div>
		</form:form>
	</div>
	<div class="row" style="margin-bottom: 3%;">
		<div class="table-responsive table-bordered movie-table">
			<table class="table movie-table">

				<tr class="movie-table-head">
					<th>Category Id</th>
					<th>Category Name</th>
					<th>Edit/Delete</th>
				</tr>
				<c:forEach items="${categorylist}" var="c">
					<tr>
						<td>${c.category_Id}</td>
						<td>${c.category_Name}</td>
						<td>
							<div class="row">
								<div class="col-6">
									<a href="${cr2}/admin/deletecategory?catname=${c.category_Name }"
										class="btn btn-danger">Delete</a>
								</div>
								<div class="col-6">
									<a href="${cr2}/admin/getdatatoedit?catname=${c.category_Name }"
										class="btn btn-success">Edit</a>
								</div>
							</div>
						</td>

					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>