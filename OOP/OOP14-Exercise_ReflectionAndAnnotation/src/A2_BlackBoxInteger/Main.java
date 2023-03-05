package A2_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field field = clazz.getDeclaredField("innerValue");
        field.setAccessible(true);

        String input;

        while (!(input = scanner.nextLine()).equals("END")) {

            String[] data = input.split("_");
            String methodName = data[0];
            int argument = Integer.parseInt(data[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, argument);

            System.out.println(field.get(blackBoxInt));

        }
    }
}
/*You are helping a buddy of yours who is still in the OOP Basics course - his name is John.
He is rather slow and made a class with all private members. Your tasks are to instantiate an object from his class
(always with start value 0) and then invoke the different methods it has.
Your restriction is to not change anything in the class itself (consider it a black box).
You can look at his class but don't touch anything! The class itself is called BlackBoxInt.
It is a wrapper for the int primitive. The methods it has are:
Input
The input will consist of lines in the form:
"{command name}_{value}"
Input will always be valid and in the format described, so there is no need to check it explicitly.
You stop receiving input when you encounter the command "END".
Output
Each command (except the "END" one) should print the current value of innerValue
of the BlackBoxInt object you instantiated. Don't cheat by overriding toString in the class -
you must get the value from the private field.
*/