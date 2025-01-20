function openForm() {
    $.ajax({
        type: "get",
        url: "/user/form",
        contentType: "html",
        success: function (userForm) {
            $('#modalForm').modal('show');
            $('.modal-title').html('User Form');
            $('.modal-body').html(userForm);
        }
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `/user/edit/${id}`,
        contentType: "html",
        success: function (userForm) {
            $('#modalForm').modal('show');
            $('.modal-title').html('User Form');
            $('.modal-body').html(userForm);
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