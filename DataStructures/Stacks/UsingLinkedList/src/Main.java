import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        System.out.println("------Stack with LinkedList-------");
        Stack s  = new Stack();
        menu(s);

    }


    public static void menu(Stack s){
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
                    s.push(el);
                    System.out.println("Data pushed onto stack.");
                    break;
                case 2:
                    int pop = s.pop();
                    System.out.println("Popped "+ pop + " from stack.");
                    break;
                case 3:
                    int p = s.peek();
                    System.out.println("Peeking "+ p+" from the top.");
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
