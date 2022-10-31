import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A2_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();
        String resource;
        int resourceQuantity;
        int sum = 0;

        while (!(resource = scanner.nextLine().trim()).equals("stop")) {

            map.putIfAbsent(resource, 0);
            resourceQuantity = Integer.parseInt(scanner.nextLine());
            if (map.containsKey(resource) && map.containsValue(0)) {
                map.put(resource, resourceQuantity);
            } else {
                sum = map.get(resource) + resourceQuantity;
                map.put(resource, sum);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
/*Until you receive the "stop" command, you will be given a sequence of strings, each on a new line.
Every odd line on the console represents a resource (e.g., Gold, Silver, Copper, etc.) and every even - quantity.
Your task is to collect the resources and print them on a new line.
Print the resources and their quantities in format: "{resource} –> {quantity}".
The quantities inputs will be in the range [1 … 2 000 000 000].
*/