function openForm() {
    console.log("berhasil");
    $.ajax({
        type: "get",
        url: "/category/form",
        contentType: "html",
        success: function (categoryForm) {
            $('#modalCreateCategory').modal('show');
            $('.modal-title').html('Category Form');
            $('.modal-body').html(categoryForm);
        }
    });
}

function editForm() {
    console.log("berhasil");
    $.ajax({
        type: "get",
        url: "/category/edit/${id}",
        contentType: "html",
        success: function (categoryForm) {
            $('#modalCreateCategory').modal('show');
            $('.modal-title').html('Category Form');
            $('.modal-body').html(categoryForm);
        }
    });
}