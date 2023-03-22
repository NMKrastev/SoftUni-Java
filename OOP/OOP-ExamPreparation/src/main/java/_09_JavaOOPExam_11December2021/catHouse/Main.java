package _09_JavaOOPExam_11December2021.catHouse;

import _09_JavaOOPExam_11December2021.catHouse.core.Engine;
import _09_JavaOOPExam_11December2021.catHouse.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
