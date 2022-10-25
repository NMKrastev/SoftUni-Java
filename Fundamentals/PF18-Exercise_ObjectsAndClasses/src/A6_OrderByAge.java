import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A6_OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<A6_PersonsInfo> personsInfoList = new ArrayList<>();
        String input = "";

        while (!(input = scanner.nextLine()).equals("End")) {

            String name = input.split("\\s+")[0];
            String id = input.split("\\s+")[1];
            int age = Integer.parseInt(input.split("\\s+")[2]);

            A6_PersonsInfo person = new A6_PersonsInfo(name, id, age);

            personsInfoList.add(person);
        }

        personsInfoList = personsInfoList.stream().sorted(Comparator.comparing(A6_PersonsInfo::getAge)).collect(Collectors.toList());

        for (A6_PersonsInfo person : personsInfoList) {
            System.out.println(person);
        }
    }
}
/*You will receive an unknown number of lines. On each line, you will receive an array with 3 elements.
The first element will be a string and represents the name of the person. The second element will be a string and
will represent the ID of the person. The last element will be an integer which represents the age of the person.
When you receive the command "End", stop taking input and print all the people, ordered by age.
*/