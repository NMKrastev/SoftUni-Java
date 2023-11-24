function solve() {

    let inputText = document.getElementById('input').value.split('.');
    let outputContent = document.getElementById('output');

    inputText = inputText
        .filter(s => s.length > 0)
        .map(s => s += '.');

    while(inputText.length > 0) {

        let p = document.createElement('p');

        p.textContent = inputText.splice(0, 3).join('');

        outputContent.appendChild(p);
    }

}