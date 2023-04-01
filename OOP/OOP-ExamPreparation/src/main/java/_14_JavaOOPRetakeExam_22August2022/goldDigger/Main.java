package _14_JavaOOPRetakeExam_22August2022.goldDigger;

import _14_JavaOOPRetakeExam_22August2022.goldDigger.core.Controller;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.core.ControllerImpl;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.core.Engine;
import _14_JavaOOPRetakeExam_22August2022.goldDigger.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
