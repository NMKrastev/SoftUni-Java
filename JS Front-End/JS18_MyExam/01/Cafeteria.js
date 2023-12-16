function solve(input) {

    let allBaristas = [];

    const num = Number(input[0]);

    for (let i = 1; i <= num; i++) {
        const [name, shift, drinks] = input[i].split(' ');
        allBaristas.push({ name, shift, drinks: drinks.split(',') });
    }

    for (let i = num + 1; i < input.length - 1; i++) {
        const [command, baristaName, shiftType, coffeeType] = input[i].split(' / ');

        switch (command) {

            case 'Prepare':

                const shift = shiftType;
                const coffee = coffeeType;
                const barista = allBaristas.find((b) => b.name === baristaName);

                if (barista && barista.shift === shift && barista.drinks.includes(coffee)) {
                    console.log(`${baristaName} has prepared a ${coffee} for you!`);
                } else {
                    console.log(`${baristaName} is not available to prepare a ${coffee}.`);
                }

                break;

            case 'Change Shift':

                const newShift = shiftType;
                const baristaIndex = allBaristas.findIndex((b) => b.name === baristaName);

                if (baristaIndex !== -1) {
                    allBaristas[baristaIndex].shift = newShift;
                    console.log(`${baristaName} has updated his shift to: ${newShift}`);
                }

                break;

            case 'Learn':

                const newDrinkType = shiftType;
                const baristaNewCoffeeSkill = allBaristas.find((b) => b.name === baristaName);

                if (baristaNewCoffeeSkill && !baristaNewCoffeeSkill.drinks.includes(newDrinkType)) {
                    baristaNewCoffeeSkill.drinks.push(newDrinkType);
                    console.log(`${baristaName} has learned a new coffee type: ${newDrinkType}.`);
                } else {
                    console.log(`${baristaName} knows how to make ${newDrinkType}.`);
                }

                break;

        }
    }

    printBaristas();

    function printBaristas() {
        allBaristas.forEach((barista) => {
            console.log(`Barista: ${barista.name}, Shift: ${barista.shift}, Drinks: ${barista.drinks.join(', ')}`);
        });
    }
}