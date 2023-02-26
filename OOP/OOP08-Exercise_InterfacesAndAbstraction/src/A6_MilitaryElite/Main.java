package A6_MilitaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Soldier> soldiersList = new ArrayList<>();

        String input;

        while (!(input = scanner.nextLine()).equals("End")) {

            String[] data = input.split("\\s+");

            String soldierType = data[0];
            int id = Integer.parseInt(data[1]);
            String firstName = data[2];
            String lastName = data[3];
            double salary = Double.parseDouble(data[4]);

            switch (soldierType) {

                case "Private":
                    PrivateImpl currentPrivate = new PrivateImpl(id, firstName, lastName, salary);

                    soldiersList.add(currentPrivate);
                    break;
                case "LieutenantGeneral":
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                    String[] ids = getIds(data);

                    addPrivate(soldiersList, lieutenantGeneral, ids);

                    soldiersList.add(lieutenantGeneral);
                    break;
                case "Engineer":
                    String engineerCorp = data[5];

                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, engineerCorp);

                        String[] parts = getParts(data);

                        addRepair(engineer, parts);

                        soldiersList.add(engineer);
                    } catch (IllegalArgumentException e) {

                    }
                    break;
                case "Commando":
                    String commandoCorp = data[5];

                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, commandoCorp);

                        String[] missions = getParts(data);

                        addMission(commando, missions);

                        soldiersList.add(commando);
                    } catch (IllegalArgumentException e) {

                    }
                    break;
                case "Spy":
                    String codeNumber = data[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiersList.add(spy);
                    break;
            }
        }

        soldiersList.forEach(System.out::println);
    }

    private static void addMission(CommandoImpl commando, String[] missions) {

        for (int i = 0; i < missions.length; i += 2) {

            String missionCodeName = missions[i];
            String missionState = missions[i + 1];

            try {
                MissionImpl mission = new MissionImpl(missionCodeName, missionState);
                commando.addMission(mission);
            } catch (IllegalArgumentException e) {

            }
        }
    }

    private static void addRepair(EngineerImpl engineer, String[] parts) {

        for (int i = 0; i < parts.length; i += 2) {

            String partName = parts[i];
            int workHours = Integer.parseInt(parts[i + 1]);

            RepairImpl repair = new RepairImpl(partName, workHours);

            engineer.addRepair(repair);
        }
    }

    private static void addPrivate(List<Soldier> soldiersList, LieutenantGeneralImpl lieutenantGeneral, String[] ids) {

        for (String privateIds : ids) {

            Soldier currentPrivate = soldiersList.stream()
                    .filter(s -> s.getId() == Integer.parseInt(String.valueOf(privateIds)))
                    .findFirst()
                    .get();

            lieutenantGeneral.addPrivate(currentPrivate);
        }
    }

    private static String[] getIds(String[] data) {

        String[] ids = new String[data.length - 5];

        System.arraycopy(data, 5, ids, 0, ids.length);

        return ids;
    }

    private static String[] getParts(String[] data) {

        String[] parts = new String[data.length - 6];

        System.arraycopy(data, 6, parts, 0, parts.length);

        return parts;
    }
}
/*Create the following class hierarchy:
•	SoldierImpl – general class for soldiers, holding id (int), first name, and last name
o	PrivateImpl – lowest base soldier type, holding the field salary(double)
	LieutenantGeneralImpl – holds a set of PrivatesImpl under his command
-	public void addPrivate(Private priv)
	SpecialisedSoldierImpl – general class for all specialized soldiers – holds the corps of the soldier.
The corps can only be one of the following: "Airforces" or "Marines" (Enumeration)
-	EngineerImpl – holds a set of repairs. A repair holds a part name and
hours worked (int)
o	public void addRepair(Repair repair)
o	public Collection<Repair> getRepairs()
-	CommandoImpl – holds a set of missions. A mission holds a code name and a state
(Enumeration: "inProgress" or "finished"). A mission can be finished through the method completeMission()
o	public void addMission(Mission mission)
o	public Collection<Mission> getMissions()
o	SpyImpl – holds the code number of the spy.
Extract interfaces for each class. (e.g. Soldier, Private, LieutenantGeneral, etc.) The interfaces should hold
their public get methods (e.g. Soldier should hold getId, getFirstName, and getLastName). Each class should
implement its respective interface. Validate the input where necessary (corps, mission state) -
input should match exactly one of the required values, otherwise, it should be treated as invalid.
In the case of invalid corps, the entire line should be skipped, in the case of an invalid mission state,
only the mission should be skipped.
You will receive from the console an unknown amount of lines containing information about soldiers
until the command "End" is received. The information will be in one of the following formats:
•	Private: "Private {id} {firstName} {lastName} {salary}"
•	LieutenantGeneral: "LieutenantGeneral {id} {firstName} {lastName} {salary} {private1Id} {private2Id} … {privateNId}"
where privateXId will always be an Id of a private already received through the input
•	Engineer: "Engineer {id} {firstName} {lastName} {salary} {corps} {repair1Part} {repair1Hours} … {repairNPart} {repairNHours}"
where repairXPart is the name of a repaired part and repairXHours the hours it took to repair it (the two parameters will always come paired)
•	Commando: "Commando {id} {firstName} {lastName} {salary} {corps} {mission1CodeName}  {mission1state} … {missionNCodeName} {missionNstate}"
a missions code name, description and state will always come together
•	Spy: "Spy {id} {firstName} {lastName} {codeNumber}"
Define proper constructors. Avoid code duplication through abstraction.
Override toString() in all classes to print detailed information about the object.
Privates:
"Name: {firstName} {lastName} Id: {id} Salary: {salary}"
Spy:
"Name: {firstName} {lastName} Id: {id}
Code Number: {codeNumber}"
LieutenantGeneral:
"Name: {firstName} {lastName} Id: {id} Salary: {salary}
Privates:
  {private1 ToString()}
  {private2 ToString()}
  …
  {privateN ToString()}"
Note: privates must be sorted by id in descending order.
Engineer:
"Name: {firstName} {lastName} Id: {id} Salary: {salary}
Corps: {corps}
Repairs:
  {repair1 ToString()}
  {repair2 ToString()}
  …
  {repairN ToString()}"
Commando:
"Name: {firstName} {lastName} Id: {id} Salary: {salary}
Corps: {corps}
Missions:
  {mission1 ToString()}
  {mission2 ToString()}
  …
  {missionN ToString()}"
Repair:
"Part Name: {partName} Hours Worked: {hoursWorked}"
Mission:
"Code Name: {codeName} State: {state}"
NOTE: Salary should be printed and rounded to two decimal places after the separator.
*/
