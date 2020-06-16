<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="cr2" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>RovingFits</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
.bs-example {
	margin: 20px;
}

.topnav-right {
	float: right;
}
</style>
</head>
<body>
	<div class="bs-example">
		<nav class="navbar navbar-expand-md navbar-light bg-light">
			<a href="home" class="navbar-brand"> <img
				src="${cr2}img\RovingFits.JPG" height="50" alt="RovingFits" />
			</a>
			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<div class="navbar-nav">
					<c:choose>
						<c:when test="${sessionScope.adminrole}">
							<a href="${cr2}/home" class="nav-item nav-link active">Home</a>
							<a href="${cr2}/aboutus" class="nav-item nav-link">About Us</a>
							<a href="${cr2}/contactus" class="nav-item nav-link">Contact
								Us</a>
							<a href="${cr2}/admin/category" class="nav-item nav-link">Manage
								Category</a>
							<a href="${cr2}/admin/product" class="nav-item nav-link">Manage
								Product</a>
							<li class="nav-item "><a class="nav-link"
							href="logout">Hello ${sessionScope.username}Logout</a></li>
						</c:when>
						<c:when test="${userrole}">
						<li class="nav-item "><a class="nav-link" href="${cr2}/home">Home</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr2}/aboutus">About Us</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr2}/contactus">Contact US</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr2}/allproducts"> Product </a></li> 
						<li class="nav-item "><a class="nav-link"
							href="${cr2}/user/viewcart">
							 <i class="fa fa-shopping-cart ico5 "><sup>${cartqty}</sup></i></a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr2}/user/viewallorders"> UserOrder </a></li> 
						<li class="nav-item "><a class="nav-link"
							href="logout">Welcome ${sessionScope.username} Logout </a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item "><a class="nav-link" href="${cr2}/home">Home</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr2}/aboutus">About Us</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr2}/contactus">Contact Us</a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr2}/allproducts"> Product </a></li>
						<li class="nav-item "><a class="nav-link"
							href="${cr2}/user/viewcart"> Cart </a></li>
						<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${cr2}/register">Register</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>							<div class="topnav-right">
								<div class="navbar-nav ml-led">
									<form class="form-inline">
										<input class="form-control mr-sm-2" type="search"
											placeholder="Search Something..." aria-label="Search">
										<button class="btn btn-light" type="submit">Search</button>
									</form>
								</div>
							</div>
					</div>
			</div>
		</nav>
	</div>
</body>
</html>
