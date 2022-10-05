import java.util.Scanner;

public class A11_MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int num = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        if(multiplier > 10) {
            System.out.printf("%d X %d = %d\n", num, multiplier, num * multiplier);
        } else {
            for (int i = multiplier; i <= 10; i++) {
                System.out.printf("%d X %d = %d\n", num, i, num * i);
            }
        }
    }
}
/*Rewrite your program so it can receive the multiplier from the
console. Print the table from the given multiplier to 10. If the
given multiplier is more than 10 - print only one row with the
integer, the given multiplier, and the product.*/