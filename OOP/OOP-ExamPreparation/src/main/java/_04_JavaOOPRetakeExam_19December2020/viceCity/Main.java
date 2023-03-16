package _04_JavaOOPRetakeExam_19December2020.viceCity;

import _04_JavaOOPRetakeExam_19December2020.viceCity.core.ControllerImpl;
import _04_JavaOOPRetakeExam_19December2020.viceCity.core.EngineImpl;
import _04_JavaOOPRetakeExam_19December2020.viceCity.core.interfaces.Controller;
import _04_JavaOOPRetakeExam_19December2020.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
