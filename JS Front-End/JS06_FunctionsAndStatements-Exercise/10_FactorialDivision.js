function calculateAndPrintDivision(num1, num2) {
    let factorial1 = calculateFactorial(num1);
    let factorial2 = calculateFactorial(num2);

    let divisionResult = (factorial1 / factorial2).toFixed(2);

    function calculateFactorial(number) {
        if (number === 0 || number === 1) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }

    console.log(divisionResult);
}

calculateAndPrintDivision(6, 2);