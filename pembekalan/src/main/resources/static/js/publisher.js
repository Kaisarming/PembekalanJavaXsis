function openForm() {
    $('#publisherFormModal').modal('show');
    // $.ajax({
    //     type: "get",
    //     url: "/publisher/form",
    //     contentType: "html",
    //     success: function (publisherForm) {
    //         $('#publisherFormModal').modal('show');
    //         $('.modal-title').html('Publisher Form');
    //         $('.modal-body').html(publisherForm);
    //     }
    // });
}

document.getElementById("publisherSubmitBtn").onclick = function () {

    console.log("tes save btn");
    let name = document.getElementById("name").value;
    let address = document.getElementById("address").value;
    $.ajax({
        type: "POST",
        url: "/publisher",
        data: JSON.stringify({
            "name": name,
            "address": address
        }),
        contentType: "application/json",
        success: function (response) {
            console.log("Data berhasil terkirim!");
            $("#publisherFormModal").modal("hide");
            location.reload();
        },
        error: function (xhr, textStatus, error) {
            console.log("Data gagal terkirim!");
        }
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `/publisher/edit/${id}`,
        contentType: "html",
        success: function (authorForm) {
            $('#publisherFormModal').modal('show');
            $('.modal-title').html('Publisher Edit Form');
            $('.modal-body').html(authorForm);
        }
    });
}

function deletePublisher(id) {
    $.ajax({
        type: "get",
        url: `/publisher/delete/${id}`,
        contentType: "html",
        success: function (response) {
            location.reload();
        }
    });
}