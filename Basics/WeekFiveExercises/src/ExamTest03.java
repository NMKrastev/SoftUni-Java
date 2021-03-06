import java.util.Scanner;

public class ExamTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        String pack = scanner.nextLine();
        String vip = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        double pricePerDay = 0, totalPrice = 0;

        if (!city.equals("Bansko") && !city.equals("Borovets")
                && !city.equals("Varna") && !city.equals("Burgas")) {
            System.out.println("Invalid input!");
        } else if (!pack.equals("withEquipment") && !pack.equals("noEquipment")
                && !pack.equals("withBreakfast") && !pack.equals("noBreakfast")) {
            System.out.println("Invalid input!");
        } else if (days < 1) {
            System.out.println("Days must be positive number!");
        } else {

            switch (vip) {
                case "yes":
                    if (city.equals("Bansko") || city.equals("Borovets") && pack.equals("withEquipment")) {
                        pricePerDay = 100 - 100 * 0.1;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Bansko") || city.equals("Borovets") && pack.equals("noEquipment")) {
                        pricePerDay = 80 - 80 * 0.05;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Varna") || city.equals("Burgas") && pack.equals("withBreakfast")) {
                        pricePerDay = 130 - 130 * 0.12;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Varna") || city.equals("Burgas") && pack.equals("noBreakfast")) {
                        pricePerDay = 100 - 100 * 0.07;
                        totalPrice = days * pricePerDay;
                    }
                    break;
                case "no":
                    if (city.equals("Bansko") || city.equals("Borovets") && pack.equals("withEquipment")) {
                        pricePerDay = 100;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Bansko") || city.equals("Borovets") && pack.equals("noEquipment")) {
                        pricePerDay = 80;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Varna") || city.equals("Burgas") && pack.equals("withBreakfast")) {
                        pricePerDay = 130;
                        totalPrice = days * pricePerDay;
                    } else if (city.equals("Varna") || city.equals("Burgas") && pack.equals("noBreakfast")) {
                        pricePerDay = 100;
                        totalPrice = days * pricePerDay;
                    }
                    break;
            }
            if (days > 7) {
                days -= 1;
                totalPrice = days * pricePerDay;
            }
            System.out.printf("The price is %.2flv! Have a nice time!", totalPrice);
        }
    }
}
/*???????????????????????? ?????????????? ?????? ?????????? ???? ?????????????? ???? ?????????????????????? ???? ?????????????????? ???????? ?????? ????????????????????.
?? ???????????????????? ???? ???????????????????? ???????????????????? ?? ???????????????????? ????????????, ???????????? ?? ????????????????.
???????????? ???? ?????? ???? ????????????????:
???????? ???? ??????	            ????????????/??????????????	                            ??????????/????????????
	             ?? ????????????????????	    ?????? ????????????????????	        ?????? ??????????????	        ?????? ??????????????
	            100????.	            80????	                130????.	            100????.
VIP ????????????????	10%	                5%	                    12%	                7%
?????? ???????????????? ?? ???????????? ?????????????? ???????????? ???? 7 ??????, ???????????????? ???????????? ?????? ??????????????????.
????????
???? ?????????????????? ???? ?????????? 4 ????????:
1.	?????? ???? ?????????? - ?????????? ?? ?????????????????????? ("Bansko",  "Borovets", "Varna" ?????? "Burgas")
2.	?????? ???? ???????????? - ?????????? ?? ?????????????????????? ("noEquipment",  "withEquipment", "noBreakfast" ?????? "withBreakfast")
3.	???????????????????? ???? VIP ???????????????? - ?????????? ?? ??????????????????????  "yes" ?????? "no"
4.	?????? ???? ?????????????? - ???????? ?????????? ?? ?????????????????? [1 ??? 10000]
??????????
???? ?????????????????? ???? ?????????????????? 1 ??????:
???	???????????? ???????????????????????? ?? ?????????? ???????????? ?????????? ????????????????, ??????????????????????:
"The price is {????????????, ?????????????????????? ???? ???????????? ????????}lv! Have a nice time!"
???	?????? ???????????????????????? ?? ?????????? ????-?????????? ???? 1 ?????? ???? ??????????????, ??????????????????????:
"Days must be positive number!"
???	???????????? ?????? ?????????????????????? ???? ?????????? ?????? ???????? ???? ???????????? ???? ?????????????? ?????????????????? ??????????, ??????????????????????: "Invalid input!"
*/