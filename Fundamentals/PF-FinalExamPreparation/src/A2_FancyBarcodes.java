import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A2_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("([@][#]+)(?<barcode>[A-Z]([a-zA-Z0-9]{4,})[A-Z])([@][#]+)");

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                StringBuilder productGroup = getProductGroup(matcher);
                System.out.printf("Product group: %s\n", productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }

    private static StringBuilder getProductGroup(Matcher matcher) {

        String barcode = matcher.group("barcode");
        StringBuilder productGroup = new StringBuilder();
        boolean isDigitPresent = false;
        for (int i = 0; i < barcode.length(); i++) {
            char symbol = barcode.charAt(i);
            if (Character.isDigit(symbol)) {
                productGroup.append(symbol);
                isDigitPresent = true;
            }
        }
        if (!isDigitPresent) {
            productGroup.append(0);
            productGroup.append(0);
        }
        return productGroup;
    }
}
/*Your first task is to determine if the given sequence of characters is a valid barcode or not.
Each line must not contain anything else but a valid barcode. A barcode is valid when:
•	It is surrounded by a "@" followed by one or more "#"
•	It is at least 6 characters long (without the surrounding "@" or "#")
•	It starts with a capital letter
•	It contains only letters (lower and upper case) and digits
•	It ends with a capital letter
Examples of valid barcodes: @###Che46sE@##, @#FreshFisH@#, @###Brea0D@###, @##Che46sE@##
Examples of invalid barcodes: ##InvaliDiteM##, @InvalidIteM@, @#Invalid_IteM@#
Next, you have to determine the product group of the item from the barcode. The product group is obtained by
concatenating all the digits found in the barcode. If there are no digits present in the barcode, the default product group is "00".
Examples:
@#FreshFisH@# -> product group: 00
@###Brea0D@### -> product group: 0
@##Che4s6E@## -> product group: 46
Input
On the first line, you will be given an integer n – the count of barcodes that you will be receiving next.
On the following n lines, you will receive different strings.
Output
For each barcode that you process, you need to print a message.
If the barcode is invalid:
•	"Invalid barcode"
If the barcode is valid:
•	"Product group: {product group}"
*/