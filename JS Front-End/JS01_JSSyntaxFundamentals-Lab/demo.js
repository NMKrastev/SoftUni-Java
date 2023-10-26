let name = "Alex"; // let Can change its values

const nameTwo = "John" // const Cannot change its value

console.log(name);

function printName(name) {
    console.log(name);
}

printName("John");

const arr = [1, 2, 3, 4, 5];
const [first, ...rest] = arr;
console.log(first);

function solve(...input) {

   const sortedInput = input.sort(function (a, b) {
       return b - a;
   });

   const highestNum = sortedInput[0];

   console.log(highestNum);
}

solve(1, 4, 10, 7, 8);

const arr2 = [1, 2, 3, 4, 5]
console.log(arr2);
arr2.push(6);
console.log(arr2);
const lastNum = arr2.pop();
console.log(lastNum);

const users = ["John", "Pesho", "Ivan"]
users.forEach(function (user) {
    console.log(`Hello, ${user}!`);
})

const usersTwo = ["John", "Pesho", "Ivan"]
const usersGreetings = users.map(function (user) {
    return `Hello, ${user}!`;
})
console.log(usersGreetings);