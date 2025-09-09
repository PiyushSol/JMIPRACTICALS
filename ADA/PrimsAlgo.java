import java.util.*;

public class PrimsAlgo {
    public static void main(String[] args) {
        int w[][] = {
                { Integer.MAX_VALUE, 1, 3, Integer.MAX_VALUE, Integer.MAX_VALUE },
                { 1, Integer.MAX_VALUE, 3, 6, Integer.MAX_VALUE },
                { 3, 3, Integer.MAX_VALUE, 4, 2 },
                { Integer.MAX_VALUE, 6, 4, Integer.MAX_VALUE, 5 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 2, 5, Integer.MAX_VALUE } };
        int n = 5;
        prime(w, n);
    }
    
    public static void prime(int w[][], int n) {
        int nearest[] = new int[n-1];
        int distance[] = new int[n-1];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <=n-2; i++) {
            nearest[i] = 0;
            distance[i] = w[0][i+1];
        }
        int k = 1;
        while (k < n) {
            int min = Integer.MAX_VALUE;
            int near = -1;
            for (int i = 0; i <n-1; i++) {
                if (0 <= distance[i] && distance[i] < min) {
                    min = distance[i];
                    near = i;
                }
            }
            edges.add(Arrays.asList(nearest[near], near+1));
            distance[near] = -1;
            for (int i = 0; i < n - 1; i++) {
                if (distance[i] == -1)
                    continue;
                if (w[i+1][near+1] < distance[i]) {
                    distance[i] = w[i+1][near+1];
                    nearest[i] = near+1;
                }
            }
          
            System.out.println("Iteration -> "+k);
             System.out.println("Distance Array-> Iteration  "+  Arrays.toString(distance));
            System.out.println("Nearest Array-> Iteration  "+Arrays.toString(nearest));
            System.out.println("List of Edges -> Iteration  " + edges);
            System.out.println("-".repeat(20));
              k++;
        }

       
    }
}
