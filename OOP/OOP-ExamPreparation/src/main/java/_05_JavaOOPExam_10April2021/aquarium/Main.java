package _05_JavaOOPExam_10April2021.aquarium;

import _05_JavaOOPExam_10April2021.aquarium.core.Engine;
import _05_JavaOOPExam_10April2021.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
