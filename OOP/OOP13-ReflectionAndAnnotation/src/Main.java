import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        /*
        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);

        System.out.println(clazz.getSuperclass());

        Arrays.stream(clazz.getInterfaces())
                .forEach(System.out::println);

        Constructor<Reflection> constructor = clazz.getConstructor();
        Reflection reflection = constructor.newInstance();
        System.out.println(reflection);
        */
        //System.out.println(clazz.getConstructor().newInstance());
//----------------------------------------------------------------------------------------
        /*
        //Gets only the public constructors
        Constructor<?>[] constructors = clazz.getConstructors();
        //Gets ALL constructors
        Constructor<?>[] allConstructors = clazz.getDeclaredConstructors();
        */
//----------------------------------------------------------------------------------------
        //Gets public fields
        /*
        Field name = clazz.getField("name");
        name.setAccessible(true);
        System.out.println(name.getName());
        System.out.println(name.getType());
        System.out.println(name.getDeclaringClass());

        System.out.println();

        //Gets ALL fields
        Field nickName = clazz.getDeclaredField("nickName");
        nickName.setAccessible(true);
        System.out.println(nickName.getName());
        System.out.println(nickName.get(null));
        System.out.println(nickName.getType());
        System.out.println(nickName.getDeclaringClass());
        System.out.println();
        */
//----------------------------------------------------------------------------------------
        /*
        Reflection reflection1 = new Reflection();

        System.out.println(reflection1.getName());

        Method method = clazz.getMethod("getName");

        System.out.println(method.invoke(reflection1));
        System.out.println();
        */
//----------------------------------------------------------------------------------------
        /*
        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);

        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);

        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.contains("get")){
                getters.add(method);
            } else if (methodName.contains("set")) {
                setters.add(method);
            }
        }

        for (Method getter : getters) {
            System.out.printf("%s will return class %s\n", getter.getName(), getter.getReturnType().getName());
        }

        for (Method setter : setters) {
            System.out.printf("%s and will set field of class %s\n", setter.getName(), setter.getParameterTypes()[0].getName());
        }
        System.out.println()
        */
//----------------------------------------------------------------------------------------
        /*Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);

        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);

        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.contains("get")) {
                getters.add(method);
            } else if (methodName.contains("set")) {
                setters.add(method);
            }
        }

        Set<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Field::getName))));

        for (Field field : fields) {
            int modifier = field.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.printf("%s must be private!\n", field.getName());
            }
        }

        for (Method getter : getters) {
            int modifier = getter.getModifiers();
            if (!Modifier.isPublic(modifier)) {
                System.out.printf("%s have to be public!\n", getter.getName());
            }
        }

        for (Method setter : setters) {
            int modifier = setter.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.printf("%s have to be private!\n", setter.getName());
            }
        }

        System.out.println();*/
//----------------------------------------------------------------------------------------

    }
}
