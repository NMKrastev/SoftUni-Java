package JavaOOPExam_10April2021.aquarium;

import JavaOOPExam_10April2021.aquarium.core.Engine;
import JavaOOPExam_10April2021.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
