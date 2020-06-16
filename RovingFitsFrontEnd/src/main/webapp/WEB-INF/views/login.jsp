<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<style>
body
{font-family: Arial, Helvetica, sans-serif;}
{box-sizing: border-box}
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
  opacity:1;
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
@h1
{
align: center;
}
@media screen and (max-width: 200px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
</style>
<body>
<c:if test="${info}">
		<div class="alert alert-success">${message}</div>
	</c:if>

<form action="perform_login"  method="post" style="border:1px solid #ccc">
  <div class="container">
    <h1>Login</h1>
    <hr>
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter your Email " name="user_name" id="user_name" required>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="user_password" id="user_password" required>
    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>
    <div class="container">
    <button type="submit" class="signupbtn">Sign In</button>
      <button type="button" class="cancelbtn">Cancel</button>
    </div>
  </div>
</form>

</body>
</html>
