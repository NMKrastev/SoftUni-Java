import java.util.Scanner;

public class A1_ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isXPEnough = false;
        double experienceNeeded = Double.parseDouble(scanner.nextLine());
        int numOfBattles = Integer.parseInt(scanner.nextLine());
        double sumOfCurrentXP = 0;
        int battlesCount = 0;

        for (int i = 1; i <= numOfBattles; i++) {

            double currentXP = Double.parseDouble(scanner.nextLine());
            sumOfCurrentXP += currentXP;
            battlesCount++;
            if (i % 3 == 0) {
                sumOfCurrentXP += (currentXP * 0.15);
            }
            if (i % 5 == 0) {
                sumOfCurrentXP -= (currentXP * 0.10);
            }
            if (i % 15 == 0) {
                sumOfCurrentXP += (currentXP * 0.05);
            }

            if (sumOfCurrentXP >= experienceNeeded) {
                isXPEnough = true;
                break;
            }
        }

        if (isXPEnough) {
            System.out.printf("Player successfully collected his needed experience for %d battles.\n", battlesCount);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", experienceNeeded - sumOfCurrentXP);
        }
    }
}
/*On the first line, you will receive the amount of experience needed to unlock the tank. On the second line, you will
receive the count of battles. On the following lines, you will receive the experience the player can gain in every battle.
Calculate if he can unlock the tank. Keep in mind that he gets 15% more experience for every third battle and 10% less
for every fifth battle, and 5% more experience on every fifteenth. You also need to stop the program as soon as
he collects the needed experience .
Format the output as shown below.
Input:
•	On the  first  line, you will  receive  the  needed  experience  amount  - a  real  number  in the  range
(0.0....400000.0).
•	On the second line, you will receive the count of battles - an integer number in the range
(0....500).
•	On the following lines, you will receive the experience earned per battle - a real number in the range
[0.0....5000.0).
Output:
•	If he managed to gather the experience:
o	"Player	successfully collected	his needed experience for {battleCount} battles."
•	If he was not able to do it:
o	"Player was not able to collect the needed experience, {neededExperience} more needed."
NOTE: Format the needed experience to the second decimal place.
*/