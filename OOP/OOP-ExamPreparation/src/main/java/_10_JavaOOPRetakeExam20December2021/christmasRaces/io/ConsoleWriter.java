package _10_JavaOOPRetakeExam20December2021.christmasRaces.io;

import _10_JavaOOPRetakeExam20December2021.christmasRaces.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
