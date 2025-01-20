function openForm() {
    $.ajax({
        type: "get",
        url: "/author/form",
        contentType: "html",
        success: function (authorForm) {
            $('#authorForm').modal('show');
            $('.modal-title').html('Author Form');
            $('.modal-body').html(authorForm);
        }
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `/author/edit/${id}`,
        contentType: "html",
        success: function (authorForm) {
            $('#authorForm').modal('show');
            $('.modal-title').html('Author Edit Form');
            $('.modal-body').html(authorForm);
        }
    });
}

function deleteAuthor(id) {
    $.ajax({
        type: "get",
        url: `/author/delete/${id}`,
        contentType: "html",
        success: function (response) {
            location.reload();
        }
    });
}