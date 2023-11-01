function reverseAnArrayOfNumbers(n, arr) {

    let slice = arr.slice(0, n);

    console.log(slice.reverse().join(' '));
}

reverseAnArrayOfNumbers(3, [10, 20, 30, 40, 50]);