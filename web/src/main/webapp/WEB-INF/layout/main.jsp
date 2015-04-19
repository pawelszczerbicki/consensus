<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>Consensus</title>
    <link href='//fonts.googleapis.com/css?family=Roboto:500,300,400' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" type="text/css">


    <link rel="stylesheet" href="/resources/css/materia.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/overrides.css" type="text/css">

    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/jquery.easing.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/jquery.mtr-ripple.js"></script>
    <script src="/resources/js/jquery.mtr-panel.js"></script>
    <script src="/resources/js/jquery.mtr-header.js"></script>
</head>

<body class="mtr-grey-50">
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
        <tiles:insertAttribute name="body"/>
    </div>
</div>
</body>
</html>
