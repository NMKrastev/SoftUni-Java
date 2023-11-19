function getPiccolo(arr) {

    let parkingLot = [];

    for (const car of arr) {

        let [direction, plateNumber] = car.split(', ');

        if (direction === 'IN' && !parkingLot.includes(plateNumber)) {
            parkingLot.push(plateNumber);
        } else if (direction === 'OUT' && parkingLot.includes(plateNumber)) {
            let index = parkingLot.indexOf(plateNumber);
            parkingLot.splice(index, 1);
        }
    }

    if (parkingLot.length > 0) {
        console.log(parkingLot.sort().join('\n'));
    } else {
        console.log('Parking Lot is Empty')
    }
}

getPiccolo(['IN, CA2844AA', 'IN, CA1234TA', 'OUT, CA2844AA', 'IN, CA9999TT', 'IN, CA2866HI', 'OUT, CA1234TA', 'IN, CA2844AA', 'OUT, CA2866HI', 'IN, CA9876HH', 'IN, CA2822UU'])