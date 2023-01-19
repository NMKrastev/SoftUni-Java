import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class A10_SerializeArrayList {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/serializableList.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("PA08-Exercise_StreamsFilesAndDirectories/resources/serializableList.ser"));

        List<Double> serializableList = new ArrayList<>();
        serializableList.add(22.3);
        serializableList.add(1.8);
        serializableList.add(9.2);

        objectOutputStream.writeObject(serializableList);
        List<Double> newSerializableList = (List<Double>) objectInputStream.readObject();
        newSerializableList.forEach(System.out::println);
    }
}
/*Write a program that saves and loads an ArrayList of doubles to a file using ObjectInputStream and ObjectOutputStream.
Set the name of the file as "list.ser".*/