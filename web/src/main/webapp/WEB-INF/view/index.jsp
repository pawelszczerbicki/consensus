<nav id="topbar" class="toolbar toolbar-expanded mtr-green-500">
  <div class="container-fluid header-title">
    <div class="row">
      <div class="col-sm-12">Consensus App Manager</div>
    </div>
  </div>
</nav>


<div class="panel panel-default main-panel">
  <div class="panel-heading">Tasks</div>
  <div class="panel-body">

    <button class="btn btn-success add-button" data-toggle="modal" data-target="#myModal">Add new</button>

    <div class="modal fade" id="myModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">New task</h4>
          </div>
          <div class="modal-body">
            <p>Form will be soon</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-flat btn-primary" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-flat btn-primary">Add task</button>
          </div>
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
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>1</td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="info">
        <td>3</td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="success">
        <td>4</td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="danger">
        <td>5</td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="warning">
        <td>6</td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="active">
        <td>7</td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      </tbody>
    </table>


  </div>
</div>


<script type="text/javascript">
  $(function() {
    $('.btn, .dropdown-menu a, .navbar a, .navbar-panel a, .toolbar a, .nav-pills a, .nav-tabs a, .pager a, .pagination a, .list-group a').mtrRipple({live: true});
  });
</script>
