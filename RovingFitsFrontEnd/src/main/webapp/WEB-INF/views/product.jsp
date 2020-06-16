<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="cr2" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Products</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	font-family: Calibri;
	background-color: white;
	margin-bottom: 7%;
}

* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=number], textarea, select {
	width: 100%;
	padding: 5px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	font-size: 100%;
}

input[type=text]:focus, input[type=number]:focus, textarea:focus, select:focus
	{
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 6px 12px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: brown;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: brown;
	text-align: center;
}
</style>
</head>
<body>
	<c:if test="${info}">
		<div class="alert alert-success">${message}</div>
	</c:if>

	<div style="width: 50%; height: 50%; margin-left: 25%;">
		<div class="col-12" style="margin-top: 1%">
			<c:if test="${edit}">
				<c:set var="url" value="${cr2}/admin/updateproduct"></c:set>
			</c:if>
			<c:if test="${!edit}">
				<c:set var="url" value="${cr2}/admin/addproduct"></c:set>
			</c:if>

			<form:form action="${url}" method="post"
				modelAttribute="productobject" enctype="multipart/form-data">
				<div class="container">

					<c:if test="${edit}">
						<form:hidden id="product_Id" placeholder="Product Id"
							name="product_Id" path="product_Id"/>
					</c:if>

					<p
						style="font-size: 170%; font-family: algerian; text-align: center;">
						<ins>Product Page</ins>
					</p>

					<label for="product name"><b style="font-size: 130%;">Product
							Name</b></label>
					<form:input type="text" placeholder="Enter Your Name"
						path="product_Name"/>
					<form:errors path="product_Name" cssStyle="color:Red"></form:errors>
					<br> <label style="font-size: 130%;" for="description"><br><b>
					Description</b></label>
					<form:textarea style="font-size:110%;height:120px;"
						placeholder="Write Something..." path="product_Description" />
					<form:errors path="product_Description" cssStyle="color:Red"></form:errors>
					<br> <label for=" stock"><b style="font-size: 130%;">Stock</b></label>
					<form:input type="number" placeholder="Enter the Stock"
						name=" stock" path="product_Stock" />
					<form:errors path="product_Stock" cssStyle="color:Red"></form:errors>
					<br> <label for="price"><b style="font-size: 130%;">Price</b></label>
					<form:input type="number" step="any" placeholder="Enter Price"
						path="product_Price" />
					<form:errors path="product_Price" cssStyle="color:Red"></form:errors>
					<br> <label for="category_name"><b
						style="font-size: 130%;">Category Name</b></label><br>
					<form:select name="category_Name"
						path="product_Category.category_Id">

						<c:forEach items="${categorylist}" var="c">
							<option value="${c.category_Id}">${c.category_Name}</option>
						</c:forEach>
					</form:select>

					<form:input type="file" path="product_Images" />


					<button type="submit" class="registerbtn" style="font-size: 130%;"
						style="color:brown;">Submit</button>
				</div>
			</form:form>
		</div>
		</div>
		<div class="row" style="margin-bottom: 3%;">
			<div class="table-responsive table-bordered movie-table">
				<table class="table movie-table">

					<tr class="movie-table-head">
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Product Stock</th>
						<th>Product Price</th>
						<th>Product Category</th>
						<th>Images</th>
						<th>Edit/Delete</th>
					</tr>


					<c:forEach items="${productlist}" var="p">
						<tr>
							<td>${p.product_Id}</td>
							<td>${p.product_Name}</td>
							<td>${p.product_Stock}</td>
							<td>${p.product_Price}</td>
							<td>${p.product_Category.category_Name}</td>
							<td><img src="${cr2}/pimg/${p.product_Id}.jpeg" height="50px"></td>
							<td>
								<div class="row">
									<div class="col-6">
										<a href="${cr2}/admin/deleteproduct?prodid=${p.product_Id}"
											class="btn btn-danger">Delete</a>
									</div>
									<div class="col-6">
										<a href="${cr2}/admin/getproducttoedit?prodid=${p.product_Id}"
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