public class NumbersDividedBy3WithoutReminder {
    public static void main(String[] args) {

        int n = 1;

        while (n <= 100) {

            if (n % 3 == 0) {
                System.out.println(n);
            }
            n++;
        }
    }
}
