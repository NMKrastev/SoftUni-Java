import java.util.Scanner;

public class PF10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        int lightsabers = (int) Math.ceil((students + (students * 0.1)));
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());
        int robes = students;
        int discountBelts = 0;
        int belts = 0;
        if (students > 5) {
            discountBelts = students / 6;
            belts = students - discountBelts;
        } else {
            belts = students;
        }

        double totalPrice = (lightsabers * lightsaberPrice) + (robes * robePrice) + (belts * beltPrice);

        if (totalPrice <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - budget);
        }
    }
}
/*Yoda is starting his newly created Jedi academy. So, he asked Master George Lucas to buy the needed equipment.
The number of items depends on how many students will sign up. The equipment for the Padawan contains lightsabers,
belts, and robes.
You will be given the amount of money George Lucas has, the number of students, and the prices of each item.
You have to help George Lucas calculate if the money he has is enough to buy all of the equipment, or how much
more money he needs.
Because the lightsabers sometimes break, George Lucas should buy 10% more, rounded up to the next integer.
Also, every sixth belt is free.
Input / Constraints
The input data should be read from the console. It will consist of exactly 5 lines:
•	The amount of money George Lucas has – the floating-point number in the range [0.00…1,000.00].
•	The count of students – integer in the range [0…100].
•	The price of lightsabers for a single saber – the floating-point number in the range [0.00…100.00].
•	The price of robes for a single robe – the floating-point number in the range [0.00…100.00].
•	The price of belts for a single belt – the floating-point number in the range [0.00…100.00].
The input data will always be valid. There is no need to check it explicitly.
Output
The output should be printed on the console.
•	If the calculated price of the equipment is less or equal to the money George Lucas has:
"The money is enough - it would cost {the cost of the equipment}lv."
•	If the calculated price of the equipment is more than the money George Lucas has:
 "George Lucas will need {neededMoney}lv more."
•	All prices must be rounded to two digits after the decimal point.
*/