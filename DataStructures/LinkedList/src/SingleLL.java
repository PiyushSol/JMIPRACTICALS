/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Singly Linked List data structure and provides the following operations:
 * 1. Insert at head
 * 2. Insert at tail
 * 3. Insert at a specific index
 * 4. Search for a given value's index
 * 5. Delete at tail
 * 6. Delete at head
 * 7. Delete at a specific index
 * 8. Print the list
 *
 * The Singly Linked List allows efficient insertion and deletion at various positions
 * and supports searching and printing operations.
 */

public class SingleLL {
    private Node head;
    private int size;

    class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next =null;
        }
    }


    //Function to insert a Node at head of the Linked List.
    public void insertAtHead(int data){
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }
        node.next =head;
        head=node;
        size++;
    }

    //Function to insert a Node at the tail of the list
    public void insertAtTail(int val){
        if(isEmpty()){
            head = new Node(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        while(temp.next !=null){
            temp = temp.next;
        }
        temp.next=node;
        size++;

    }

    //Function to insert a Node at a given index
    public void insertAtIndex(int index,int val){
        //First we check if index is within the size of linked list
        if(index<0 || index>size){
            System.out.println("Invalid index passed.");
            return;
        }
        Node node= new Node(val);
        if(isEmpty()){
            head = node;
            size++;
            return;
        }
        if(index == 0){
            insertAtHead(val);
            return;
        }
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        if(size == index){
            temp.next=node;
            size++;
            return;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    //Function to Delete a Node from head
    public void deleteHead(){
        if(isEmpty()){
            System.out.println("Deletion not possible! List is empty");
            return;
        }
        Node temp = head;
        head  = temp.next;
        temp =null;
        return;
    }

    //Function to delete a node from tail
    public void deleteTail(){
        if(isEmpty()){
            System.out.println("Deletion not possible! List is empty");
            return;
        }
        Node prev = null;
        Node temp =head;
        if(temp.next ==null){
            head =null;
            return ;
        }
        while(temp.next!=null){
            prev =temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.next =null;
        return;
    }

    //Function to Search for a given index
    public int getIndex(int index){
        if(index<0 || index>size) return -1;
        Node temp = head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp==null?-1: temp.data;
    }

    //Function to delete at a given index
    public void deleteAtIndex(int index){
        int i=0;
        Node temp =head;
        if(index<0 || index>size){
            System.out.println("Deletion not possible . Invalid index passed.");
            return;
        }
        if(index == 0){
            deleteHead();
            return;
        }
        if(index ==size){
            deleteTail();
            return;
        }
        while(i<index-1){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    //Function to print Linked List
    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    //Function to check if the linked list is null
    public boolean isEmpty(){
        return head == null;
    }
}
