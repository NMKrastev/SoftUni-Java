function determineAge(age) {

    let ageIfo = 'out of bounds';

    if (age >= 0 && age <= 2) {
        ageIfo = 'baby';
    } else if (age >= 3 && age <= 13) {
        ageIfo = 'child';
    } else if (age >= 14 && age <= 19) {
        ageIfo = 'teenager';
    } else if (age >= 20 && age <= 65) {
        ageIfo = 'adult';
    } else if (age >= 66) {
        ageIfo = 'elder';
    }

    console.log(ageIfo);
}

determineAge(-1)