package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;
import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.Circle;

public class Main {
    public static void main(String[] args) {

        DrawingManager drawingManager = new DrawingManagerImpl(new ConsoleRenderer());

        Shape rectangle = new Rectangle(13, 2);

        Shape cycle = new Circle(5);

        drawingManager.draw(rectangle);
        drawingManager.draw(cycle);
    }
}
