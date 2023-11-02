<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
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
            <th>DepartId</th>
            <th>DepartName</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${department.departId}</td>
            <td>${department.departName}</td>
            <td>${department.description}</td>
          </tr>
        </tbody>
      </table>
<div class="button">
    <span class="span label-danger" style="margin-left: 50%;"><a href="/">Back</a></span>
</div>


<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>