public class TestDLL {
    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        ll.insertAtHead(1);
        ll.insertAtTail(2);
        ll.insertAtTail(3);
        ll.insertAtTail(4);
        ll.insertAtTail(5);
        ll.insertAtTail(6);
        ll.printList();
        System.out.println(ll.getIndex(5));


    }
}
