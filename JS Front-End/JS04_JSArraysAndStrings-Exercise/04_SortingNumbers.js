function sortingNumbers(arr) {

    let nums = [];

    let count = arr.length;

    for (let i = 0; i < count; i++) {
        if (i % 2 === 0) {
            arr.sort(function(a,b) {return a - b;});
        } else {
            arr.sort(function(a,b) {return b - a;});
        }
        nums.push(arr.shift());
    }

    return nums;
}

sortingNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);