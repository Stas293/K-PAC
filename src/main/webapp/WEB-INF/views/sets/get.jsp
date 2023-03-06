<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>KPAC</title>
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
                    <h1>Knowledge Package</h1>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <div id="grid" style="width: 100%; height: 900px"></div>
            <script type="text/javascript">
                const grid = new dhx.Grid("grid", {
                    columns: [
                        { id: "id", header: [{ text: "ID" }], sort: "int" },
                        { id: "title", header: [{ text: "Title" }], sort: "string" },
                        { id: "description", header: [{ text: "Description" }], sort: "string" },
                    ],
                    editable: false,
                    autoWidth: true,
                    autoHeight: true,
                    selection: "row",
                    data: JSON.parse('${set}')
                });
            </script>
        </div>
    </div>
</div>
</body>
</html>
