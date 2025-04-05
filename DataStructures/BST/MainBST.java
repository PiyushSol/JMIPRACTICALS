import java.util.Scanner;

public class MainBST {
    public static void main(String[] args) {
      menu();
    }
    public static void menu(){
        int choice;
        Scanner sc = new Scanner(System.in);
        BST b = new BST();
        while(true){
            System.out.println("-".repeat(20));
            System.out.println("Binary Search Tree using Node Representation");
            System.out.println("1. Build Binary Tree");
            System.out.println("2. PreOrder Traversal"+"\n3. Inorder Traversal"+"\n4. PostOrder Traversal");
            System.out.println("5. Size "+"\n6. Search"+"\n7. isEmpty");
            System.out.println("8. Height "+"\n9. Exit");
            System.out.println("-".repeat(20));
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter the data: ");
                    String data = sc.next();
                    b.insert(data);
                    System.out.println("Insertion successful!");
                    break;
                case 2:b.preOrder(b.getRoot());
                    System.out.println();
                    break;
                case 3:b.inOrder(b.getRoot());
                    System.out.println();
                    break;
                case 4: b.postOrder(b.getRoot());
                    System.out.println();
                    break;
                case 5:int size=b.getSize(b.getRoot());
                    System.out.println("The size of tree is : "+size);
                    break;
                case 6:
                    System.out.print("Enter the key to search: ");
                    String key = sc.next();
                    BST.Node node = b.search(key);
                    System.out.println("The key is found at : "+node);
                    break;
                case 7:System.out.println(b.isEmpty());
                    break;
                case 8: int height = b.getHeight(b.getRoot());
                    System.out.println("The height of tree is :"+height);
                    break;
                case 9:System.out.println("Exiting......");
                    System.exit(0);
                    break;
                default:System.out.println("Invalid choice...");
            }
        }
    }
}
