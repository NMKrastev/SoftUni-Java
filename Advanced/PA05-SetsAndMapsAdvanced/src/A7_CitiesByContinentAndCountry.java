import java.util.*;

public class A7_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> atlasMap = new LinkedHashMap<>();
        String input;
        while (num-- > 0) {
            input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            atlasMap.putIfAbsent(continent, new LinkedHashMap<>());
            atlasMap.get(continent).putIfAbsent(country, new ArrayList<>());
            atlasMap.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, Map<String, List<String>>> continents : atlasMap.entrySet()) {
            System.out.printf("%s:\n", continents.getKey());
            for (Map.Entry<String, List<String>> country : continents.getValue().entrySet()) {
                System.out.printf("%s -> %s\n", country.getKey(), String.join(", ", country.getValue()));
            }

        }


    }
}
/*Write a program to read continents, countries, and their cities put them on a nested map,
and print them in the order of their first appearance.*/
