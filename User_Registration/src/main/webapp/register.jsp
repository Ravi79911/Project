<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
body {
    padding-top: 4.5rem;
    padding-bottom: 4.5rem;
}

.form-table {
    width: 100%;
}

.form-table th, .form-table td {
    padding: 10px;
}
</style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">User Management</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarColor01">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item"><a class="nav-link active" href="index.jsp">Home <span class="visually-hidden">(current)</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <h1 class="text-center mt-3">User Registration Form</h1>
        <div class="container">
            <form method="post" action="register">
                <table class="table table-bordered form-table">
                    <tbody>
                        <tr>
                            <th colspan="4">PERSONAL DETAILS</th>
                        </tr>
                        <tr>
                            <th>Name</th>
                            <td colspan="3"><input type="text" name="name" class="form-control" required></td>
                        </tr>
                       
                        <tr>
                            <th>Email</th>
                            <td><input type="email" name="email" class="form-control" required></td>
                            <th>Addrs</th>
                            <td><input type="text" name="addrs" class="form-control" required></td>
                        </tr>
                       
                    </tbody>
                </table>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
        </div>
    </main>
    
    
</body>
</html>
