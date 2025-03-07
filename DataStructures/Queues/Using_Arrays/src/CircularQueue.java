/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Circular Queue data structure using Arrays and provides the following operations:
 * 1. Push
 * 2. Pop
 * 3. Peek
 */
public class CircularQueue {
     private int arr[];
     private int size;
     private int front;
     private int rear;

     CircularQueue(int n){
         arr = new int[n];
         size =n;
         rear =-1;
         front =-1;
     }

     //Checking if empty
    public  boolean isEmpty(){
         return rear ==-1 && front == -1;
    }

    //Check if queue is full
    public boolean isFull(){
         return (rear+1)%size == front;
    }

    //Add
    public void add(int data){
         if(isFull()){
             System.out.println("Queue is full!");
             return;
         }
         if(front == -1){
             front=0;
         }
         rear = (rear+1)%size;
         arr[rear]=data;
    }

    //Remove Queue
    public int remove(){
         if(isEmpty()){
             System.out.println("Queue is empty!");
             return -1;
         }

         int res = arr[front];

         if(rear == front){
             rear =front =-1;
         }
         else{
             front =(front+1)%size;
         }
         return res;
    }

    //Peek
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }

}
