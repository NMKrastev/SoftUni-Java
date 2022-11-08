import java.util.Scanner;

public class A5_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String text = scanner.nextLine();
        String comment;

        System.out.printf("<h1>\n\t%s\n</h1>\n", title);
        System.out.printf("<article>\n\t%s\n</article>\n", text);
        while (!(comment = scanner.nextLine()).equals("end of comments")) {

            System.out.printf("<div>\n\t%s\n</div>\n", comment);
        }

    }
}
/*You will receive 3 lines of input. On the first line, you will receive a title of an article. On the next line,
you will receive the content of that article. On the next n lines, until you receive "end of comments", you will get
the comments about the article. Print the whole information in HTML format. The title should be in "h1" tag (<h1></h1>);
the content in article tag (<article></article>); each comment should be in div tag (<div></div>).*/