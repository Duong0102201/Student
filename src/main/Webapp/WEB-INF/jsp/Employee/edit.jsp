<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
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
</style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<h2>Edit Employee</h2>

    <form method="post" action="/Employee/update" style="margin-left: 40px;"
        modelAttribute="employee">

        <input  type="hidden" id="emp_id" name="emp_id" value="${employee.empId}" <br></br>
           EmployeeName :
          <input type="text" id="emp_name" name="emp_name" value="${employee.empName}" <br></br>
           Age :
          <input style="margin-left: 76px;" type="text" id="age" name="age" value="${employee.age}" <br></br>
           sex:
           <c:if test="${employee.sex ==1}">
            <input type="radio" id="sex" name="sex" checked="checked" value="0">
            <label for="male">Male</label>
                          <input type="radio" id="sex" name="sex" value="1">
                          <label for="female">Female</label><br></br>
          </c:if>
           <c:if test="${employee.sex == 0}">
           <input type="radio" id="sex" name="sex"  value="0">
                       <label for="male">Male</label>
              <input type="radio" checked="checked" id="sex" name="sex" value="1">
              <label for="female">Female</label><br></br>
            </c:if>

          <label for="birthday">Birthday:</label>
          <input type="date" id="birthday" name="birthday" value="${employee.birthday}" pattern="dd-MM-yyyy"><br></br>

          <label for="departName">DepartName</label>
          <select name="departId" >
             <c:forEach var="dep" items="${department}">
                <option value="${dep.departId}">
                        ${dep.departName}
                </option>
              </c:forEach>
           </select> <br></br>
          <input type="submit" value="Save">
        </form>

<!--
     <f:form  action="/Employee/update"  method="post" modelAttribute="employee">
                 <f:input path="empId" name="emp_id" type="hidden"/>
                 EmployeeName<f:input path="empName" name="emp_name" style="margin-left: 24px;"/><br>
                 Age<f:input path="age" name="age" style="margin-left: 100px;"/><br>
                 sex
                 <c:if test="${employee.sex ==1}">
                             <input type="radio" id="sex" name="sex" checked="checked" value="0">
                             <label for="male">Male</label>
                                           <input type="radio" id="sex" name="sex" value="1">
                                           <label for="female">Female</label><br></br>
                           </c:if>
                            <c:if test="${employee.sex == 0}">
                            <input type="radio" id="sex" name="sex"  value="0">
                                        <label for="male">Male</label>
                               <input type="radio" checked="checked" id="sex" name="sex" value="1">
                               <label for="female">Female</label><br></br>
                 </c:if>

                 Birthday <f:input type="date" path="birthday" name="birthday" style="margin-left: 67px;" pattern="dd-MM-yyyy"/><br>

                 department <f:select items="${department}" path="departId"
                 itemLabel="departName" itemValue="departId" style="margin-left: 50px;" name="departId"/><br>
                 <f:button type="submit">save</f:button>
             </f:form>
       -->
</body>
</html>