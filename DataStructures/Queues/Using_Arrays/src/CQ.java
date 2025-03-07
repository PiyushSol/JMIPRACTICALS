import java.util.Scanner;

public class CQ {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("------Ciruclar Queue with Arrays-------");
        System.out.print("Enter the size of your queue : ");
        int n= sc.nextInt();
        CircularQueue q  = new CircularQueue(n);
        menu(q);
        sc.close();
    }

    public static void menu(CircularQueue q){
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("-".repeat(10));
            System.out.println("1. Push Element");
            System.out.println("2. Pop Element");
            System.out.println("3. Peek Element");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter the element : ");
                    int el = sc.nextInt();
                    q.add(el);
                    System.out.println("Element added to the queue.");
                    break;
                case 2:
                    int data=q.remove();
                    System.out.println("Element "+ data+ " removed from the queue.");
                    break;
                case 3:
                    int p = q.peek();
                    System.out.println("Peeking : "+p);
                    break;
                case 4:
                    System.out.println("Exiting......");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid choice!");
            }
        }
    }
}
