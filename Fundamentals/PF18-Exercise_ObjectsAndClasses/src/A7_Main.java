//package groomingSalon;

public class A7_Main {

    public static void main(String[] args) {
        // Initialize the repository
        A7_GroomingSalon salon = new A7_GroomingSalon(20);

        // Initialize entity
        A7_Pet dog = new A7_Pet("Ellias", 5, "Tim");

        // Print Pet
        System.out.println(dog); // Ellias 5 - (Tim)

        // Add Pet
        salon.add(dog);

        // Remove Pet
        System.out.println(salon.remove("Ellias")); // true
        System.out.println(salon.remove("Pufa")); // false

        A7_Pet cat = new A7_Pet("Bella", 2, "Mia");
        A7_Pet bunny = new A7_Pet("Zak", 4, "Jon");

        salon.add(cat);
        salon.add(bunny);

        // Get Pet
        A7_Pet pet = salon.getPet("Bella", "Mia");
        System.out.println(pet); // Bella 2 - (Mia)

        // Count
        System.out.println(salon.getCount()); // 2

        // Get Statistics
        System.out.println(salon.getStatistics());
        // The grooming salon has the following clients:
        //Bella Mia
        //Zak Jon
    }
}