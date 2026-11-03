import java.util.Scanner;

public class StudentAttendanceMonitoringSystem {
    static Scanner sc = new Scanner(System.in);
    static String[] students = new String[100];
    static boolean[] present = new boolean[100];
    static int count = 0;

    static void addStudent() {
        if (count == students.length) { System.out.println("Student list is full."); return; }
        System.out.print("Student name: "); students[count] = sc.nextLine();
        count++;
        System.out.println("Student added!");
    }

    static void recordAttendance() {
        if (count == 0) { System.out.println("Add students first."); return; }
        for (int i = 0; i < count; i++) {
            System.out.print(students[i] + " (P = Present, A = Absent): ");
            String answer = sc.nextLine();
            present[i] = answer.equalsIgnoreCase("P");
        }
        System.out.println("Attendance recorded!");
    }

    static void showReport() {
        if (count == 0) { System.out.println("No students yet."); return; }
        int absences = 0, attended = 0;
        System.out.println("\n--- ATTENDANCE REPORT ---");
        for (int i = 0; i < count; i++) {
            System.out.printf("%s: %s%n", students[i], present[i] ? "Present" : "Absent");
            if (present[i]) attended++; else absences++;
        }
        double percentage = (attended * 100.0) / count;
        System.out.println("Total absences: " + absences);
        System.out.printf("Attendance percentage: %.2f%%%n", percentage);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== STUDENT ATTENDANCE MONITORING ===");
            System.out.println("1. Add Student\n2. Record Attendance\n3. View Attendance Report\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: recordAttendance(); break;
                case 3: showReport(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
