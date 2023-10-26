function sumDigits(num) {

    let sum = 0;

    for (let digit of num.toString()) {
        sum += parseInt(digit);
    }

    console.log(sum);
}

sumDigits(245678);

