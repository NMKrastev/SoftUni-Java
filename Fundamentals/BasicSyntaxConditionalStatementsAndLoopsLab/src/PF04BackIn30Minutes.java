import java.util.Scanner;

public class PF04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        if (minutes + 30 > 59) {
            minutes = (minutes + 30) - 60;
            hour++;
        } else {
            minutes = minutes + 30;
        }
        if (hour > 23) {
            hour = 0;
        }

        if(minutes < 10) {
            System.out.printf("%d:0%d", hour, minutes);
        } else {
            System.out.printf("%d:%d", hour, minutes);
        }

    }
}
/*Every time John tries to pay his bills he sees on the cash desk the sign: "I will be back in 30 minutes".
One day John was sick of waiting and decided he needs a program, which prints the time after 30 minutes.
That way he won’t have to wait at the desk and come at the appropriate time. He gave the assignment to you,
so you have to do it.
Input
The input will be on two lines. On the first line, you will receive the hours and on the second you will
receive the minutes.
Output
Print on the console the time after 30 minutes. The result should be in the format "hh:mm". The hours have
one or two numbers and the minutes have always two numbers (with leading zero).
Constraints
•	The hours will be between 0 and 23.
•	The minutes will be between 0 and 59.
*/