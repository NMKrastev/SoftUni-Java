package _13_JavaOOPExam_14August2022.football;

import _13_JavaOOPExam_14August2022.football.core.Engine;
import _13_JavaOOPExam_14August2022.football.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
