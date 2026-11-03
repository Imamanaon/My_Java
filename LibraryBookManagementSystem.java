import java.util.Scanner;

public class LibraryBookManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static String[] titles = new String[100], authors = new String[100];
    static boolean[] borrowed = new boolean[100];
    static int count = 0;

    static void addBook() {
        if (count == titles.length) { System.out.println("Book list is full."); return; }
        System.out.print("Book title: "); titles[count] = sc.nextLine();
        System.out.print("Author: "); authors[count] = sc.nextLine();
        borrowed[count] = false;
        count++;
        System.out.println("Book added successfully!");
    }

    static void displayBooks() {
        if (count == 0) { System.out.println("No books yet."); return; }
        System.out.println("\n--- LIBRARY BOOKS ---");
        for (int i = 0; i < count; i++)
            System.out.printf("%s by %s - %s%n", titles[i], authors[i], borrowed[i] ? "BORROWED" : "AVAILABLE");
    }

    static int findBook(String key) {
        for (int i = 0; i < count; i++) if (titles[i].equalsIgnoreCase(key)) return i;
        return -1;
    }

    static void searchBook() {
        System.out.print("Book title to search: "); String key = sc.nextLine();
        int i = findBook(key);
        if (i >= 0) System.out.printf("Found: %s by %s (%s)%n", titles[i], authors[i], borrowed[i] ? "Borrowed" : "Available");
        else System.out.println("Book not found.");
    }

    static void borrowBook() {
        System.out.print("Book title to borrow: "); int i = findBook(sc.nextLine());
        if (i < 0) System.out.println("Book not found.");
        else if (borrowed[i]) System.out.println("This book is already borrowed.");
        else { borrowed[i] = true; System.out.println("Book borrowed successfully!"); }
    }

    static void returnBook() {
        System.out.print("Book title to return: "); int i = findBook(sc.nextLine());
        if (i < 0) System.out.println("Book not found.");
        else if (!borrowed[i]) System.out.println("This book was not borrowed.");
        else { borrowed[i] = false; System.out.println("Book returned successfully!"); }
    }

    static void countAvailable() {
        int available = 0;
        for (int i = 0; i < count; i++) if (!borrowed[i]) available++;
        System.out.println("Available books: " + available);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== LIBRARY BOOK MANAGEMENT ===");
            System.out.println("1. Add Book\n2. Display Books\n3. Search Book");
            System.out.println("4. Borrow Book\n5. Return Book\n6. Count Available Books\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1: addBook(); break;
                case 2: displayBooks(); break;
                case 3: searchBook(); break;
                case 4: borrowBook(); break;
                case 5: returnBook(); break;
                case 6: countAvailable(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
