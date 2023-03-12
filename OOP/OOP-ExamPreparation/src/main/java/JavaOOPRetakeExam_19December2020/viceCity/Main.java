package JavaOOPRetakeExam_19December2020.viceCity;

import JavaOOPRetakeExam_19December2020.viceCity.core.ControllerImpl;
import JavaOOPRetakeExam_19December2020.viceCity.core.EngineImpl;
import JavaOOPRetakeExam_19December2020.viceCity.core.interfaces.Controller;
import JavaOOPRetakeExam_19December2020.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
