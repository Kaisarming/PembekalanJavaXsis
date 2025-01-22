function createForm() {
    $.ajax({
        type: "get",
        url: "/book/form",
        contentType: "html",
        success: function (bookFormModal) {
            $('#bookFormModal').modal('show');
            $('.modal-title').html('Book Form');
            $('.modal-body').html(bookFormModal);
        }
    });
}

function submitForm() {
    var bookRequestDto = {
        id: $("#id").val(),
        author: $("#selectAuthor").val(),
        category: $("#selectCategory").val(),
        publisher: $("#selectPublisher").val(),
        title: $("#bookTitle").val(),
        synopsis: $("#sysnopsis").val(),
        stock: $("#stock").val(),
        publishedAt: $("#publishedAt").val(),
    };

    $.ajax({
        url: "/api/book/save",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(bookRequestDto),
        success: function (response) {
            console.log("Response:", response);
            alert("Book saved successfully!");
        },
        error: function (xhr, status, error) {
            console.error("Error:", error);
            alert("Failed to save book.");
        }
    });
}

// function submitForm() {
//     const form = document.querySelector("#bookForm");

//     async function sendData() {
//         // Associate the FormData object with the form element
//         const formData = new FormData(form);

//         try {
//             const response = await fetch("http://localhost:8080/api/book", {
//                 method: "POST",
//                 // Set the FormData instance as the request body
//                 body: formData,
//             });
//             console.log(await response.json());
//         } catch (e) {
//             console.error(e);
//         }
//     }

//     // Take over form submission
//     form.addEventListener("submit", (event) => {
//         event.preventDefault();
//         sendData();
//     });
// }

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