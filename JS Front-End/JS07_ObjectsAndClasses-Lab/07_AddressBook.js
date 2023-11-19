function getAddressBook(arr) {

    const addressBook = {};

    for (const element of arr) {
        const [name, address] = element.split(':');
        addressBook[name] = address;
    }

    const sortedEntries = Object.entries(addressBook).sort(([a], [b]) => a.localeCompare(b));

    const sortedAddressBook = Object.fromEntries(sortedEntries);

    for (const name in sortedAddressBook) {
        console.log(`${name} -> ${sortedAddressBook[name]}`)
    }

    /*const sortedEntries = Object.entries(addressBook);

    const sortedAddressBook = sortedEntries.sort();

    for (const name of sortedAddressBook) {
        console.log(`${name[0]} -> ${name[1]}`);
    }*/

}

getAddressBook(['Tim:Doe Crossing', 'Bill:Nelson Place', 'Peter:Carlyle Ave', 'Bill:Ornery Rd'])