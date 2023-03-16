package _03_JavaOOPExam_12December2020.bakery.io;


import _03_JavaOOPExam_12December2020.bakery.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
