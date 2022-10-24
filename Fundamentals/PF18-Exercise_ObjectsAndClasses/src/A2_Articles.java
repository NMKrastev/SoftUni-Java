import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A2_Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialArticleList = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        List<A2_Article> articleList = new ArrayList<>();
        A2_Article article = new A2_Article(initialArticleList.get(0), initialArticleList.get(1), initialArticleList.get(2));
        int numOfChanges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfChanges; i++) {
            String command = scanner.nextLine();

            if (command.contains("Rename")) {
                String titleToRename = command.split(": ")[1];
                article.renameTitle(titleToRename);
            } else if (command.contains("Edit")) {
                String contentToEdit = command.split(": ")[1];
                article.editContent(contentToEdit);
            } else if (command.contains("ChangeAuthor")) {
                String authorToChange = command.split(": ")[1];
                article.changeAuthor(authorToChange);
            }
        }

        System.out.println(article);
    }
}
/*Create an article class with the following properties:
•	Title – a string
•	Content – a string
•	Author – a string
The class should have a constructor and the following methods:
•	Edit (new content) – change the old content with the new one
•	ChangeAuthor (new author) – change the author
•	Rename (new title) – change the title of the article
•	override ToString – print the article in the following format:
"{title} - {content}: {author}"
Write a program that reads an article in the following format "{title}, {content}, {author}".
On the next line, you will get a number n. On the next n lines, you will get one of the following commands:
"Edit: {new content}"; "ChangeAuthor: {new author}"; "Rename: {new title}". At the end, print the final article.
*/
