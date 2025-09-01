public class DisjointSet {
    int U[];
    int n;

    DisjointSet(int n) {
        this.n = n;
        U = new int[n];
    }

    public void makeSet() {
        for (int i = 0; i < n; i++) {
            U[i] = -1;
        }
    }

    public int find(int i) {
        int j = i;
        while (U[j] > 0) {
            j = U[j];
        }
        return j;
    }

    public void merge(int u, int v) {
        int rootu = find(u);
        int rootv = find(v);
        if (rootu == rootv) {
            return;
        }

        if (U[rootu] < U[rootv]) {
            U[rootu] += U[rootv];
            U[rootv] = rootu;
        } else {
            U[rootv] += U[rootu];
            U[rootu] = rootv;
        }
    }
    
    public boolean equal(int u, int v) {
        return find(u) == find(v);
    }
    
    public static void main(String[] args) {
        
    }
}
