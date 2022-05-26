import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Only the first nine letters from the alphabet are going to be used
        //but I decided to go with full alphabet in case is needed.
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numOne; i++) {
            for (int j = 1; j <= numOne; j++) {
                for (int k = 0; k < numTwo; k++) {
                    for (int l = 0; l < numTwo; l++) {
                        for (int m = 1; m <= numOne; m++) {

                            if (m > i && m > j) {
                                System.out.printf("%d%d%s%s%d ", i, j, alphabet[k], alphabet[l], m);
                            }
                        }
                    }
                }
            }
        }
    }
}
/*Да се напише програма, която чете две цели числа n и l, въведени от потребителя, и генерира по азбучен
ред всички възможни  пароли, които се състоят от следните 5 символа:
•	Символ 1: цифра от 1 до n.
•	Символ 2: цифра от 1 до n.
•	Символ 3: малка буква измежду първите l букви на латинската азбука.
•	Символ 4: малка буква измежду първите l букви на латинската азбука.
•	Символ 5: цифра от 1 до n, по-голяма от първите 2 цифри.
Вход
Входът се чете от конзолата и се състои от две цели числа n и l в интервала [1…9], по едно на ред.
Изход
На конзолата трябва да се отпечатат всички пароли по азбучен ред, разделени с интервал.
*/