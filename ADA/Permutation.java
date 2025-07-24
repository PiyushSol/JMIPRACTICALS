public class Permutation {
    public static void main(String[] args) {
        String a[] = new String[]{"A","B","C"};
        permutations(a, 0, a.length-1);
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
