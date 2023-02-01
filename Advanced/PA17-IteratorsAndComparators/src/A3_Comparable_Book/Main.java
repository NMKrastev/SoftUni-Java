package A3_Comparable_Book;

public class Main {

    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        if (bookOne.compareTo(bookTwo) > 0) {
            System.out.println(String.format("%s is before %s", bookOne, bookTwo));
        } else if (bookOne.compareTo(bookTwo) < 0) {
            System.out.println(String.format("%s is before %s", bookTwo, bookOne));
        } else {
            System.out.println("Book are equal");
        }
    }
}
/*Expand Book by implementing Comparable<Book>.
The book has to be compared by title. When the title is equal, compare them by year.
Expand Book from UML diagram below:
<<Comparable<Book>>>
Book
-	title: String
-	year: int
-	authors: List<String>
-	setTitle(String)
-	setYear(String)
-	setAuthors(String…)
+	getTitle(): String
+	getYear(): int
+	getAuthors(): List<String>
+	compareTo(Book): int
You can use only one constructor. There can be no authors, one author, or many authors.
*/