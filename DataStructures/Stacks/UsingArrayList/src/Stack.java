/**
 * Author: Piyush Solanki
 * Semester: 2
 * Subject: Advanced Data Structures
 *
 * This program implements a Stack data structure using ArrayList and provides the following operations:
 * 1. Push
 * 2. Pop
 * 3. Peek
 */
import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> stack = new ArrayList<>();
    //Check if is stack is empty
    public boolean isEmpty(){
        return stack.size()==0;
    }

    //Push Operation
    public void push(int data){
        stack.add(data);
    }

    //Pop Operation
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int top = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return top;
    }

    //Peek
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        int top = stack.get(stack.size()-1);
        return top;
    }
}
