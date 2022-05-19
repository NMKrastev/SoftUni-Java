import java.util.Scanner;

public class ExamTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        double fee = Double.parseDouble(scanner.nextLine());
        double feePerSunbed = Double.parseDouble(scanner.nextLine());
        double feePerUmbrella = Double.parseDouble(scanner.nextLine());
        double totalFee = people * fee;
        int totalSunbeds = (int) Math.ceil((people * 0.75));
        int totalUmbrellas = (int) Math.ceil(people / 2.00);
        double totalMoney = totalFee + (Math.ceil(totalUmbrellas) * feePerUmbrella) +
                (totalSunbeds * feePerSunbed);

        System.out.printf("%.2f lv.", totalMoney);

    }
}
/*Преподавателският екип на СофтУни организира работен ден на басейн по случай настъпването на лятото.
Вашата задача е да напишете програма, която да изчислява каква сума трябва да се заплати.
За всеки един човек от екипа трябва да се заплати такса вход. Трябва да имате предвид, че един чадър
стига за двама души. Знае се, че само 75% от екипа искат шезлонги.
При изчислението на броя на чадърите и шезлонгите, техният брой да се закръгли до по-голямото цяло число.
Вход
От конзолата се четат 4 числа:
1.	Първи ред – брой на хората. Цяло число в интервала [1…100]
2.	Втори ред – такса вход. Реално число в интервала [0.00…50.00]
3.	Трети ред – цена един за шезлонг. Реално число в интервала [0.00…50.00]
4.	Четвърти ред – цена за един чадър. Реално число в интервала [0.00...50.00]
Изход
"{сумата за покриване на разходите} lv."
Резултатът да се форматира до втората цифра след десетичния знак.
*/