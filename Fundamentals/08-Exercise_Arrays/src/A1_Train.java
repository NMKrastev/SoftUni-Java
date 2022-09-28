import java.util.Scanner;

public class A1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int[] carsArray = new int[num];
        int sum = 0;

        for (int i = 0; i < num; i++) {

            int people = Integer.parseInt(scanner.nextLine());
            carsArray[i] = people;
            sum += people;

        }

        for (int cars :
             carsArray) {
            System.out.print(cars + " ");
        }

        System.out.println();
        System.out.println(sum);
    }
}
/*You will be given a count of wagons in a train n. On the next n lines,
you will receive how many people will get on that wagon. In the end,
print the whole train and the sum of the people on the train*/