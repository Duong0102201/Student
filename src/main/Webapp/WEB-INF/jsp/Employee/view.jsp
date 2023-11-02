<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
 rel="stylesheet">
</head>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

a{
    color: #ffffff;
}

.button span{
    padding: 10px 30px;
    border-radius: 5px;
    width: 15px !important;
    height: 18px;
}

</style>

<body>

<h2> Detail Department : </h2>

 <table class="table table-striped">
        <thead>
          <tr>
            <th>EmployeeId</th>
            <th>EmployeeName</th>
            <th>Age</th>
            <th>Sex</th>
            <th>Birthday</th>
            <th>DepartName</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${employee.empId}</td>
            <td>${employee.empName}</td>
            <td>${employee.age}</td>
            <td>
              <c:if test="${employee.sex  == 0}"> Nu</c:if>
              <c:if test="${employee.sex  == 1}"> Nam</c:if>
            </td>
            <td>
                <fmt:formatDate value="${employee.birthday}" pattern="dd-MM-yyyy"/>
            </td>
            <td>${employee.departmentName}</td>
          </tr>
        </tbody>
      </table>
<div class="button">
    <span class="span label-danger" style="margin-left: 50%;"><a href="/emp">Back</a></span>
</div>


<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>