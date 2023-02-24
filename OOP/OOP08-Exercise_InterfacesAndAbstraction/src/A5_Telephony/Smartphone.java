package A5_Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {

        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("[^0-9]+");

        numbers.forEach(e -> {
            Matcher matcher = pattern.matcher(e);
            if (matcher.find()) {
                sb.append("Invalid number!")
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format("Calling... %s", e))
                        .append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }

    @Override
    public String browse() {

        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("[0-9]+");

        urls.forEach(e -> {
            Matcher matcher = pattern.matcher(e);
            if (matcher.find()) {
                sb.append("Invalid URL!")
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!", e))
                        .append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }
}
