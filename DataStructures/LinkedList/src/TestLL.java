import java.util.Scanner;

public class TestLL {
    public static void main(String[] args) {
        SingleLL list = new SingleLL();
        Scanner sc = new Scanner(System.in);
        int choice, data, index;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at head");
            System.out.println("2. Insert at tail");
            System.out.println("3. Insert at index");
            System.out.println("4. Search for a value");
            System.out.println("5. Delete at tail");
            System.out.println("6. Delete at head");
            System.out.println("7. Delete at index");
            System.out.println("8. Print the list");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert at head: ");
                    data = sc.nextInt();
                    list.insertAtHead(data);
                    list.printList();
                    break;
                case 2:
                    System.out.print("Enter the value to insert at tail: ");
                    data = sc.nextInt();
                    list.insertAtTail(data);
                    list.printList();
                    break;
                case 3:
                    System.out.print("Enter the value to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter the index: ");
                    index = sc.nextInt();
                    list.insertAtIndex(data, index);
                    list.printList();
                    break;
                case 4:
                    System.out.print("Enter the value to search: ");
                    data = sc.nextInt();
                    list.getIndex(data);
                    break;
                case 5:
                    list.deleteTail();
                    System.out.println("Deleted the node.");
                    list.printList();
                    break;
                case 6:
                    list.deleteHead();
                    System.out.println("Deleted the node.");
                    list.printList();
                    break;
                case 7:
                    System.out.print("Enter the index to delete: ");
                    index = sc.nextInt();
                    list.deleteAtIndex(index);
                    System.out.println("Deleted the node.");
                    list.printList();
                    break;
                case 8:
                    list.printList();
                    break;
                case 9:
                    System.out.println("Exiting program.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

}
