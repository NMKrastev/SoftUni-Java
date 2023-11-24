function generateReport() {

    let personObject = {};
    let personAllObjects = [];
    let columnSetNumbers = [];

    let columnsAll = document.querySelectorAll('thead tr th input');

    for (let i = 0; i < columnsAll.length; i++) {
        let checkboxState = columnsAll[i].checked;

        if (checkboxState) {
            columnSetNumbers.push(i);
        }
    }

    let columnTitles = document.querySelectorAll('thead tr')[0].getElementsByTagName('th');
    let rowsCount = document.querySelectorAll('tbody tr').length;

    for (let i = 0; i < rowsCount; i++) {

        columnSetNumbers.forEach((element) => {
            let key = columnTitles[element].textContent.trim().toLowerCase();
            let value = document.querySelectorAll('tbody tr')[i].getElementsByTagName('td')[element].textContent;
            personObject[key] = value;
        });

        personAllObjects.push(Object.assign(personObject));
        personObject = {};
    }

    personAllObjects.forEach(e => console.log(e));

   document.getElementById('output').innerHTML = JSON.stringify(personAllObjects);

}