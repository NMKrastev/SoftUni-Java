package A5_CodingTracker;

public class Main {

    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthors(Class<?> clazz) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
