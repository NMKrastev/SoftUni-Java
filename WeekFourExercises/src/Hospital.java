import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int treatedPatients = 0, untreatedPatients = 0, doctor = 7;

        for (int i = 1; i <= days; i++) {
            int patientsPerDay = Integer.parseInt(scanner.nextLine());

            if (i % 3 == 0 && untreatedPatients > treatedPatients) {
                doctor++;
            }
            if (patientsPerDay > doctor) {
                untreatedPatients += patientsPerDay - doctor;
                treatedPatients += doctor;
            } else {
                treatedPatients += patientsPerDay;
            }

        }
        System.out.printf("Treated patients: %d.\nUntreated patients: %d.\n", treatedPatients, untreatedPatients);
    }
}
/*За даден период от време, всеки ден в болницата пристигат пациенти за преглед. Тя разполага първоначално със 7 лекари.
Всеки лекар може да преглежда само по един пациент на ден, но понякога има недостиг на лекари, затова останалите пациенти се изпращат в други болници.
Всеки трети ден, болницата прави изчисления и ако броят на непрегледаните пациенти е по-голям от броя на прегледаните, се назначава още един лекар.
Като назначаването става преди да започне приемът на пациенти за деня.
Напишете програма, която изчислява за дадения период броя на прегледаните и непрегледаните пациенти.
Вход
Входът се чете от конзолата и съдържа:
•	На първия ред – периода, за който трябва да направите изчисления. Цяло число в интервала [1 ... 1000]
•	На следващите редове(равни на броят на дните) – броя пациенти, които пристигат за преглед за текущия ден. Цяло число в интервала [0…10 000]
Изход
Да се отпечатат на конзолата 2 реда :
•	На първия ред: "Treated patients: {брой прегледани пациенти}."
•	На втория ред: "Untreated patients: {брой непрегледани пациенти}."
*/