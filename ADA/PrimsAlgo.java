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
        int nearest[] = new int[n];
        int distance[] = new int[n];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 1; i <n; i++) {
            nearest[i] = 0;
            distance[i] = w[0][i];
        }
        int k = 1;
        while (k < n) {
            int min = Integer.MAX_VALUE;
            int near = -1;
            for (int i = 1; i <n; i++) {
                if (0 <= distance[i] && distance[i] < min) {
                    min = distance[i];
                    near = i;
                }
            }
            edges.add(Arrays.asList(nearest[near], near));
            distance[near] = -1;
            for (int i = 1; i <n; i++) {
                if (w[i][near] < distance[i]) {
                    distance[i] = w[i][near];
                    nearest[i] = near;
                }
            }
            k++;
        }

        System.out.println("Distance Array-> " + Arrays.toString(distance));
        System.out.println("Nearest Array-> "+Arrays.toString(nearest));
        System.out.println("List of Edges -> "+edges);
    }
}
