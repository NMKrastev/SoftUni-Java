function attachEvents() {

    const baseURL = 'http://localhost:3030/jsonstore/phonebook';
    const loadButton = document.getElementById('btnLoad');
    const createButton = document.getElementById('btnCreate');
    const phonebookUl = document.getElementById('phonebook');

    async function loadPhonebook() {
        phonebookUl.innerHTML = '';

        const response = await fetch(baseURL);
        const phonebookInfo = await response.json();

        console.log(Object.values(phonebookInfo));

        for (const phonebookInfoElement of Object.values(phonebookInfo)) {
            let li = document.createElement('li');
            let deleteButton = document.createElement('button');

            deleteButton.id = phonebookInfoElement._id;
            deleteButton.textContent = 'Delete';

            li.id = phonebookInfoElement._id;
            li.textContent = `${phonebookInfoElement.person}: ${phonebookInfoElement.phone}`;

            li.appendChild(deleteButton);
            phonebookUl.appendChild(li);

            deleteButton.addEventListener('click', async () => {
                const id = deleteButton.id;
                await fetch(`${baseURL}/${id}`, {
                    method: 'DELETE',
                });

                li.remove();
            });
        }
    }

    createButton.addEventListener('click', async () => {
        const person = document.getElementById('person').value;
        const phone = document.getElementById('phone').value;

        const isValidContact = person !== '' && phone !== '';

        if (isValidContact) {
            await fetch(baseURL, {
                method: 'POST',
                body: JSON.stringify({
                    person,
                    phone,
                }),
            });
        }

        document.getElementById('person').value = '';
        document.getElementById('phone').value = '';

        // Call the loadPhonebook function after creating a contact
        await loadPhonebook();
    });

    loadButton.addEventListener('click', loadPhonebook);
}

attachEvents();