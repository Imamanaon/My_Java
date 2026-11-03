import java.util.Scanner;

public class StudentGradeManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static String[] names = new String[100], ids = new String[100];
    static double[] grades = new double[100];
    static int count = 0;

    static void addStudent() {
        if (count == names.length) { System.out.println("Student list is full."); return; }
        System.out.print("Student name: "); names[count] = sc.nextLine();
        System.out.print("Student number: "); ids[count] = sc.nextLine();
        System.out.print("Grade: "); grades[count] = sc.nextDouble(); sc.nextLine();
        count++;
        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (count == 0) { System.out.println("No student records yet."); return; }
        System.out.println("\n--- STUDENT RECORDS ---");
        for (int i = 0; i < count; i++)
            System.out.printf("%s | %s | Grade: %.2f | %s%n", ids[i], names[i], grades[i],
                    grades[i] >= 75 ? "PASSED" : "FAILED");
    }

    static void showAverage() {
        if (count == 0) { System.out.println("No grades available."); return; }
        double sum = 0;
        for (int i = 0; i < count; i++) sum += grades[i];
        System.out.printf("Class average: %.2f%n", sum / count);
    }

    static void showHighestLowest() {
        if (count == 0) { System.out.println("No grades available."); return; }
        int high = 0, low = 0;
        for (int i = 1; i < count; i++) {
            if (grades[i] > grades[high]) high = i;
            if (grades[i] < grades[low]) low = i;
        }
        System.out.printf("Highest: %s (%.2f)%n", names[high], grades[high]);
        System.out.printf("Lowest : %s (%.2f)%n", names[low], grades[low]);
    }

    static void searchStudent() {
        System.out.print("Enter name or student number: ");
        String key = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(key) || ids[i].equalsIgnoreCase(key)) {
                System.out.printf("Found: %s | %s | Grade: %.2f%n", ids[i], names[i], grades[i]);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== STUDENT GRADE MANAGEMENT ===");
            System.out.println("1. Add Student\n2. Display Students\n3. Class Average");
            System.out.println("4. Highest and Lowest Grade\n5. Search Student\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: showAverage(); break;
                case 4: showHighestLowest(); break;
                case 5: searchStudent(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
