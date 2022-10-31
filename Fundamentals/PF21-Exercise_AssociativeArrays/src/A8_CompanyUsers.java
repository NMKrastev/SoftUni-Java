import java.util.*;

public class A8_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companiesMap = new LinkedHashMap<>();

        String line;

        while (!(line = scanner.nextLine()).equals("End")) {

            String company = line.split("\\s+->\\s+")[0];
            String employeeID = line.split("\\s+->\\s+")[1];

            if (!companiesMap.containsKey(company)) {
                companiesMap.put(company, new ArrayList<>());
                companiesMap.get(company).add(employeeID);
            } else if (companiesMap.containsKey(company) && !companiesMap.get(company).contains(employeeID)) {
                companiesMap.get(company).add(employeeID);
            }
        }

        printResult(companiesMap);
    }

    private static void printResult(Map<String, List<String>> companiesMap) {

        for (Map.Entry<String, List<String>> entry : companiesMap.entrySet()) {

            System.out.printf("%s\n", entry.getKey());
            for (String student : entry.getValue()) {
                System.out.printf("-- %s\n", student);
            }
        }
    }
}
/*Write a program which keeps the information about companies and their employees.
You will receive company names and an employees' id until you receive the "End" command.
Add each employee to the given company. Keep in mind that a company cannot have two employees with the same id.
Print the company name and each employee's id in the following format:
"{company_name}
-- {id1}
-- {id2}
…
-- {idN}"
Input / Constraints
•	Until you receive "End", the input come in the format: "{companyName} -> {employeeId}".
•	The input always will be valid.*/