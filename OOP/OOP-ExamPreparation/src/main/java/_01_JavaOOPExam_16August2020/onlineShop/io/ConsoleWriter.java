package _01_JavaOOPExam_16August2020.onlineShop.io;


import _01_JavaOOPExam_16August2020.onlineShop.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
