function findLargestNumber(...input) {

    let largestNumber = Number.MIN_SAFE_INTEGER;

    input.forEach(function (number) {
           if (number > largestNumber) {
               largestNumber = number;
           }
    })

    console.log(`The largest number is ${largestNumber}.`);
}

findLargestNumber(1, 4, 15, 7, 8);