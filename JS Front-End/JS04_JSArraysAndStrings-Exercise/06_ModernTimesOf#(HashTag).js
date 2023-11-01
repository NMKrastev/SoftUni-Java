function hashTag(text) {

    const regex = /#([a-zA-Z]+)\b/g;

    const matches = text.match(regex);

    if (matches) {
        const specialWords = matches.map(match => match.substring(1)); // Remove the #
        console.log(specialWords.join('\n'));
    }
}

hashTag('Nowadays everyone uses # to tag a #special word in #socialMedia')