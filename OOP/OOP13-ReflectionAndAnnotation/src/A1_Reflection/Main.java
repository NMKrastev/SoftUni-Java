package A1_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);

        System.out.println(clazz.getSuperclass());

        Arrays.stream(clazz.getInterfaces())
                .forEach(System.out::println);

        Constructor<Reflection> constructor = clazz.getConstructor();
        Reflection reflection = constructor.newInstance();
        System.out.println(reflection);
        //System.out.println(clazz.getConstructor().newInstance());

    }
}
/*Import "Reflection.java" to your "src" folder in your project.
Try to use reflection and print some information about this class. Print everything on a new line:
•	This class type
•	Super class type
•	All interfaces that are implemented by this class
•	Instantiate object using reflection and print it too
Don’t change anything in "Reflection class"!
*/