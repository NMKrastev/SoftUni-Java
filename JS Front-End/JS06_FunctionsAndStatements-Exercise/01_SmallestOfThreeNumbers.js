function smallestOfThreeNumbers(numOne, numTwo, numThree) {

    if (numOne <= numTwo && numOne <= numThree) {
        console.log(numOne);
    } else if (numTwo <= numOne && numTwo <= numThree) {
        console.log(numTwo);
    } else if (numThree <= numOne && numThree <= numTwo) {
        console.log(numThree);
    }

    //console.log(Math.min(numOne, numTwo, numThree));
}

smallestOfThreeNumbers(25,
    21,
    4
);
