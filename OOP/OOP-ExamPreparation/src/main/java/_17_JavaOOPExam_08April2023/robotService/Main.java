package _17_JavaOOPExam_08April2023.robotService;

import _17_JavaOOPExam_08April2023.robotService.core.Engine;
import _17_JavaOOPExam_08April2023.robotService.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
