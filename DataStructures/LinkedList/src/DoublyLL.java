/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Doubly Linked List data structure and provides the following operations:
 * 1. Insert at head
 * 2. Insert at tail
 * 3. Insert at a specific index
 * 4. Search for a given value's index
 * 5. Delete at tail
 * 6. Delete at head
 * 7. Delete at a specific index
 * 8. Print the list
 *
 * The Doubly Linked List allows efficient insertion and deletion at various positions
 * and supports searching and printing operations.
 */
public class DoublyLL {
    private Node head;
  int size=0;

    class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next=null;
            this.prev=null;
        }
    }
    //Function to insert a Node at head of the Linked List.
    public void insertAtHead(int data){
        Node node = new Node(data);
        size++;
        if(head == null) {
            head = node;
            return;
        }
        node.next =head;
        head=node;
    }

    //Function to insert a Node at tail of the Linked List.
    public void insertAtTail(int data){
        Node node = new Node(data);
        if(head == null){
            insertAtHead(data);
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        size++;
        temp.next =node;
        node.prev = temp;
    }

    //Function to insert a Node at a given index
    public void insertAtIndex(int index , int data){
        if(index<0 || index>size){
            System.out.println("Invalid index passed.");
            return;
        }
        Node node = new Node(data);
        if(index ==0){
            insertAtHead(data);
            return;
        }
        Node temp = head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        size++;
    }
    //Function to delete the head node
    public void deleteHead(){
        if(head==null){
            System.out.println("Deletion not possible! List is empty");
            return;
        }
        Node temp = head;
        head  = temp.next;
        temp =null;
        size--;
        return;
    }

    public void deleteTail(){
        if(head == null){
            System.out.println("Deletion not possible! List is empty");
            return;
        }
        if(head.next ==null){
            head=null;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.prev.next = null;
        size--;
    }

    //Function to delete at a given index
    public void deleteAtIndex(int index){
        if(index<0||index>=size){
            System.out.println("Invalid Index !");
            return;
        }
        if(index==0){
            deleteHead();
            return;
        }
        Node temp = head;
        int i=0;
        while(i<index){
            temp = temp.next;
            i++;
        }
        if(temp.next==null){
            deleteTail();
            return;
        }
        temp.next.next.prev = temp;
        temp.next =temp.next.next;
        size--;
    }

    // Function to search for a given index value.
    public int getIndex(int index){
        if(index<0 || index>=size) return -1;
        Node temp = head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp==null?-1: temp.data;
    }

    //Function to print list
    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

//import java.util.*;
//
//public class DoublyLL {
//    private Node head;
//    int size = 0;
//
//    // Node representing a point (x, y) in 2D space
//    class Node {
//        int x, y;
//        Node next;
//        Node prev;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//            this.next = null;
//            this.prev = null;
//        }
//    }
//
//    // Insert at head
//    public void insertAtHead(int x, int y) {
//        Node node = new Node(x, y);
//        size++;
//        if (head == null) {
//            head = node;
//            return;
//        }
//        node.next = head;
//        head = node;
//    }
//
//    // Insert at tail
//    public void insertAtTail(int x, int y) {
//        Node node = new Node(x, y);
//        if (head == null) {
//            insertAtHead(x, y);
//            return;
//        }
//        Node temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        size++;
//        temp.next = node;
//        node.prev = temp;
//    }
//
//    // Print the list of points
//    public void printList() {
//        Node temp = head;
//        while (temp != null) {
//            System.out.print("(" + temp.x + ", " + temp.y + ") <-> ");
//            temp = temp.next;
//        }
//        System.out.println("NULL");
//    }
//
//    // Convex Hull using Andrew's monotone chain algorithm
//    public List<Node> convexHull() {
//        if (head == null) return new ArrayList<>();  // If the list is empty
//
//        List<Node> points = new ArrayList<>();
//        Node temp = head;
//        while (temp != null) {
//            points.add(temp);
//            temp = temp.next;
//        }
//
//        // Sort points lexicographically by x, then by y
//        points.sort((p1, p2) -> {
//            if (p1.x != p2.x) return p1.x - p2.x;
//            return p1.y - p2.y;
//        });
//
//        // Build the lower hull
//        List<Node> lower = new ArrayList<>();
//        for (Node p : points) {
//            while (lower.size() >= 2 && cross(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) <= 0) {
//                lower.remove(lower.size() - 1);
//            }
//            lower.add(p);
//        }
//
//        // Build the upper hull
//        List<Node> upper = new ArrayList<>();
//        for (int i = points.size() - 1; i >= 0; i--) {
//            Node p = points.get(i);
//            while (upper.size() >= 2 && cross(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) <= 0) {
//                upper.remove(upper.size() - 1);
//            }
//            upper.add(p);
//        }
//
//        // Remove the last point of each half because it's repeated at the beginning of the other half
//        lower.remove(lower.size() - 1);
//        upper.remove(upper.size() - 1);
//
//        // Concatenate lower and upper hull to get the full convex hull
//        lower.addAll(upper);
//        return lower;
//    }
//
//    // Helper function to calculate the cross product (used for checking the orientation of the turn)
//    private int cross(Node o, Node a, Node b) {
//        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
//    }
//
//    // Test the convex hull
//    public static void main(String[] args) {
//        DoublyLL list = new DoublyLL();
//        list.insertAtTail(0, 0);
//        list.insertAtTail(1, 1);
//        list.insertAtTail(2, 2);
//        list.insertAtTail(0, 2);
//        list.insertAtTail(2, 0);
//        list.insertAtTail(1, 0);
//        list.insertAtTail(3, 1);
//
//        System.out.println("Original List:");
//        list.printList();
//
//        List<Node> convexHullPoints = list.convexHull();
//        System.out.println("Convex Hull:");
//        for (Node p : convexHullPoints) {
//            System.out.print("(" + p.x + ", " + p.y + ") ");
//        }
//    }
//}
