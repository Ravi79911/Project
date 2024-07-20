<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Update Form</title>
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
                <a class="navbar-brand" href="#">Employee Management</a>
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
        <h1 class="text-center mt-3">Employee Update Form</h1>
        <div class="container">
        
            <form method="post" action="editEmployee" >
            <input type="hidden" name="id" value="${empty empMaster.id ? '' :  empMaster.id }" class="form-control" required>
                <table class="table table-bordered form-table">
                    <tbody>
                        <tr>
                            <th colspan="4">PERSONAL DETAILS</th>
                        </tr>
                        <tr>
                            <th>Full Name</th>
                            <td colspan="3"><input type="text" name="fullName" value="${empty empMaster.employeeName ? '' :  empMaster.employeeName }" class="form-control" required></td>
                        </tr>
                        <tr>
                            <th>Father's Name</th>
                            <td><input type="text" name="fatherName" value="${empty empPersonalDetails.fatherName ? '' :  empPersonalDetails.fatherName }" class="form-control" required></td>
                            <th>Mother's Name</th>
                            <td><input type="text" name="motherName" value="${empty empPersonalDetails.motherName ? '' :  empPersonalDetails.motherName }"  class="form-control" required></td>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <td><input type="email" value="${empty empPersonalDetails.email ? '' :  empPersonalDetails.email }" name="email"  class="form-control" required></td>
                            <th>Phone Number</th>
                            <td><input type="text" name="phone" value="${empty empPersonalDetails.phone ? '' :  empPersonalDetails.phone }"class="form-control" required></td>
                        </tr>
                        <tr>
                            <th>Gender</th>
                            <td><select name="gender" class="form-select"
                             value="${empty empPersonalDetails.gender ? '' :  empPersonalDetails.gender }"required>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                    <option value="other">Other</option>
                                </select></td>
                        </tr>
                        
                        <tr>
                            <th colspan="4">COMMUNICATION ADDRESS</th>
                        </tr>
                        <tr>
                            <th>House</th>
                            <td><input type="text" name="communicationHouse" value="${empty empPersonalDetails.communicationHouse ? '' :  empPersonalDetails.communicationHouse }" class="form-control" required></td>
                            <th>Street</th>
                            <td><input type="text" name="communicationStreet" value="${empty empPersonalDetails.communicationStreet ? '' :  empPersonalDetails.communicationStreet }"class="form-control" required></td>
                        </tr>
                        <tr>
                            <th>Landmark</th>
                            <td><input type="text" name="communicationLandmark" value="${empty empPersonalDetails.communicationLandmark ? '' :  empPersonalDetails.communicationLandmark }" class="form-control"></td>
                            <th>City</th>
                            <td><input type="text" name="communicationCity" value="${empty empPersonalDetails.communicationCity ? '' :  empPersonalDetails.communicationCity }" class="form-control" required></td>
                        </tr>
                        <tr>
                            <th>District</th>
                            <td><input type="text" name="communicationDistrict" value="${empty empPersonalDetails.communicationDistrict ? '' :  empPersonalDetails.communicationDistrict}" class="form-control" required></td>
                            <th>State</th>
                            <td><input type="text" name="communicationState" value="${empty empPersonalDetails.communicationState ? '' :  empPersonalDetails.communicationState }" class="form-control" required></td>
                        </tr>
                        <tr>
                            <th>PIN</th>
                            <td><input type="text" name="communicationPin" value="${empty empPersonalDetails.communicationPin ? '' :  empPersonalDetails.communicationPin }"class="form-control" required></td>
                        </tr>
                        
                    </tbody>
                </table>
                <div class="text-center">
                    <button type="submit" value="update"class="btn btn-primary">Save</button>
                </div>
            </form>
        </div>
    </main>
    <script>
        $(document).ready(function() {
            $('.add-dependent').click(function() {
                var newRow = '<tr>' +
                    '<td><input type="text" name="dependentName" class="form-control"></td>' +
                    '<td><input type="text" name="relation" class="form-control"></td>' +
                    '<td><input type="text" name="aadhaarNo" class="form-control"></td>' +
                    '<td><button type="button" class="btn btn-danger remove-dependent">Remove</button></td>' +
                    '</tr>';
                $(this).closest('tr').after(newRow);
            });

            $(document).on('click', '.remove-dependent', function() {
                $(this).closest('tr').remove();
            });
        });
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
