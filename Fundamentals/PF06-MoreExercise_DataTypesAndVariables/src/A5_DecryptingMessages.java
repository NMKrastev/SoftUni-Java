import java.util.Scanner;

public class A5_DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int key = Integer.parseInt(scanner.nextLine());
        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {

            char ch = (char) (scanner.nextLine().charAt(0) + key);
            sb.append(String.valueOf(ch));

        }

        System.out.println(sb);
    }
}
/*You will receive a key (integer) and n characters afterward.
Add the key to each character and append them to the message.
In the end, print the message, which you decrypted.
Input:
· On the first line, you will receive the key.
· On the second line, you will receive n – the number of lines that will follow.
· On the next n lines – you will receive lower and uppercase characters from the Latin alphabet.
Output:
Print the decrypted message.
Constraints:
· The key will be in the interval [0…20].
· n will be in the interval [1…20].
· The characters will always be upper or lower-case letters from the English alphabet.
· You will receive one letter per line.*/