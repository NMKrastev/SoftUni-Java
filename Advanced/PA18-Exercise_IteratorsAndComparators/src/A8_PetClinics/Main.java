package A8_PetClinics;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, Pet> petsMap = new LinkedHashMap<>();
        Map<String, Clinic> clinicsMap = new LinkedHashMap<>();

        for (int i = 0; i < numOfCommands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String clinicName;
            switch (command) {
                case "Create":
                    if (input[1].equals("Pet")) {
                        String name = input[2];
                        int age = Integer.parseInt(input[3]);
                        String kind = input[4];
                        Pet pet = new Pet(name, age, kind);
                        petsMap.put(name, pet);
                    } else if (input[1].equals("Clinic")) {
                        String name = input[2];
                        int capacity = Integer.parseInt(input[3]);
                        try {
                            Clinic clinic = new Clinic(name, capacity);
                            clinicsMap.put(name, clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = input[1];
                    clinicName = input[2];
                    System.out.println(clinicsMap.get(clinicName).add(petsMap.get(petName)));
                    break;
                case "Release":
                    clinicName = input[1];
                    System.out.println(clinicsMap.get(clinicName).release());
                    break;
                case "HasEmptyRooms":
                    String name = input[1];
                    System.out.println(clinicsMap.get(name).hasEmptyRooms());
                    break;
                case "Print":
                    if (input.length == 2) {
                        clinicName = input[1];
                        clinicsMap.get(clinicName).printAllRooms();
                    } else {
                        clinicName = input[1];
                        int room = Integer.parseInt(input[2]);
                        clinicsMap.get(clinicName).printRoom(room);
                    }
                    break;
            }
        }
    }
}
/*You are a young and ambitious owner of Pet Clinics Holding. You ask your employees to create a program that will
store all information about the pets in the database. Each pet should have a name, age, and kind.
Your application should support a few basic operations such as creating a pet, creating a clinic, adding a pet to a clinic,
releasing a pet from a clinic, printing information about a specific room in a clinic, or printing information about
all rooms in a clinic.
Clinics should have an odd number of rooms, attempting to create a clinic with an even number should fail and throw
an appropriate exception.
Accommodation Order
For example, let us take a look at a clinic with 5 rooms. The first room where a pet will be treated is the central one (room 3).
Therefore, the order in which an animal is entering is: the first animal is going to the centre(3) room, and after that,
the next pets are entering first to the left (2) and then to the right (4) room. The last rooms in which pets can enter
are room 1 and room 5. In case a room is already occupied, we skip it and go to the next room in the above order.
Your task is to model the application and make it support some commands.
The first pet enters room 3. 					-> 	1 2 3 4 5
After that, the next pet enters room 2. 				-> 	1 2 3 4 5
The third pet would enter room 4. 				-> 	1 2 3 4 5
And the last two pets would be going to rooms - 1 and 5. 	->	1 2 3 4 5
Now when we have covered adding the pets, it is time to find a way to release them. The process of releasing them
is not so simple, when the release method is called, we start from the centre room (3) and continue right
(4, 5… and so on) until we find a pet or reach the last room. If we reach the last room, we start from the first (1)
and again move right until we reach the centre room (3). If a pet is found, we remove it from the collection,
stop further search and return true, if a pet is NOT found, the operation returns false.
When a print command for a room is called, if the room contains a pet, we print the pet on a single line in the format
"{pet name} {pet age} {pet kind}". Alternatively, if the room is empty, print "Room empty" instead.
When a print command for a clinic is called, it should print all rooms in the clinic in order of their number.
On the first line, you will be given an integer N - the number of commands you will receive. On each of the next N lines, you will receive a command.
Output
For each command with a boolean return type received through the input, you should print its return value on a separate line. In case of a method throwing an exception (such as trying to create a clinic with an even number of rooms or trying to add a pet that doesn't exist), you should catch the exceptions and instead print "Invalid Operation!".
•	The "Print" command with a clinic and a room should print information for that room in the format specified above.
•	The "Print" command with only a clinic should print information for each room in the clinic in order of their numbers.
*/
