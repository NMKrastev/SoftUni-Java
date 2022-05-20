import java.util.Scanner;

public class Gymnastics03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalPoints = 0, percentNeeded = 0;
        String country = scanner.nextLine();
        String discipline = scanner.nextLine();

        switch (country) {
            case "Russia" :
                if (discipline.equals("ribbon")) {
                    totalPoints = 9.100 + 9.400;
                    percentNeeded = ((20 - totalPoints) / 20) * 100;
                } else if (discipline.equals("hoop")){
                    totalPoints = 9.300 + 9.800;
                    percentNeeded = ((20 - totalPoints) / 20) * 100;
                } else if (discipline.equals("rope")) {
                    totalPoints = 9.600 + 9.000;
                    percentNeeded = ((20 - totalPoints) / 20) * 100;
                }
                break;
            case "Bulgaria" :
                if (discipline.equals("ribbon")) {
                    totalPoints = 9.600 + 9.400;
                    percentNeeded = ((20 - totalPoints) / 20) * 100;
                } else if (discipline.equals("hoop")){
                    totalPoints = 9.550 + 9.750;
                    percentNeeded = ((20 - totalPoints) / 20) * 100;
                } else if (discipline.equals("rope")) {
                    totalPoints = 9.500 + 9.400;
                    percentNeeded = ((20 - totalPoints) / 20) * 100;
                }
                break;
            case "Italy" :
                if (discipline.equals("ribbon")) {
                    totalPoints = 9.200 + 9.500;
                    percentNeeded = ((20 - totalPoints) / 20) * 100;
                } else if (discipline.equals("hoop")){
                    totalPoints = 9.450 + 9.350;
                    percentNeeded = ((20 - totalPoints) / 20) * 100;
                } else if (discipline.equals("rope")) {
                    totalPoints = 9.700 + 9.150;
                    percentNeeded = ((20 - totalPoints) / 20) * 100;
                }
                break;
        }
        System.out.printf("The team of %s get %.3f on %s.\n" +
                "%.2f%%", country, totalPoints, discipline, percentNeeded);
    }
}
/*На световно първенство по художествена гимнастика три от държавите се изявяват като лидери в класирането
(Русия, България, Италия). Вашата задача е да изчислите каква е оценката дадена от журито за конкретно
съчетание, като знаете държавата, която е играла и с кой уред е играла - лента, обръч или въже.
За съчетанието си, отбора е получил две оценки: оценка за трудност и оценка за изпълнение на съчетанието,
като крайната оценка е сбор на двете оценки. В таблицата са показани какви оценки за трудност и изпълнение
са получили ансамблите за всеки един уред.
Уред	                Русия	                България             	Италия
Лента(ribbon)	        Трудност: 9.100         Трудност: 9.600         Трудност: 9.200
                        Изпълнение: 9.400       Изпълнение: 9.400       Изпълнение: 9.500

Обръч(hoop)             Трудност: 9.300         Трудност: 9.550         Трудност: 9.450
                        Изпълнение: 9.800	    Изпълнение: 9.750       Изпълнение: 9.350

Въже(rope)	            Трудност: 9.600         Трудност: 9.500         Трудност: 9.700
                        Изпълнение: 9.000	    Изпълнение: 9.400       Изпълнение: 9.150

Напишете програма, която изчислява каква е оценката на дадена държава за определен уред и колко процента
не им достигат, за да имат максималната оценка, която е 20.
Вход
Входът се чете от конзолата и се състои от два реда:
•	Първи ред – държава – текст ("Russia", "Bulgaria" или "Italy")
•	Втори ред – уред - текст ("ribbon", "hoop" или "rope")
Изход
На конзолата трябва да се отпечатат два реда:
•	Първи ред: "The team of {държава} get {обща оценка} on {уред}."
•	Втори ред:  "{процентът, който не им достига до максималния брой точки}%"
Общата оценка да бъде форматирана до третата цифра след десетичния знак, а процентът да бъде форматиран до втората цифра след десетичния знак.
*/