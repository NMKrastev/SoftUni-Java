function getCats(arr) {

    let cats = [];

    class Cat {
        constructor(name, age) {
            this.name = name
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`)
        }
    }

    for (let i = 0; i < arr.length; i++) {
        const catInfo = arr[i].split(' ');
        const [name, age] = catInfo;
        const cat = new Cat(name, age)
        cats.push(cat)
        cat.meow();
    }
}

getCats(['Mellow 2', 'Tom 5']);


