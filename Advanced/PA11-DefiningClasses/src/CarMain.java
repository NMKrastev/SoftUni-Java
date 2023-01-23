import java.util.Scanner;

public class CarMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String input;
        for (int i = 0; i < num; i++) {
            input = scanner.nextLine();
            String brand = input.split("\\s+")[0];
            String model = input.split("\\s+")[1];
            int horsePower = Integer.parseInt(input.split("\\s+")[2]);
            Car car = new Car(brand, model, horsePower);
            car.carInfo();
        }
    }
}
/*Read cars objects, add them to the collection of your choice, and print each one on the console using the
carInfo() method. The input consists of a single integer N, the number of lines representing car objects.
On each line you will read car info in the following format "{brand} {model} {horsePower}" separated by single space.*/
