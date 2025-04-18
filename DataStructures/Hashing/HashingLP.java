public class HashingLP {
    public static void main(String[] args) {
        Hashing ht = new Hashing(10, 10);

        ht.insert(25);
        ht.insert(35);
        ht.insert(15);
        ht.insert(95);

        ht.display();

        System.out.println("Search 15: " + (ht.search(15) != -1 ? "Found" : "Not Found"));
        System.out.println("Search 55: " + (ht.search(55) != -1 ? "Found" : "Not Found"));

        ht.delete(35);
        ht.display();

        ht.insert(45);
        ht.display();
    }
}
