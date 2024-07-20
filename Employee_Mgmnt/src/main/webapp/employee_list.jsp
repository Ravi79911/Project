<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <style>
        html, body {
            height: 100%;
        }

        body {
            display: flex;
            flex-direction: column;
        }

        main {
            flex: 1;
             margin-top: 60px;
        }
        
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Employee Management</a>
            <button class="navbar-toggler" type="button"
                    data-bs-toggle="collapse" data-bs-target="#navbarColor01"
                    aria-controls="navbarColor01" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item"><a class="nav-link active"
                                            href="index.jsp">Home <span class="visually-hidden">(current)</span>
                    </a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<main class="flex-shrink-0">
    <div class="container">
        <h2 class="mt-5">Employee List</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Employee Code</th>
                <th>Name</th>
                <th>Father's Name</th>
                <th>Created Date</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.employeeCode}</td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.employeeFatherName}</td>
                    <td>${employee.createdDate}</td>
                    <td>
                        <a href="editEmployee?id=${employee.id}" class="btn btn-primary btn-sm">Edit</a>
                        <a href="employeeDelete?id=${employee.id}" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
<footer class="footer mt-auto py-3 bg-light">
    <div class="container text-center">
        <span class="text-muted">Employee Management System &copy; 2024</span>
    </div>
</footer>
</body>
</html>
