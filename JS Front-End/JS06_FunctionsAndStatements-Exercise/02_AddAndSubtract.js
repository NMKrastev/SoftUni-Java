function addAndSubtract(numOne, numTwo, numThree) {

    let sumResult = ()=> {
        return numOne + numTwo;
    };

    let result = ()=> {
        return sumResult() - numThree;
    };

    console.log(result());
}

addAndSubtract(23,
    6,
    10
);