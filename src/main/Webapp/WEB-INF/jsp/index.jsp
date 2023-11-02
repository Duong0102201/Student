<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %> -->
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

    td,
    th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }

    a {
        color: #ffffff;
    }

    .button span {
        padding: 10px 30px;
        border-radius: 5px;
        width: 15px !important;
        height: 18px;
    }
     #pagination {
          display: flex;
          display: -webkit-flex; /* Safari 8 */
          flex-wrap: wrap;
          -webkit-flex-wrap: wrap; /* Safari 8 */
          justify-content: center;
         -webkit-justify-content: center;
     }
</style>
<body>
<h1>${err}</h1>
    <div class="container">
        <h2 style="margin-top:20px;padding-bottom: 25px;">Department Demo</h2>
        <div class="alert alert-info" role="alert">
            ${msgDel}
        </div>
        <div class="col-md-12">
            <div class="col-md-3">
                <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                    data-target="#myModal">Create</button>
            </div>
            <div class="col-md-9">
                <!-- Search form -->
                <form method="get" action="/" name="departmentModel">

                    <input class="form-control" type="text" placeholder="Search" aria-label="Search" id="departName"
                        name="departName" style="width: 70%;float:left;">
                    <button type="submit" class="btn btn-primary">Search</button>
                    <h1>${err}</h1>
                </form>
            </div>
        </div>
        <!-- table -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>DepartId</th>
                    <th>DepartName</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="list" items="${department}">
                    <tr class="contentPage">
                                <td>${list.departId}</td>
                                <td>${list.departName}</td>
                                <td>${list.description}</td>
                            <td style="width:347px;">
                                <div class="button">
                                <span class="span label-default"><a href="/view/${list.departId}">Show Detail</a></span>
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                    data-target="#update${list.departId}" style="padding: 4px 16px;">Edit</button>
                                <span class="span label-danger"><a onclick="return myFunction()"
                                        href="/delete/${list.departId}">Delete</a></span>
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
    <c:forEach var="list" items="${department}">
        <div id="update${list.departId}" class="modal fade" role="dialog">
            <div class="modal-dialog" style="margin-left: 404px;">
                <!-- Modal content-->
                <div class="modal-content" style="height: 257px;">
        <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Edit Department</h4>
        </div>
          <div class="modal-body">
              <div class="container">
                 <form class="form-horizontal" method="post" action="/edit/save">
                     <div class="form-group">
                          <label class="control-label col-sm-2" for="DepartId">DepartId</label>
                             <div class="col-sm-10">
                                  <input readonly style="width:350px; type=" text" class="form-control"
                                   id="DepartId" name="depart_Id" value="${list.departId}">
                              </div>
                     </div>

                     <div class="form-group">
                             <label class="control-label col-sm-2" for="DepartName">DepartName</label>
                        <div class="col-sm-10">
                              <input style="width:350px; type=" text" class="form-control" id="DepartName"
                              placeholder="Enter DepartName" name="depart_name" value="${list.departName}">
                         </div>
                     </div>
                     <div class="form-group">
                             <label class="control-label col-sm-2" for="Description"
                             style="margin-right: 13px;">Description:</label>
                             <input style="width: 351px;" type="text" class="form-control" id="Description"
                             placeholder="Enter Description" name="Description" value="${list.description}">
                     </div>
                   </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10" style="text-align:center;">
                                <button type="submit" onsubmit="alert('edit department success !')"
                                style="background:#ccc;border-radius:6px;border:none;width:80px;padding:7px 10px;">Save</button>
                            </div>
                        </div>
                        </form>
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
                        <div class="modal-content" style="height: 257px;">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Edit Department</h4>
                            </div>
                            <div class="modal-body">

                                <div class="container">
                                    <form class="form-horizontal" method="post" action="/save">
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="DepartName">DepartName</label>
                                            <div class="col-sm-10">
                                                <input style="width:350px; type=" text" class="form-control" id="DepartName"
                                                    placeholder="Enter DepartName" name="depart_name">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="Description"
                                                style="margin-right: 13px;">Description:</label>
                                            <input style="width: 351px;" type="text" class="form-control" id="Description"
                                                placeholder="Enter Description" name="Description">
                                        </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10" style="text-align:center;">
                                        <button type="submit" onsubmit="alert('add department success !')";
                                            style="background:#ccc;border-radius: 6px;border: none;width: 80px;padding: 7px 10px;">Save</button>
                                    </div>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

       <!-- endAddModal -->

    </div>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
         <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
        <script>
            function myFunction() {
                if (confirm("bạn có chắc muốn xóa bản ghi này không ? ")) {

                } else {
                    return false;
                }
            }

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