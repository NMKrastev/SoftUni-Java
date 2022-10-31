import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A4_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> parkMap = new LinkedHashMap<>();
        int numOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCommands; i++) {

            String[] command = scanner.nextLine().split("\\s+");

            if (command[0].equals("register")) {
                if (isUserExist(command[1], parkMap)) {
                    System.out.printf("ERROR: already registered with plate number %s\n", parkMap.get(command[1]));
                } else {
                    parkMap = addUserToParking(command[1], command[2], parkMap);
                    System.out.printf("%s registered %s successfully\n", command[1], command[2]);
                }
            } else {
                if (isUserExist(command[1], parkMap)) {
                    parkMap = removeUserFromParking(command[1], parkMap);
                    System.out.printf("%s unregistered successfully\n", command[1]);
                } else {
                    System.out.printf("ERROR: user %s not found\n", command[1]);
                }
            }
        }

        printResult(parkMap);
    }

    private static void printResult(Map<String, String> parkMap) {

        for (Map.Entry<String, String> entry : parkMap.entrySet()) {
            System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
        }
    }

    private static Map<String, String> removeUserFromParking(String username, Map<String, String> parkMap) {

        parkMap.remove(username);
        return parkMap;
    }

    private static Map<String, String> addUserToParking(String username, String licensePlateNumber, Map<String, String> parkMap) {

        parkMap.put(username, licensePlateNumber);
        return parkMap;
    }

    private static boolean isUserExist(String username, Map<String, String> parkMap) {

        return parkMap.containsKey(username);
    }
}
/*Write a program that validates parking for an online service. Users can register to park and unregister to leave.
The program receives 2 commands:
•	"register {username} {licensePlateNumber}":
o	The system only supports one car per user at the moment, so if a user tries to register another license plate
using the same username, the system should print:
"ERROR: already registered with plate number {licensePlateNumber}"
o	If the aforementioned checks pass successfully, the plate can be registered, so the system should print:
"{username} registered {licensePlateNumber} successfully"
•	"unregister {username}":
o	If the user is not present in the database, the system should print:
"ERROR: user {username} not found"
o	If the aforementioned check passes successfully, the system should print:
"{username} unregistered successfully"
After you execute all the commands, print all the currently registered users and their license plates in the format:
•	"{username} => {licensePlateNumber}"
Input
•	First line: n - number of commands – integer.
•	Next n lines: commands in one of two possible formats:
o	Register: "register {username} {licensePlateNumber}"
o	Unregister: "unregister {username}"
The input will always be valid, and you do not need to check it explicitly.
*/