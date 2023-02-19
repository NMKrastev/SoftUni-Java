package A4_TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] signals = scanner.nextLine().split("\\s+");
        int iterations = Integer.parseInt(scanner.nextLine());
       /* List<TrafficLight> trafficLightList = new ArrayList<>();

        for (String signal : signals) {
            Color color = Color.valueOf(signal);
            TrafficLight trafficLight = new TrafficLight(signal);
            trafficLightList.add(trafficLight);
        }*/

        List<TrafficLight> trafficLightList = Arrays.stream(signals)
                .map(Color::valueOf)
                .map(TrafficLight::new)
                .collect(Collectors.toList());

        for (int i = 0; i < iterations; i++) {
            for (TrafficLight trafficLight : trafficLightList) {
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }
    }
}
/*Implement a simple state machine in the form of a traffic light.
Every traffic light has three possible signals - red, green, and yellow. Each traffic light can be updated,
which changes the color of its signal (e.g. if it is currently red, it changes to green, if it is green it changes to yellow).
The order of signals is red -> green -> yellow -> red and so on.
On the first line, you will be given multiple traffic light signals in the format "RED GREEN YELLOW".
They may be 3, more, or less than 3. You need to make as many traffic lights as there are signals in the input.
On the second line, you will receive the n number of times you need to change each traffic light's signal.
Your output should consist of n number of lines, including each updated traffic light's signal.*/
