/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Stack data structure using Arrays and provides the following operations:
 * 1. Push
 * 2. Pop
 * 3. Peek
 */
public class Stack {
    private  int n;
    private  int[] stack;
    private  int top;



    //Intialise the stack
    public Stack(int n){
        this.n=n;
        stack = new int[n];
        top =-1;
    }

    //Push Operation
    public void push(int data) throws StackFullException{
        //Checking if stack is full
        if(top == n-1){
            throw new StackFullException("The stack is full. Cannot push " + data);
        }
        top =top+1;
        stack[top] = data;
        System.out.println("Element pushed successfully.");
        return;
    }

    //Pop Operation
    public void pop() throws StackEmptyException{
        if(top == -1){
            throw new StackEmptyException("Stack is empty. Cannot pop.");
        }
        int data = stack[top--];
        System.out.println("Element: "+data+ " popped out successfully.");
        return;
    }

    //Peek Operation
    public void peek() throws StackEmptyException{
        if(top == -1){
            throw new StackEmptyException("Stack is empty. Cannot peek.");
        }
        System.out.println("Peeking : "+stack[top]);
        return;
    }

    //Check if stack is empty
    public  boolean isEmpty(){
        return top == -1;
    }

}
