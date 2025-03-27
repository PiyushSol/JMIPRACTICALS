package UsingArrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------Stack with Arrays-------");
        System.out.print("Enter the size of your stack: ");
        int n = sc.nextInt();
        Stack s = new Stack(n);
        menu(s);
        sc.close();
    }

    public static void menu(Stack s) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("-".repeat(10));
            System.out.println("1. Push Element");
            System.out.println("2. Pop Element");
            System.out.println("3. Peek Element");
            System.out.println("4. Evaluate Postfix Expression");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element: ");
                    int el = sc.nextInt();
                    try {
                        s.push(el);
                    } catch (StackFullException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        int d = s.pop();
                        System.out.println(d + " popped out from the stack.");
                    } catch (StackEmptyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        s.peek();
                    } catch (StackEmptyException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                 
                    System.out.println("Enter your postfix expression : ");
                    sc.nextLine(); 
                    String exp = sc.nextLine();

                    if (exp.trim().isEmpty()) {
                        System.out.println("Invalid input: empty postfix expression.");
                    } else {
                        int res = s.evaluate(exp);
                        System.out.println("The evaluation is: " + res);
                    }
                    break;
                case 5:
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
