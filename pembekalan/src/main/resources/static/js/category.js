function openForm() {
    console.log("berhasil");
    $.ajax({
        url: "/category/form",
        type: "get",
        contentType: "html",
        success: function (categoryForm) {
            $('.modal').modal('show');
            $('.modal-title').html('Category Form');
            $('.modal-body').html(categoryForm);
        }
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `/category/edit/${id}`,
        contentType: "html",
        success: function (categoryForm) {
            $('.modal').modal('show');
            $('.modal-title').html('Category Form');
            $('.modal-body').html(categoryForm);
        }
    });
}