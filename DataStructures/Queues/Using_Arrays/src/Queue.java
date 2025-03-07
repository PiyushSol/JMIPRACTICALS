/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Queue data structure using Arrays and provides the following operations:
 * 1. Push
 * 2. Pop
 * 3. Peek
 */
public class Queue {
    private  int[]arr;
    private static int size;
    private int front = 0;
    private int rear;
    Queue(int n){
        arr= new int[n];
        size =n;
        rear =-1;
    }

    //Checking queue is empty
    public boolean isEmpty(){
        return rear ==-1;
    }

    //Add
    public void add(int data){
        if(rear == size-1){
            System.out.println("Queue is full");
            return;
        }
        rear=rear+1;
        arr[rear]=data;
    }

    //Remove
    public  int remove(){
        if(isEmpty()){
            return -1;
        }
        int data = arr[front];
        for(int i=0;i<rear;i++){
            arr[i]=arr[i+1];
        }
        rear = rear -1;
        return data;
    }

    //Peek
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[0];
    }
}
