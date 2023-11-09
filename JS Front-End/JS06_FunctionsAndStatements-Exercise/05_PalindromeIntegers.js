function palindromeIntegers(numberArr) {

    for (let i = 0; i < numberArr.length; i++) {

        let numberAsString = numberArr[i].toString();

        let palindrome = numberAsString.split('').reverse().join('');

        console.log(numberAsString === palindrome)

    }
}

palindromeIntegers([123,323,421,121]);