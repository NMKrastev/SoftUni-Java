package _15_JavaOOPExam_10December2022.christmasPastryShop.io;

import _15_JavaOOPExam_10December2022.christmasPastryShop.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
