import java.util.Scanner;

public class OscarsWeekInCinema03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        String typeOfHall = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        switch (movie) {
            case "A Star Is Born":
                switch (typeOfHall) {
                    case "normal":
                        totalPrice = tickets * 7.50;
                        break;
                    case "luxury":
                        totalPrice = tickets * 10.50;
                        break;
                    case "ultra luxury":
                        totalPrice = tickets * 13.50;
                        break;
                }
                break;
            case "Bohemian Rhapsody":
                switch (typeOfHall) {
                    case "normal":
                        totalPrice = tickets * 7.35;
                        break;
                    case "luxury":
                        totalPrice = tickets * 9.45;
                        break;
                    case "ultra luxury":
                        totalPrice = tickets * 12.75;
                        break;
                }
                break;
            case "Green Book":
                switch (typeOfHall) {
                    case "normal":
                        totalPrice = tickets * 8.15;
                        break;
                    case "luxury":
                        totalPrice = tickets * 10.25;
                        break;
                    case "ultra luxury":
                        totalPrice = tickets * 13.25;
                        break;
                }
                break;
            case "The Favourite":
                switch (typeOfHall) {
                    case "normal":
                        totalPrice = tickets * 8.75;
                        break;
                    case "luxury":
                        totalPrice = tickets * 11.55;
                        break;
                    case "ultra luxury":
                        totalPrice = tickets * 13.95;
                        break;
                }
                break;
        }
        System.out.printf("%s -> %.2f lv.", movie, totalPrice);
    }
}
/*По време на седмицата на Оскарите, градското кино пуска прожекции на някои от филмите, които са номинирани в
категорията за "Най-добър филм". В таблицата са показани кои са филмите и каква е цената за прожекция спрямо залата,
в която се прожектира филмът.
Филм	            normal	        luxury	        ultra luxury
A Star Is Born	    7.50 лв.	    10.50 лв.	    13.50 лв.
Bohemian Rhapsody	7.35 лв.	    9.45 лв.	    12.75 лв.
Green Book	        8.15 лв.	    10.25 лв.	    13.25 лв.
The Favourite	    8.75 лв.	    11.55 лв.	    13.95 лв.
Напишете програма, която изчислява какъв е приходът от даден филм, като знаете в какъв тип зала се прожектира и
колко човека са си купили билет за прожекцията.
Вход
Входът се чете от конзолата и се състои от три реда:
•	Първи ред – име на филм – текст ("A Star Is Born", "Bohemian Rhapsody","Green Book" или "The Favourite")
•	Втори ред– вид на залата – текст ("normal", "luxury" или "ultra luxury")
•	Трети ред – брой на закупените билети – цяло число в интервала [1…100]
Изход
На конзолата трябва да се отпечата един ред:
"{име на филма} -> {приходи от прожекцията на филма} lv."
Приходите да бъдат закръглени до втория знак след десетичната запетая.
*/