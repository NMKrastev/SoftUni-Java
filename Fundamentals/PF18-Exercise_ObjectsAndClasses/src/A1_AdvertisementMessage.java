import java.util.*;

public class A1_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numOfAds = Integer.parseInt(scanner.nextLine());

        List<String> phrasesList = Arrays.asList("Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.", "Exceptional product.",
                "I can’t live without this product.");
        List<String> eventsList = Arrays.asList("Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!");
        List<String> authorsList = Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva");
        List<String> citiesList = Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");

        for (int i = 0; i < numOfAds; i++) {
            int randomIndexPhrases = random.nextInt(phrasesList.size());
            int randomIndexEvents = random.nextInt(eventsList.size());
            int randomIndexAuthors = random.nextInt(authorsList.size());
            int randomIndexCities = random.nextInt(citiesList.size());
            System.out.printf("%s %s %s - %s\n", phrasesList.get(randomIndexPhrases), eventsList.get(randomIndexEvents),
                    authorsList.get(randomIndexAuthors), citiesList.get(randomIndexCities));
        }
    }
}
