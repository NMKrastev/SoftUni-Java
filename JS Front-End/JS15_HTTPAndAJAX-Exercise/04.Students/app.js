async function attachEvents() {

    const baseURL = 'http://localhost:3030/jsonstore/collections/students';
    const [firstName, lastName, facultyNumber, grade] = document.getElementsByTagName('input');
    const tbody = document.querySelector('tbody');
    const submitButton = document.getElementById('submit');

    submitButton.addEventListener('click', onSubmit);

    async function onLoad() {

        tbody.innerHTML = '';

        const response = await fetch(baseURL);
        const studentsInfo = await response.json();

        Object.values(studentsInfo).forEach((student) => {

            const row = document.createElement('tr');
            row.innerHTML =
                `
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.facultyNumber}</td>
            <td>${student.grade}</td>
            `;

            tbody.appendChild(row);
        });
    }

    await onLoad();

    function onSubmit(e) {

        e.preventDefault();

        const isValidStudent = firstName.value !== ''
            && lastName.value !== '' && facultyNumber.value !== '' && grade.value !== '';

        if (isValidStudent) {

            fetch(baseURL, {
                method: 'POST',
                body: JSON.stringify({
                    firstName: firstName.value,
                    lastName: lastName.value,
                    facultyNumber: facultyNumber.value,
                    grade: grade.value,
                }),
            });

        }

        firstName.value = '';
        lastName.value = '';
        facultyNumber.value = '';
        grade.value = '';

        onLoad();
    }
}

attachEvents();