import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A10_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessonsList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        distribution(scanner, lessonsList);
        printLessons(lessonsList);
    }

    private static void printLessons(List<String> lessonsList) {

        for (String lesson : lessonsList) {
            System.out.println(lessonsList.indexOf(lesson) + 1 + "." + lesson);
        }
    }

<<<<<<< HEAD
    private static List<String> distribution(Scanner scanner, List<String> lessonsList) {
        String input;
=======
    private static void distribution(Scanner scanner, List<String> lessonsList) {
>>>>>>> main

        String input;
        while (!(input = scanner.nextLine()).equals("course start")) {
            String[] command = input.split(":");
            String lesson;
            String lessonTwo;
            switch (command[0]) {
                case "Add":
                    lesson = command[1];
                    addLesson(lessonsList, lesson);
                    break;
                case "Remove":
                    lesson = command[1];
                    removeLesson(lessonsList, lesson);
                    break;
                case "Insert":
                    lesson = command[1];
                    int index = Integer.parseInt(command[2]);
                    insertLessonAtIndex(lessonsList, lesson, index);
                    break;
                case "Swap":
                    lesson = command[1];
                    lessonTwo = command[2];
                    swapLessons(lessonsList, lesson, lessonTwo);
                    break;
                case "Exercise":
                    String exercise = command[0];
                    lesson = command[1];
                    addExerciseLessons(lessonsList, exercise, lesson);
            }
        }
        return lessonsList;
    }

    private static List<String> addExerciseLessons(List<String> lessonsList, String exercise, String lesson) {

        if (lessonsList.contains(lesson) && !lessonsList.contains(lesson + "-Exercise")) {
            lessonsList.add(lessonsList.indexOf(lesson) + 1, lesson + "-" + exercise);
        }
        if (!lessonsList.contains(lesson)) {
            lessonsList.add(lesson);
            lessonsList.add(lesson + "-" + exercise);
        }
        return lessonsList;
    }

    private static List<String> swapLessons(List<String> lessonsList, String lesson, String lessonTwo) {

        if (lessonsList.contains(lesson) && lessonsList.contains(lessonTwo)) {
            int indexLesson = lessonsList.indexOf(lesson);
            int indexLessonTwo = lessonsList.indexOf(lessonTwo);
            String tempLesson = lesson;
            lessonsList.remove(lesson);
            lessonsList.add(indexLesson, lessonTwo);
            lessonsList.remove(indexLessonTwo);
            lessonsList.add(indexLessonTwo, tempLesson);
        }
        if (lessonsList.contains(lesson + "-Exercise")) {
            int indexOne = lessonsList.indexOf(lesson);
            int indexOfExerciseOne = lessonsList.indexOf(lesson + "-Exercise");
            lessonsList.set(indexOne + 1, lesson + "-Exercise");
            lessonsList.remove(indexOfExerciseOne);
        }
        if (lessonsList.contains(lessonTwo + "-Exercise")) {
            int indexTwo = lessonsList.indexOf(lessonTwo);
            int indexOfExerciseTwo = lessonsList.indexOf(lessonTwo + "-Exercise") + 1;
            lessonsList.add(indexTwo + 1, lessonTwo + "-Exercise");
            lessonsList.remove(indexOfExerciseTwo);
        }

        return lessonsList;
    }

    private static List<String> insertLessonAtIndex(List<String> lessonsList, String lesson, int index) {

        if (!lessonsList.contains(lesson)) {
            lessonsList.add(index, lesson);
        }
        return lessonsList;
    }

    private static List<String> removeLesson(List<String> lessonsList, String lesson) {

        if (lessonsList.contains(lesson)) {
            lessonsList.remove(lesson);
        }
        return lessonsList;
    }

    private static List<String> addLesson(List<String> lessonsList, String lesson) {

        if (!lessonsList.contains(lesson)) {
            lessonsList.add(lesson);
        }
        return lessonsList;
    }
}
/*On the first input line, you will receive the initial schedule of lessons and exercises that will be part of the next
course, separated by a comma and space ", ". But before the course starts, there are some changes to be made. Until you
receive "course start", you will be given some commands to modify the course schedule. The possible commands are:
Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
Insert:{lessonTitle}:{index} - insert the lesson to the given index, if it does not exist
Remove:{lessonTitle} - remove the lesson, if it exists
Swap:{lessonTitle}:{lessonTitle} - change the place of the two lessons, if they exist
Exercise:{lessonTitle} - add Exercise in the schedule right after the lesson index, if the lesson exists and there is no
 exercise already, in the following format "{lessonTitle}-Exercise". If the lesson doesn't exist, add the lesson at the
 end of the course schedule, followed by the Exercise.
Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any,
which follow the lessons.
Input
•	On the first line -the initial schedule lessons -strings, separated by comma and space ", ".
•	Until "course start", you will receive commands in the format described above.
Output
•	Print the whole course schedule, each lesson on a new line with its number(index) in the schedule:
"{lesson index}.{lessonTitle}".
•	Allowed working time / memory: 100ms / 16MB.
*/