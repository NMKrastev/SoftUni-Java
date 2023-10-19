package bg.softuni.temp.utils;

public class DurationConverter {

    public String formatDuration(int seconds) {

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        return String.format("%d:%02d", minutes, remainingSeconds);
    }
}
