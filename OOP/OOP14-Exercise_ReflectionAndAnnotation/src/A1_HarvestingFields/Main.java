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
/*You are given a RichSoilLand class with lots of fields (look at the provided skeleton).
Like the good farmer you are, you must harvest them.
Harvesting means that you must print each field in a certain format (see output).
Input
You will receive a maximum of 100 lines with one of the following commands:
•	private - print all private fields
•	protected - print all protected fields
•	public - print all public fields
•	all - print ALL declared fields
•	HARVEST - end the input
Output
For each command, you must print the fields that have the given access modifier as described in the input section.
The format in which the fields should be printed is:
"{access modifier} {field type} {field name}"
*/