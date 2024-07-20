<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
	background-color: #f5f5f5;
}

.jumbotron {
	background-color: #ffffff;
	border-radius: 0;
	padding: 60px 30px;
	margin-bottom: 0;
}

footer {
	background-color: #333333;
	color: #ffffff;
	padding: 10px 0;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />

	<main>
		<div class="container">
			<div class="jumbotron">
				<h1 class="display-4">Welcome to User Management</h1>
				<p class="lead">Manage your User with ease and efficiency.</p>
				<hr class="my-4">
				<p>Use our intuitive interface to add, edit, and delete employee
					records.</p>
				<p class="lead">
					<a class="btn btn-primary btn-lg" href="register.jsp" role="button">Register
						User</a>
						 <a href="userlist" class="btn btn-success">User List</a>
				</p>
			</div>
		</div>
	</main>

	<jsp:include page="footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>
