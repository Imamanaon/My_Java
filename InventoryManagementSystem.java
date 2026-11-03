import java.util.Scanner;

public class InventoryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static String[] products = new String[100];
    static int[] quantities = new int[100];
    static double[] prices = new double[100];
    static int count = 0;

    static void addProduct() {
        if (count == products.length) { System.out.println("Inventory is full."); return; }
        System.out.print("Product name: "); products[count] = sc.nextLine();
        System.out.print("Quantity: "); quantities[count] = sc.nextInt();
        System.out.print("Price: "); prices[count] = sc.nextDouble(); sc.nextLine();
        count++;
        System.out.println("Product added successfully!");
    }

    static void displayProducts() {
        if (count == 0) { System.out.println("No products yet."); return; }
        System.out.println("\n--- INVENTORY LIST ---");
        for (int i = 0; i < count; i++)
            System.out.printf("%s | Qty: %d | Price: PHP %.2f%n", products[i], quantities[i], prices[i]);
    }

    static void totalValue() {
        double total = 0;
        for (int i = 0; i < count; i++) total += quantities[i] * prices[i];
        System.out.printf("Total inventory value: PHP %.2f%n", total);
    }

    static void searchProduct() {
        System.out.print("Product to search: "); String key = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (products[i].equalsIgnoreCase(key)) {
                System.out.printf("Found: %s | Qty: %d | Price: PHP %.2f%n", products[i], quantities[i], prices[i]);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    static void highestPrice() {
        if (count == 0) { System.out.println("No products yet."); return; }
        int high = 0;
        for (int i = 1; i < count; i++) if (prices[i] > prices[high]) high = i;
        System.out.printf("Highest-priced product: %s (PHP %.2f)%n", products[high], prices[high]);
    }

    static void updateQuantity() {
        System.out.print("Product to update: "); String key = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (products[i].equalsIgnoreCase(key)) {
                System.out.print("New quantity: "); quantities[i] = sc.nextInt(); sc.nextLine();
                System.out.println("Quantity updated!");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== INVENTORY MANAGEMENT ===");
            System.out.println("1. Add Product\n2. Display Products\n3. Total Inventory Value");
            System.out.println("4. Search Product\n5. Highest-Priced Product\n6. Update Quantity\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();
            switch (choice) {
                case 1: addProduct(); break;
                case 2: displayProducts(); break;
                case 3: totalValue(); break;
                case 4: searchProduct(); break;
                case 5: highestPrice(); break;
                case 6: updateQuantity(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
