import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A10_Robotics {
    public static class Robot {
        private String robot;
        private int processingPeriod;

        public Robot(String robot, int processingPeriod) {
            this.robot = robot;
            this.processingPeriod = processingPeriod;

        }

        public String getRobot() {
            return robot;
        }

        public int getProcessingPeriod() {
            return processingPeriod;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String robots = scanner.nextLine();
        String time = scanner.nextLine();

        Map<Robot, Integer> busyRobots = new LinkedHashMap();
        Pattern pattern = Pattern.compile("(?<robotName>[a-zA-Z0-9]+)-(?<processingTime>[\\d]+)");
        Matcher matcher = pattern.matcher(robots);
        while (matcher.find()) {
            String robotName = matcher.group("robotName");
            int processingTime = Integer.parseInt(matcher.group("processingTime"));
            Robot robot = new Robot(robotName, processingTime);
            busyRobots.put(robot, 0);
        }

        ArrayDeque<String> productsQueue = new ArrayDeque<>();
        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            productsQueue.offer(input);
        }

        int startingTime = getTimeInSeconds(time);
        while (!productsQueue.isEmpty()) {
            startingTime++;
            String currentProduct = productsQueue.poll();
            boolean isRobotBusy = false;
            decreaseWorkTime(busyRobots);

            for (Map.Entry<Robot, Integer> entry : busyRobots.entrySet()) {
                if (entry.getValue() == 0) {
                    entry.setValue(entry.getKey().getProcessingPeriod());
                    System.out.printf("%s - %s [%s]\n", entry.getKey().getRobot(), currentProduct, getTime(startingTime));
                    isRobotBusy = true;
                    break;
                }
            }

            if (!isRobotBusy) {
                productsQueue.offer(currentProduct);
            }
        }
    }

    private static String getTime(int startTimeInSeconds) {
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static int getTimeInSeconds(String startTime) {
        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private static void decreaseWorkTime(Map<Robot, Integer> robotsInProcess) {

        for (Map.Entry<Robot, Integer> entry : robotsInProcess.entrySet()) {
            if (entry.getValue() > 0) {
                robotsInProcess.put(entry.getKey(), entry.getValue() - 1);
            }
        }
    }
}
/*Somewhere in the future, there will be a robotics factory. The current project is assembly-line robots.
Each robot has a processing time, the time it needs to process a product. When a robot is free, it should take a
product for processing and log its name, product, and processing start time.
Each robot processes a product coming from the assembly line. A product comes from the line each second
(so the first product should appear at [start time + 1 second]). If a product passes the line and there is no free
robot to take it, it should be queued at the end of the line again.
The robots are standing in the line in the order of their appearance.
Input
•	On the first line, you will get the names of the robots and their processing times in the format
"robotName-processTime;robotName-processTime;robotName-processTime".
•	On the second line, you will get the starting time in the format "hh:mm:ss".
•	Next, until the "End" command, you will get a product on each line.
*/
