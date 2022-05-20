import java.util.Scanner;

public class MobileOperator03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String period = scanner.nextLine();
        String type = scanner.nextLine();
        String mobileInternet = scanner.nextLine();
        int months = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        switch (mobileInternet) {
            case "yes":
                if (period.equals("one")) {
                    switch (type) {
                        case "Small":
                            totalPrice = months * (9.98 + 5.50);
                            break;
                        case "Middle":
                            totalPrice = months * (18.99 + 4.35);
                            break;
                        case "Large":
                            totalPrice = months * (25.98 + 4.35);
                            break;
                        case "ExtraLarge":
                            totalPrice = months * (35.99 + 3.85);
                            break;
                    }
                } else if (period.equals("two")) {
                    switch (type) {
                        case "Small":
                            totalPrice = months * (8.58 + 5.50);
                            totalPrice = totalPrice - (totalPrice * 0.0375);
                            break;
                        case "Middle":
                            totalPrice = months * (17.09 + 4.35);
                            totalPrice = totalPrice - (totalPrice * 0.0375);
                            break;
                        case "Large":
                            totalPrice = months * (23.59 + 4.35);
                            totalPrice = totalPrice - (totalPrice * 0.0375);
                            break;
                        case "ExtraLarge":
                            totalPrice = months * (31.79 + 3.85);
                            totalPrice = totalPrice - (totalPrice * 0.0375);
                            break;
                    }
                }
                break;
            case "no":
                if (period.equals("one")) {
                    switch (type) {
                        case "Small":
                            totalPrice = months * 9.98;
                            break;
                        case "Middle":
                            totalPrice = months * 18.99;
                            break;
                        case "Large":
                            totalPrice = months * 25.98;
                            break;
                        case "ExtraLarge":
                            totalPrice = months * 35.99;
                            break;
                    }
                } else if (period.equals("two")) {
                    switch (type) {
                        case "Small":
                            totalPrice = months * 8.58;
                            totalPrice = totalPrice - (totalPrice * 0.0375);
                            break;
                        case "Middle":
                            totalPrice = months * 17.09;
                            totalPrice = totalPrice - (totalPrice * 0.0375);
                            break;
                        case "Large":
                            totalPrice = months * 23.59;
                            totalPrice = totalPrice - (totalPrice * 0.0375);
                            break;
                        case "ExtraLarge":
                            totalPrice = months * 31.79;
                            totalPrice = totalPrice - (totalPrice * 0.0375);
                            break;
                    }
                }
                break;
        }

        System.out.printf("%.2f lv.", totalPrice);
    }
}
/*Мобилен оператор предлага договори с различна месечна такса в зависимост от срока - 1 или 2 години.
Да се напише програма, която изчислява дължимата сума, която трябва да се плати за определен брой месеци.
срок / тип	    Small	    Middle	    Large	    ExtraLarge
1 година(one)	9.98 лв.	18.99 лв.	25.98 лв.	35.99 лв.
2 години(two)	8.58 лв.	17.09 лв.	23.59 лв.	31.79 лв.
Условия:
•	при добавен мобилен интернет, към таксата за един месец се добавя:
o	при такса по-малка или равна на 10.00 лв.  5.50 лв.
o	при такса по-малка или равна на 30.00 лв.  4.35 лв.
o	при такса по-голяма от 30.00 лв.  3.85 лв.
•	ако договорът e за две години, общата сума се намалява с 3.75%
Вход
От конзолата се четат 3 реда:
1.	Срок на договор – текст – "one", или "two"
2.	Тип на договор – текст – "Small",  "Middle", "Large"или "ExtraLarge"
3.	Добавен мобилен интернет – текст – "yes" или "no"
4.	Брой месеци за плащане - цяло число в интервала [1 … 24]
Изход
На конзолата се отпечатва 1 ред:
•	Цената, която заплаща клиентът, форматирана до втория знак след десетичната запетая, в следния формат:  "{цената} lv."
*/