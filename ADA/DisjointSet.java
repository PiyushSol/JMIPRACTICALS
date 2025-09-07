public class DisjointSet {
    static int n;
    static int []U;

    DisjointSet(int n){
        this.n =n;
        U = new int[n];
        for(int i=0;i<n;i++){
            U[i]=i;
        }
    }

    public static void merge(int p , int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            U[rootQ] = rootP;
        }
    }

    public static int find(int i){
        if (U[i] != i) {
            U[i] = find(U[i]);  // Path compression
        }
        return U[i];
    }

    public static boolean equal(int p, int q){
    return find(p)==find(q);

    }

    public static void main(String[] args) {

    }
}
