import java.util.Scanner;

public class Cinema04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int peopleCount = 0, totalIncome = 0;
        boolean isFull = false;

        while (!input.equals("Movie time!")) {
            int people = Integer.parseInt(input);
            peopleCount += people;

            if (peopleCount > capacity) {
                isFull = true;
                break;
            }
            totalIncome += people * 5;

            if (people % 3 == 0) {
                totalIncome -= 5;
            }

            input = scanner.nextLine();
        }
        if(isFull) {
            System.out.printf("The cinema is full.\nCinema income - %d lv.", totalIncome);
        } else {
            System.out.printf("There are %d seats left in the cinema.\nCinema income - %d lv.",
                    capacity - peopleCount, totalIncome);
        }
    }
}
/*От кино ви наемат да напишете програма, чрез която да разберете дали на една прожекцията ще се запълни
залата и колко пари ще се изкарат от нея. Получавате места в залата и на всеки следващ ред до команда "Movie time!",
колко хора влизат в залата. Цената на един билет е 5 лв. Ако текущия брой хора влезли в залата се дели на 3 без
остатък, се прави отстъпка 5лв от общата им сметка.
Ако в залата се опитат да влязат повече хора от колкото места са останали, то се счита че местата са изчерпани и
програмата трябва да приключи четенето на вход.
Вход
От конзолата се четат:
•	На първия ред - капацитет на залата - цяло число в интервала [50... 150]
На всеки следващ ред до команда "Movie time!":
o	Брой хора влизащи в киното - цяло число в интервала [1… 15]
Изход
На конзолата първо да се отпечата един ред:
•	При получена команда "Movie time!":
 "There are {останали места} seats left in the cinema."
•	При изчерпване на местата в залата:
	"The cinema is full."
След това да се отпечата:
	"Cinema income - {приходи от залата} lv."
*/