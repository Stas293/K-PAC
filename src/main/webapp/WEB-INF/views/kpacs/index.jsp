<!DOCTYPE html>
<html>
<head>
    <title>KPACS</title>
    <script type="text/javascript" src="/resources/codebase/grid.js"></script>
    <link rel="stylesheet" href="/resources/codebase/grid.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="d-flex justify-content-between">
                <div class="p-2">
                    <h1>Knowledge Packages</h1>
                </div>
                <div class="p-2">
                    <a href="/kpacs/new" class="btn btn-primary">New Knowledge Package</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <div id="grid" style="width: 100%; height: 900px"></div>
            <script src="/resources/js/kpacs.js"></script>
        </div>
    </div>
</div>

