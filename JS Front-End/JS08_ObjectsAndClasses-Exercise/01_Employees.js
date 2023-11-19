function employees(arr) {

    for (const employee of arr) {
        console.log(`Name: ${employee} -- Personal Number: ${employee.length}`);
    }
}

employees([

    'Silas Butler',

    'Adnaan Buckley',

    'Juan Peterson',

    'Brendan Villarreal'

])