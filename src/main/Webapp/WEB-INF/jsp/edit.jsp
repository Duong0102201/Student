<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
</head>
<body>

<h2>Edit Department</h2>
    <br>


        <form method="post" action="/edit/save">
     <input type="hidden" value="${department.departId}" id="depart_Id" name="depart_Id"<br></br>
           DepartmentName :
          <input type="text" id="depart_name"  value="${department.departName}"name="depart_name"<br></br>
            Description :
          <input style="margin-left: 38px;" type="text" value="${department.description}" id="Description" name="Description"<br></br>

          <input type="submit" value="save">
        </form>

</body>
</html>