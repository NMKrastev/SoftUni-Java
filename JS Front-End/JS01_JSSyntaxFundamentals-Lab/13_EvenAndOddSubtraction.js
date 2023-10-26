function differenceBetweenOddSumAndEvenSum(arr) {

    let sumEven = 0;
    let sumOdd = 0;

    arr.forEach(function (num) {
      if (num % 2 === 0)  {
          sumEven += num;
      } else {
          sumOdd += num
      }
    })

    console.log(sumEven - sumOdd);
}

differenceBetweenOddSumAndEvenSum([2,4,6,8,10]);