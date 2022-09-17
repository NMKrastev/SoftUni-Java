import java.util.Scanner;

public class A4_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        minutes = minutes + 30;

        if (minutes > 59) {
            minutes = minutes - 60;
            hour++;
        }
        if (hour > 23) {
            hour = 0;
        }

        if (minutes < 10) {
            System.out.printf("%d:0%d", hour, minutes);
        } else {
            System.out.printf("%d:%d", hour, minutes);
        }

    }
}
/*Every time John tries to pay his bills, he sees on the cash desk
the sign: "I will be back in 30 minutes". One day John was sick of
waiting and decided he needed a program that prints the time after
30 minutes. That way he won't have to wait at the desk and come at
the appropriate time. He gave the assignment to you, so you have
to do it.*/