package A2_HierarchicalInheritance;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
/*Create three classes named Animal, Dog, and Cat.
Animal with a single public method eat() that prints: "eating…"
Dog with a single public method bark() that prints: "barking…"
Cat with a single public method meow() that prints: "meowing…"
Dog and Cat should inherit from Animal.
*/