function solve() {

    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {

        let tableRows = document.querySelectorAll('tbody > tr');

        for (const tableRow of tableRows) {
            tableRow.classList.remove('select');
            console.log(tableRow.textContent)
        }

        let searchedInput = document.getElementById('searchField').value;

        for (let i = 0; i < tableRows.length; i++) {

            for (let j = 0; j < tableRows[i].children.length; j++) {

                let cellContent = tableRows[i].children[j];
                let cellText = cellContent.textContent;

                if (cellText.includes(searchedInput)) {
                    tableRows[i].classList.add('select')
                    break;
                }
            }
        }
    }
}