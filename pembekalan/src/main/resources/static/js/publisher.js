function openForm() {
    $('#publisherFormModal').modal('show');
}

document.getElementById("publisherSubmitBtn").onclick = function () {

    console.log("tes save btn");
    let idPublisher = document.getElementById("id").value;
    let name = document.getElementById("name").value;
    let address = document.getElementById("address").value;
    let method = idPublisher ? "PUT" : "POST";
    $.ajax({
        type: method,
        url: "/publisher/api/save",
        data: JSON.stringify({
            "id": idPublisher,
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
    console.log("Edit button berfungsi!");

    $.ajax({
        type: "GET",
        url: `/publisher/api/${id}`,
        success: function (response) {
            console.log("Data edit form berhasil diambil!");
            //document.getElementById("id").value = response.data.id;
            document.getElementById("name").value = response.data.name;
            document.getElementById("address").value = response.data.address;
            $("#publisherFormModal").modal("show");
        },
        error: function (xhr, textStatus, error) {
            console.log("Data edit form gagal diambil!");
        }
    });
}

function deletePublisher(id) {
    //id = document.getElementById("publisherDeleteBtn").value;

    $.ajax({
        type: "DELETE",
        url: `/publisher/api/${id}`,
        data: JSON.stringify({
            "id": id
        }),
        contentType: "application/json",
        success: function (response) {
            console.log("Data berhasil terhapus!");
            //$("#publisherFormModal").modal("hide");
            location.reload();
        },
        error: function (xhr, textStatus, error) {
            console.log("Data gagal terhapus!");
        }
    });
}