import java.io.*;

public class A11_SerializeCustomObject {

    public static class Courses implements Serializable {
        String name;
        Integer numOfStudents;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/courses.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/courses.ser"));

        Courses course = new Courses();
        course.name = "SoftUni Java";
        course.numOfStudents = 7;
        objectOutputStream.writeObject(course);
        //Deserialized
        /*Courses deserialization = (Courses) objectInputStream.readObject();
        System.out.printf("%s: %d\n", deserialization.name, deserialization.numOfStudents);*/

        objectOutputStream.close();
        objectInputStream.close();

    }
}
/*Write a program that saves and loads the information about a custom object using ObjectInputStream and ObjectOutputStream.
Create a simple class called "Course" that has a String field containing its name and an integer field containing
the number of students attending the course. Set the name of the save file as "course.ser".
*/
