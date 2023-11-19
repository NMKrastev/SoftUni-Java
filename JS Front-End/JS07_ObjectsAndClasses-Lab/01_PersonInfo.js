function createObject(firstName, lastName, age) {

    //Short syntax
    //When the arguments/variables are with the same name!
    //If the names are different it can be done like that:
    //myName: firstName,
    /*return {
        firstName,
        lastName,
        age
    }*/

    let object = {};
    object.firstName = firstName;
    object.lastName = lastName;
    object.age = age;

    return object;
}

console.log(createObject("Peter", "Pan", "20"));