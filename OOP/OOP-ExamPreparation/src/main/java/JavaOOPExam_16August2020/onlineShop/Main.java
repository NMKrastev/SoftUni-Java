package JavaOOPExam_16August2020.onlineShop;

import JavaOOPExam_16August2020.onlineShop.core.interfaces.Engine;
import JavaOOPExam_16August2020.onlineShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
