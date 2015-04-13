
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
        <td><a href="/tasks/1">1</a></td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr>
        <td><a href="/tasks/2">2</a></td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="info">
        <td><a href="/tasks/3">3</a></td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="success">
        <td><a href="/tasks/4">4</a></td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="danger">
        <td><a href="/tasks/5">5</a></td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="warning">
        <td><a href="/tasks/6">6</a></td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      <tr class="active">
        <td><a href="/tasks/7">7</a></td>
        <td>Column content</td>
        <td>Column content</td>
        <td>Column content</td>
      </tr>
      </tbody>
    </table>

<script type="text/javascript">
  $(function() {
    $('.btn, .dropdown-menu a, .navbar a, .navbar-panel a, .toolbar a, .nav-pills a, .nav-tabs a, .pager a, .pagination a, .list-group a').mtrRipple({live: true});
  });
</script>
