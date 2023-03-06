const grid = new dhx.Grid("grid", {
    columns: [
        { id: "id", header: [{ text: "ID" }], sort: "int" },
        { id: "title", header: [{ text: "Title" }], sort: "string" },
        { id: "delete", header: [{ text: "Delete" }], htmlEnable:true, width: 90, sortable: false }
    ],
    editable: false,
    autoWidth: true,
    autoHeight: true,
    selection: "row",
});


function ajax(url, callback, method) {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            console.log(xhr.responseText);
            callback(xhr.responseText);
        }
    };
    xhr.open(method, url, true);
    xhr.send();
}

function deleteRow (id) {
    grid.data.remove(id);
    ajax("/sets/delete/" + id, function (response) {
        const data = JSON.parse(response);
        grid.data.parse(data);
    }, "DELETE");
}

ajax("/sets/table", function (response) {
    const data = JSON.parse(response);
    grid.data.parse(data);
    grid.events.on("cellDblClick", function(row,column,e){
        window.location.href = "/sets/" + row.id;
    });
    grid.data.forEach(function (obj) {
        grid.data.update(
            obj.id,
            {delete: "<button class='btn btn-danger' onclick='deleteRow(" + obj.id + ")'>Delete</button>"});
    });
}, "GET");