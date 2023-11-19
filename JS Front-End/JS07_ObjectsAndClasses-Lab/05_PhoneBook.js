function getPhoneBook(arr) {

    const phoneBook = {};

    for (const element of arr) {
        const [name, phone] = element.split(' ');
        phoneBook[name] = phone;
    }

    for (const key in phoneBook) {
        console.log(`${key} -> ${phoneBook[key]}`);
    }
}

getPhoneBook(['Tim 0834212554',
    'Peter 0877547887',
    'Bill 0896543112',
    'Tim 0876566344'])