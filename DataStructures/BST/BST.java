/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Binary Search Tree-Using Node data structure and provides the following operations:
 * 1. Build Binary Tree
 * 2. Preorder Traversal
 * 3. Inorder Traversal
 * 4. PostOrder Traversal
 * 5. Size
 * 6. Search
 * 7. Empty
 * 8. Height
 * 9.Exit
 *
 */
public class BST {
  class Node{
        String data;
        Node left , right;
        Node(String data){
            this.data=data;
            this.left = this.right=null;
        }
  }
        Node root;

        BST(){
            root =null;
        }
      //GetRoot
      public Node getRoot(){
          return this.root;
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

      public int getSize(Node r){
          if(r ==null){
              return 0;
          }
          else{
              return getSize(r.left)+getSize(r.right)+1;
          }
      }

        //Searching Operation
        public boolean search(String key) {
            Node r = root;
            while (r != null) {
                if (key.equals(r.data)) return true;
                r = (key.compareTo(r.data) < 0) ? r.left : r.right;
            }
            return false;
        }

      //Insertion Operation
      public void insert(String data) {
          Node newNode = new Node(data);
          if (root == null) {
              root = newNode;
              return;
          }

          Node parent = null, current = root;
          while (current != null) {
              parent = current;
              if (data.compareTo(current.data) < 0)
                  current = current.left;
              else if (data.compareTo(current.data) > 0)
                  current = current.right;
              else {
                  System.out.println("Key already exists.");
                  return;
              }
          }

          if (data.compareTo(parent.data) < 0)
              parent.left = newNode;
          else
              parent.right = newNode;
      }


    //Deletion Operation
    public void delete(String data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, String data) {
        if (root == null) return root;

        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = deleteRec(root.right, successor.data);
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

        //Inorder Traversing
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

        //PreOrder Traversing
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

       //PostOrder Traversing
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

    }

