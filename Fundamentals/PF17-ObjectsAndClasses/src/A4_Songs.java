import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A4_Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfSongs = Integer.parseInt(scanner.nextLine());
        List<A4_Song> songs = new ArrayList<>();

        for (int i = 0; i < numOfSongs; i++) {

            String[] line = scanner.nextLine().split("_");
            String typeOfPlaylist = line[0];
            String nameOfSong = line[1];
            String timeOfSong = line[2];

            A4_Song song = new A4_Song();

            song.setTypeOfPlaylist(typeOfPlaylist);
            song.setNameOfSong(nameOfSong);
            song.setTimeOfSong(timeOfSong);

            songs.add(song);
        }

        String typeOfList = scanner.nextLine();

        if (typeOfList.equals("all")) {
            for (A4_Song song : songs) {
                System.out.println(song.getNameOfSong());
            }
        } else {
            for (A4_Song song : songs) {
                if (song.getTypeOfPlaylist().equals(typeOfList)) {
                    System.out.println(song.getNameOfSong());
                }
            }
        }
    }
}
/*Define a class Song, which holds the following information about songs: Type List, Name, and Time.
On the first line, you will receive the number of songs - N.
On the next N-lines, you will be receiving data in the following format: "{typeList}_{name}_{time}".
On the last line, you will receive "Type List" / "all". Print only the names of the songs which are
from that Type List / All songs.*/