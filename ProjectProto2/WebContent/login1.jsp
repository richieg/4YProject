<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tead@s</title>
<%@ include file="head.jsp" %>
</head>
<body>
<div class="container-fluid" style="width:488px;margin: 0 auto">



<h1>Welcome to Teadas User Login</h1>
<p>Please enter your user credentials below</p>
<form class="form" action="LoginUser" method="post">
<div class="form-group">
Username: <input type="text" name="user">
</div>
  <div class="form-group">
Password: <input type="password" name="pwd">
</div>
<input type="submit" value="Login">
</form>
</div>

</body>
</html>