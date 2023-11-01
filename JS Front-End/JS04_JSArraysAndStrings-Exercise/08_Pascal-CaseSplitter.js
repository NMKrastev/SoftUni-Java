function splitPascalCaseString(input) {
    const words = input.split(/(?=[A-Z])/);
    const result = words.join(', ');
    console.log(result);
}

splitPascalCaseString('SplitMeIfYouCanHaHaYouCantOrYouCan')