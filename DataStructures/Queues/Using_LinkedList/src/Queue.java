/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Queue data structure using LinkedList and provides the following operations:
 * 1. Push
 * 2. Pop
 * 3. Peek
 */
public class Queue {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    Node head = null;
    Node tail = null;

    //Checking if queue empty
    public boolean isEmpty(){
        return head == null && tail == null;
    }

    //Add
    public void add(int data){
        Node newnode= new Node(data);
        if(head==null){
            head = tail=newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }

    //Remove
    public int remove(){
        if(isEmpty()){
            System.out.println("Empty Queue!");
            return -1;
        }
        int front = head.data;
        if(head == tail){
            tail = head =null;
        }
        else{
            head = head.next;
        }
        return front;
    }

    //Peek
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }

}
