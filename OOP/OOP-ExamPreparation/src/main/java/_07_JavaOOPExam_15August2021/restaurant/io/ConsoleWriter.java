package _07_JavaOOPExam_15August2021.restaurant.io;

import _07_JavaOOPExam_15August2021.restaurant.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
