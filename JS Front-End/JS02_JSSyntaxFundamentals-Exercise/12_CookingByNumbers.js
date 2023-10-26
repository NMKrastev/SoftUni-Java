function cookingByNumbers(number, command1, command2, command3, command4, command5) {

    let num = parseInt(number);
    let arr = [command1, command2, command3, command4, command5];

    for (let command of arr) {
        switch (command) {
            case 'chop':
                num = num / 2;
                console.log(num);
                break;
            case 'dice':
                num = Math.sqrt(num);
                console.log(num);
                break;
            case 'spice':
                num += 1;
                console.log(num);
                break;
            case 'bake':
                num *= 3;
                console.log(num);
                break;
            case 'fillet':
                num *= 0.8;
                console.log(num.toFixed(1));
                break
        }
    }
}

cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet')