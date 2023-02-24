package A2_MultipleImplementation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Class[] citizenInterfaces = Citizen.class.getInterfaces();

        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {

            Method[] methods = Birthable.class.getDeclaredMethods();
            Method[] methods1 = Identifiable.class.getDeclaredMethods();

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());

            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();

            Identifiable identifiable = new Citizen(name, age, id, birthDate);
            Birthable birthable = new Citizen(name, age, id, birthDate);

            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods1.length);
            System.out.println(methods1[0].getReturnType().getSimpleName());
        }
    }
}
/*Using the code from the previous task, define an interface Identifiable with a String method getId
and an interface Birthable with a String method getBirthDate and implement them in the Citizen class.
Rewrite the Citizen constructor to accept the new parameters.
Add the following code to your main method and submit it to Judge.
<<Interface>>
Identifiable
+	getId(): String

<<Interface>>
Person
+	getName(): String
+	getAge(): int

<<Interface>>
Birthable
+	getBirthDate(): String

Citizen
-	name: String
-	age: int
-	id: String
-	birthDate: String
+	Citizen(String, int, String, String)
+	getName(): String
+	getAge(): int
+	getId(): String
+	getBirthDate(): String
+	toString(): String
*/
