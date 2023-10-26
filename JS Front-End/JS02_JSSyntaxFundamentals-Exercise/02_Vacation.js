function calculateTotalPrice(peopleCount, groupType, dayOfWeek) {

    let totalPrice = 0;

    switch (dayOfWeek) {
        case 'Friday':
            if (groupType === 'Students') {
                totalPrice = peopleCount * 8.45;
                if (peopleCount >= 30) {
                    totalPrice -= totalPrice * 0.15;
                }
            } else if (groupType === 'Business') {
                if (peopleCount >= 100) {
                    peopleCount -= 10;
                }
                totalPrice = peopleCount * 10.90;
            } else if (groupType === 'Regular') {
                totalPrice = peopleCount * 15;
                if (peopleCount >= 10 && peopleCount <= 20) {
                    totalPrice -= totalPrice * 0.05;
                }
            }
            break;
        case 'Saturday':
            if (groupType === 'Students') {
                totalPrice = peopleCount * 9.80;
                if (peopleCount >= 30) {
                    totalPrice -= totalPrice * 0.15;
                }
            } else if (groupType === 'Business') {
                if (peopleCount >= 100) {
                    peopleCount -= 10;
                }
                totalPrice = peopleCount * 15.60;
            } else if (groupType === 'Regular') {
                totalPrice = peopleCount * 20;
                if (peopleCount >= 10 && peopleCount <= 20) {
                    totalPrice -= totalPrice * 0.05;
                }
            }
            break;
        case 'Sunday':
            if (groupType === 'Students') {
                totalPrice = peopleCount * 10.46;
                if (peopleCount >= 30) {
                    totalPrice -= totalPrice * 0.15;
                }
            } else if (groupType === 'Business') {
                if (peopleCount >= 100) {
                    peopleCount -= 10;
                }
                totalPrice = peopleCount * 16;
            } else if (groupType === 'Regular') {
                totalPrice = peopleCount * 22.50;
                if (peopleCount >= 10 && peopleCount <= 20) {
                    totalPrice -= totalPrice * 0.05;
                }
            }
            break;
    }

    console.log(`Total price: ${totalPrice.toFixed(2)}`);
}

calculateTotalPrice(100,
    "Business",
    "Sunday")