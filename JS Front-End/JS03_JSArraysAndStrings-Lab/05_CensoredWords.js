function censoredWords(text, word) {

    let censored = '*'.repeat(word.length);

    let censoredText = text.replaceAll(word, censored);

    console.log(censoredText);

}

censoredWords('Find the hidden word', 'hidden');