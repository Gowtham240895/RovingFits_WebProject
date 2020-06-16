<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div style="min-heght: 400px;">
		<c:if test="${indexpage}">
			<jsp:include page="slider.jsp"></jsp:include>
		</c:if>
		<c:if test="${aboutuspage}">
			<jsp:include page="aboutus.jsp"></jsp:include>
		</c:if>
		<c:if test="${contactuspage}">
			<jsp:include page="contactus.jsp"></jsp:include>
		</c:if>
		<c:if test="${categorypage}">
			<jsp:include page="category.jsp"></jsp:include>
		</c:if>
		<c:if test="${productpage}">
			<jsp:include page="product.jsp"></jsp:include>
		</c:if>
		<c:if test="${productdetails}">
			<jsp:include page="oneproduct.jsp"></jsp:include>
		</c:if>
		<c:if test="${allproductpage}">
			<jsp:include page="allproduct.jsp"></jsp:include>
		</c:if>
		<c:if test="${registerpage}">
			<jsp:include page="register.jsp"></jsp:include>
		</c:if>
		<c:if test="${loginpage}">
			<jsp:include page="login.jsp"></jsp:include>
		</c:if>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>