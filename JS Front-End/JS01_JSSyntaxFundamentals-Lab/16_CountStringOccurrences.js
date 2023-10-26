function countStringOccurrences(text, searched) {

    let count = 0;
    let words = text.split(' ');

    for (let word of words) {
        if (word === searched) {
            count++;
        }
    }

    console.log(count);
}

countStringOccurrences('This is a word and it also is a sentence', 'is');