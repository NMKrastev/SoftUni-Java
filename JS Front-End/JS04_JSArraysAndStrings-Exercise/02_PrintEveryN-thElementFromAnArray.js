function printNthElement(array, n) {

    const newArr = [];

    for (let i = 0; i < array.length; i+=n) {
        newArr.push(array[i]);
    }

    return newArr;
}

printNthElement(['5',
        '20',
        '31',
        '4',
        '20'],
    2
);