package A1_JarOfT;

public class Main {

    public static void main(String[] args) {

        Jar<String> stringJar = new Jar<>();

        stringJar.add("Ivan");
        stringJar.add("Peter");

        System.out.println(stringJar.remove());

    }
}
/*Create a class Jar<> that can store anything.
It should have two public methods:
•	void add(element)
•	element remove()
Adding should add on top of its contents. Remove should get the topmost element.
Use the syntax Jar<T> to create a generic class.
*/
