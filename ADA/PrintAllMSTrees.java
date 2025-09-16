import java.util.Arrays;
import java.util.Scanner;

public class PrintAllMSTrees {
    static class DisjointSet {
        int[] u;
        int n;

        DisjointSet(int n) {
            this.n = n;
            this.u = new int[n];
            for (int i = 0; i < n; i++) {
                u[i] = i;
            }
        }

        DisjointSet(DisjointSet s) {
            this.n = s.n;
            this.u = new int[n];
            for (int i = 0; i < n; i++) {
                u[i] = s.u[i];
            }
        }

        public int find(int i) {
            int j = i;
            while (u[j] != j) {
                j = u[j];
            }
            return j;
        }

        public void merge(int i, int j) {
            if (i < j) {
                u[j] = i;
            } else {
                u[i] = j;
            }
        }

        public boolean isEqual(int i, int j) {
            return i == j;
        }

        public String toString() {
            String s = "u = [";
            for (int i = 0; i < n - 1; i++) {
                s = s + u[i] + " , ";
            }
            s = s + u[n - 1] + " ]";
            return s;
        }
    }

    static class Edge {
        int s, d, w;

        public void read() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter an edge in (source, destination , weight) : ");
            this.s = sc.nextInt();
            this.d = sc.nextInt();
            this.w = sc.nextInt();

        }

        public String toString() {
            String s = "( " + this.s + " , " + this.d + " ) = " + this.w;
            return s;
        }

    }


    public static int getWeight(Edge e[]) {
        int w = 0;
        for (int i = 0; i < e.length; i++) {
            w += e[i].w;
        }
        return w;
    }

    //Kruskal Algo to find min Spanning tree
    public static int kruskal(Edge e[], int n) {
        int m = e.length; //No of edges
        Edge F[] = new Edge[n - 1];
     DisjointSet ds = new DisjointSet(n);
        int k = 0;
        for (int i = 0; i < m; i++) {
            Edge edge = e[i];
            int s = edge.s;
            int d = edge.d;
            int p = ds.find(s);
            int q = ds.find(d);
            if (p != q) {
                F[k++] = edge;
                ds.merge(p, q);
            }
        }
        System.out.println("Edges of minimum spanning tree");
        print(F);
        return getWeight(F);
    }

    public static void read(Edge E[]) {
        System.out.println("Enter " + E.length + " edges in non-decreasing order of their weights");
        for (int i = 0; i < E.length; i++)
            E[i].read();
    }

    public static void print(Edge E[]) {
    
        System.out.print("E = [");
        for (int i = 0; i < E.length - 1; i++)
            System.out.print(E[i] + ", ");
        System.out.print(E[E.length - 1] + "]\n");
    }
    
    public static void printALLMST(int minLen, int k, int kk, DisjointSet s, Edge[] E, int n, int m, Edge []F) {
        if ((k == n - 1) && getWeight(F) == minLen) {
            print(F);
            return;
        }

        boolean flag = true;

        while (flag) {
            kk = kk + 1;
            if (kk >= m)
                break;

            int currentWeight = E[kk].w;

            while (kk < m && E[kk].w == currentWeight) {
                int p = E[kk].s;
                int q = E[kk].d;

                int r = s.find(p);
                int t = s.find(q);

                if (r != t) {
                    flag = false;
                    DisjointSet ss = new DisjointSet(s);
                    ss.merge(r, t);
                    Edge FF[] = Arrays.copyOf(F, F.length);
                    FF[k] = E[kk];
                    printALLMST(minLen, k + 1, kk, ss, E, n, m,FF);
                }

                kk = kk + 1;
            }

            if (flag) {
                kk = kk - 1;
            }
        }
    }



    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
        System.out.print("How many vertices? ");
        int n = in.nextInt();
        System.out.print("How many edges? ");
        int m = in.nextInt();
        Edge E[] = new Edge[m];
        for (int i = 0; i < E.length; i++)
            E[i] = new Edge();
        read(E);
        print(E);
        int minLen= kruskal(E, n);
      DisjointSet s = new DisjointSet(n);
        Edge e = E[0];
        int kk = -1;
        Edge[] F = new Edge[n - 1];
        System.out.println("Minimum  Spanning Tree : ");
        printALLMST(minLen, 0, kk, s, E, n,m, F);
    System.out.println("-".repeat(30));
    }
}
