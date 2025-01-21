function createForm() {
    $.ajax({
        type: "get",
        url: "/book/form",
        contentType: "html",
        success: function (bookForm) {
            $('#bookForm').modal('show');
            $('.modal-title').html('Book Form');
            $('.modal-body').html(bookForm);
        }
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `/book/edit/${id}`,
        contentType: "html",
        success: function (bookForm) {
            $('#bookForm').modal('show');
            $('.modal-title').html('Book Edit Form');
            $('.modal-body').html(bookForm);
        }
    });
}

function deleteBook(id) {
    $.ajax({
        type: "get",
        url: `/book/delete/${id}`,
        contentType: "html",
        success: function (response) {
            location.reload();
        }
    });
}