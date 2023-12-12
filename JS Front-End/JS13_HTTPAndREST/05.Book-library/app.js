function attachEvents() {

    const baseURL = 'http://localhost:3030/jsonstore/collections/books'

    const loadBooksButton = document.getElementById('loadBooks');
    const bookListElement = document.getElementById('bookList');
    const titleInput = document.querySelector('#form input[name=title]')
    const authorInput = document.querySelector('#form input[name=author]')
    const bookIdInput = document.querySelector('#form input[name=bookId]')

    const createBookButton = document.querySelector('#form button');
    const updateBookButton = document.createElement('button');
    updateBookButton.textContent = 'Update';

    loadBooksButton.addEventListener('click', (e) => {
        fetch(baseURL)
            .then(res => res.json())
            .then(result => {

                bookListElement.innerHTML = '';

                const books = Object.keys(result).reduce((acc, _id) => {

                    acc.push({_id, ...result[_id]})

                    return acc;
                }, []);

                books.map(book => createBookItem(book))
                    .forEach(bookElement => {
                        bookListElement.appendChild(bookElement);
                    });
            });
    });

    createBookButton.addEventListener('click', (e) => {

        e.preventDefault();

        const title = titleInput.value;
        const author = authorInput.value;

        fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title,
                author
            })
        })
            .then(response => response.json())
            .then(result => {
                console.log(result);
                const bookElement = createBookItem({title, author});
                bookListElement.appendChild(bookElement);

                titleInput.value = '';
                authorInput.value = '';
            })
            .catch(err => {
                console.log(err);
            });
    })

    updateBookButton.addEventListener('click', (e) => {

        e.preventDefault();

        const title = titleInput.value;
        const author = authorInput.value;
        const bookId = bookIdInput.value;

        if (!bookId) {
            return;
        }

        fetch(`${baseURL}/${bookId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title,
                author,
                _id: bookId
            })
        })
            .then(response => response.json())
            .then(data => {
                const currentRow = bookListElement.querySelector('tr[data-update=true]');

                const titleTd = currentRow.firstChild;
                const authorTd = titleTd.nextSibling;

                titleTd.textContent = title;
                authorTd.textContent = author;

                editButton.textContent = 'Edit';
                updateBookButton.replaceWith(createBookButton);

                bookTr.removeAttribute('data-update');

            })

    })

    function createBookItem(book) {

        const bookTr = document.createElement('tr');
        // bookTr.innerHTML =
        //     `<td>${book.title}</td>
        //      <td>${book.author}</td>
        //      <td>
        //          <button>Edit</button>
        //          <button>Delete</button>
        //      </td>`;

        const titleTd = document.createElement('td');
        titleTd.textContent = book.title;

        const authorTd = document.createElement('td');
        authorTd.textContent = book.author;

        const buttonsTd = document.createElement('td');
        const editButton = document.createElement('button');
        editButton.textContent = 'Edit';
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';

        buttonsTd.appendChild(editButton);
        buttonsTd.appendChild(deleteButton);

        bookTr.appendChild(titleTd);
        bookTr.appendChild(authorTd);
        bookTr.appendChild(buttonsTd);

        editButton.addEventListener('click', (e) => {

            e.preventDefault();

            if (editButton.textContent === 'Cancel') {

                titleInput.value = '';
                authorInput.value = '';
                bookIdInput.value = '';

                editButton.textContent = 'Edit';
                updateBookButton.replaceWith(createBookButton);
                
                bookTr.removeAttribute('data-update');

                return;
            }

            titleInput.value = book.title;
            authorInput.value = book.author;
            bookIdInput.value = book._id;

            editButton.textContent = 'Cancel';

            createBookButton.replaceWith(updateBookButton);
            bookTr.setAttribute('data-update', true);
        })


        console.log(bookTr);

        return bookTr;
    }
}

attachEvents();