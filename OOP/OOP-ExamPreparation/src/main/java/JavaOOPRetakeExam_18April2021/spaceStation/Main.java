package JavaOOPRetakeExam_18April2021.spaceStation;

import JavaOOPRetakeExam_18April2021.spaceStation.core.Controller;
import JavaOOPRetakeExam_18April2021.spaceStation.core.ControllerImpl;
import JavaOOPRetakeExam_18April2021.spaceStation.core.Engine;
import JavaOOPRetakeExam_18April2021.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();

    }
}
