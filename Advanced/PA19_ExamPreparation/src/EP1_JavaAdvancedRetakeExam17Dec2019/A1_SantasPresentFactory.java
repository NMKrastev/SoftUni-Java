package EP1_JavaAdvancedRetakeExam17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class A1_SantasPresentFactory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> presentsProduction = new TreeMap<>(Map.of("Doll", 0,
                "Wooden train", 0,
                "Teddy bear", 0,
                "Bicycle", 0));
        ArrayDeque<Integer> materials = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);
        ArrayDeque<Integer> magicValues = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(magicValues::offer);

        while (!materials.isEmpty() && !magicValues.isEmpty()) {

            int material = materials.peek();
            int magicValue = magicValues.peek();
            int product = magicValue * material;

            if (product < 0) {
                int result = magicValue + material;
                magicValues.poll();
                materials.pop();
                materials.push(result);
                continue;
            }
            if (material == 0 || magicValue == 0) {
                if (material == 0) {
                    materials.pop();
                }
                if (magicValue == 0) {
                    magicValues.poll();
                }
                continue;
            }

            if (product != 150 && product != 250 && product != 300 && product != 400) {
                magicValues.poll();
                material += 15;
                materials.pop();
                materials.push(material);
                continue;
            }

            if (product == 150) {
                materials.pop();
                magicValues.poll();
                presentsProduction.put("Doll", presentsProduction.get("Doll") + 1);
            } else if (product == 250) {
                materials.pop();
                magicValues.poll();
                presentsProduction.put("Wooden train", presentsProduction.get("Wooden train") + 1);
            } else if (product == 300) {
                materials.pop();
                magicValues.poll();
                presentsProduction.put("Teddy bear", presentsProduction.get("Teddy bear") + 1);
            } else if (product == 400) {
                materials.pop();
                magicValues.poll();
                presentsProduction.put("Bicycle", presentsProduction.get("Bicycle") + 1);
            }
        }

        if ((presentsProduction.get("Doll") > 0 && presentsProduction.get("Wooden train") > 0)
                || (presentsProduction.get("Teddy bear") > 0 && presentsProduction.get("Bicycle") > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()) {
            System.out.printf("Materials left: %s\n", materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!magicValues.isEmpty()) {
            System.out.printf("Magic left: %s\n", magicValues.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        presentsProduction.entrySet()
                .stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
    }
}
/*First, you will receive a sequence of integers, representing the number of materials for crafting toys in one box.
After that, you will be given another sequence of integers – their magic level.
Your task is to mix materials with magic so you can craft presents, listed in the table below with the exact magic level.
To craft a toy, you have to take the last box with materials and the first magic level value.
The total magic level is calculated by their multiplication. If the result equals one of the levels described
in the table above, you craft the present and remove both materials and magic value. Otherwise:
•	If the product of the operation is a negative number, then you have to sum the values together,
remove them both from their positions and the result should be added to the materials.
•	If the product doesn’t equal one of the magic levels in the table and is a positive number,
remove only the magic value and increase the material value by 15.
•	If the magic or material (or both) equals 0, remove it (or both) and continue crafting the presents.
Stop crafting presents when you run out of boxes of materials or magic level values.
Your task is considered done if you manage to craft either one of the pairs - a doll and a train or a teddy bear and a bicycle.
Input
•	The first line of input will represent the values of boxes with materials - integers, separated by a single space.
•	On the second line, you will be given the magic values - integers again, separated by a single space.
Output
•	On the first line - print whether you've succeeded in crafting the presents
o	"The presents are crafted! Merry Christmas!"
o	"No presents this Christmas!"
•	On the next two lines print the materials and magic that are left, if there are any, otherwise skip the line
o	"Materials left: {material1}, {material2}, …"
o	"Magic left: {magicValue1}, {magicValue2}, …
•	On the next lines print the presents you have crafted at least once, ordered alphabetically in the format:
"{toy name}: {amount}"
…
Constraints
•	All of the materials' values will be integers in the range [0, 100].
•	Magic level values will be integers in the range [-15, 100].
•	In all cases, at least one present will be crafted.
*/