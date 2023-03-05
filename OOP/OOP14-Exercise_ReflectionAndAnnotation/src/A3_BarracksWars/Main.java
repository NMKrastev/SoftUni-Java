package A3_BarracksWars;

import A3_BarracksWars.core.Engine;
import A3_BarracksWars.core.commands.CommandInterpreterImpl;
import A3_BarracksWars.core.factories.UnitFactoryImpl;
import A3_BarracksWars.data.UnitRepository;
import A3_BarracksWars.interfaces.CommandInterpreter;
import A3_BarracksWars.interfaces.Repository;
import A3_BarracksWars.interfaces.Runnable;
import A3_BarracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {

        Repository repository = new UnitRepository();

        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
/*You are given a small console-based project called Barracks (the code for it is included in the provided skeleton).
The general functionality of the project is adding new units to its repository and printing
a report with statistics about the units currently in the repository. First, let's go over the original task
before the project was created:
Input
The input consists of commands each on a separate line. Commands that execute the functionality are:
•	add {Archer/Swordsman/Pikeman/{…}} - adds a unit to the repository
•	report - prints a lexicological ordered statistic about the units in the repository
•	fight - ends the input
Output
Each command except fight should print output on the console.
•	add should print: "{Archer/Swordsman/Pikeman/{…}} added!"
•	report should print all the info in the repository in the format: "{UnitType} -> {UnitQuantity}", sorted by UnitType
Constraints
•	Input will consist of no more than 1000 lines.
•	report command will never be given before any valid add command was provided.
Your Task
1) You have to study the code of the project and figure out how it works. However,
there are parts of it that are not implemented (left with TODOs (TODO window will be useful)).
You must implement the functionality of the createUnit method in the UnitFactoryImpl class so that it creates
a unit based on the unit type received as a parameter. Implement it in such a way that whenever you add a new unit
it will be creatable without the need to change anything in the UnitFactoryImpl class (psst - use reflection).
You can use the approach called Simple Factory.
2) Add two new unit classes (there will be tests that require them) - Horseman with 50 health and 10 attacks
and Gunner with 20 health and 20 attacks.
If you do everything correctly for this problem, you should write code only in the factories and units packages.


As you might have noticed commands in the project from Problem 3 are implemented via a switch case with method calls
in the Engine class. Although this approach works it is flawed when you add a new command because you have
to add a new case for it. In some projects, you might not have access to the engine and this would not work.
Imagine this project will be outsourced and the outsourcing firm will not have access to the engine.
Make it so whenever they want to add a new command they won't have to change anything in the Engine.
Notice how all commands that extend this one will have both a Repository and a UnitFactory although
not all of them need these. Leave it like this for this problem, because for the reflection to work we need
all constructors to accept the same parameters. We will see how to go around this issue in Problem 5.
Once you've implemented the pattern add a new command. It will have the following syntax:
•	retire {UnitType} - All it has to do is remove a unit of the provided type from the repository.
o	If there are no such units currently in the repository print: "No such units in repository."
o	If there is such a unit currently in the repository, print: "{UnitType} retired!"
To implement this command, you will also have to implement a corresponding method in the UnitRepository.
If you do everything correctly for this problem, you should write/refactor code only in the core and data packages.


In the final part of this epic problem trilogy, we will resolve the issue where all Commands received
all utility classes as parameters in their constructors. We can accomplish this by using an approach called dependency
injection container. This approach is used in many frameworks like Spring for instance.
We will do a little twist on that approach. Remove all fields from the abstract command except the data.
Instead, put whatever fields each command needs in the concrete class. Create an annotation called Inject
and make it so it can be used only on fields. Put the annotation over the fields we need to set through reflection.
Once you've prepared all of this, write the necessary reflection code in the Command Interpreter
(which you should have refactored out from the engine in Problem 4).
Use the tests from Problem 4 to test your solution.
*/
