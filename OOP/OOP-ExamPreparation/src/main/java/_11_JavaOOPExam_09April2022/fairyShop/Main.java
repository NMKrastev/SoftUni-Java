package _11_JavaOOPExam_09April2022.fairyShop;

import _11_JavaOOPExam_09April2022.fairyShop.core.Engine;
import _11_JavaOOPExam_09April2022.fairyShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
