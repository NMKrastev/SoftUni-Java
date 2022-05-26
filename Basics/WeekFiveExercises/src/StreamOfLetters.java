import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cCount = 0, oCount = 0, nCount = 0;
        String text = "", endText = "";

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            if (input.matches("[a-zA-Z]+")) {

                text += input;

                if (input.equals("c") && cCount != 1) {
                    text = text.substring(0, text.length() - 1);
                    cCount++;
                } else if (input.equals("o") && oCount != 1) {
                    text = text.substring(0, text.length() - 1);
                    oCount++;
                } else if (input.equals("n") && nCount != 1) {
                    text = text.substring(0, text.length() - 1);
                    nCount++;
                }

                if (cCount == 1 && oCount == 1 && nCount == 1) {
                    text = text + " ";
                    endText = text;
                    //System.out.println(text);
                    cCount = 0;
                    oCount = 0;
                    nCount = 0;
                }

            }
            input = scanner.nextLine();
            if (input.equals("End")){
                System.out.println(endText);
            }
        }
        //System.out.println(text);
    }
}
/*Напишете програма, която прочита скрито съобщение в поредица от символи.
Те се получават по един на ред до получаване на командата "End".
Думите се образуват от буквите в реда на четенето им. Символите, които не са латински букви трябва
да бъдат игнорирани. Думите скрити в потока са разделени от тайна команда от три букви –
"c", "o" и "n". При първото получаване на една от тези букви, тя се маркира като срещната,
но не се запазва в думата. При всяко следващо нейно срещане се записва нормално в думата.
След като са налични и трите символа от командата, се печата думата и интервал " ".
Започва се нова дума, която по същия начин чака тайната команда, за да бъде отпечатана.
Вход
От конзолата се чете поредица от редове с един символ на всеки до получаване на командата "End".
Изход
На конзолата се печата на един ред всяка дума след тайната команда, следвана от интервал.
*/