function solve() {

    let text = Array.from(document.getElementById('text').value.split(" "));
    let wordsArr = [];
    console.log(text);

    switch (document.getElementById('naming-convention').value) {
        case 'Camel Case':

            for (let i = 0; i < text.length; i++) {

                let word = '';

                if (i === 0) {
                    word = text[i].toLowerCase();
                    wordsArr.push(word);
                } else {
                    word = text[i].toLowerCase();
                    word = word.substring(0,1).toUpperCase().concat(word.substring(1, word.length));
                    wordsArr.push(word);
                }
            }

            break;
        case 'Pascal Case':

            for (let i = 0; i < text.length; i++) {

                let word = '';
                word = text[i].toLowerCase();
                word = word.substring(0,1).toUpperCase().concat(word.substring(1, word.length));
                wordsArr.push(word);
            }

            break;
        default:
            wordsArr.push('Error!')
    }

    let result = document.getElementById('result');

    result.textContent = wordsArr.join('');
}