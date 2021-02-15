<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>

	<h1>Rekareka Login</h1>
	<form action="/authenticate" method="post" enctype="application/json">
		<p>
			User-Name: <input type="text" name="userName" required />
		</p>
		<p>
			Password: <input type="password" name="password" required />
		</p>
		<h2><a href="http://localhost:9090/forgot">forget</a></h2>
		<p>
			<input type="submit" value="Login" />
		</p>
	</form>
</body>
</html>