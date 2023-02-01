package A2_Library;

public class Main {

    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library(bookOne, bookTwo, bookThree);

        for (Book book: library) {
            System.out.println(book.getTitle());
        }
    }
}
/*Create a class Library from the UML diagram below:
<<Iterable<Book>>>
Library
-	books: Book[]
+	iterator(): Iterator<Book>
Create a nested class LibIterator from the UML diagram below:
<<Iterator<Book>>>
LibIterator
-	counter: int
+	hasNext(): boolean
+	next(): Book
*/
