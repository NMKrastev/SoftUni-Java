function getTheatrePromotion(dayOfWeek, age) {

    let ticketPrice = 0;

    switch (dayOfWeek) {
        case 'Weekday':
            if (age >= 0 && age <= 18) {
                ticketPrice = 12;
            } else if (age >= 19 && age <= 64) {
                ticketPrice = 18;
            } else if (age >= 65 && age <= 122) {
                ticketPrice = 12;
            }
            break;
        case 'Weekend':
            if (age >= 0 && age <= 18) {
                ticketPrice = 15;
            } else if (age >= 19 && age <= 64) {
                ticketPrice = 20;
            } else if (age >= 65 && age <= 122) {
                ticketPrice = 15;
            }
            break;
        case 'Holiday':
            if (age >= 0 && age <= 18) {
                ticketPrice = 5;
            } else if (age >= 19 && age <= 64) {
                ticketPrice = 12;
            } else if (age >= 65 && age <= 122) {
                ticketPrice = 10;
            }
            break;
    }

    if (ticketPrice === 0) {
        console.log('Error!')
    } else {
        console.log(`${ticketPrice}$`)
    }

}

getTheatrePromotion('Weekday',
    42)