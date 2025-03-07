/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Stack data structure using LinkedList and provides the following operations:
 * 1. Push
 * 2. Pop
 * 3. Peek
 */
public class Stack {
    //Node class to create our linked list.
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    //Data Items of stack
    Node head =null;

    //checking stack if empty
    public boolean isEmpty(){
        return head==null;
    }

    //Push Operation
    public void push(int data){
        Node node = new Node(data);
        if(isEmpty()){
            head =node;
            return;
        }
        node.next = head;
        head = node;
    }

    //Pop Operation
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    //Peek Operation
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }
}
