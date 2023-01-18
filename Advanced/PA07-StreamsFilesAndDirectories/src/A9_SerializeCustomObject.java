import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class A9_SerializeCustomObject {
    static class Cube implements Serializable {

        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String green, double v, double v1, double v2) {

        }
    }

    public static void main(String[] args)  {

    Cube cube = new Cube("green", 15.3, 12.4, 3.0);

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PA07-StreamsFilesAndDirectories/resources/save.txt"))) {
        oos.writeObject(cube);
    } catch (IOException e) {
        e.printStackTrace();
        }

    }
}
/*Create a class called "Cube". It should have properties for color, width, height, and depth.
Create an instance of the class with the following values:
•	Color: "green"
•	Width: 15.3
•	Height: 12.4
•	Depth: 3.0
Serialize and deserialize the instance created. When saved to a file, the object should look like something like the example below.
*/
