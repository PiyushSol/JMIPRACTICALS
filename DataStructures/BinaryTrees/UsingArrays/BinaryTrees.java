/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Binary Tree-Using Arrays data structure and provides the following operations:
 * 1. Build Binary Tree
 * 2. Preorder Traversal
 * 3. Inorder Traversal
 * 4. PostOrder Traversal
 * 5. Level Order Traversal
 * 6. Size
 * 7. Search
 * 8. Empty
 * 9. Height
 * 10.Exit
 *
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTrees {
    int h ;
    String BT[];

    BinaryTrees(int h){
        this.h= h;
        BT = new String[(int)((Math.pow(2,h))-1)];
        for(int i=0;i<(int)((Math.pow(2,h))-1);i++){
            BT[i]="\0";
        }
    }

    //Function to build a binary tree
    public void build(int rootIndex){
        Scanner sc = new Scanner(System.in);
        if(rootIndex == 0){
            System.out.println("Enter the root of the tree : ");
        }
        else if(rootIndex%2 ==1){
            System.out.println("Enter the left child of "+BT[(int)Math.floor((rootIndex-1)/2)]+" : ");
        }
        else{
            System.out.println("Enter the right child of "+BT[(int)Math.floor((rootIndex-1)/2)]+" : ");
        }
        BT[rootIndex] = sc.nextLine();
        System.out.println("Does the "+BT[rootIndex]+ " have left child ? (Y/y) ");
        char ch = sc.next().charAt(0);
        if((ch == 'Y'||ch == 'y') && 2*(rootIndex+1)-1 <(int)((Math.pow(2,h))-1)){
            build(2*(rootIndex+1)-1);
        }
        System.out.println("Does the " +BT[rootIndex]+ " have right child ? (Y/y) ");
        char ch1 = sc.next().charAt(0);
        if((ch1 == 'Y'||ch1 == 'y') && 2*(rootIndex+1) <(int)((Math.pow(2,h))-1)){
            build(2*(rootIndex+1));
        }
    }

    //Preorder Traversing
    public void preOrder(int root){
        if(!BT[root].equals("\0")) {
            System.out.print(BT[root] + " ");
        }
        if(2*(root+1)-1 <(int)((Math.pow(2,h))-1) && !BT[2*(root+1)-1].equals("\0")){
            preOrder(2*(root+1)-1);
        }
        if(2*(root+1)<(int)((Math.pow(2,h))-1) && !BT[2*(root+1)].equals("\0")){
            preOrder(2*(root+1));
        }
    }

    //Inorder Traversing
    public void inOrder(int root){
        if(2*(root+1)-1 <(int)((Math.pow(2,h))-1) && !BT[2*(root+1)-1].equals("\0")){
            inOrder(2*(root+1)-1);
        }
        if(!BT[root].equals("\0")) {
            System.out.print(BT[root] + " ");
        }
        if(2*(root+1)<(int)((Math.pow(2,h))-1) && !BT[2*(root+1)].equals("\0")){
            inOrder(2*(root+1));
        }
    }

    //PostOrderTraversing
    public void postOrder(int root){
        if(2*(root+1)-1 <(int)((Math.pow(2,h))-1) && !BT[2*(root+1)-1].equals("\0")){
            postOrder(2*(root+1)-1);
        }
        if(2*(root+1)<(int)((Math.pow(2,h))-1) && !BT[2*(root+1)].equals("\0")){
            postOrder(2*(root+1));
        }
        if(!BT[root].equals("\0")) {
            System.out.print(BT[root] + " ");
        }
    }

    //LevelOrder Traversing using inbuild Queue
    public void levelOrder(int root){
        if(BT[0].equals("\0")){
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(q.isEmpty()==false){
            int i=q.remove();
            System.out.print(BT[i]+" ");
            if(2*(i+1)-1 <(int)((Math.pow(2,h))-1) && !BT[2*(i+1)-1].equals("\0")){
                q.add(2*(i+1)-1);
            }
            if(2*(i+1)<(int)((Math.pow(2,h))-1) && !BT[2*(i+1)].equals("\0")){
                q.add(2*(i+1));
            }
        }
    }

    //isEmpty
    public boolean isEmpty(){
        if(BT[0].equals("\0")){
            return true;
        }
        else{
            return false;
        }
    }

    //Size
    public int size(){
        int sz=0;
        for(int i=0;i<(int)((Math.pow(2,h))-1);i++){
            if(!BT[i].equals("\0")){
                sz++;
            }
        }
        return sz;
    }

    //Getheight
    public  int getHeight(){
        return h;
    }

    //Search
    public int search(String key){
        for(int i=0;i<(int)((Math.pow(2,h))-1);i++){
            if(BT[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
}
