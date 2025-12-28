import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

 /*   InventoryManager manager = new InventoryManager();

        Product product1 = new Product(1,"Vegetables",20,2);
        Product product2 = new Product(2,"Fruits",30,1);

        manager.addProduct(product1);
        manager.addProduct(product2);

        manager.sellProduct(1,1);
        manager.sellProduct(1,1);
        manager.sellProduct(1,1);

        manager.restockProduct(1,3);
        manager.sellProduct(1,2);

        manager.listProducts();

        manager.printSalesReport();*/

        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== INVENTORY SYSTEM ===");
            System.out.println("1. Add Product");
            System.out.println("2. Sell Product");
            System.out.println("3. Restock Product");
            System.out.println("4. Discontinue Product");
            System.out.println("5. List Product");
            System.out.println("6. Sales Report");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Product ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Product Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Product Price: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Product Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    manager.addProduct(new Product(id, name, price, quantity));
                    System.out.println("Product added successfully.");
                    break;

                    case 2:
                        System.out.print("Product ID: ");
                        int sellid=scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Product Quantity: ");
                        int qty=scanner.nextInt();

                        manager.sellProduct(sellid, qty);
                        break;

                        case 3:
                            System.out.print("Product ID: ");
                            int restockId=scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Product Quantity: ");
                            int restockQty=scanner.nextInt();

                            manager.restockProduct(restockId, restockQty);
                            break;

                            case 4:
                                System.out.print("Product ID: ");
                                int discountId=scanner.nextInt();
                                scanner.nextLine();

                                manager.discontinueProduct(discountId);
                                break;

                                case 5:
                                    manager.listProducts();
                                    break;
                                    case 6:
                                        manager.printSalesReport();
                                        break;
                                        case 0:
                                            System.out.println("Exiting...");
                                            return;
                                            default:
                                                System.out.println("Invalid choice");
            }

        }


    }
}