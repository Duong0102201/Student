<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    </head>
<style>
    table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
    }
    .button span {
            padding: 10px 30px;
            border-radius: 5px;
            width: 15px !important;
            height: 18px;
    }
    a {
            color: #ffffff;
    }

    td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
    }

    tr:nth-child(even) {
    background-color: #dddddd;
    }
    .radio-gender{
        padding-top: 6px;
    }
    .for-male{
         margin-left: 15px;
    }
    .for-female{
        margin-left: 32px;
    }

</style>
<body>
<div class="container">
        <h2 style="margin-top:20px;padding-bottom: 25px;">Employee Demo</h2>
        <div class="col-md-12">
            <div class="col-md-3">
                <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                    data-target="#myModal">Create</button>
            </div>
            <div class="col-md-9">
                <!-- Search form -->
                <form method="get" action="/emp" name="employeeModel">

                    <input class="form-control" type="text" placeholder="Search" aria-label="Search" id="employeeName"
                        name="employeeName" style="width: 70%;float:left;">
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
        <!-- table -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>EmployeeId</th>
                    <th>EmployeeName</th>
                    <th>Age</th>
                    <th>Sex</th>
                    <th>Birthday</th>
                    <th>DepartName</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list" items="${employee}">
                    <tr class="contentPage">
                        <td>${list.empId}</td>
                        <td>${list.empName}</td>
                        <td>${list.age}</td>
                        <td>
                            <c:if test="${list.sex  == 0}"> Nữ</c:if>
                            <c:if test="${list.sex  == 1}"> Nam</c:if>
                        </td>
                        <td>
                         <fmt:formatDate value="${list.birthday}" pattern="dd-MM-yyyy"/>
                        </td>
                        <td>${list.departmentName}</td>
                        <td style="width:347px;">
                            <div class="button">
                                <span class="span label-default"><a href="/Employee/view/${list.empId}">Show Detail</a></span>
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                    data-target="#update${list.empId}" style="padding: 4px 16px;">Edit</button>
                                        <span class="span label-danger"><a onclick="return myFunction()"
                                        href="/Employee/delete/${list.empId}">Delete</a></span>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


<ul id="pagination">


</ul>

        <!-- end table -->

        <!-- modal -->
    <c:forEach var="list" items="${employee}">
        <div id="update${list.empId}" class="modal fade" role="dialog">
            <div class="modal-dialog" style="margin-left: 404px;">
                <!-- Modal content-->
                <div class="modal-content" style="height: 464px;">
                    <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Edit Employee</h4>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <form class="form-horizontal" method="post" action="/Employee/update">
                                <div class="form-group">
                                    <label class="control-label col-md-1" for="EmployeeId">EmployeeId</label>
                                        <div class="col-sm-10">
                                            <input readonly style="width:350px; type=" text" class="form-control"
                                            id="EmployeeId" name="emp_id" value="${list.empId}">
                                        </div>
                                </div>

                                <div class="form-group">
                                        <label class="control-label col-md-1" for="EmployeeName" style="padding-left: 0px;">EmployeeName</label>
                                    <div class="col-sm-10">
                                        <input style="width:350px; type=" text" class="form-control" id="EmployeeName"
                                        placeholder="Enter EmployeeName" name="emp_name" value="${list.empName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                        <label class="control-label col-md-1" for="Age">Age</label>
                                    <div class="col-sm-10">
                                        <input style="width:350px; type=" text" class="form-control" id="Age"
                                        placeholder="Enter Age" name="age" value="${list.age}">
                                    </div>
                                </div>

                                <div class="form-group">
                                <c:if test="${list.sex ==1}">
                                    <label class="control-label col-md-1" for="Sex">Sex</label>
                                    <div class="col-sm-10">
                                    <div class="row radio-gender" style="padding-top:6px;">
                                        <label class="for-male" for="Male">Male</label>
                                        <input  type="radio" class="" name="sex" id="sex" checked="checked" value="0">
                                        <label class="for-female"for="Female">Female</label>
                                        <input type="radio" class="" name="sex" id="sex" value="1">
                                    </div>
                                    </div>
                                 </c:if>
                                <c:if test="${list.sex ==0}">
                                    <label class="control-label col-md-1" for="Sex">Sex</label>
                                    <div class="col-sm-10">
                                    <div class="row radio-gender" style="padding-top:6px;">
                                        <label class="for-male" for="Male">Male</label>
                                        <input  type="radio" class="" name="sex" id="sex" checked="checked" value="0">
                                        <label class="for-female"for="Female">Female</label>
                                        <input type="radio" class="" name="sex" id="sex" value="1">
                                    </div>
                                    </div>
                                 </c:if>
                                </div>


                                <div class="form-group">
                                    <label class="control-label col-md-1" for="Birthday">Birthday</label>
                                    <div class="col-sm-10">
                                        <input type="date" id="birthday" name="birthday" style="width:350px;"
                                         value="list.birthday">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-1" for="departName">departName</label>
                                    <div class="col-sm-10">
                                        <select class="form-control" name="departId" id="departName" style="width:37%;">
                                            <c:forEach var="dep" items="${department}">
                                                <option value="${dep.departId}">
                                                ${dep.departName}
                                                </option>
                                            </c:forEach>
                                            </select> <br></br>
                                    </div>

                                </div>

                                <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="edit";
                                               style="background:#ccc;border-radius: 6px;border: none;width: 80px;padding: 7px 10px;">Save</button>
                                        </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
        <!-- end modal -->

        <!-- addModal -->
                <div id="myModal" class="modal fade" role="dialog">
                            <div class="modal-dialog" style="margin-left: 404px;">
                                <!-- Modal content-->
                                <div class="modal-content" style="height: 464px;">
                                    <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Add Employee</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container">
                                            <form class="form-horizontal" method="post" action="/Employee/save">
                                                <div class="form-group">
                                                        <label class="control-label col-md-1" for="EmployeeName" style="padding-left: 0px;">EmployeeName</label>
                                                    <div class="col-sm-10">
                                                        <input style="width:350px; type=" text" class="form-control" id="EmployeeName"
                                                        placeholder="Enter EmployeeName" name="emp_name">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                        <label class="control-label col-md-1" for="Age">Age</label>
                                                    <div class="col-sm-10">
                                                        <input style="width:350px; type=" text" class="form-control" id="Age"
                                                        placeholder="Enter Age" name="age">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-1" for="Sex">Sex</label>
                                                    <div class="col-sm-10">
                                                    <div class="row radio-gender" style="padding-top:6px;">
                                                        <label class="for-male" for="Male">Male</label>
                                                        <input  type="radio" class="" name="sex" id="sex" value="0">
                                                        <label class="for-female"for="Female">Female</label>
                                                        <input type="radio" class="" name="sex" id="sex" value="1">
                                                    </div>
                                                    </div>
                                                </div>


                                                <div class="form-group">
                                                    <label class="control-label col-md-1" for="Birthday">Birthday</label>
                                                    <div class="col-sm-10">
                                                        <input style="width:350px;" type="date" class="form-control" id="Birthday" name="birthday">
                                                        </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-1" for="departName">departName</label>
                                                    <div class="col-sm-10">
                                                        <select class="form-control" name="departId" id="departName" style="width:37%;">
                                                            <c:forEach var="dep" items="${department}">
                                                                <option value="${dep.departId}">
                                                                ${dep.departName}
                                                                </option>
                                                            </c:forEach>
                                                            </select> <br></br>
                                                    </div>

                                                </div>

                                                <div class="form-group">
                                                        <div class="col-sm-offset-2 col-sm-10">
                                                            <button type="submit" id="create";
                                                                style="background:#ccc;border-radius: 6px;border: none;width: 80px;padding: 7px 10px;">Save</button>
                                                        </div>
                                                </div>
                                        </form>
                                    </div>
                               </div>
                          </div>
                     </div>
                 </div>

       <!-- endAddModal -->

    </div>

<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
<script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
<script>
   function myFunction() {
       if (confirm("do you want delete this record ? ")) {
           alert('delete success !');
        } else {
            return false;
                }
          }

        $("#create").click(function(){
                   alert('add new employee success !');
        });

        $(".edit").click(function(){
                   alert('edit employee success !');
        });

        $(function () {
                           var pageSize = 5;
                            showPage = function (page) {
                               $(".contentPage").hide();
                               $(".contentPage").each(function (n) {
                                if (n >= pageSize * (page - 1) && n < pageSize * page)
                                                $(this).show();
                                   });
                                 }
                        showPage(1);
                        var totalRows = ${totalItems};
                        var btnPage = ${totalItems} / pageSize;
                        var iTotalPages = Math.ceil(totalRows / pageSize);
                        var obj = $('#pagination').twbsPagination({
                        totalPages: iTotalPages,
                        visiblePages: btnPage,
                        onPageClick: function (event, page) {
                        console.info(page);
                        showPage(page);
                    }
                   });
                   console.info(obj.data());
                 });
</script>
</body>
</html>