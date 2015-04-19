<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty success}">
    <div class="alert alert-dismissible alert-success">
        <button type="button" class="close" data-dismiss="alert">x</button>
        <strong>Well done!</strong> ${success}
    </div>
</c:if>

<button class="btn btn-success add-button margin" data-toggle="modal" data-target="#myModal">Add new</button>

<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">New task</h4>
            </div>
            <form class="form-horizontal" action="/tasks" method="POST" enctype="multipart/form-data">
                <div class="modal-body">
                    <fieldset>
                        <div class="form-group">
                            <div class="col-lg-10 margin">
                                <input class="form-control" id="inputName" name="name" type="text">
                                <label for="inputName" class="">Name</label>
                            </div>
                            <div class="col-lg-10 margin">
                                <input class="form-control" id="inputFile" name="file" type="file">
                                <label for="inputFile" class="">Data file</label>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn btn-flat btn-primary">Cancel</button>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>

<table class="table table-striped table-hover ">
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Cores</th>
        <th>Progress</th>
        <th>State</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td><a href="<c:url value="/tasks/${task.id}"/>">More</a></td>
            <td>${task.name}</td>
            <td>${task.cores}</td>
            <td>${task.progress}</td>
            <td><c:if test="${task.finished == true}">Finished</c:if><c:if test="${task.finished == false}">In progress</c:if></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<script type="text/javascript">
    $(function () {
        $('.btn, .dropdown-menu a, .navbar a, .navbar-panel a, .toolbar a, .nav-pills a, .nav-tabs a, .pager a, .pagination a, .list-group a').mtrRipple({live: true});
    });
</script>
