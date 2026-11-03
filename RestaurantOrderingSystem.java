import java.util.Scanner;

public class RestaurantOrderingSystem {
    static Scanner sc = new Scanner(System.in);
    static String[] menu = {"Burger", "Fries", "Iced Tea", "Pizza"};
    static double[] prices = {85.00, 45.00, 30.00, 150.00};
    static int[] orderQty = new int[menu.length];

    static void displayMenu() {
        System.out.println("\n--- RESTAURANT MENU ---");
        for (int i = 0; i < menu.length; i++)
            System.out.printf("%d. %-10s PHP %.2f%n", i + 1, menu[i], prices[i]);
    }

    static double calculateBill() {
        double total = 0;
        for (int i = 0; i < menu.length; i++) total += orderQty[i] * prices[i];
        return total;
    }

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Choose item number (0 to finish): ");
            choice = sc.nextInt();
            if (choice >= 1 && choice <= menu.length) {
                System.out.print("Quantity: ");
                int qty = sc.nextInt();
                if (qty > 0) orderQty[choice - 1] += qty;
                else System.out.println("Quantity must be greater than zero.");
            } else if (choice != 0) System.out.println("Invalid item number.");
        } while (choice != 0);

        System.out.println("\n--- YOUR ORDER ---");
        for (int i = 0; i < menu.length; i++)
            if (orderQty[i] > 0)
                System.out.printf("%-10s x %d = PHP %.2f%n", menu[i], orderQty[i], orderQty[i] * prices[i]);

        double total = calculateBill();
        System.out.printf("TOTAL: PHP %.2f%n", total);
        if (total == 0) { System.out.println("No items ordered."); return; }
        System.out.print("Payment amount: PHP ");
        double payment = sc.nextDouble();
        if (payment < total) System.out.printf("Insufficient payment. Balance: PHP %.2f%n", total - payment);
        else System.out.printf("Change: PHP %.2f%nThank you for ordering!%n", payment - total);
    }
}
