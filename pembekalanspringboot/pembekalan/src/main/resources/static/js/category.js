function openForm() {
    console.log("berhasil");
    $.ajax({
        type: "get",
        url: "/category/form",
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

function deleteCategory(id) {
    $.ajax({
        type: "get",
        url: `/category/delete/${id}`,
        contentType: "html",
        success: function (response) {
            location.reload();
        }
    });
}