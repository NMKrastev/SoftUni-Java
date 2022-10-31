import java.util.*;

public class A9_ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> sidesMap = new LinkedHashMap<>();

        String line;

        while (!(line = scanner.nextLine()).equals("Lumpawaroo")) {

            if (line.contains("|")) {
                String side = line.split("\\s+\\|\\s+")[0];
                String user = line.split("\\s+\\|\\s+")[1];
                boolean isExist = false;

                for (Map.Entry<String, List<String>> entry : sidesMap.entrySet()) {
                    if (entry.getValue().contains(user)) {
                        isExist = true;
                        break;
                    }
                }

                if (!isExist) {
                    if (!isSideExist(sidesMap, side)) {
                        sidesMap.put(side, new ArrayList<>());
                        sidesMap.get(side).add(user);
                    } else if (isSideExist(sidesMap, side) && !isUserExist(sidesMap, side, user)) {
                        sidesMap.get(side).add(user);
                    }
                }

            } else if (line.contains("->")) {
                String side = line.split("\\s+->\\s+")[1];
                String user = line.split("\\s+->\\s+")[0];

                for (Map.Entry<String, List<String>> entry : sidesMap.entrySet()) {
                    if (entry.getValue().contains(user)) {
                        sidesMap.get(entry.getKey()).remove(user);
                    }
                }

                if (!isSideExist(sidesMap, side)) {
                    sidesMap.put(side, new ArrayList<>());
                    sidesMap.get(side).add(user);
                    System.out.printf("%s joins the %s side!\n", user, side);
                } else if (isSideExist(sidesMap, side) && !isUserExist(sidesMap, side, user)) {
                    sidesMap.get(side).add(user);
                    System.out.printf("%s joins the %s side!\n", user, side);
                }
            }
        }

        printResult(sidesMap);
    }

    private static boolean isUserExist(Map<String, List<String>> sideMap, String side, String user) {

        if (sideMap.get(side).contains(user)) {
            return true;
        }
        return false;
    }
    private static boolean isSideExist(Map<String, List<String>> sidesMap, String side) {

        if (sidesMap.containsKey(side)) {
            return true;
        }
        return false;
    }
    private static void printResult(Map<String, List<String>> sidesMap) {
        for (Map.Entry<String, List<String>> entry : sidesMap.entrySet()) {
            if (entry.getValue().size() != 0) {
                System.out.printf("Side: %s, Members: %d\n", entry.getKey(), entry.getValue().size());
                for (String user : entry.getValue()) {
                    System.out.printf("! %s\n", user);
                }
            }
        }
    }
}
/*You will receive several input lines in one of the following formats:
"{force_side} | {force_user}"
"{force_user} -> {force_side}"
The "force_user" and "force_side" are strings containing any character.
If you receive "force_side | force_user":
•	If there is no such force user and no such force side -> create a new force side and add the force
user to the corresponding side.
•	Only if there is no such force user on any force side -> add the force user to the corresponding side.
•	If there is such force user already -> skip the command and continue to the next operation.
If you receive a "force_user -> force_side":
•	If there is such force user already -> change their side.
•	If there is no such force user on any force side -> add the force user to the corresponding force side.
•	If there is no such force user and no such force side -> create a new force side and add the force user
to the corresponding side.
•	Then you should print on the console: "{force_user} joins the {force_side} side!".
You should end your program when you receive the command "Lumpawaroo". At that point, you should print each
force side. For each side, print the force users.
In case there are no force users on a side, you shouldn't print the side information.
Input / Constraints
•	The input comes in the form of commands in one of the formats specified above.
•	The input ends when you receive the command "Lumpawaroo".
Output
•	As output for each force side, you must print all the force users.
•	The output format is:
"Side: {forceSide}, Members: {forceUsers.Count}
! {forceUser}
! {forceUser}
! {forceUser}"
•	In case there are NO forceUsers, don't print this side.*/