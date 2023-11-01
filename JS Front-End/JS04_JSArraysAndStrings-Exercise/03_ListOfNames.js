function listOfNames(arr) {

    arr.sort((w1, w2) => w1.localeCompare(w2));

    for (let i = 0; i < arr.length; i++) {
        console.log(`${i + 1}.${arr[i]}`);
    }
}

listOfNames(["John", "Bob", "Christina", "Ema"]);