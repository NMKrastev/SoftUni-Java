function oddOccurrences(sentence) {

    const uniqueWordsSet = new Set(sentence.split(' ').map(word => word.toLowerCase()));

    const uniqueWordsArray = Array.from(uniqueWordsSet);

    let oddOccurrences = []

    uniqueWordsArray.forEach((searchedWord) => {

        let occurrences= 0;

        sentence.split(' ').forEach((word) => {

            if (searchedWord.toLowerCase() === word.toLowerCase()) {

                occurrences++;

            }
        });

        if (occurrences % 2 !== 0) {
            oddOccurrences.push(searchedWord);
        }
    });

    console.log(oddOccurrences.join(' '));
}

oddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');