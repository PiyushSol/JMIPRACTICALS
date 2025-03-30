import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        menu();
    }

    public static void menu(){
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the height of binary tree : ");
        int h = sc.nextInt();
        BinaryTrees b = new BinaryTrees(h);
        while(true){
            System.out.println("-".repeat(20));
            System.out.println("Binary Trees using Arrays");
            System.out.println("1. Build Binary Tree");
            System.out.println("2. PreOrder Traversal"+"\n3. Inorder Traversal"+"\n4. PostOrder Traversal");
            System.out.println("5. Level Order Traversal");
            System.out.println("6. Size "+"\n7. Search"+"\n8. isEmpty");
            System.out.println("9. Height "+"\n10. Exit");
            System.out.println("-".repeat(20));
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                       b.build(0);
                       System.out.println("Binary Tree builded successfully!");
                       break;
                case 2:b.preOrder(0);
                       System.out.println();
                       break;
                case 3:b.inOrder(0);
                    System.out.println();
                       break;
                case 4: b.postOrder(0);
                    System.out.println();
                        break;
                case 5:b.levelOrder(0);
                    System.out.println();
                        break;
                case 6:int size=b.size();
                        System.out.println("The size of tree is : "+size);
                        break;
                case 7:System.out.println("Enter the key to be searched : ");
                        sc.nextLine();
                       String key = sc.nextLine();
                       int idx = b.search(key);
                       System.out.println("The key is at location : "+idx);
                       break;
                case 8:System.out.println(b.isEmpty());
                        break;
                case 9: int height = b.getHeight();
                        System.out.println("The height of tree is :"+height);
                        break;
                case 10:System.out.println("Exiting......");
                System.exit(0);
                break;
                default:System.out.println("Invalid choice...");
            }
        }
    }
}
