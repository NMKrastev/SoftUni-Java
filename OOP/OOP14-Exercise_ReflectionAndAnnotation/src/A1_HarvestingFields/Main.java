package A1_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;


        Field[] fields = clazz.getDeclaredFields();

        String input;

        while (!(input = scanner.nextLine()).equals("HARVEST")) {
            printResult(fields, input);
        }

    }

    private static void printResult(Field[] fields, String input) {
        for (Field field : fields) {
            if (input.equals("all")) {
                System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
            } else if (field.toString().contains(input)) {
                System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
            }
        }
    }
}
