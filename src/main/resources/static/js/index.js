function delete_all() {
    let settings = {
        "url": "/v1/contacts",
        "method": "DELETE",
        "timeout": 0,
    };
    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}

function get_by_id() {
    window.location.href = "/v1/contacts/" + document.getElementById("id").value;
}

function delete_by_id() {
    let settings = {
        "url": "/v1/contacts/" + document.getElementById("id_delete").value,
        "method": "DELETE",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}
