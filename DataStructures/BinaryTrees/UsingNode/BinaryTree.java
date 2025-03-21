import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    //Class Node
    class Node{
        int data;
        Node left , right;
        Node(){
            this.left = this.right=null;
        }
    }
    //Binarytree data members
    Node root;
    BinaryTree(){
        root = null;
    }

    //Building binary tree
    public void build(Node r , Node p){
        Scanner sc = new Scanner(System.in);
        if(r == null && p==null){
            System.out.println("Enter Root Data : ");
            r=root = new Node();
        }
        else if(r==p.left){
            System.out.println("Enter left child of "+p.data+" : ");
        }
        else{
            System.out.println("Enter right child of "+p.data+" : ");
        }
        r.data = sc.nextInt();
        System.out.println("Does "+r.data+" have left child?(Y/y) ");
        char ch = sc.next().charAt(0);
        if((ch =='Y'||ch=='y')){
            r.left = new Node();
            build(r.left,r);
        }
        System.out.println("Does "+r.data+" have right child?(Y/y) ");
        char ch1 = sc.next().charAt(0);
        if((ch =='Y'||ch=='y')){
            r.right = new Node();
            build(r.right,r);
        }
    }

    //isEmpty
    public boolean isEmpty(){
        if(root ==null){
            return true;
        }
        else {
            return false;
        }
    }

    //Size
    public int getSize(Node r){
        if(r ==null){
            return 0;
        }
        else{
            return getSize(r.left)+getSize(r.right)+1;
        }
    }

    //Preorder
    public void preOrder(Node r){
        if(r != null){
            System.out.print(r.data+" ");
        }
        if(r.left!=null){
            preOrder(r.left);
        }
        if(r.right!=null){
            preOrder(r.right);
        }
    }

    //PostOrder
    public void postOrder(Node r){
        if(r.left!=null){
            postOrder(r.left);
        }
        if(r.right!=null){
            postOrder(r.right);
        }
        if(r != null){
            System.out.print(r.data+" ");
        }
    }

    //Inorder
    public void inOrder(Node r){
        if(r.left!=null){
            inOrder(r.left);
        }
        if(r != null){
            System.out.print(r.data+" ");
        }
        if(r.right!=null){
            inOrder(r.right);
        }
    }

    //LevelOrder
    public void levelOrder(Node r){
        if(r == null){
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(r);
        while(!q.isEmpty()){
            Node d = q.remove();
            System.out.print(d.data+" ");
            if(d.left!=null){
                q.add(d.left);
            }
            if(d.right!=null){
                q.add(d.right);
            }
        }
    }

    //Height
    public int getHeight(Node r){
        if(r == null){
            return 0;
        }
        else if(getHeight(r.left)>getHeight(r.right)){
            return getHeight(r.left)+1;
        }
        else{
            return getHeight(r.right)+1;
        }
    }

    //getroot
    public Node getRoot(){
        return root;
    }

    //Search
    public Node Search(Node r , int key){
        if(r == null){
            return null;
        }
        if(r.data == key){
            return r;
        }
        else{
            Node res1 = Search(r.left,key);
            if(res1!=null){
                return res1;
            }
            else{
                Node res2 = Search(r.right,key);
                return res2;
            }
        }
    }


}
