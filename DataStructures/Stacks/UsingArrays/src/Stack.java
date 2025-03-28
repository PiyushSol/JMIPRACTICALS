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
    public int pop() throws StackEmptyException{
        if(top == -1){
            throw new StackEmptyException("Stack is empty. Cannot pop.");
        }
        int data = stack[top--];
        System.out.println("Element: "+data+ " popped out successfully.");
        return data;
    }

    //Evaluation of Infix to Postfix
    public String infixToPostfix(String expression) {
        StringBuilder res = new StringBuilder();
        String[] expr = expression.split("\\s+");
        java.util.Stack<String> s = new java.util.Stack<>();

        for (String token : expr) {
            token = token.trim();

            if (!isOperator(token) && !token.equals("(") && !token.equals(")")) {
                res.append(token).append(" ");
            }

            else if (token.equals("(")) {
                s.push(token);
            }

            else if (token.equals(")")) {
                while (!s.isEmpty() && !s.peek().equals("(")) {
                    res.append(s.pop()).append(" ");
                }
                s.pop();
            }

            else {
                while (!s.isEmpty() && getPrecedence(s.peek()) >= getPrecedence(token)) {
                    res.append(s.pop()).append(" ");
                }
                s.push(token);
            }
        }

        // Pop remaining operators
        while (!s.isEmpty()) {
            res.append(s.pop()).append(" ");
        }

        return res.toString().trim();
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

    //Helper function to get precedence of Operator
    public int getPrecedence(String ch) {
        if (ch.equals("^"))
            return 3;
        else if (ch.equals("/") || ch.equals("*"))
            return 2;
        else if (ch.equals( "+") || ch.equals( "-"))
            return 1;
        else
            return -1;
    }

    //Helper function to check operator
    public boolean isOperator(String ch) {
        if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("^")) {
            return true;
        }
        return false;
    }

}
