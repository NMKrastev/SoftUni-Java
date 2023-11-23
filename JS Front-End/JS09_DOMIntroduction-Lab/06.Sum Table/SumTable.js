function sumTable() {

    let items = Array.from(document.querySelectorAll('td:nth-child(even)'));
    let sum = 0;

    for (let i = 0; i < items.length - 1; i++) {
        sum += Number(items[i].textContent);
    }

    console.log(sum)

    let result = document.getElementById('sum');
    result.textContent = sum.toString();

}