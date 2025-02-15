public class TestLL {
    public static void main(String[] args) {
        SingleLL list = new SingleLL();
        list.insertAtHead(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.printList();
        list.deleteTail();
        list.deleteTail();
        list.deleteTail();
        list.deleteTail();
        list.deleteTail();
        list.printList();


    }
}
