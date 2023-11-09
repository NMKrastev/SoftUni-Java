function nxnMatrix(number) {

    let num = ''

    for (let i = 0; i < number; i++) {
        for (let j = 0; j < number; j++) {
            num += `${number.toString()} `
        }
        console.log(num.trim());
        num = '';
    }
}

nxnMatrix(7);