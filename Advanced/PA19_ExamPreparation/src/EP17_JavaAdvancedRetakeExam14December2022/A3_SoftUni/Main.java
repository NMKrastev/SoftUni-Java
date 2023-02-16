package EP17_JavaAdvancedRetakeExam14December2022.A3_SoftUni;

public class Main {
    public static void main(String[] args) {
 //TODO
        // Initialize the repository
        SoftUni softUni = new SoftUni(7);

// Initialize entities
        Student student = new Student("Boryana", "Dimitrova", "JavaScript");
        Student studentTwo = new Student("Joana", "Jonkova", "Java");
        Student studentThree = new Student("Desislava", "Topuzakova", "FundamentalsInMathematics");
        Student studentFour = new Student("Alex", "Raykova", "Python");
        Student studentFive = new Student("Rosica", "Nenova", "C#");

// Register Student
        String adding = softUni.insert(student);
        System.out.println(adding); // Added student Boryana Dimitrova.
        String adding1 = softUni.insert(studentTwo);
        System.out.println(adding1); // Added student Joana Jonkova.
        softUni.insert(studentThree);
        softUni.insert(studentFour);

// Remove Student
        String removal = softUni.remove(studentTwo);
        System.out.println(removal); // Removed student Joana Jonkova.
        String removal1 = softUni.remove(studentFive);
        System.out.println(removal1); // Student not found.

// Get Student
        System.out.println(softUni.getStudent("Alex", "Raykova")); // Student: Alex Raykova, Best Course – Python

// Get Statistics
        System.out.println(softUni.getStatistics());
//Hall size: 3
//Student: Boryana Dimitrova, Best Course = JavaScript
//Student: Desislava Topuzakova, Best Course = FundamentalsInMathematics
//Student: Alex Raykova, Best Course = Python

    }
}
/*Your task is to create a repository which stores departments by creating the classes described below.
Student
First, write a Java class Student with the following fields:
•	firstName: String
•	lastName: String
•	bestCourse: String
The class constructor should receive а firstName, lastName and bestCourse.
You need to create the appropriate getters and setters. The class should override the toString() method in the following format:
"Student: {firstName} {lastName}, Best Course = {bestCourse}"
SoftUni
Next, write a Java class SoftUni that has students (a collection, which stores the entity Student).
All entities inside the repository have the same fields. Also, the SoftUni class should have those fields:
•	capacity: int
•	data: List<Student> - holds all added students in the hall
The class constructor should receive capacity, also it should initialize the students with a new instance of the collection.
Implement the following features:
•	getCapacity()
•	getCount() method – returns the number of students in the course.
•	insert(Student student) method – adds an entity to the data if there is a hall for it.
o	Returns "Added student {firstName} {lastName}." –  if the student is successfully added.
o	Returns "Student is already in the hall." –  if the student is already in the hall.
o	Returns "The hall is full." - if the hall is full.
•	remove(Student student) method – removes the student
o	Returns "Removed student {firstName} {lastName}." –  if the student is successfully removed.
o	Returns "Student not found." if the student is not in the hall.
•	getStudent(String firstName, String lastName) method - returns the student with the given names.
•	getStatistics() – returns a String in the following format:
o	"Hall size: {addedStudentsCount}
 Student: {firstName} {lastName}, Best Course = {bestCourse}
 Student: {firstName} {lastName}, Best Couse = {bestCourse}
 (…)"
Constraints
•	The combinations of names will always be unique.
•	The capacity will always be a positive number.
*/