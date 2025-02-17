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
