<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}
{
box-sizing:
border-box
}
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

.cancelbtn, .signupbtn {
	float: left;
	width: 15%;
}

.container {
	padding: 16px;
}

.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

@
h1 {
	align: center;
}

@media screen and (max-width: 200px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}
</style>
<body>

	<form:form action="addcustomer" style="border: 1px solid #ccc"
		method="post" modelAttribute="customerobject">
		<div class="container">
			<h1>Register</h1>
			<hr>
			<label for="fnme"><b>Name</b></label>
			<form:input type="text" placeholder="Enter your User Name" name="nme" path="customer_Name" />
			<form:errors path="customer_Name" cssStyle="color:Red"></form:errors>
			<br> <label for="email"><b>Email</b></label>
			<form:input type="text" placeholder="Enter Email" name="email" path="customer_Email" />
			<form:errors path="customer_Email" cssStyle="color:Red"></form:errors>
			<br> <label for="phno"><b>Phone Number</b></label>
			<form:input type="text" placeholder="Enter your Phone Number" name="phno" path="customer_PhoneNo" />
			<form:errors path="customer_PhoneNo" cssStyle="color:Red"></form:errors>
			<br> <label for="psw"><b>Password</b></label>
			<form:input type="password" placeholder="Enter Password" name="psw" path="customer_Password" />
			<form:errors path="customer_Password" cssStyle="color:Red"></form:errors>
			<br> <input type="checkbox" checked="checked" name="remember"
				style="margin-bottom: 15px"> Remember me</div>
			<div class="clearfix">
				<button type="submit" class="signupbtn">Sign Up</button>
				<button type="button" class="cancelbtn">Cancel</button>
			</div>
			<div class="container signin">
				<p>
					Already have an account? <a href="#">Sign in</a>.
				</p>
			</div>
	</form:form>

</body>
</html>
