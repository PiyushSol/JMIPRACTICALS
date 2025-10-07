import java.util.Arrays;

public class KNPString {
    public static void main(String[] args) {
        String T = "abcabc";
        String P = "abc";
        KMP_Match(T, P);
        int[] pie = compute_Prefix2(P, 3);
        System.out.println(Arrays.toString(pie));
    }

    //Knuth Morris Pratt Matching Algorithm
    public static void KMP_Match(String T, String P) {
        int n = T.length();
        int m = P.length();
        int pie[] = computePrefixFunction(P);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (q > 0 && P.charAt(q ) != T.charAt(i)) {
                q = pie[q-1];
            }
            if (P.charAt(q ) == T.charAt(i)) {
                q = q + 1;
            }
            if (q == m) {
                System.out.println("Pattern occurs with shift : " + (i-m+1));
                q = pie[q-1];
            }
        }
    }
    
    //Computing Common Prefix Array
    public static int[] computePrefixFunction(String p) {
        int m = p.length();
        int pie[] = new int[m];
        pie[0] = 0;
        int k = 0;
        for (int q = 1; q < m; q++) {
            while (k > 0 && p.charAt(k) != p.charAt(q)) {
                k = pie[k-1];
            }
            if (p.charAt(k) == p.charAt(q)) {
                k = k + 1;
            }
            pie[q] = k;
        }
        return pie;
    }

    //Another Algorithm to compute the prefix 
    public static int getPie(String P) {
        int m = P.length();
        int p = m - 2;
        while (p > 0) {
            boolean found = true;
            int j = m - 1;
            for (int i = p; i >= 0; i--) {
                if (P.charAt(i) != P.charAt(j)) {
                    p = p - 1;
                    found = false;
                    break;
                }
                j = j - 1;
            }
            if (found)
                break;
        }
        return p + 1;
    }

    public static int[] compute_Prefix2(String p , int m){
        int[] pie = new int[m];
        pie[0] = 0;
        int k = 0;
        for (int q = 1; q < m; q++) {
            while (k > 0 && p.charAt(k) != p.charAt(q)) {
                k = pie[k-1];
            }
            if (p.charAt(k) == p.charAt(q)) {
                k = k + 1;
            }
            pie[q] = k;
        }
        return pie;
    }
}
