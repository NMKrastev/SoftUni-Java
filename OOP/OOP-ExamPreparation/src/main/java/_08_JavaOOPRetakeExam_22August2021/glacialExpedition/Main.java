package _08_JavaOOPRetakeExam_22August2021.glacialExpedition;

import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.core.Controller;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.core.Engine;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.core.ControllerImpl;
import _08_JavaOOPRetakeExam_22August2021.glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
