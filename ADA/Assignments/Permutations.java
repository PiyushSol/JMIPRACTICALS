import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        String a[] = new String[] { "G","F","E" };
        int n = a.length;
        long start = System.currentTimeMillis();
        permutations(a, 0, n-1);
        long end = System.currentTimeMillis();
        System.out.println("Recursive Permutations time : " + (end - start) + " ms.");

        System.out.println("-".repeat(60));

        long start1 = System.currentTimeMillis();
        printAllPermutations(a, n);
        long end1 = System.currentTimeMillis();
        System.out.println("Iterative Permutations time : " + (end1 - start1) + " ms.");
    }

    //Iterative Next Permutations
    public static boolean permutations_iterative(String a[], int n) {
        int i = n - 2;
        while (i >= 0 && a[i].compareTo(a[i + 1]) > 0) {
            i = i - 1;
        }
        if (i == -1) {
            return false;
        }
        int j = n - 1;
        while (a[j].compareTo(a[i]) < 0) {
            j = j - 1;
        }

        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        reverseArray(a, i + 1, n - 1);
        return true;
    }

    public static void printAllPermutations(String a[], int n) {
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        while (permutations_iterative(a, n) == true) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void reverseArray(String a[], int s, int e) {
        while (s < e) {
            String temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }

    public static void permutations(String a[], int k, int n) {
        if (k == n) {
            print(a);
            return;
        }
        for (int i = k; i <= n; i++) {
            String temp = a[k];
            a[k] = a[i];
            a[i] = temp;
            permutations(a, k + 1, n);
            temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }
    }

    public static void print(String a[]) {
        System.out.print("{");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print("}");
        System.out.println();
    }
}
