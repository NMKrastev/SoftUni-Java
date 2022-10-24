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
