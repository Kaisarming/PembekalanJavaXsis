function openForm() {
    console.log("tes");
    $.ajax({
        type: "get",
        url: "/publisher/form",
        contentType: "html",
        success: function (publisherForm) {
            $('#publisherFormModal').modal('show');
            $('.modal-title').html('Publisher Form');
            $('.modal-body').html(publisherForm);
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