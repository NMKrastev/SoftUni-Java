import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        int countStandard = 0, countStudent = 0,
                countKid = 0, countTotal = 0;

        while (!movie.equals("Finish")) {

            int seats = Integer.parseInt(scanner.nextLine());
            int currentCount = 0;
            String ticketType = scanner.nextLine();

            while (!ticketType.equals("End")) {
                countTotal++;
                currentCount++;
                switch (ticketType) {
                    case "standard":
                        countStandard++;
                        break;
                    case "student":
                        countStudent++;
                        break;
                    case "kid":
                        countKid++;
                        break;
                }
                if (currentCount == seats){
                    break;
                }
                ticketType = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.\n", movie, currentCount * 1.00 / seats * 100);
            movie = scanner.nextLine();
        }

        System.out.printf("Total tickets: %d\n", countTotal);
        System.out.printf("%.2f%% student tickets.\n", countStudent * 1.00 / countTotal * 100);
        System.out.printf("%.2f%% standard tickets.\n", countStandard * 1.00 / countTotal * 100);
        System.out.printf("%.2f%% kids tickets.\n", countKid * 1.00 / countTotal * 100);
    }
}
/*Вашата задача е да напишете програма, която да изчислява процента на билетите за всеки тип от продадените
билети: студентски(student), стандартен(standard) и детски(kid), за всички прожекции. Трябва да изчислите и
колко процента от залата е запълнена за всяка една прожекция.
Вход
Входът е поредица от цели числа и текст:
•	На първия ред до получаване на командата "Finish" - име на филма – текст
•	На втори ред – свободните места в салона за всяка прожекция – цяло число [1 … 100]
•	За всеки филм, се чете по един ред до изчерпване на свободните места в залата или до получаване на
командата "End":
o	Типа на закупения билет - текст ("student", "standard", "kid")
Изход
На конзолата трябва да се печатат следните редове:
•	След всеки филм да се отпечата, колко процента от кино залата е пълна
"{името на филма} - {процент запълненост на залата}% full."
•	При получаване на командата "Finish" да се отпечатат четири реда:
o	"Total tickets: {общият брой закупени билети за всички филми}"
o	"{процент на студентските билети}% student tickets."
o	"{процент на стандартните билети}% standard tickets."
o	"{процент на детските билети}% kids tickets."
*/