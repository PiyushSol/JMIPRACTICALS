public class SingleLL {
    private Node head;
    private int size;

    public SingleLL(){
        this.head =null;
        size=0;
    }

    //Function to insert a Node at head of the Linked List.
    public void insertAtHead(int data){
        Node node = new Node(data);
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
            return;
        }
        if(index<0){
            index=0;
        }
        Node node= new Node(val);
        if(isEmpty()){
            head = node;
            size++;
            return;
        }

        Node temp = head;
        for(int i=0;i<index;i++){
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
