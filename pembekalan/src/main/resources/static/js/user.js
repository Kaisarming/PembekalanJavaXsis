function openForm() {
    console.log("berhasil");
    $.ajax({
        type: "get",
        url: "/user/form",
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
        url: `/user/edit/${id}`,
        contentType: "html",
        success: function (categoryForm) {
            $('.modal').modal('show');
            $('.modal-title').html('Category Form');
            $('.modal-body').html(categoryForm);
        }
    });
}

function deleteUser(id) {
    $.ajax({
        type: "get",
        url: `/user/delete/${id}`,
        contentType: "html",
        success: function (response) {
            location.reload();
        }
    });
}