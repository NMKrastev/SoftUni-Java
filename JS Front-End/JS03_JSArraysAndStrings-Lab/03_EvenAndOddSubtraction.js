function evenAndOddSubtraction(arr) {

    let sumEven = 0;
    let sumOdd = 0;

    for (const num of arr) {
        if (num % 2 === 0) {
            sumEven += num;
        } else {
            sumOdd += num
        }
    }

    console.log(sumEven - sumOdd);
}

evenAndOddSubtraction([3,5,7,9]);