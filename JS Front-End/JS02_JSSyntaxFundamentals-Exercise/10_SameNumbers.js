function sameNumbers(number) {

    let areSame = true;
    let num = number.toString()[0];
    let sum = 0;

    for (let digit of number.toString()) {
        if (digit !== num) {
            areSame = false;
            break;
        }
    }

    for (let digit of number.toString()) {
        sum += parseInt(digit);
    }

    console.log(areSame);
    console.log(sum);
}

sameNumbers(1234);