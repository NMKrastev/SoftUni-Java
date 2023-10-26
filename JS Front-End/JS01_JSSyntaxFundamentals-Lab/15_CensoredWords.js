function censorWord(text, word) {

    let censored = '*'.repeat(word.length);

    text = text.replaceAll(word, censored);

    console.log(text);
}

censorWord('Find the hidden word', 'hidden');