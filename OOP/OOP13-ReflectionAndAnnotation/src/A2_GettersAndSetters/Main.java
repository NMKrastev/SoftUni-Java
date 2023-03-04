package A2_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

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
    }
}
