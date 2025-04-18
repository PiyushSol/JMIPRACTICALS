public class Hashing {
    //Data Members
   private int a[];
   private int h;
   private int n;

    Hashing(int n,int h){
        this.h =h;
        this.n=n;
        a = new int[n];
        for (int i=0;i<n;i++){
            a[i]=-1;
        }
    }

    //Deleting in HashTable
    public int delete(int key){
        int i=search(key);
        if(i==-1){
            System.out.println("Key does not exist.");
            return -1;
        }
        int j=(i+1)%h;
        int k=i;
        while(j!=k && a[j]!=-1){
            if(a[j]%h<=i){
                a[i]=a[j];
                i=j;
            }
            j=(j+1)%h;
        }
        a[i]=-1;
        return a[j];
    }

    //Inserting in HashTable
    public void insert(int key){
        int i = key % h;
        int start = i;

        do {
            if (a[i] == -1) {
                a[i] = key;
                System.out.println("Inserted successfully at index " + i);
                return;
            } else if (a[i] == key) {
                System.out.println("Key already exists at index " + i);
                return;
            } else {
                i = (i + 1) % h;
            }
        } while (i != start);

        System.out.println("Hash table is full!");
    }

    //Searching in the HashTable
    public int search(int key){
        int i = key % h;
        int start = i;

        do {
            if (a[i] == -1) {
                return -1;
            } else if (a[i] == key) {
                return i;
            } else {
                i = (i + 1) % h;
            }
        } while (i != start);

        return -1;
    }

    // Display method
    public void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < n; i++) {
            if (a[i] == -1)
                System.out.println(i + " --> empty");
            else
                System.out.println(i + " --> " + a[i]);
        }
    }
}
