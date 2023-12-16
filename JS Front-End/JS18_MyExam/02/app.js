window.addEventListener("load", solve);

function solve() {

    const addButton =  document.getElementById('add-btn');
    const deleteButton = document.querySelector('.btn.delete');
    const expenseInput = document.getElementById('expense');
    const amountInput = document.getElementById('amount');
    const dateInput = document.getElementById('date');

    addButton.addEventListener('click', addToPreviewList);
    deleteButton.addEventListener('click', deleteList);

    function addToPreviewList() {

        let isInputValid =
            expenseInput.value !== '' && amountInput.value !== '' && dateInput.value !== '';

        if (!isInputValid) {
            return;
        }

        addButton.disabled = true;

        let expense = expenseInput.value;
        let amount = amountInput.value;
        let date = dateInput.value;

        const previewListUl = document.getElementById('preview-list');
        const li = document.createElement('li');
        li.classList.add('expense-item');

        const article = document.createElement('article');
        const pTypeFood = document.createElement('p');
        const pAmount = document.createElement('p');
        const pDate = document.createElement('p');

        pTypeFood.textContent = `Type: ${expense}`;
        pAmount.textContent = `Amount: ${amount}$`;
        pDate.textContent = `Date: ${date}`;

        const divButtons = document.createElement('div');
        divButtons.classList.add('buttons');

        const editButton = document.createElement('button');
        editButton.textContent = 'edit';
        editButton.classList.add('btn');
        editButton.classList.add('edit');
        editButton.addEventListener('click', edit);

        const okButton = document.createElement('button');
        okButton.textContent = 'ok';
        okButton.classList.add('btn');
        okButton.classList.add('ok');
        okButton.addEventListener('click', ok);

        divButtons.appendChild(editButton);
        divButtons.appendChild(okButton);

        article.appendChild(pTypeFood);
        article.appendChild(pAmount);
        article.appendChild(pDate);

        li.appendChild(article);
        li.appendChild(divButtons);

        previewListUl.appendChild(li);

        clearInput();

        function edit() {

            expenseInput.value = expense;
            amountInput.value = amount;
            dateInput.value = date;

            li.remove();
            addButton.disabled = false;
        }

        function ok() {

            const expensesList = document.getElementById('expenses-list');

            previewListUl.removeChild(li);

            li.removeChild(divButtons);

            expensesList.appendChild(li);

            addButton.disabled = false;
        }
    }

    function deleteList() {

        const expensesList = document.getElementById('expenses-list');

        while (expensesList.firstChild) {
            expensesList.removeChild(expensesList.firstChild);
        }
    }

    function clearInput(){
        expenseInput.value = '';
        amountInput.value = '';
        dateInput.value = '';
    }
}