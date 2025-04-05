import java.util.Scanner;

public class Main1 {
    public static void main(String []args){
        menu();
    }
    public static void menu(){
        int choice;
        Scanner sc = new Scanner(System.in);
        BinaryTree b = new BinaryTree();
        while(true){
            System.out.println("-".repeat(20));
            System.out.println("Binary Trees using Node Representation");
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
                    b.build(b.getRoot(),null);
                    System.out.println("Binary Tree builded successfully!");
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
                case 5:b.levelOrder(b.getRoot());
                    System.out.println();
                    break;
                case 6:int size=b.getSize(b.getRoot());
                    System.out.println("The size of tree is : "+size);
                    break;
                case 7:System.out.println("Enter the key to be searched : ");
                    sc.nextLine();
                    String key = sc.nextLine();
                    BinaryTree.Node node = b.Search(b.getRoot(),key);
                    if(node == null){
                        System.out.println("The key is not present.");
                    }
                    else {
                        System.out.println("The key is at location : " + node);
                    }
                    break;
                case 8:System.out.println(b.isEmpty());
                    break;
                case 9: int height = b.getHeight(b.getRoot());
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
