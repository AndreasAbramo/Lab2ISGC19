function fetchBooks() {
    fetch('/books')
        .then(response => response.json())
        .then(data => {
            const booksList = document.getElementById('books-list');
            booksList.innerHTML = '';
            data.forEach(book => {
                booksList.innerHTML += `<p>id=${book.id} ${book.title} by ${book.author} (${book.publishedYear})</p>`;
            });
        })
        .catch(error => console.error('Error fetching books:', error));
}

function createBook() {
    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;
    const publishedYear = document.getElementById('publishedYear').value;
    const author = document.getElementById('author').value;
    const category = document.getElementById('category').value;

    fetch('/books', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ title, description, publishedYear, author, category }),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            fetchBooks();
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function fetchBookByTitle() {
    const title = document.getElementById('search-title').value;
    fetch(`/books?title=${encodeURIComponent(title)}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('No book found with that title');
            }
            return response.json();
        })
        .then(book => {
            const booksList = document.getElementById('books-list');
            booksList.innerHTML = '';
            if (book.length > 0) {
                book.forEach(book => {
                    booksList.innerHTML += `<p>id=${book.id}<br>${book.title} by ${book.author}<br>Description: ${book.description}<br>Published: ${book.publishedYear}<br>Category: ${book.category}</p>`;
                });
            } else {
                booksList.innerHTML = '<p>No books found with that title.</p>';
            }
        })
        .catch(error => console.error('Error:', error));
}

function fetchBookById() {
    const id = document.getElementById('search-id').value;
    fetch(`/books/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('No book found with that ID');
            }
            return response.json();
        })
        .then(book => {
            const booksList = document.getElementById('books-list');
            booksList.innerHTML = `<p>id=${book.id}<br>${book.title} by ${book.author}<br>Description: ${book.description}<br>Published: ${book.publishedYear}<br>Category: ${book.category}</p>`;
        })
        .catch(error => console.error('Error:', error));
}

document.addEventListener('DOMContentLoaded', fetchBooks);
