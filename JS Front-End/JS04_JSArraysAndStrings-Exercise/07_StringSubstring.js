function stringSubstring(word, text) {

    return text.toLowerCase()
        .split(" ")
        .some((w) => w === word.toLowerCase()) ? word : `${word} not found!`;
}

stringSubstring('python', 'JavaScript is the best programming language')