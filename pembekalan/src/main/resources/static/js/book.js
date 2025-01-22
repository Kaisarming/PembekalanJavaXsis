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


function submitForm(event) {
    event.preventDefault();
    const form = event.target;
    const data = {
        id: form.id.value,
        author: form.selectAuthor.authorId.value,
        category: form.selectCategory.categoryId.value,
        publisher: form.selectPublisher.publisherId.value,
        title: form.bookTitle.value,
        synopsis: form.synopsis.value,
        stock: form.stock.value,
        publishedAt: form.publishedAt.value
    };
    fetch('/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Lakukan sesuatu dengan data yang diterima
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}



// function submitForm() {
//     var bookRequestDto = {
//         id: $("#id").val(),
//         author: $("#selectAuthor").val(),
//         category: $("#selectCategory").val(),
//         publisher: $("#selectPublisher").val(),
//         title: $("#bookTitle").val(),
//         synopsis: $("#sysnopsis").val(),
//         stock: $("#stock").val(),
//         publishedAt: $("#publishedAt").val(),
//     };

//     $.ajax({
//         url: "/api/book/save",
//         type: "POST",
//         contentType: "application/json",
//         data: JSON.stringify(bookRequestDto),
//         success: function (response) {
//             console.log("Response:", response);
//             alert("Book saved successfully!");
//         },
//         error: function (xhr, status, error) {
//             console.error("Error:", error);
//             alert("Failed to save book.");
//         }
//     });
// }

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