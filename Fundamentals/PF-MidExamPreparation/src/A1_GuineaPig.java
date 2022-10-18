import java.util.Scanner;

public class A1_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine()) * 1000.0;
        double hay = Double.parseDouble(scanner.nextLine()) * 1000.0;
        double cover = Double.parseDouble(scanner.nextLine()) * 1000.0;
        double guineaWeight = Double.parseDouble(scanner.nextLine()) * 1000.0;
        int secondDayCount = 1;
        int thirdDayCount = 1;

        for (int i = 1; i <= 30; i++) {

            food -= 300;
            if (i % 3 == 0 && i % 2 == 0) {
                double neededHay = food * 0.05;
                hay -= neededHay;
                double neededCover = guineaWeight / 3;
                cover -= neededCover;
                secondDayCount = 0;
                thirdDayCount = 0;

            } else if (i % 2 == 0) {
                double neededHay = food * 0.05;
                hay -= neededHay;
                secondDayCount = 0;
            } else if (i % 3 == 0) {
                double neededCover = guineaWeight / 3;
                cover -= neededCover;
                thirdDayCount = 0;
            }
        }
        if (food > 0 && hay > 0 && cover > 0) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    food / 1000, hay / 1000, cover / 1000);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
/*
On the first three lines, you will receive the quantity of food, hay, and cover, which Merry buys for a month (30 days).
On the fourth line, you will receive the guinea pig's weight.
Every day Puppy eats 300 gr of food. Every second day Merry first feeds the pet, then gives it a certain amount of hay
equal to 5% of the rest of the food. On every third day, Merry puts Puppy cover with a quantity of 1/3 of its weight.
Calculate whether the quantity of food, hay, and cover, will be enough for a month.
If Merry runs out of food, hay, or cover, stop the program!
Input
•	On the first line – quantity food in kilograms - a floating-point number in the range [0.0 – 10000.0].
•	On the second line – quantity hay in kilograms - a floating-point number in the range [0.0 – 10000.0].
•	On the third line – quantity cover in kilograms - a floating-point number in the range [0.0 – 10000.0].
•	On the fourth line – guinea's weight in kilograms - a floating-point number in the range [0.0 – 10000.0].
Output
•	If the food, the hay, and the cover are enough, print:
o	"Everything is fine! Puppy is happy! Food: {excessFood}, Hay: {excessHay}, Cover: {excessCover}."
•	If one of the things is not enough, print:
o	"Merry must go to the pet store!"
The output values must be formatted to the second decimal place!
*/