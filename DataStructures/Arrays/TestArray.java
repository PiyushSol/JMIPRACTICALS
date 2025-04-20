import java.util.Scanner;

public class TestArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter capacity of the array: ");
        int cap = sc.nextInt();
        Array a = new Array(cap);
        menu(a);
        sc.close();

    }

    public static void menu(Array a) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------ Array Operations Menu ------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search (indexOf)");
            System.out.println("4. Get Element");
            System.out.println("5. isEmpty");
            System.out.println("6. Size");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int x = sc.nextInt();
                    System.out.print("Enter index to insert at: ");
                    int idx = sc.nextInt();
                    a.insert(x, idx);
                    break;

                case 2:
                    System.out.print("Enter index to delete: ");
                    int delIdx = sc.nextInt();
                    int deleted = a.delete(delIdx);
                    if (deleted != -1) {
                        System.out.println("Deleted element: " + deleted);
                    }
                    break;

                case 3:
                    System.out.print("Enter element to search: ");
                    int search = sc.nextInt();
                    int pos = a.indexOf(search);
                    if (pos != -1)
                        System.out.println("Element found at index: " + pos);
                    else
                        System.out.println("Element not found.");
                    break;

                case 4:
                    System.out.print("Enter index to get element: ");
                    int getIdx = sc.nextInt();
                    int element = a.get(getIdx);
                    if (element != -1)
                        System.out.println("Element at index " + getIdx + ": " + element);
                    break;

                case 5:
                    System.out.println("Is array empty? " + a.isEmpty());
                    break;

                case 6:
                    System.out.println("Size of array: " + a.size());
                    break;

                case 7:
                    System.out.print("Array elements: ");
                    a.display();
                    System.out.println();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}
